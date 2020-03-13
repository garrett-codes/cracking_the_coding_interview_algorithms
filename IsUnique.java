import java.util.Set;
import java.util.HashSet;

/* overall this solution should solve the algorithm in O(n) time complexity 
because you are iterating through the string of n characters and it takes about O(1)
to access data from a hashset. All of the other processes are thought of as instant for simplicity.
*/
public class IsUnique { // the class or object. In this case the entire program

  // this is a method that returns a boolean
  public static boolean isUnique(String str) { /* the public part means you can access 
                                               this method outside of the object    */
    Set<Character> set = new HashSet<>();     /* static this method is used by the class
                                               and not the instance of the object*/
    for (int i = 0; i < str.length(); ++i) { // typical for loop starting at 0
      if (set.contains(str.charAt(i))) { // contains finds if the set contains the char of the string at the ith index
        return false; // if it does then it returns false cause theres duplicates
      } else {
        set.add(str.charAt(i)); // otherwise it adds it to the set to keep track of it
      }
    }
    // if it gets to the end then it must be unique
    return true;
  }
  public static void main(String[] args) { // this is the main method for the class that gets executed when you compile and run the program as an executable
    System.out.println(IsUnique.isUnique("hello")); // prints out false
    System.out.println("unique"); // prints out true
  }
}