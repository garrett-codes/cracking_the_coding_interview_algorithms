/*
GOAL: See if a string is one edit away from being another string
  - Replace
  - Insert = Delete (kind of)

PROCCESS: 
1) Process the strings to figure out whetehr we want to test for replace or inserting/deleting
  i) if length of one is greater than the other throw it into the insertion category
    a) iterate through both strings and make sure the chars are the same
      1) if we find that one two are not the same then we say one insertion was made (maybe we can use a boolean to keep track of this) 
        We also have to make sure to not increment this index of the smaller one
      2) if an insertion was alrdy made and we find another mismatch then we return false
  ii) if length is the same throw it into the replace category
    a) here we are looking for a mismatch just like in insertion however theres less steps involved because we a just assume its replaced and move on
  iii) if the length differs more than one false

  There are more edits you can make such as switching but that would make the problem a lot more involved and the book just went with these guys
  Make sure you clarify what the interviewer wants!!!
*/


public class OneAway {

  public static boolean check(String str1, String str2) {
    if (str1 == str2) return true; // is they are the same just return truw
    else if (str1.length() == str2.length()) { // if they are the same length it must be a replacement problem
      return replace(str1, str2);
    } else if (str1.length() == str2.length() + 1) { // if it is one is bigger than the other we must do an insertion
      return insert(str1, str2);
    } else if (str2.length() == str1.length() + 1) { // if one is bigger than the other we must do an insertion
      return insert(str2, str1);
    }

    return false; 
  } 

  // insertiton step
  private static boolean insert(String big, String small) {
    int j = 0; // big pointer starts at zero just like i does for small pointer
    boolean inserted = false; // keeps track of whether the insertion happened alrdy
    for (int i = 0; i < small.length(); ++i) {
      if (big.charAt(j) != small.charAt(i)) { // if the chars do not equal each other then
        if (inserted) return false;  // check if it has been inserted alrdy return false because it needs more than one insertion
        else {
          inserted = true; // set inserted to true to know for future purposes 
          --i; //decrement i by one because it will increment from the for loop and we want it to stay on this char
        }
      }
      ++j; // increment big pointer each looop
    }
    return true; // return true because only had to insert once 
  }

  // replacement step
  private static boolean replace(String str1, String str2) {
    boolean replaced = false;
    for (int i = 0; i < str1.length(); ++i) {
      if (str1.charAt(i) != str2.charAt(i)) {
        if (replaced) return false; // has more than one repalcements
        else {
          replaced = true; // now we know it was replaced alrdy once
        }
      }
    }
    return  true;
  }


  public static void main(String[] args) {
    System.out.println("should be true: " + OneAway.check("pale", "ple"));
    System.out.println("should be true: " + OneAway.check("pales", "pale"));
    System.out.println("should be true: " + OneAway.check("pale", "bale"));
    System.out.println("should be false: " + OneAway.check("pale", "bae"));

  }
}