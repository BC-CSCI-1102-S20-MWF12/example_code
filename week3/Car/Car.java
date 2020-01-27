class Car {

  int num_passengers;
  String color;
  String country;
  double speed = 0;
  int num_wheels = 4;

  public Car(int num_passengers, String color) {
    this.num_passengers = num_passengers;
    this.color = color;
  }

  void go(double max_speed) {
    this.speed = max_speed;
    System.out.println("Vroom, vroom!");
  }

  void stop() {
    System.out.println("Screech!");
    this.speed = 0;
  }

  public String toString() {
    String s = color + ", " + num_passengers + ", " + speed;
    return s;
  }

}
