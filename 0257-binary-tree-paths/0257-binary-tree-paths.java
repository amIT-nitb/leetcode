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
class Solution {

    List<String> list=new ArrayList<>();
    
    /*
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
        dfsFindLeafsAndAddToResult(root.left, new StringBuilder(sb.toString()));
        dfsFindLeafsAndAddToResult(root.right, new StringBuilder(sb.toString()));
    }
*/    
    
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root,"");
        return list;
    }
    public void binaryTreePaths(TreeNode root,String str) {
        if(root==null)return;

        str+=root.val+"->";

        binaryTreePaths(root.left,str);
        binaryTreePaths(root.right,str);

        if(root.left==null && root.right==null) list.add(str.substring(0,str.length()-2));
        return;
    }
    
    
    
}