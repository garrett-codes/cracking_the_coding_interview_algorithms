/*
GOAL: Rotate a matrix 90 degree

PROCCESS: 

1) check the size of the rows and the columns 
2) establish the layer we are on
  i) have variable keeping track of the layer we are on
  ii) boundary is n / 2 where n is the length of the matrix


*/




public class RotateMatrix {

  public static void rotate90(int[][] matrix) {
    if (matrix.length != matrix[0].length) return;

    int n = matrix.length;
    
    for (int layer = 0; layer < n / 2; ++layer) { // only going to half matrix length b/c otherwise we would be repeating

      int first = layer; // note what layer we are intially on and use it as a boundary for when we process the shifting
      int last = (n - 1) - layer; // uses the layer as an end boundary to process the shifting

      for (int i = first; i < last; ++i) {
        int offset = i - first; // offset is this problems way of incrementing or moving to the next set for that layer

        int top = matrix[first][i]; // top saving as a temp variable and swapping the rest

        //left -> top
        matrix[first][i] = matrix[last - offset][first];

        //bottom -> left
        matrix[last - offset][first] = matrix[last][last - offset];

        //right -> bottom
        matrix[last][last - offset] = matrix[i][last];

        //top -> right 
        matrix[i][last] = top;
      }

    }
  }
  public static void main(String[] args) {

  }
}