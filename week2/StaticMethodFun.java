public class StaticMethodFun {

  static void sayHi() {
    System.out.println("Hi there!");
  }

  static void sayHiWithName(String s) {
    System.out.format("Hi there, %s!\n", s);
  }

  static double take_average(double d1, double d2, double d3) {
    double result = (d1+d2+d3) / 3;
    return result;
  }

  public static void main (String[] args) {
    sayHi();
    sayHiWithName(args[0]);
    System.out.println(take_average(3.0, 4.2, 89.340));
  }

}
