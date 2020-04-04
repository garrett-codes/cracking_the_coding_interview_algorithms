import java.util.HashSet;
import java.util.Set;

/*

GOAL: Find where there originally are zeroes in the matrix and where there were zeroes make the entire row and column zero

PROCESS: 
1) How do we keep track of the zeroes?
  i) HashSet to store where its zero for columns and rows
2) Process the matri and iterate through the entire matrix while adding zero values to the hash
  i) if its zero check if the hash has that key
    a) if it doesn't add the key
    b) if it does do nothing
3) Go through the hash and add zeroes where the keys say to.
  i) probably best to create another method that handles the zeroing process

*/

public class ZeroMatrix {

  public static void zero(int[][] matrix) { // returns nothing and accepts a 2d int array
    Set<Integer> rows = new HashSet<>(); // hash keeps track of rows with a zero
    Set<Integer> columns = new HashSet<>(); // hash keeps track of columns with a zero

    for (int row = 0; row < matrix.length; ++row) { // iterating through each row
      for (int column = 0; column < matrix[0].length; ++column) { // iterating through each column in a row
        if (matrix[row][column] == 0) { // when the value is zero at a specific index
          if (!rows.contains(row)) rows.add(row); // add row index to the rows hash
          if (!columns.contains(column)) columns.add(column); // add column index to the columns hash
        }
      }
    }

    // adding in zeroes
    addZeroes(rows, columns, matrix); // separate method for zeroing the columns and rows
  }

  private static void addZeroes(Set<Integer> rows, Set<Integer> columns, int[][] matrix) { // returns nothing and accepts the hashes and matrix from the other method

    // rows
    for (int element: rows) {
      for (int i = 0; i < matrix[element].length; ++i ) {
        matrix[element][i] = 0;
      }
    }

    // columns
    for (int element: columns) {
      for (int i = 0; i < matrix.length; ++i ) {
        matrix[i][element] = 0;
      }
    }
  }
  public static void main(String[] args) {

  }
}