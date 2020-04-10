public class nthToLast {

  public static LinkedListNode find(LinkedListNode list, int n) {

    LinkedListNode curr = list; // initallizing the curr pointer
    LinkedListNode nth = list; // initallizing the nth pointer

    // increments curr so that it gets n aheaad of nth
    for (int i = 0; i < n; ++i) {
      if (curr == null) return null;
      curr = curr.next; // incrementing curr by one node
    }

    // increment curr and nth until curr hits null
    while (curr != null) {
      curr = curr.next; // incrementing the curr pointer
      nth = nth.next; // incrementing the nth pointer
    }

    return nth; // rerturns the nth to last pointer in the list




  }

  public static void main(String[] args) {
    
  }
}