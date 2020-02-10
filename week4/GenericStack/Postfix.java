import java.util.Scanner;

public class Postfix {

  public static void main(String[] args) {

    BCStack<Double> ss = new BCStackArray<Double>();
    System.out.println("Enter an expression to evaluate: ");
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    String[] parts = s.split("\\s+");

    for (int i=0; i<parts.length; i++) {
      String e = parts[i];
      if (e.equals("+")) {
        double d2 = ss.pop();
        double d1 = ss.pop();
        double result = d1 + d2;
        ss.push(result);
      } else if (e.equals("-")) {
        double d2 = ss.pop();
        double d1 = ss.pop();
        double result = d1 - d2;
        ss.push(result);
      } else if (e.equals("*")) {
        double d2 = ss.pop();
        double d1 = ss.pop();
        double result = d1 * d2;
        ss.push(result);
      } else if (e.equals("/")) {
        double d2 = ss.pop();
        double d1 = ss.pop();
        double result = d1 / d2;
        ss.push(result);
      } else {
        ss.push(Double.parseDouble(e));
      }

    }
    System.out.println(ss.toString());

  }
}
