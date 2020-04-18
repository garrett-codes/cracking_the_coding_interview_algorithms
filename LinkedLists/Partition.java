/*
GOAL: Partition the linked list based on the number
APPROACH: Remove each node and add it to the appropriate list then combine it at the end
NOTES: You have to go through the entire list to know what elements are in it
You can keep the problem O(n) time complexity and there is not much need for additional space
*/

public class Partition {

  public static LinkedListNode partition(LinkedListNode head, int x) {
    LinkedListNode leftStart = null; // start of left side partition node
    LinkedListNode leftEnd = null; // end of left side partition node
    LinkedListNode rightStart = null; // start of right side partition node
    LinkedListNode rightEnd = null; // end of right side partition node

    while (head != null) {

      LinkedListNode next = head.next; // saving the next node before cutting off the current node
      head.next = null; // cutting off the current node
      if (head.data < x) { // handles if the node's data is less than the parititon 
        if (leftStart == null) { // handles if the left linked list was not made yet
          leftStart = head;
          leftEnd = leftStart;
        } else { // adds it to the end of the left linked list
          leftEnd.next = head;
          leftEnd = head;
        }
      } else {
        if (rightStart == null) { // handles if right linked list was not made yet
          rightStart = head;
          rightEnd = rightStart;
        } else { // adds node to the end of the linked list
          rightEnd.next = head;
          rightEnd = head;
        }
      }
      head = next;
    }

    leftEnd.next = rightEnd; // connects linkeded list
    if (leftStart != null) return leftStart; // checks to see if left side was made
    else return rightStart; // returns right if there is no left side 
  }
  public static void main(String[] args) {
    
  }
}