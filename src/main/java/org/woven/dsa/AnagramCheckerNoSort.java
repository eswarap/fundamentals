package org.woven.dsa;

public class AnagramCheckerNoSort {

    /**
     * Converts each character to its index in the alphabet by subtracting the
     * ASCII value of 'a'. This is used to map lower-case letters 'a' to 'z' into
     * the range of indices 0 to 25.
     */
// Convert characters to array index by subtracting 'a'
    public static boolean areAnagrams(String str1, String str2) {
        // If lengths differ, not anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Manual frequency count using array for lowercase letters
        int[] charCounts = new int[26]; // For 'a' to 'z'

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            // Convert characters to array index by subtracting 'a'
            charCounts[c1 - 'a']++;
            charCounts[c2 - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println("They are anagrams!");
        } else {
            System.out.println("Not anagrams.");
        }
    }
}
