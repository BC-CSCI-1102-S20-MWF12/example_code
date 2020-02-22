public class GenericQueueCircularArray<T> implements GenericQueue<T> {

  // static variables
  // Here we're saying the maximum size of the queue is 10.
  int CAPACITY = 5;

  // instance variables

  T[] storage;  // array to store queue
  int size;     // size of queue
  int front;    // index of front of queue
  int tail;     // index of tail of queue

  // constructor
  public GenericQueueCircularArray () {
    // You want to create an array, but you aren't allowed to
    // create an array of a generic type, so this is a way around that.
    // Create an array of Objects that you then cast to type T
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    this.storage = temp;
    this.size = 0;
  }

  // Interface methods
  public void enqueue (T item) {
    if (size == CAPACITY) {
      System.out.println("Queue is full.");
      return;
    }

    // otherwise, if there is room to add something...
    System.out.println("Enqueuing " + item.toString());

    // if the queue is not empty...
    if (!isEmpty()) {
      // increment the tail, and wrap around if necessary
      tail = (tail+1) % CAPACITY;
    }

    // and if the queue is empty, set both front and tail to 0
    else {
      front = 0;
      tail = 0;
    }

    // enter the item into the queue and increment size
    storage[tail] = item;
    size++;

  }

  // remove from beginning: more complicated
  public T dequeue() {
    if (isEmpty()) return null;

    // Get the front element.
    T toreturn = storage[front];
    System.out.println("Dequeueing " + toreturn.toString());
    storage[front] = null; // (just so my toString() words nicely)

    // Move front forward 1 and wrap around if necessary
    front = (front+1) % (storage.length);

    // Decrement size.
    size--;

    // and if the queue is now empty, reset both front and tail to 0
    if (isEmpty()) {
      tail = 0;
      front = 0;
    }

    // return the saved out front element
    return toreturn;

  }

  // getFront, easy
  public T getFront() {
    if (isEmpty()) {
      return null;
    }
    return storage[front];
  }

  // getSize, easy
  public int getSize() {
    return size;
  }

  // isEmpty, easy
  public boolean isEmpty() {
    return (size ==0);
  }

  // This toString() method displayes the queue with the
  // front and tail indices, just to make it easier to visualize
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<storage.length; i++) {
      sb.append(storage[i] + " ");
    }
    sb.append("\n");
    for (int i=0; i<storage.length; i++) {
      if (front == i) {
        sb.append("F");
      }
      if (tail == i) {
        sb.append("T");
      }
      int stop = 4;
      if (storage[i] != null) {
        stop = storage[i].toString().length();
      }
      for (int q=0; q <= stop; q++) {
        sb.append(" ");
      }
    }
    sb.append("\n");
    return sb.toString();

  }

  // main
  public static void main(String[] args) {
    GenericQueue<String> q = new GenericQueueCircularArray<String>();
    q.enqueue("Boston");
    System.out.println(q.toString());

    q.enqueue("Cambridge");
    System.out.println(q.toString());

    q.enqueue("Somerville");
    System.out.println(q.toString());

    q.enqueue("Lexington");
    System.out.println(q.toString());

    q.enqueue("Chestnut_Hill");
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.enqueue("Brookline");
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.enqueue("Allston");
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.dequeue();
    System.out.println(q.toString());

    q.enqueue("Quincy");
    System.out.println(q.toString());


  }
}
