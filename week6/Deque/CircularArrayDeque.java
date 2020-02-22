public class CircularArrayDeque<T> implements Deque<T> {

  // static variables
  // Here we're saying the maximum size of the deque is 10.
  int CAPACITY = 10;

  // instance variables
  T[] storage;    // you need an array to store the deque
  int front;      // index of the front of the deque
  int tail;       // index of the tail of the deque
  int size;       // size of the deque

  // constructor
  public CircularArrayDeque () {
    // You want to create an array, but you aren't allowed to
    // create an array of a generic type, so this is a way around that.
    // Create an array of Objects that you then cast to type T
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[CAPACITY];
    this.storage = temp;
    this.size = 0;
  }

  // Interface methods

  // NOTE: Some of the "wrap around" syntax can be made much simpler using
  // the modulus operator %. I am being explicit here so you can
  // see exactly what is happening. Feel free to use % for PS6.

  // add to the front
  public void addFront (T item) {
    if (size == CAPACITY) throw new RuntimeException("Stack Overflow.");

    // If the current front index is 0, then put the new element
    // at the end of the array.
    // i.e., wrap around backwards.
    System.out.println("Adding to front: " + item.toString());
    if (front == 0) {
      front = CAPACITY-1;
    } else {
      front--;
    }
    // Otherwise, add the element to the index before the current front index.

    storage[front] = item;

    if (size == 0) {
      tail = front;
    }

    // don't forget, if you're adding to an empty list,
    // front and tail will be the same

    size++;
    // increment size

  }

  // add to the tail
  public void addTail(T item) {
    if (size == CAPACITY) throw new RuntimeException("Stack Overflow.");

    // If the current tail index is CAPACITY-1, then add to index 0,
    // i.e., wrap around forwards.
    System.out.println("Adding to tail: " + item.toString());

    if (tail == CAPACITY-1) {
      storage[0] = item;
      tail = 0;
    }
    // Otherwise, add the element to the index before the current front index.
    else {
      storage[tail+1] = item;
      tail++;
    }

    // don't forget, if you're adding to an empty list,
    // front and tail will be the same
    if (size == 0) {
      front = tail;
    }
    size++;
  }

  // remove from tail
  public T removeTail() {

    // if it's empty, return null
    if (isEmpty()) return null;

    // otherwise, save out whatever is at tail
    T returnme = storage[tail];
    System.out.println("Removing from tail: " + returnme.toString());

    storage[tail] = null;

    // if size is 1, reset tail and front to 0
    if (getSize()==1) {
      tail = 0;
      front= 0;
    }

    // otherwise, either decrement tail
    // or if it's zero, set it to CAPACITY-1
    //tail = (tail-1) % CAPACITY;
    if (tail == 0) {
      tail = CAPACITY-1;
    } else {
      tail--;
    }

    // decrement size
    size--;

    // return what you saved out above
    return returnme;

  }

  // remove from front
  public T removeFront() {
    if (isEmpty()) return null;

    T returnme = storage[front];
    storage[front] = null;
    System.out.println("Removing from front: " + returnme.toString());


    // if size is 1, reset tail and front to 0
    if (size == 1) {
      tail = 0;
      front = 0;
    }
    // otherwise, increment front,
    // and if it exceeds CAPACITY, set to 0
    else {
      front++;
      if (front >= CAPACITY) {
        front = 0;
      }
    }

    size--;
    return returnme;

  }

  // peekFront, easy
  public T peekFront() {
    if (isEmpty()) {
      return null;
    }
    return storage[front];
  }

  // peekTail, easy
  public T peekTail() {
    if (isEmpty()) {
      return null;
    }
    return storage[tail];
  }

  // getSize, easy
  public int getSize() {
    return size;
  }

  // isEmpty, easy
  public boolean isEmpty() {
    return (size ==0);
  }

  // print out the deque from front to tail
  public void printDeque() {
    System.out.println();
    for (int i = 0; i < size; i++) {
      System.out.println(storage[(i+front)%CAPACITY]);
    }
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


  // main()
  public static void main(String[] args) {
    CircularArrayDeque<String> mydeque = new CircularArrayDeque<String>();
    mydeque.addFront("dog");
    System.out.println(mydeque.toString());
    mydeque.addFront("tree");
    System.out.println(mydeque.toString());
    mydeque.addTail("elephant");
    System.out.println(mydeque.toString());
    mydeque.addFront("animal");
    mydeque.addFront("piano");
    System.out.println(mydeque.toString());
    mydeque.removeFront();
    System.out.println(mydeque.toString());
    mydeque.removeTail();
    mydeque.removeTail();
    System.out.println(mydeque.toString());
    mydeque.addFront("piano1");
    mydeque.addFront("piano2");
    mydeque.addFront("piano3");
    mydeque.addFront("piano4");
    mydeque.addFront("piano5");
    System.out.println(mydeque.toString());
    mydeque.addTail("piano6");
    System.out.println(mydeque.toString());
    mydeque.addTail("piano7");
    System.out.println(mydeque.toString());

  }
}
