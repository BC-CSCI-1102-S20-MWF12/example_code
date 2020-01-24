public class StaticMethodFun {

  static void sayHi() {
    System.out.println("Hi there!");
  }

  static void sayHiWithName(String s) {
    System.out.format("Hi there, %s!\n", s);
  }

  // This method takes three numbers and returns their average.
  // It's static because you shouldn't have to make an instance
  // of this class to average three numbers
  static double take_average(double d1, double d2, double d3) {
    double result = (d1+d2+d3) / 3;
    return result;
  }

  // I am overloading the take_average method.
  static double take_average(double[] numbers) {
    double total = 0;
    for (int i = 0; i < numbers.length; i++) {
      total += numbers[i];
    }
    return total / numbers.length;
  }

  public static void main (String[] args) {
    sayHi();
    sayHiWithName(args[0]);
    System.out.println(take_average(3.0, 4.2, 89.340));
    double[] darray = {3.0, 4.2, 89.340, 11.6};
    System.out.println(take_average(darray));

  }

}
