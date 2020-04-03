import java.util.*;

public class TreeVersusHash {

  public static void main (String[] args) {

    List<String> namelist = new ArrayList<String>();
    namelist.add("Zelda");
    namelist.add("Bao");
    namelist.add("Melania");
    namelist.add("Tony");

    Set<String> ts = new TreeSet<String>(namelist);
    for (String name : ts) {
      System.out.println(name);
    }

    Set<String> hs = new HashSet<String>(namelist);
    for (String name : hs) {
      System.out.println(name);
    }

    Set<String> hs = new HashSet<String>(namelist);
    for (String name : hs) {
      System.out.println(name);
    }


  }


}
