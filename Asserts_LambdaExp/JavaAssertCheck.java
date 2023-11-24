public class JavaAssertCheck {

  public void unReachableCode() {
    System.out.println("Unreachable Code");
    return;
    //assert true;
  }


  public static void main(String args[]) {

    String[] names = {"John", "Mary", "David"};
    assert names.length == 2 : "The assertion condition is false.";
    System.out.println("There are " + names.length + "  names in an array");


    int n = 2;
    if (n % 3 == 0)
      System.out.println("n % 3 == 0");
    else if (n % 3 == 1)
      System.out.println("n % 3 == 1");
    else
      assert n % 3 == 2 : "Assumption is false. " + n;

  }

}
