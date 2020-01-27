public class Toyota extends Car {

  public Toyota(int num_passengers, String color) {
    super(num_passengers, color);
    this.country = "Japan";
  }

  void report_reliability() {
    System.out.println("Consumer Reports says I am very reliable!");
  }

  public String toString() {
    String s = color + ", " + num_passengers + ", " + speed + ", very reliable";
    return s;
  }

  public static void main (String[] args) {
    Toyota t = new Toyota(5, "blue");
    t.go(65);
    System.out.println(t);
    t.stop();
    System.out.println(t);
    t.report_reliability();
  }

}
