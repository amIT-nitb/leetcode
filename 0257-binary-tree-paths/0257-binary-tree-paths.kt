/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

/*
 * 257. Binary Tree Paths  (Easy)
 *
 * Approach: DFS, build the path as we descend, emit at every leaf.
 *   The non-obvious bit: at a node with TWO children, the LEFT subtree's
 *   recursion will mutate any shared mutable path. So we pass each subtree
 *   its own fresh string copy (or path-list copy). At single-child nodes we
 *   can mutate in place — only the two-child case needs forking.
 *
 *      1            paths -> ["1->2->5", "1->3"]
 *     / \
 *    2   3
 *     \
 *      5
 *
 * Time: O(N * H)   Space: O(N * H) results + O(H) stack
 */
class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val out = mutableListOf<String>()
        if (root != null) dfs(root, "", out)
        return out
    }

    private fun dfs(node: TreeNode, prefix: String, out: MutableList<String>) {
        // String is immutable in Kotlin, so concatenation already gives each
        // recursive call its own copy — no manual fork needed
        val path = if (prefix.isEmpty()) "${node.`val`}" else "$prefix->${node.`val`}"
        if (node.left == null && node.right == null) {
            out.add(path)
            return
        }
        node.left?.let { dfs(it, path, out) }
        node.right?.let { dfs(it, path, out) }
    }
}
