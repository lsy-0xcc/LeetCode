package editor.libs;

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