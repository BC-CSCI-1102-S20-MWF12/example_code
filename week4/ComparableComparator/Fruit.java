import java.util.*;

public class Fruit implements Comparable<Fruit> {

  // instance variable String fruit NameComp
  String fruitname;

  // constructor: set fruit name
  public Fruit(String fruitname) {
    this.fruitname = fruitname;
  }


  // implement
   public int compareTo(Fruit f) {
     if (this.fruitname.length() > f.fruitname.length()) {
       return 1;
     } else if (f.fruitname.length() > this.fruitname.length()) {
       return -1;
     } else {
       return 0;
     }
   }


  public static void main(String[] args) {
    Fruit g = new Fruit("banana");
    Fruit h = new Fruit("strawberry");
    if (g.compareTo(h) > 0) {
      System.out.println(g.fruitname + " is better than " + h.fruitname);
    } else {
      System.out.println(h.fruitname + " is better than " + g.fruitname);

    }
    ArrayList<Fruit> al = new ArrayList<Fruit>();
    al.add(g);
    al.add(h);
    al.add(new Fruit("grape"));
    Collections.sort(al);
    for (Fruit t : al) {
      System.out.println(t.fruitname);
    }

  }


}
