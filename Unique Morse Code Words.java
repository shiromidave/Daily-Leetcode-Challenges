/*
804. Unique Morse Code Words
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.
*/
 
//Time Complexity: O(S), where S is the sum of the lengths of words in words. We iterate through each character of each word in words.
//Space Complexity: O(S).

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(arr[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
