/*
108. Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]

*/
/*Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC=O(n)
//SC=O(n)
//Recursive approach

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        return constructTreeFromArray(nums,0,nums.length-1);
    }
    public TreeNode constructTreeFromArray(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int midpoint = left + (right-left) / 2;
        TreeNode node = new TreeNode(nums[midpoint]);//current root node
        node.left = constructTreeFromArray(nums,left,midpoint-1);
        node.right = constructTreeFromArray(nums,midpoint+1,right);
        return node;
    }
}


//Iterative approach
class Solution{
    class Node{//need this class to store information
        int low,up;//index
        TreeNode t;
        Node(int l,int u,TreeNode n){
            low = l;
            up = u;
            t = n;
        }
        
    }
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums==null||nums.length==0) return null;
        
        Stack<Node> stack = new Stack();
        TreeNode root = new TreeNode(nums[(nums.length-1)/2]);//root
        Node rootNode = new Node(0,nums.length-1,root);
        stack.push(rootNode);
         while(!stack.isEmpty()){
            Node node = stack.pop();
            int middle = (node.low+node.up)/2; // cut half for [low, up]
            
            // [low, middle-1]
            if(middle-1 >= node.low){
                TreeNode leftnode = new TreeNode(nums[(middle-1+node.low)/2]);
                node.t.left = leftnode;
                Node left = new Node(node.low, middle-1, leftnode);
                stack.push(left);
            }
            // [middle+1, up]
            if(middle+1 <= node.up){
                TreeNode rightnode = new TreeNode(nums[(middle+1+node.up)/2]);
                node.t.right = rightnode;
                Node right = new Node(middle+1, node.up, rightnode);
                stack.push(right);
            }
        }
        return root;


    } 

}
