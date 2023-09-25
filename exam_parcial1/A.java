public class A extends B{

  static int a = 2;
  static int b = 10;
  private int c = b >> super.getA();


  public A(){
    printC();
  }
  public static int getA(){
    return a;
  }

  public void printC(){
    System.out.println(c);
  }

  public static void main(int b) {
    A a = new A();
    a.a = a.a * a.getA("algo");
    System.out.println(b);
    System.out.println(a.letras[3]);

  }

  public static void main(String c) {
    A a = new A();
    System.out.println(a.a);
    B b = new A();
    System.out.println(b.b);
    System.out.println(c);

  }

  public static void main(String[] args) {
    //A.main(args[0]);
     A.main(Integer.valueOf(args[0]));
  }


}
