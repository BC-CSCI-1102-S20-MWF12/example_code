public class FormattingOutput {


  public static void main (String[] args) {

    int x = 12;
    String y = "seltzer";
    double z = 3.14;
    System.out.format("My favorite drink is %s, my favorite number is %d, ", y, x);
    System.out.format("and my favorite truncation of pi is %.2f%n", z);

  }

}
