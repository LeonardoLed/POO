package p2;
import p1.A;
class B
{
  public void MetB()
  {
    A a= new A();
    a.pubc = 1;   // Ok
    //a.priva = 2;  // error, privado
    a.setPrivx(2);
    //super.protb = 3;

    a.MetPub();  // Ok
    //a.MetProt();
    //a.paqd = 2;
  }

  public static void main(String[] args) {
    B b = new B();
    b = null;
    System.gc();
    System.out.println("Running garbage collector by gc() method");

    System.gc();
    System.out.println("Again try to run garbage collector by gc() method");
  }

  @Override
  // overriding method
  protected void finalize() {
    System.out.println("Finalize method is called");
    }


}
