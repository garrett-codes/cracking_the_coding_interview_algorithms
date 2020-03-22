/*
GOAL: Find the first unique char in a string.

PROCCESS: 
1) Will a data astructure help? 
  i) HashMap is good. A hashset would not work b/c we can't keep track of more than 2 occurrences accurately. HashMap<Character, Boolean>
  ii) what do we keep track of?
    a) The value of each key is a boolean that says whether it is unique or not
    b) Our HashMap would be structured as <Character, Boolean> 
2) ITERATE through with the HASHMAP
  i) we go through w/ the hashmap
    a) the map contains the key mark the value of the key false
    b) if not mark the value of the key true
    *** I feel this keeps it simpler. Most people were incrmenting but there is no point of keeping track of how many times it just matters if its alrdy there or not ***
3) Now that we know the unique chars or if there are any we go through the string again 
  i) if the char's value in the hashmap is true then thats the first unique string 
  ii) if we don't find any then we dont find any unique return '_'

**Note** using an array that kept track of positions of index is slightly faster because although hashmap's time complexity lookup is O(1) directly getting the index of an array is still going to run slightly faster
so if you are doing this on leetcode with a hash and run it don't be surprised if it comes up slower than you thought. It is still a good solution & I feel a better practice solution
*/

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

  public static char isUnique(final String str) { // is unique returns a character and takes in a string as an arg
    final Map<Character, Boolean> map = new HashMap<>(); // creating our hashmap with a character key and boolan value

    for (int i = 0; i < str.length(); ++i) { // for loop through the entire string
      if (map.containsKey(str.charAt(i))) { // if the map contains the character 
        map.put(str.charAt(i), false); // set the value of that key in the map to false
      } else {
        map.put(str.charAt(i), true); // if the map does not contain that char then set the value of that key to true
      }
    }

    for (int i = 0; i < str.length(); ++i) { // for loop through the string again to find the first occuring unique char (we now alrdy know all unique chars)
      if (map.get(str.charAt(i))) { // if the char has a value of true in the map
        return str.charAt(i); // returns the first unique char
      }
    }

    return '_'; // no unique char found
  }

  public static void main(final String[] args) {
    // unit tests
    System.out.println("should be e: " + FirstUniqueChar.isUnique("aabccccbefg"));
    System.out.println("should be b: " + FirstUniqueChar.isUnique("abcdefga"));
    System.out.println("should be _: " + FirstUniqueChar.isUnique("aabbccddd"));
  }
}