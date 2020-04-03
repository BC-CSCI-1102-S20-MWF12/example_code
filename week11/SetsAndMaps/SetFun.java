import java.util.*;

public class SetFun {

  public static void main (String[] args) {

    List<String> mylist = new ArrayList<String>();
    mylist.add("dog");
    mylist.add("ant");
    mylist.add("zebra");
    mylist.add("koala");
    mylist.add("elephant");

    Set<String> hs = new HashSet<String>(mylist);
    for (String animal : hs) {
      System.out.println(animal);
    }

    System.out.println();


    Set<String> lhs = new LinkedHashSet<String>(mylist);
    for (String animal : lhs) {
      System.out.println(animal);

    }

    System.out.println();


    Set<String> ts = new TreeSet<String>(mylist);
    for (String animal : ts) {
      System.out.println(animal);

    }
  }

}
