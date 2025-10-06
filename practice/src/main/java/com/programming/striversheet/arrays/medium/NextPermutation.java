package com.programming.striversheet.arrays.medium;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        for (int num : nextPermutation1(arr))
            System.out.print(num + " ");
        System.out.println();
        for (int num : nextPermutation2(arr))
            System.out.print(num + " ");
    }

    // Permutation => Rearrange the elements in any order
    // For an element of size n we have n! permutationss, ex: for arr of size 3 we
    // have 3! = 6 permutations.
    // Next permutation => one permutation after another in sorted/increasing order.
    // Ex: if arr = {1,2,3} => next per {1,3,2} => {2,1,3} => {2,3,1} => {3,1,2} =>
    // {3,2,1} => {1,2,3}(Fallback to the first and continue).

    // Generate all permutations in sorted order -> Using recursion
    // Linear search arr
    // Next index of the arr will the permutation, if next does not exist -> first
    // one will be the answer
    // N! for all permutations and each is of length N => T.C = O(N!xN)
    private static int[] nextPermutation1(int[] arr) {
        return arr;
    }

    // ************* Very important algo ***************
    // Observation: Next permutation has longer prefix match -> raj, rax, rbx ->
    // here next permutation after raj is rax, ra is the prefix and its longer
    // Example arr = {2 1 5 4 3 0 0} -> longest match 2 1 5 4 3 0 0, same
    // try matching till n-2 => 2 1 5 4 3 0, same
    // reduce further => 2 1 5 4 3, since next numbers are 0 0, no change after
    // rearranging -> same arr
    // reducing => 2 1 5 4, now we have 3 numbers left 3 0 0 to rearrange but if we
    // do something like 0 3 0, final arr = 2 1 5 4 0 3 0, this is smaller than 2 1
    // 5 4 3 0 0, but we need the next/bigger number.
    // reducing 2 1 5, 4 numbers 4 3 0 0, if we try to arrange this we still cannot
    // get a number greater than 4 3 0 0
    // reducing 2 1, 5 numbers 5 4 3 0 0, if we try to rearrange this we still
    // cannot get a number greater than 5 4 3 0 0
    // reducing 2, 6 numbers 1 5 4 3 0 0, if we try to rearrange now, we can get
    // multiple greater numbers => {2 5 4 3 1 0 0}, {2 4 5 3 1 0 0}, but we need to
    // find the number which is closest to and greater than {2 1 5 4 3 0 0}
    // so in our case it will be 2 3, then rest elements a 3 is closest among the
    // given numbers to 1 and also greater
    // Algo =>
    // Step1: So basically we are trying to figure out the peak or breakpoint => 2
    // 1->i |(breakpoint/peak) 5 4 3 0 0 -> all elements to the next of breakpoint
    // are greater => a[i] < a[i+1]
    // Step2: Find the closest greater element than 1 -> a[i]
    // Step3: Now place remaining elements in sorted ascending order.
    // => o/p = {2 3 0 0 1 4 5}
    // T.C = O(3N), S.C = O(1) for extra space but O(N) as modifying the given
    // array.
    private static int[] nextPermutation2(int[] arr) {
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return reverse(arr, 0, arr.length - 1);
        for (int i = arr.length - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break; // To find the first greater as this is the closest, so break after swapping
                       // with closest greater element.
            }
        }
        reverse(arr, index + 1, arr.length - 1); // instead of sorting which has T.C of O(NlogN) we are reversing as
                                                 // elements are in sorted desc order, reduces T.C here to O(N).
        return arr;
    }

    private static int[] reverse(int[] arr, int st, int en) {
        while (st <= en) {
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
        return arr;
    }
}
