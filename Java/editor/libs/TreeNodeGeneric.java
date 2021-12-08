package editor.libs;

import java.util.*;

public class TreeNodeGeneric<T> {
    public T val;
    public TreeNodeGeneric<T> left;
    public TreeNodeGeneric<T> right;

    public TreeNodeGeneric() {
        this.val = null;
    }

    public TreeNodeGeneric(T val) {
        this.val = val;
    }

    public TreeNodeGeneric(T val, TreeNodeGeneric<T> left, TreeNodeGeneric<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 通过数组生成带泛型的二叉树
     *
     * @param input 输入的数组
     */
    public TreeNodeGeneric(T[] input) {
        if (input.length == 0) {
            this.val = null;
        } else {
            Queue<TreeNodeGeneric<T>> queue = new LinkedList<>();
            TreeNodeGeneric<T> root = new TreeNodeGeneric<>();
            queue.add(root);
            for (T t : input) {
                TreeNodeGeneric<T> temp = queue.poll();
                assert temp != null;
                temp.left = new TreeNodeGeneric<>();
                temp.right = new TreeNodeGeneric<>();
                temp.val = t;
                queue.add(temp.left);
                queue.add(temp.right);
            }
            this.val = root.val;
            this.left = root.left;
            this.right = root.right;
        }
    }

    /**
     * 按照某个节点转化为val为int型的二叉树
     * 若泛型不是Integer，返回null
     *
     * @param treeNodeGeneric 树的根节点
     * @return 生成的普通二叉树
     */
    private TreeNode toTreeNode(TreeNodeGeneric<T> treeNodeGeneric) {
        if (treeNodeGeneric.val == null) {
            return null;
        } else if (treeNodeGeneric.val instanceof Integer) {
            TreeNode node = new TreeNode();
            node.val = (int) treeNodeGeneric.val;
            node.left = this.toTreeNode(treeNodeGeneric.left);
            node.right = this.toTreeNode(treeNodeGeneric.right);
            return node;
        } else {
            return null;
        }
    }


    /**
     * 返回当前对象对应的int型二叉树
     *
     * @return 生成的二叉树根节点
     */
    public TreeNode toTreeNode() {
        return this.toTreeNode(this);
    }

    /**
     * 把二叉树转换为数组
     *
     * @return 数组形式的二叉树
     */
    public List<T> toArray() {
        // 层序遍历
        List<T> result = new ArrayList<>();
        Queue<TreeNodeGeneric<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNodeGeneric<T> temp = queue.poll();
            if (temp == null) {
                result.add(null);
            } else {
                result.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        // 移除末尾多余的null
        int removePosition = result.size() - 1;
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) != null) {
                removePosition = i;
                break;
            }
        }
        int removeAmount = result.size() - 1 - removePosition;
        for (int i = 0; i < removeAmount; i++) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public String toString() {
        return this.toArray().toString();
    }
}
