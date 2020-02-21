import java.io.*;

public class ExceptionFun  {
  public static void main(String[] args) throws IOException {

    try {
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      String line;
      while ( (line = in.readLine()) != null ) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println(e + " does not exist. Please try again.");
    }
  }

}
