class Toyota extends Car {

  public Toyota(int num_passengers, String color) {
    super(num_passengers, color);
    this.country = "Japan";
  }

  void turn_on_AC() {
    System.out.println("It's nice and cool in this car.");
  }

  public static void main (String[] args) {
    Toyota t = new Toyota(4, "blue");
    t.go(45);
    System.out.println(t.speed);

    t.stop();
    System.out.println(t.speed);
  }

}
