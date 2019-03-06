import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    int[][] grid;
    ArrayList<String> instructions = new ArrayList<String>();
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
    System.out.println(r + ", " + c + ", " + e + ", " + n);
    return 0;
  }

  public static int silver(String filename){
    return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze(args[0]));
  }
}
