public class StringStackLinkedList implements StringStack{


  // create a Node called top and an int called size
  Node top;
  int size;

  // here's the node class
  class Node {
    String item;
    Node next;
  }


  // constructor
  public StringStackLinkedList() {
    this.top = null;
    this.size = 0;
  }

  // push: don't forget to check if stack is empty!
  public void push(String s) {
    Node newnode = new Node();
    newnode.item = s;
    newnode.next = top;
    top = newnode;
    size++;
  }

  // peek: easy, but check if empty!
  public String peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
      return null;
    }
    return top.item;
  }

  // pop: I'm providing it for you.
  public String pop() {
    if (this.isEmpty()) {
      System.out.println("The stack is empty.");
      return null;
    }
    String returnme = this.top.item;
    this.top = this.top.next;
    this.size--;
    return returnme;
  }

  // isEmpty()
  public boolean isEmpty() {
    return (this.size == 0);
  }

  // print out from the top of the stack
  public String toString() {
    return "Sorry -- you need to implement this for PS4!";
  }

  public static void main (String[] args) {
    StringStack ss = new StringStackLinkedList();
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
