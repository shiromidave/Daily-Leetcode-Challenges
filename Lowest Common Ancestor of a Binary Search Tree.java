/*
235. Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC-O(N)
//SC_O(1)
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        
        TreeNode Left = lowestCommonAncestor(root.left,p,q);
        TreeNode Right = lowestCommonAncestor(root.right,p,q);
        
        if(Left==null) return Right;
        
        else if(Right==null) return Left;
        
        else //if both Left & Right are not null then return root
            return root;
    }
}
*/
//TC-O(logn)
//SC-O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
         if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
            
        return root;
    }
}
