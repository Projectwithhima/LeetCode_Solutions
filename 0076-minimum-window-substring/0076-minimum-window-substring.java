import java.util.HashMap;
import java.util.Map;


public class Solution {

    public String minWindow(String S, String T) {
        
        // Safety checks for null, empty strings, or T being longer than S.
        if (S == null || S.isEmpty() || T == null || T.isEmpty() || T.length() > S.length()) {
            return "";
        }

        // 1. Pre-processing: Create the required frequency map for T
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : T.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Initialize state variables for the window
        int left = 0;          // Left pointer (window start)
        int minStart = 0;      // Stores the start index of the current smallest window
        int minLength = Integer.MAX_VALUE; // Stores the length of the current smallest window
        int matched = 0;       // Counts the total characters from T that are present in the window.
                               // When matched == T.length(), the window is valid.
                               
        Map<Character, Integer> windowMap = new HashMap<>();

        // Iterate through S using the right pointer to expand the window
        for (int right = 0; right < S.length(); right++) {
            char c = S.charAt(right);
            
            // Add the new character 'c' to the window map
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if this character helps satisfy a required count
            // The <= check ensures we count required duplicates.
            if (targetMap.containsKey(c) && windowMap.get(c) <= targetMap.get(c)) {
                matched++;
            }

            // Contraction Phase: Once the window is valid (matched == T.length()), try to shrink it
            while (matched == T.length() && left <= right) {
                int windowLen = right - left + 1;
                
                // Update the minimum window if the current one is shorter
                if (windowLen < minLength) {
                    minLength = windowLen;
                    minStart = left;
                }

                // Prepare to shrink: remove the character at the left pointer
                char leftChar = S.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // Check for Invalidation: Did removing leftChar invalidate a requirement?
                // This happens if the count drops below the required threshold.
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    matched--; // Decrement matched, which breaks the contraction loop
                }

                // Move the left pointer to the right to shrink the window
                left++;
            }
        }

        // Final check: If minLength is still the initial max value, no valid window was found.
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        
        // Return the substring using the saved start index and minimum length.
        return S.substring(minStart, minStart + minLength);
    }
}