import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    int[][] grid;
    int[][] instructions;
    int r;
    int c;
    int e;
    int n;
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
      for (int i = 0; i < 3; x++){
        instructions[x][i] = Integer.parseInt(scan.next());
      }
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
