public class Naturales{
  public static void main(String[] args) {
    Operaciones n = new Operaciones(4);
    System.out.println(n.factorial());
    n.suma();
    //double suma2 = n.suma(10);
    System.out.println(Operaciones.factorial(9));
    System.out.println(n);
    n.suma(90);



  }
}
