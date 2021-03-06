public class RecursionExamples {


  public static int powerOfToo(int q) {
    if (q==0) {
      return 1;
    }
    return 2 * powerOfToo(q-1);
  }


  // b is the beginning index of the String
  // e is the ending index of the string
  public static boolean isItPalindrome(String s, int b, int e) {
    // if b crosses e, you've managed to never find two chars
    // that are not the same so return true!
    if (b >= e) {
      return true;
    }
    // if the two characters are not the same, return false
    if (s.charAt(b) != s.charAt(e)) {
      return false;
    }
    // otherwise, move toward the middle, and try again
    else {
      return isItPalindrome(s, b+1, e-1);
    }
  }



  // recursive method to reverse a string
  public static String reverse (String a) {
    if (a.length() <= 1) {
      return a;
    } else {
      return reverse(a.substring(1)) + a.charAt(0);
    }
  }

  // iterative method to reverse a string
  public static String reverseIt (String a) {
    String returnme = "";
    for (int i=a.length()-1; i >=0; i--) {
      returnme = a.charAt(i) + returnme;
    }
    return returnme;
  }


  // recursive method to find the length of a string
    public static int getLength(String a) {
      if (a.equals("")) {
        return 0;
      } else {
        return 1 + getLength(a.substring(1));
      }
    }

  // iterative method to find the length of a string
  public static int getLengthIt(String a) {
    int i = 0;
    while (!a.equals("")) {
      i++;
      a = a.substring(1);
    }
    return i;
  }

  // recursive method to calculate factorial
  public static int factorial(int n) {
    if (n==0) {
      return 1;
    } else {
      return n * factorial(n-1);
    }
  }

  // iterative method to calculate factorial
  public static int factorialIt(int n) {
    int total = 1;
    for (int i = 1; i <= n; i++) {
      total *= i;
    }
    return total;
  }


  // recusive method to calculate powers of 2
  public static int powerOf2(int n) {
    if (n==0) {
      return 1;
    } else {
      return 2 * powerOf2(n-1);
    }
  }

  // recursive method to double each letter in a string
  public static String doubleEach(String s) {
    if (s.length() == 1) {
      return (s + s);
    } else {
      return Character.toString(s.charAt(0)) + Character.toString(s.charAt(0)) + doubleEach(s.substring(1));
    }
  }


  // what do you think this method does?
  public static int mystery(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n * n + mystery(n-1);
    }
  }

  public static void main (String[] args) {

    String mystring = "anbdpgigh 9ye4bljaf";
    System.out.println(reverse(mystring));
    System.out.println(reverseIt(mystring));
    System.out.println(getLength(mystring));
    System.out.println(getLengthIt(mystring));

    System.out.println(mystery(5));
    System.out.println(factorial(5));
    System.out.println(factorialIt(5));

    System.out.println(doubleEach("hello"));
    System.out.println(powerOf2(5));
    System.out.println(powerOfToo(5));

    String w = "hannh";
    System.out.println(w);
    if (isItPalindrome(w, 0, (w.length()-1)) == true) {
      System.out.println(w + " is a palindrome");
    } else {
      System.out.println(w + " is not a palindrome");
    }

  }

}
