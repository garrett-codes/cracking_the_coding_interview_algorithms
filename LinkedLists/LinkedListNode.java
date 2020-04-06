public class LinkedListNode { // this is the class for a linked list

  /* 
  The attributes and methods inside this class are what allow it to act as a linked list
  */
  
  public LinkedListNode next, prev, last; // this is a recursive property
  /*
  Recursion is the idea of calling the same method/property within the property or method itself
  In this case we are declaring three linked list nodes inside the linked list node class
  We have a prev linked list node, a next and a last
  These are all pointer for your linked list
  The last one keeps track of the last nodei n the list, next and prev keep track of what the nodes connected to
  */
  public int data; // thia is what is actually stored in the linked list node: its just a variable
  public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){ // constructor used to create a linked list node. To create one you can provide the data, and what the nodes are connected to
    data = d;
    setNext(n); // you can set next or prev to null if you don't want it to be anything
    setPrevious(p);
  }

  public LinkedListNode(int d) {  // another constructor for just making a orphan node with just the data it stores, not other connections
    data = d;
  }

  public LinkedListNode() {} // here's another constructor that just makes a node with no new data or connections

  public void setNext(LinkedListNode n) { // sets the next pointer to another node or nothing (null)
    next = n;
    if (this == last) last = n;
    if (n != null && n.prev != this) { 
      n.setPrevious(this);
    }
  }

  public void setPrevious(LinkedListNode p) { // sets the prev pointer to another node or nothing (null)
    prev = p;
    if (p != null && p.next != this) { 
      p.setNext(this);
    }
  }

  public LinkedListNode clone() {  // clones a new node. This recursively creates next2 because it starts as null then if the current node we are on has a next it will first clone next then clone the actual node 
    LinkedListNode next2 = null; 
    if (next != null) {
      next2 = next.clone();
    }
    LinkedListNode head2 = new LinkedListNode(data, next2, null); 
    return head2;
  }
}
