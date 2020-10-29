package editor.libs;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode searchOne(int val) {
        return searchOneHelper(this, val);
    }

    private TreeNode searchOneHelper(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        TreeNode l = searchOneHelper(node.left, val);
        TreeNode r = searchOneHelper(node.right, val);
        if (l != null) {
            return l;
        } else return r;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
