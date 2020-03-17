/*
Sorry this is not the permutation panlindrome walkthrough. Good less is that I failed to fully read what the question was asking. Haha
Goal: Check if a string is palindrome, or, if it is symmetrical
Draw it out: ["taco cat"] => true   ["not"] => false
               ^      ^               ^ ^
Process: 
1) Think about this problem... We only have to process a single string.
  i) You have a string that has symmetrical sides
2) We could process it with two pointers to see if the back matches the front
3) voila... simplest way to check if a string palindrome
4) Think about special cases like negletcing spaces and stuff...
*/


public class Palindrome {

  
  public static boolean check(String str) { // takes in a string as an input and returns true/false
    
    int j = str.length() - 1; // initializing our other pointer to start at the end of the string

    // only have to iterate half way through because we are using two pointers
    for (int i = 0; i < str.length()/2; ++i) {

      if (str.charAt(i) == ' ') --i; // this excludes spaces
      if (str.charAt(j) == ' ') --j; // excludes spaces from plaindrome matching

      if (str.charAt(i) != str.charAt(j--)) return false; // has to be the same on both sides of the string or its not a palindrome
    }
    
    return true;
  }
  public static void main(String[] args) {
    System.out.println("should be true: " + PalindromePermutation.check("taco cat")); //true
    System.out.println("should be true: " + PalindromePermutation.check("racecar")); //true
    System.out.println("should be false: " + PalindromePermutation.check("this is not a palindrome")); //false
  }
}
