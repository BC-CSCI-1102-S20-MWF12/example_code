public class BCStackResizingArray<Item> implements BCStack<Item> {
    private Item[] storage;         // array of items
    private int size;            // number of elements on stack


    // weird thing you have to do to make a primitive array of generic type
    public BCStackResizingArray() {
      @SuppressWarnings("unchecked")
      Item[] temp = (Item[]) new Object[2];
      storage = temp;
    }

    public int getSize(){
	return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // method to resize an array from current size to size of capacity argument
    private void resize(int capacity) {
      @SuppressWarnings("unchecked")
      Item[] temp = (Item[]) new Object[capacity];
      for (int i = 0; i < size; i++) {
        temp[i] = storage[i];
      }
      storage = temp;
    }

    // regular push, but resize array if it's too small
    public void push(Item item) {
        if (size == storage.length) resize(2*storage.length);
        storage[size++] = item;
    }

    // regular pop, but resize array if it's too big
    public Item pop() {
        if (isEmpty()) {
          return null;
        }
        Item item = storage[size-1];
        storage[size-1] = null;
        size--;

        // shrink size of array if necessary
        if (size > 0 && size == storage.length/4) resize(storage.length/2);
        return item;
    }


    public Item peek() {
        if (isEmpty()) return null;
        return storage[size-1];
    }



    public static void main(String[] args) {
        BCStack<String> s = new BCStackResizingArray<String>();
        System.out.println("The length of this stack is " + s.getSize());
        s.push("strawberries");
        s.push("blueberries");
        System.out.println("The length of this stack is " + s.getSize());
        s.push("elderberries");
        s.push("cloudberries");
        System.out.println("The length of this stack is " + s.getSize());
        System.out.println("The top of the stack is " + s.peek());
        System.out.println("The whole LIFO stack is as follows:");
        while (!s.isEmpty()) {
          System.out.println(s.pop());
        }

    }
}
