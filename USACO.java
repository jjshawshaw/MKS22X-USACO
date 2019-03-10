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

  public static int silver(String filename) throws FileNotFoundException{
    //stores map
    char[][] grid;
    //stores num of possible ways to reach a square
    int[][] pos;
    int[][] moves = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
    };
    int n, m, t, r1, r2, c1, c2;
    //reads in file
    File file = new File(filename);
    Scanner scan = new Scanner(file);
    n = Integer.parseInt(scan.next());
    m = Integer.parseInt(scan.next());
    t = Integer.parseInt(scan.next());
    grid = new char[n][m];
      for (int y = 0; y < n; y++){
        String line = scan.next();
        for (int x = 0; x < m; x++){
          grid[y][x] = line.charAt(x);
        }
      }
    r1 = Integer.parseInt(scan.next()) - 1;
    c1 = Integer.parseInt(scan.next()) - 1;
    r2 = Integer.parseInt(scan.next()) - 1;
    c2 = Integer.parseInt(scan.next()) - 1;
    //sets up pos
    pos = new int[n][m];
    for (int y = 0; y < n; y++){
      for (int x = 0; x < m; x++){
        pos[y][x] = 0;
        if (y == r1 && x == c1) pos[y][x] = 1;
      }
    }
    //calculates possible ways to reach squares
    while (t > 0){
      //printgrid(pos, grid);
      int[][] newpos = new int[n][m];
      for (int y = 0; y < n; y++){
        for (int x = 0; x < m; x++){
          newpos[y][x] = pos[y][x];
        }
      }
      for (int y = 0; y < n; y++){
        for (int x = 0; x < m; x++){
          if (pos[y][x] > 0){
            for (int[] i : moves){
              if (inbounds(y + i[0], x + i[1], n, m) &&
                  grid[y + i[0]][x + i[1]] != '*'){
              newpos[y + i[0]][x + i[1]] += pos[y][x];
              }
            }
              boolean alone = true;
              for (int[] i : moves){
                if (inbounds(y + i[0], x + i[1], n, m) &&
                    grid[y + i[0]][x + i[1]] != '*' &&
                    pos[y + i[0]][x + i[1]] != 0){
                alone = true;
                }
            }
            if (alone) newpos[y][x] = 0;
          }
        }
      }
      pos = newpos;
      t--;
    }
    return pos[r2][c2];
  }

  private static void printgrid(int[][] pos, char[][] grid){
    for (int y = 0; y < pos.length; y++){
      for (int x = 0; x < pos[0].length; x++){
        String s = pos[y][x] + "";
        if (grid[y][x] == '*') s = "*";
        while (s.length() < 4){s += " ";}
        System.out.print(s);
      }
      System.out.println();
    }
    System.out.println("\n");
  }

  private static boolean inbounds(int r, int c, int n, int m){
    return (r >= 0 && c >= 0 && r < n && c < m);
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(silver(args[0]));
  }
}
