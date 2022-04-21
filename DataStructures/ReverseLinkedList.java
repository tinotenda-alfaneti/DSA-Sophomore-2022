package DataStructures;

public class ReverseLinkedList {

    ListNode head;

 
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) head = newNode;
        else {
            ListNode temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    public ListNode getHead() {
        return head;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { // check if the linkedlist has elements
            return head;
        }
        ListNode reversedHead = reverseList(head.next); // recurse until the second last node is reached
        head.next.next = head; //Start reversing each node one by one.
        head.next = null;
        this.head = reversedHead;
        return reversedHead;

    }

    @Override
    public String toString() {
        String res = "{";
        ListNode curr = head;
        while (curr != null) {
            res += " " + curr.val;
            curr = curr.next;
        }

        return res + " }";
    }

    public static void main(String[] args) {
        ReverseLinkedList testHead = new ReverseLinkedList();
        testHead.addFirst(10);
        testHead.addFirst(9);
        testHead.addFirst(8);
        testHead.addFirst(7);
        testHead.addFirst(6);
        System.out.println(testHead);
        testHead.reverseList(testHead.getHead());
        System.out.println(testHead);

    }
}