package programming;

/**
 * 单链表节点
 */
class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
