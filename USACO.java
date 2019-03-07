import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    try{
      // read in file
      int[][] grid;
      int[][] instructions;
      int r, c, e, n;
      File file = new File(filename);
      Scanner scan = new Scanner(file);
      r = Integer.parseInt(scan.next());
      c = Integer.parseInt(scan.next());
      e = Integer.parseInt(scan.next());
      n = Integer.parseInt(scan.next());
      grid = new int[r][c];
        for (int y = 0; y < r; y++){
          for (int x = 0; x < c; x++){
            grid[y][x] = Integer.parseInt(scan.next());
          }
        }
        instructions = new int[n][3];
        for (int x = 0; x < n; x++){
          for (int i = 0; i < 3; i++){
            instructions[x][i] = Integer.parseInt(scan.next());
          }
        }
        // carry out instructions
        for (int[] i : instructions){
          int rs = i[0];
          int cs = i[1];
          int ds = i[2];
          while (ds > 0){
            int max = 0;
            for (int y = rs - 1; y < rs + 2; y++){
              for (int x = cs - 1; x < cs + 2; x++){
                if (grid[y][x] > max) max = grid[y][x];
              }
            }
            for (int y = rs - 1; y < rs + 2; y++){
              for (int x = cs - 1; x < cs + 2; x++){
                if (grid[y][x] == max) grid[y][x]--;
              }
            }
            ds--;
          }
        }
        int total = 0;
        for (int[] y : grid ){
          for (int x : y){
            if (e - x > 0) total += e - x;
          }
        }
        return total * 72 * 72;

      }

      catch (NoSuchElementException e){
        System.out.println("invalid file");
      }
      return 0;
  }

  public static int silver(String filename){
    return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze(args[0]));
  }
}
