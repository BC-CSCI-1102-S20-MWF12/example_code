public class SayHello {


  public static void main (String[] args) {

    // args[0] is the first command line argument
    // If you run this program without a command line argument
    // it will throw an exception (give you an error).

    String thename = args[0];
    System.out.println("Hi " + thename + "!");
  }

}
