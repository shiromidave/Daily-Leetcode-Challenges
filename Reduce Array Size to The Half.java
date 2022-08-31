/*
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.
Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
*/
//TC-O(nlogn)
//SC-O(n)
class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num:arr)
            map.put(num,map.getOrDefault(num,0)+1);
        
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq,Collections.reverseOrder());
        
        int totalEl = n;
        int count=0,i=0;
        
        while(totalEl>n/2){
            totalEl -= freq.get(i);
            i++;
            count++;
        }
        return count;
        
    }
}
