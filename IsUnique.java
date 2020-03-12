import java.util.Set;
import java.util.HashSet;

public class IsUnique {

  public static boolean isUnique(String str) {
    
    Set<Character> set = new HashSet<>();
    
    for (int i = 0; i < str.length(); ++i) {
      if (set.contains(str.charAt(i))) {
        return false;
      } else {
        set.add(str.charAt(i));
      }
    }

    return true;
  }
  public static void main(String[] args) {
    System.out.println(IsUnique.isUnique("hello"));
  }
}