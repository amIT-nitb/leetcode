/**
 * Definition for a binary tree node.
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
/*
 * 257. Binary Tree Paths  (Easy)
 *
 * Approach: DFS, building the path as we descend; emit at every leaf.
 *   At an internal node with TWO children, fork by passing each subtree a
 *   FRESH StringBuilder copy (so the right subtree's recursion doesn't see
 *   the left subtree's appended values). At a node with one child, the
 *   StringBuilder can be passed through (mutated, no fork needed). At a leaf,
 *   convert to String and add to the result.
 *
 *      tree:        1
 *                  / \
 *                 2   3      paths -> ["1->2->5", "1->3"]
 *                  \
 *                   5
 *
 *   Why fork only at the two-child case: forking is the costly part (string
 *   copy). When a node has only one child, we can keep mutating in place.
 *
 * Time: O(N * H)  N nodes, H = tree height (cost of building each path string)
 * Space: O(N * H) result strings + O(H) recursion stack
 */
class Solution {

    List<String> list=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
           dfsFindLeafsAndAddToResult(root, new StringBuilder()); 
        }
        return list;
    }

    private void dfsFindLeafsAndAddToResult(TreeNode root, StringBuilder sb) {
        checkRootIsNotNullAndAddValueToPath(root, sb);
        if (root.left != null && root.right != null) {
            splitPathIntoTwoPaths(root, sb);
        } else {
            if (root.left != null) {
                dfsFindLeafsAndAddToResult(root.left, sb.append("->"));
            } else {
                if (root.right != null) {
                    dfsFindLeafsAndAddToResult(root.right, sb.append("->")); 
                } else {
                    list.add(sb.toString());
                }
            }
        }
    }

    private void checkRootIsNotNullAndAddValueToPath(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
        }
    }

    private void splitPathIntoTwoPaths(TreeNode root, StringBuilder sb) {
        sb.append("->");
        // fork: each subtree gets its OWN copy so they don't pollute each other's path
        dfsFindLeafsAndAddToResult(root.left, new StringBuilder(sb.toString()));
        dfsFindLeafsAndAddToResult(root.right, new StringBuilder(sb.toString()));
    }
    
    
//     public List<String> binaryTreePaths(TreeNode root) {
//         binaryTreePaths(root,"");
//         return list;
//     }
//     public void binaryTreePaths(TreeNode root,String str) {
//         if(root==null)return;

//         str+=root.val+"->";

//         binaryTreePaths(root.left,str);
//         binaryTreePaths(root.right,str);

//         if(root.left==null && root.right==null) list.add(str.substring(0,str.length()-2));
//         return;
//     }
    
    
    
}