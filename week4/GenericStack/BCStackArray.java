public class BCStackArray<T> implements BCStack<T>{
  static int MAX_SIZE = 4;

  T[] storage;
  int size;

  public BCStackArray() {
    // You want to create an array, but you aren't allowed to
    // create an array of a generic type, so this is a way around that.
    // Create an array of Objects that you then cast to type T
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[MAX_SIZE];
    this.storage = temp;
    this.size = 0;
  }

  public void push(T s) {
    if (this.size == MAX_SIZE) {
      System.out.println("Maximum size reached.");
      return;
    }
    this.storage[size] = s;
    this.size++;
  }

  public T peek() {
    // fill in implementation here
    if (this.isEmpty()) {
      System.out.println("The stack is empty!");
      return null;
    }
    return this.storage[size-1];

  }

  public T pop() {
    // fill in implementation here
    if (this.isEmpty()) {
      System.out.println("The stack is empty!");
      return null;
    }
    T returnme = this.storage[this.size-1];
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
      result = result + this.storage[i].toString() + " ";
    }
    return result;
  }

  public static void main (String[] args) {
    BCStack<String> ss = new BCStackArray<String>();
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

    // But we can also have a stack of Doubles!
    BCStack<Double> ds = new BCStackArray<Double>();
    ds.push(4.2);
    ds.push(702097.);
    System.out.println(ds.toString());
    System.out.println(ds.peek());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());

  }

}
