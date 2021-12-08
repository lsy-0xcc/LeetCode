package editor.libs;

import java.util.Arrays;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] input) {
        if (input.length > 0) {
            this.val = input[0];
            ListNode node = this;
            for (int i = 1; i < input.length; i++) {
                node.next = new ListNode(input[i]);
                node = node.next;
            }
        }
    }


    @Override
    public String toString() {
        String symbol = "->";
        StringBuilder result = new StringBuilder(String.valueOf(val));
        if (this.next != null) {
            result.append(symbol).append(this.next.toString());
        }
        return result.toString();
    }
}