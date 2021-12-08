package editor.libs;

public class Test {
    public static void main(String[] args) {
//        Integer[] input = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] input = {3, 5, 1, null, null, 0, 8, null, null, null, null, 7, 4};
        TreeNodeGeneric<Integer> treeNodeGeneric = new TreeNodeGeneric<>(input);
        System.out.println(treeNodeGeneric);
    }
}

