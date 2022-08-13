/*
30. Substring with Concatenation of All Words
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.
Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/816466/Java-O(N*M*len)-Clear-and-easy-to-understand-sliding-window-solution-beats-70-of-submissions
*/
//TC-O(N*M*len)
//N-no of charac
//M-no of words
//len - str len
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length==0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int wordCount = words[0].length();//each word length
        int wordLength = words.length;//array length
        
        for(int i=0;i<=s.length()-(wordLength*wordCount);i++){
            Map<String,Integer> seen = new HashMap<>();
            for(int j=0;j<wordLength;j++){
                int nextIndex = i+j*wordCount;//to get next word in words[]
                String temp = s.substring(nextIndex,nextIndex+wordCount);
                
                if(!map.containsKey(temp))
                    break;
                seen.put(temp,seen.getOrDefault(temp,0)+1);
                
                if(map.get(temp)<seen.get(temp))
                    break;
                if(j==words.length-1)
                    result.add(i);
                
            }
        }
        return result;
    }
}
