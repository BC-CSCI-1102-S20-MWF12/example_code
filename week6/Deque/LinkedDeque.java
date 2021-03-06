public class LinkedDeque<T> implements Deque<T>{

  Node front;
  Node tail;
  int size;

  // instance variables
  // Remember: we have a pointer to front and tail!


  // Node inner class
  // Remember: this is a doubly linked list!

  private class Node {
    Node prev;
    Node next;
    T data;
  }


  // Add element to the front.
  public void addFront(T item) {

    Node n = new Node();
    n.data = item;

    if (isEmpty()) {
      tail = n;
    } else {
      n.next = front;
      front.prev = n;
    }
    front = n;
    size++;

  }

  // Add element to the tail
  public void addTail(T item) {
    Node addme = new Node();
    addme.data = item;

    // if adding to an empty list, both front and tail
    // must point at the new node!
    if (this.isEmpty()) {
      front = addme;
    } else {
      addme.prev = tail;
      tail.next = addme;
    }
    tail = addme;
    size++;
  }

  // When removing, special cases are isEmpty and size==1
  public T removeFront() {
    // if it's empty, return null
    if (isEmpty()) {
      return null;
    }

    // otherwise, save out the front element
    T returnme = front.data;

    // if the size is 1, set both front and tail to null
    if (getSize() == 1) {
      front = null;
      tail = null;
    }

    else {
      front = front.next;
      front.prev = null;
    }
    size--;
    return returnme;
  }

  public T removeTail() {
    if (isEmpty()) {
      return null;
    }
    T returnme = tail.data;
    if (getSize() == 1) {
      front = null;
      tail = null;
    } else {
      tail.prev.next = null; // this sounds crazy, so draw a picture
      tail = tail.prev;
    }
    size--;
    return returnme;
  }

  // peeking is easy - just return the data in the front or tail node
  public T peekFront() {
    if (isEmpty()) return null;
    return front.data;

  }

  public T peekTail() {
    if (isEmpty()) return null;
    return tail.data;

  }

  // the usual...
  public boolean isEmpty() {
    return (size == 0);
  }

  public int getSize() {
    return size;
  }

  // I wrote this method so I could test my code!
  public void printDeque() {
    Node n = front;
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
    System.out.println();
  }

  public static void main (String[]  args) {
    LinkedDeque<String> mydeque = new LinkedDeque<String>();
    mydeque.addFront("dog");
    mydeque.printDeque();
    mydeque.addFront("tree");
    mydeque.printDeque();
    mydeque.addTail("elephant");
    mydeque.printDeque();
    mydeque.addFront("animal");
    mydeque.addFront("piano");
    mydeque.printDeque();
    mydeque.removeFront();
    mydeque.printDeque();
    mydeque.removeTail();
    mydeque.removeTail();
    mydeque.printDeque();
    mydeque.addFront("piano1");
    mydeque.addFront("piano2");
    mydeque.addFront("piano3");
    mydeque.addFront("piano4");
    mydeque.addFront("piano5");
    mydeque.addTail("piano6");
    mydeque.addTail("piano7");
    mydeque.addTail("piano8");
    mydeque.addTail("piano9");
    mydeque.addTail("piano10");
    mydeque.printDeque();


  }

}
