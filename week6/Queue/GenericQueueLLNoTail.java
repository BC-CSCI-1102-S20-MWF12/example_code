public class GenericQueueLLNoTail<T> implements GenericQueue<T> {
  Node front;
  int size;

  class Node {
    T info;
    Node next;
  }

  public void enqueue(T s) {

    // create a new Node
    Node n = new Node();
    n.info = s;

    // If the list is empty, it's easy: the new Node
    // is the front!
    // Otherwise you need to traverse the LL to the end.
    if (isEmpty()) {
      front = n;
    } else {
      Node traverse = front;
      while (traverse.next != null) {
        traverse = traverse.next;
      }
      // when you get to the last node, make its next
      // pointer point at your new node.
      traverse.next = n;
    }
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
    GenericQueue<String> mygq = new GenericQueueLLNoTail<String>();
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
