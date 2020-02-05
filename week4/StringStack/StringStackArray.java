public class StringStackArray implements StringStack{
  static int MAX_SIZE = 4;

  String[] storage;
  int size;

  public StringStackArray() {
    this.size = 0;
    this.storage = new String[MAX_SIZE];
    for (int i = 0; i<MAX_SIZE; i++) {
      this.storage[i] = null;
    }
  }

  public void push(String s) {
    if (this.size == MAX_SIZE) {
      System.out.println("Maximum size reached.");
      return;
    }
    this.storage[size] = s;
    this.size++;
  }

  public String peek() {
    // fill in implementation here
    if (this.isEmpty()) {
      System.out.println("The stack is empty!");
      return null;
    }
    return this.storage[size-1];

  }

  public String pop() {
    // fill in implementation here
    if (this.isEmpty()) {
      System.out.println("The stack is empty!");
      return null;
    }
    String returnme = this.storage[this.size-1];
    this.storage[this.size-1] = null;
    this.size--;
    return returnme;
  }

  public boolean isEmpty() {
    return (this.size == 0);
  }

  // print out from the top of the stack
  public String toString() {
    String result = "";
    for (int i=size-1; i>=0; i--) {
      result = result + this.storage[i] + " ";
    }
    return result;
  }

  public static void main (String[] args) {
    StringStack ss = new StringStackArray();
    ss.push("dog");
    ss.push("cat");
    ss.push("gerbil");
    ss.push("parrot");
    ss.push("pony");
    System.out.println(ss.toString());
    System.out.println("Popping off " + ss.pop());
    System.out.println(ss.toString());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println(ss.toString());
    ss.push("apple");
    ss.push("orange");
    System.out.println(ss.toString());


  }

}
