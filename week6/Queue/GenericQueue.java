

public interface GenericQueue<T> {
  void enqueue(T s);
  T dequeue();
  T getFront();
  boolean isEmpty();
  String toString();
  int getSize();
}
