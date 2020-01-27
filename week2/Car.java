public class Car {

  // instance variables: different for each instance of the class
  double mph;
  String color;

  // constructor: use this when creating an instance of the class
  public Car (double mph, String color) {
    this.mph = mph;
    this.color = color;
  }

  // We can overload the constructor, just like any other method.
  // Here's a version of the constructor that just sets the color.
  public Car (String color) {
    this.color = color;
  }

  // Instance methods
  // getters: use these to get the values of the instance variables directly
  double getMph() {
    return this.mph;
  }

  String getColor() {
    return this.color;
  }

 //  setters: use these to set or change the values of the instance variables
  void setMph(double mph) {
    this.mph = mph;
  }

  void setColor(String color) {
    this.color = color;
  }

  // instance menthod: how long does it take a particular car to stop
  // in icy conditions?
  double icyConditionBehavior() {
    return this.mph * 5;
  }

  // overwriting the toString() method that comes "for free"
  // with every class in Java
  public String toString() {
    String s = this.color + ", " + this.mph;
    return s;
  }

  // static methods
  // number of feet in a mile is always the same
  // doesn't depend on a particular intance of a class
  static double getFeet(double miles) {
    return miles * 5280;
  }


  // main method
  public static void main (String[] args) {

    // create a new Car instance, using the constructor
    Car c1 = new Car(50, "blue");

    // calling getters
    System.out.format("This car is %s.%n", c1.getColor());
    System.out.format("This car is going %.2f miles per hour.%n", c1.getMph() );

    // calling instance method, which must be called by c1
    double stoptime = c1.icyConditionBehavior();
    System.out.format("This car takes %.2f feet to stop.%n", stoptime);

    // calling static method getFeet, which does not need to be called by c1!
    double feetInAMile = getFeet(1);
    System.out.format("There are %.2f feet in a mile!%n", feetInAMile);
    double feetPerHour = getFeet(c1.getMph());
    System.out.format("This car is going %.2f feet per hour!%n", feetPerHour);

    // calling the setter to change the color of the car
    c1.setColor("red");
    System.out.format("I have painted this car %s.%n", c1.getColor());

    // calling the toString() method
    // you can call it explicitly, but it is what gets called
    // automaticlaly when you pass it to System.out.println
    System.out.println(c1.toString());
    System.out.println(c1);

  }

}
