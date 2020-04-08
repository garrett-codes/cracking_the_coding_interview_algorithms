/*
GOAL: To remove the duplicates in the linked list

SOLUTION: Time comeplexity is O(n) b/c have to iterate throough the entire list and the delte operation is O(1) and Space Complexity is O(n) b/c of hashtable

*/


import java.util.Set;
import java.util.HashSet;

public class ReomveDups {

  public static void remove(LinkedListNode list) {
    Set<Integer> set = new HashSet<>(); // ds to store any occurences of an integer in
    LinkedListNode prev = null; //points to the previous node that we are on in the interation
    LinkedListNode curr = list; // points to the current node of the iteration
    while (curr != null) { // conditional that determines whether you are the end of the linked list or not
      if (set.contains(curr.data)) { // determine if we already seen this value already
        prev.next = curr.next; // this removes the node because it is a duplicate
      }
      else {
        set.add(curr.data); // if we did not see the val then add it to the set
        prev = curr; // set prev pointer to its next pointer (prev = prev.next is prev = curr)
      }
      
      curr = curr.next; // incrementing the pointer of current node by one
    }
    
  }
  public static void main(String[] args) {

  }
}