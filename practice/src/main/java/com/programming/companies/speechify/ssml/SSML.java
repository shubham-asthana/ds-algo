package com.programming.companies.speechify.ssml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SSML {

    public static SSMLNode parseSSML(String ssml) {
        if (!validateInputSSML(ssml))
            throw new IllegalArgumentException("Tags could not be parsed");

        return getSSMLNode(ssml);
    }

    private static boolean validateInputSSML(String input) {
        return input.startsWith("<speak") && input.endsWith("</speak>");
    }

    private static SSMLNode getSSMLNode(String input) {
        if (input.isBlank())
            return null;

        if (!input.startsWith("<") || !input.endsWith(">"))
            throw new IllegalArgumentException("Tags could not be parsed");

        if (input.indexOf("<") == -1 || input.indexOf(">") == -1)
            return new SSMLText(unescapeXMLChars(input));

        String name = input.substring(input.indexOf("<") + 1, input.indexOf(">")).trim();

        System.out.println("Value of name " + name);
        String startTag = "<" + name + ">";
        List<SSMLAttribute> ssmlAttributes = new ArrayList<>();
        if (name.contains(" ")) {
            String attributeStr = name.substring(name.indexOf(" ") + 1);
            if (!attributeStr.contains("="))
                throw new IllegalArgumentException("Attributes cannot be parsed");
            while (attributeStr.contains("=")) {
                String key = attributeStr.substring(0, attributeStr.indexOf("=")).trim();
                if (key.isEmpty())
                    throw new IllegalArgumentException("Attributes cannot be parsed");
                System.out.println("Key " + key);
                attributeStr = attributeStr.substring(attributeStr.indexOf("=") + 1).trim();
                int endIndex = !attributeStr.contains(" ") ? attributeStr.length() : attributeStr.indexOf(" ");
                System.out.println("End index " + endIndex);
                String value = attributeStr.substring(0, endIndex).trim();
                if (countDoubleQuotes(value) != 2)
                    throw new IllegalArgumentException("Attributes cannot be parsed");
                value = value.replaceAll("\"", "");
                System.out.println("Key " + key + " Value " + value);
                ssmlAttributes.add(new SSMLAttribute(key, value));
                attributeStr = attributeStr.substring(endIndex);
                System.out.println("Attribute String " + attributeStr);
            }

            name = name.substring(0, name.indexOf(" "));
        }

        String endTag = "</" + name + ">";
        if (!input.contains(startTag) || !input.contains(endTag))
            throw new IllegalArgumentException("Tags could not be parsed");
        String body = input.substring(startTag.length(), input.lastIndexOf(endTag));
        if (body.isEmpty())
            return new SSMLElement(name, ssmlAttributes, Collections.emptyList());

        if (body.indexOf("<") == -1 && body.indexOf(">") == -1)
            return new SSMLElement(name, ssmlAttributes, List.of(new SSMLText(unescapeXMLChars(body))));
        if ((body.indexOf("<") == -1 && body.indexOf(">") != -1)
                || (body.indexOf("<") != -1 && body.indexOf(">") == -1))
            throw new IllegalArgumentException("Tags could not be parsed");

        String before = body.substring(0, body.indexOf("<"));
        System.out.println("Before " + before);
        String after = body.substring(body.lastIndexOf(">") + 1);
        System.out.println("After " + after);
        System.out.println("Value of children " + body.substring(before.length(), body.lastIndexOf(">") + 1));
        String children = body.substring(before.length(), body.lastIndexOf(">") + 1);
        List<SSMLNode> childNodes = new ArrayList<>();
        if (!before.isEmpty())
            childNodes.add(new SSMLText(unescapeXMLChars(before)));
        if (!children.isEmpty())
            childNodes.add(getSSMLNode(children));
        if (!after.isEmpty())
            childNodes.add(new SSMLText(unescapeXMLChars(after)));

        return new SSMLElement(name, ssmlAttributes, childNodes);

    }

    private static int countDoubleQuotes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"')
                count++;
        }
        return count;
    }

    public static String ssmlNodeToText(SSMLNode node) {
        List<SSMLText> ssmlTextList = getSSMLTextList(node);
        StringBuffer sb = new StringBuffer();
        for (SSMLText text : ssmlTextList) {
            sb.append(text.text());
        }
        return sb.toString();
    }

    private static List<SSMLText> getSSMLTextList(SSMLNode node) {
        List<SSMLText> ssmlTextList = new ArrayList<>();
        if (node instanceof SSMLText)
            ssmlTextList.add((SSMLText) node);
        else if (node instanceof SSMLElement) {
            SSMLElement element = (SSMLElement) node;
            for (SSMLNode child : element.children()) {
                ssmlTextList.addAll(getSSMLTextList(child));
            }
        }
        return ssmlTextList;
    }

    public static String unescapeXMLChars(String text) {
        return text.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }

    public sealed interface SSMLNode permits SSMLElement, SSMLText {
    }

    public record SSMLElement(String name, List<SSMLAttribute> attributes, List<SSMLNode> children)
            implements SSMLNode {
    }

    public record SSMLAttribute(String name, String value) {
    }

    public record SSMLText(String text) implements SSMLNode {
    }
}
