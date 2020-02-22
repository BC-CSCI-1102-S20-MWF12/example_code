public class GenericQueueLL<T> implements GenericQueue<T> {
  Node front;
  Node tail;
  int size;

  class Node {
    T info;
    Node next;
  }

  public void enqueue(T s) {

    // create a new Node
    Node n = new Node();
    n.info = s;

    // if the list is empty, you need to make
    // sure front also points at the new node.
    // otherwise, just add the new node to the end.
    if (isEmpty()) {
      front = n;
    } else {
      tail.next = n;
    }
    tail = n;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) {
      return null;
    }
    T returnme = front.info;

    // Set front to the next node.
    // This will set front to null if the
    // list was of size 1.
    front = front.next;

    // And if the list was size 1, you need to
    // set tail to null as well.
    if (size == 1) {
      tail = null;
    }
    size--;
    return returnme;

  }

  public T getFront() {
    if (isEmpty()) {
      return null;
    }
    T returnme = front.info;
    return returnme;
  }

  public boolean isEmpty() {
    return (size==0);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node traverse = front;
    while (traverse != null) {
      sb.append(traverse.info + " ");
      traverse = traverse.next;
    }
    return sb.toString();
  }

  // getSize, easy
  public int getSize() {
    return size;
  }
  
  public static void main(String[] args) {
    GenericQueue<String> mygq = new GenericQueueLL<String>();
    mygq.enqueue("cat");
    mygq.enqueue("dog");
    mygq.enqueue("parrot");
    mygq.enqueue("chicken");

    System.out.println(mygq.getFront());
    System.out.println(mygq.toString());
    System.out.println(mygq.dequeue());
    System.out.println(mygq.dequeue());
    System.out.println(mygq.dequeue());
    System.out.println(mygq.dequeue());
    System.out.println(mygq.dequeue());
    System.out.println(mygq.isEmpty());

  }

}
