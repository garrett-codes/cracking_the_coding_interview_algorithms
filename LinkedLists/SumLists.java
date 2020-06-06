public class SumLists {

  public static LinkedListNode add(LinkedListNode list1, LinkedListNode list2) {

    if (list1 == null && list2 == null) return null;

    LinkedListNode sum = new LinkedListNode(); // sum list node
    LinkedListNode head = sum; // holds the pointer for the dummy head of the sum linked list
    int value = 0; // the value frrom being added together

    while (list1 != null || list2 != null) {
      if (list1 != null) {
        value += list1.data;
        list1 = list1.next;
      }

      if (list2 != null) {
        value += list2.data;
        list2 = list2.next;
      }
      int operand = value >= 10 ? value - 10 : value;
      sum.next = new LinkedListNode(operand);

      value = value >= 10 ? 1 : 0;
      sum = sum.next;
    }

    if (value == 1) {
      sum.next = new LinkedListNode(1);
    
    }

    return head.next;
  }
  public static void main(String[] args) {
    LinkedListNode list1 = new LinkedListNode(7);
    list1.next = new LinkedListNode(1);
    list1.next.next = new LinkedListNode(6);
    LinkedListNode list2 = new LinkedListNode(5);
    list2.next = new LinkedListNode(9);
    list2.next.next = new LinkedListNode(2);
    LinkedListNode sum = SumLists.add(list1, list2);
    while (sum != null) {
      System.out.print(sum.data + " -> ");
      sum = sum.next;
    }
  }
}