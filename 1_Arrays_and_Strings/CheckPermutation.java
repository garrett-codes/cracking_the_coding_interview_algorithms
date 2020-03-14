import java.util.HashMap;
import java.util.Map;


public class CheckPermutation {

  /*
  Process:
  1) create the hashmap data structure to use to keep track of chars in string 1 
  2) process the first string and add it to a hashmap where the keys are the characters and the values are # of times a char apprears 
  3) process the second string
    i) if the hash map doesn't contain a char return false right away
    ii) if the hash map does contain it and the value is greater than zero return false because theres no more left
    ii) if the hash map contains it and the value is greater than zero decrement the value by one and continue processing the string
  4) If we get to the end without returning false, return true becasue it passed all of the tests
  Peep the O(n) time complexity :)
  I guess I was more concerned with time complexity approaching this and I traded it off for having an O(n) space complexity.
  The typical way of solving it appears to be just sorting the two in O(nlog(n)) time complexity and then you are using O(1) space complexity.
  */

  // checks if str1 is a permutation of the other
  public static boolean check(String str1, String str2) { // str1 and str2 are the arguments and we are returning t/f whether they're permutations of each other

    if (str1.length() != str2.length()) return false; // lets first knock out some null cases (different sizes == not permutations of each other)

    Map<Character, Integer> map = new HashMap<>(); // create our HashMap to store the first str's results

    // process the first string adding its chars to the hashmap with their frequency
    for (int i = 0; i < str1.length(); ++i) { 
      if (map.containsKey(str1.charAt(i))) {
        map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1); // in this we are incrmenting the frequency of the string by one
      }
      else {
        map.put(str1.charAt(i), 1); // we are adding the char into the map with a freq of 1 because this is the first ocurrence of it
      }
    }

    // process the second string
    for (int i = 0; i < str2.length(); ++i) {

      // checking if the map contains the char in str2
      if (map.containsKey(str2.charAt(i))) {
        if (map.get(str2.charAt(i)) > 0) {
          map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1); // decrementing the map by 1 becasue this char has been processed
        }
        else {
          return false; // returning flase because it does not contain that frequency of chars
        }
      }
      else {
        return false; // returning false b/c it doesn't contain that char
      }
    }

    return true; // processed it fully and got not falses triggered
    
    
  }

  // unit testing my code
  public static void main(String[] args) {
    System.out.println(CheckPermutation.check("abc", "bca")); // returns true
    System.out.println(CheckPermutation.check("grh", "ggh")); // retusn false
    System.out.println(CheckPermutation.check("ggh", "grh")); // retusn false
  }
}