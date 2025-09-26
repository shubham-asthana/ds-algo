package com.programming.companies.speechify.ssml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.programming.companies.speechify.ssml.SSML.SSMLAttribute;
import com.programming.companies.speechify.ssml.SSML.SSMLElement;
import com.programming.companies.speechify.ssml.SSML.SSMLText;

public class SSMLTest {

    @Test
    public void shouldParseTagNames() {
        assertEquals(new SSMLElement("speak", Collections.emptyList(), Collections.emptyList()),
                SSML.parseSSML("<speak></speak>"));
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(),
                        Collections.singletonList(
                                new SSML.SSMLElement("p", Collections.emptyList(), Collections.emptyList()))),
                SSML.parseSSML("<speak><p></p></speak>"));
    }

    @ParameterizedTest(name = "parseSSML should throw for {0}")
    @ValueSource(strings = {
            "Hello world",
            "<p>Hello world</p>",
            "<p><speak>Hello world</speak></p>",
            "Hello <speak>world</speak>"
    })
    public void shouldThrowOnMissingSpeakTag(String ssml) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SSML.parseSSML(ssml));
        assertEquals("Tags could not be parsed", exception.getMessage());
    }

    @ParameterizedTest(name = "parseSSML should throw for {0}")
    @ValueSource(strings = {
            "<speak>Hello world</speak><foo></foo>",
            "<speak>Hello world</speak>foo",
            "<foo></foo><speak>Hello world</speak>",
            "foo<speak>Hello world</speak>"
    })
    public void shouldThrowOnMultipleTopLevelTagsOrText(String ssml) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SSML.parseSSML(ssml));
        assertEquals("Tags could not be parsed", exception.getMessage());
    }

    @ParameterizedTest(name = "parseSSML should throw for {0}")
    @ValueSource(strings = {
            "<speak>Hello world",
            "Hello world</speak>",
            "<speak><p>Hello world</speak>",
            "<speak>Hello world</p></speak>",
            "<speak><p>Hello <s>world</s></speak>",
            "<speak><p>Hello <s>world</p></speak>",
            "<speak><p>Hello <s>world</p></p></speak>",
            "<speak><p>Hello world</s></speak>",
            "<speak><p>Hello world</p></p></speak>",
            "<speak>Hello < world</speak>"
    })
    public void shouldThrowOnMissingOrInvalidSSMLOpeningAndClosingTags(String ssml) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SSML.parseSSML(ssml));
        assertEquals("Tags could not be parsed", exception.getMessage());
    }

    @Test
    public void shouldParseTagAttributes() {
        assertEquals(new SSMLElement("speak", Collections.singletonList(new SSMLAttribute("foo", "")),
                Collections.emptyList()), SSML.parseSSML("<speak foo=\"\"></speak>"));
        assertEquals(new SSMLElement("speak", Collections.singletonList(new SSMLAttribute("foo", "bar")),
                Collections.emptyList()), SSML.parseSSML("<speak foo=\"bar\"></speak>"));
        assertEquals(new SSMLElement("speak", Collections.singletonList(new SSMLAttribute("baz:foo", "bar")),
                Collections.emptyList()), SSML.parseSSML("<speak baz:foo=\"bar\"></speak>"));
        assertEquals(new SSMLElement("speak", Collections.singletonList(new SSMLAttribute("foo", "bar")),
                Collections.emptyList()), SSML.parseSSML("<speak foo  = \"bar\"></speak>"));
        assertEquals(new SSMLElement("speak",
                Arrays.asList(new SSMLAttribute("foo", "bar"), new SSMLAttribute("hello", "world")),
                Collections.emptyList()), SSML.parseSSML("<speak foo  = \"bar\" hello=\"world\"></speak>"));
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(),
                        Collections.singletonList(
                                new SSMLElement("p", Collections.singletonList(new SSMLAttribute("foo", "bar")),
                                        Collections.singletonList(new SSMLText("Hello"))))),
                SSML.parseSSML("<speak><p foo=\"bar\">Hello</p></speak>"));
    }

    @ParameterizedTest(name = "parseSSML should throw for {0}")
    @ValueSource(strings = {
            "<speak foo></speak>",
            "<speak foo=\"bar></speak>",
            "<speak foo=bar></speak>",
            "<speak foo=bar\"></speak>",
            "<speak =\"bar\"></speak>"
    })
    public void shouldThrowOnInvalidTagAttributes(String ssml) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SSML.parseSSML(ssml));
        assertEquals("Attributes cannot be parsed", exception.getMessage());
    }

    @Test
    public void shouldParseText() {
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(),
                        Collections.singletonList(new SSMLText("Hello world"))),
                SSML.parseSSML("<speak>Hello world</speak>"));
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(),
                        Arrays.asList(new SSMLText("Hello"),
                                new SSMLElement("p", Collections.emptyList(),
                                        Collections.singletonList(new SSMLText(" world"))),
                                new SSMLText(" foo"))),
                SSML.parseSSML("<speak>Hello<p> world</p> foo</speak>"));
    }

    @Test
    public void shouldUnescapeXMLCharactersInText() {
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(), Collections.singletonList(new SSMLText("TS < JS"))),
                SSML.parseSSML("<speak>TS &lt; JS</speak>"));
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(), Collections.singletonList(new SSMLText("TS &< JS"))),
                SSML.parseSSML("<speak>TS &amp;&lt; JS</speak>"));
        assertEquals(
                new SSMLElement("speak", Collections.emptyList(),
                        Arrays.asList(new SSMLElement("p", Collections.emptyList(),
                                Collections.singletonList(new SSMLText("TS<"))), new SSMLText(" JS"))),
                SSML.parseSSML("<speak><p>TS&lt;</p> JS</speak>"));
    }

    @Test
    public void shouldConvertSSMLNodesToText() {
        assertEquals("", SSML.ssmlNodeToText(new SSMLElement("baz", Collections.emptyList(), Collections.emptyList())));
        assertEquals("", SSML.ssmlNodeToText(new SSMLElement("baz",
                Collections.singletonList(new SSMLAttribute("foo", "bar")), Collections.emptyList())));
        assertEquals("Hello world", SSML.ssmlNodeToText(new SSMLElement("baz", Collections.emptyList(),
                Collections.singletonList(new SSMLText("Hello world")))));
        assertEquals("Hello world",
                SSML.ssmlNodeToText(new SSMLElement("baz", Collections.singletonList(new SSMLAttribute("foo", "bar")),
                        Collections.singletonList(new SSMLText("Hello world")))));
        assertEquals("bazHello worldbaz",
                SSML.ssmlNodeToText(new SSMLElement("baz", Collections.singletonList(new SSMLAttribute("foo", "bar")),
                        Arrays.asList(new SSMLText("baz"),
                                new SSMLElement("p", Collections.emptyList(),
                                        Collections.singletonList(new SSMLText("Hello world"))),
                                new SSMLText("baz")))));
    }
}
