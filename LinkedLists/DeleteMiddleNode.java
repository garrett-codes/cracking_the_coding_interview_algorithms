/*
GOAL: Given the node as an argument delete it. Constraints it must not be the last node. 

APPROACH: Make the node's data we are on equal to that of the following node and then delete the following node by having the next pointer skip it
*/

public class DeleteMiddleNode {

  public static void delete(LinkedListNode node) { // mutation method that reutns nothing and accepts a node as an argument

    if (node == null || node.next == null ) return; // if the node is currently null or if its the last node ignore it

    node.data = node.next.data; // setting the data of the current node we are that we want to "delete" to the data of the one after it
    node.next = node.next.next; // setting the next pointer of the node to the next node's next node
  }

  public static void main(String[] args) {
    
  }
}