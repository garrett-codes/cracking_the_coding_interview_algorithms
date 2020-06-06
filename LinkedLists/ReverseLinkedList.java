public class ReverseLinkedList {

  public LinkedListNode reverse(LinkedListNode head) {

    LinkedListNode prev = null;

    while(head != null) {
      LinkedListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }
}