import java.util.Scanner;

public class Holamundo{

  //metodo
  public static void main(String[] args) {

    int a = 3;
    int b = 4;
    System.out.println("Hola Mundo");
    int c = a + b;
    System.out.println("La suma de a y b es: " + c);

    //serie de fibonacci
    // 1 1 2 3 5 8 13 21...
    a = 1;
    b = 1;
    int n = 10;
    System.out.println("la serie de fibonacci de los primeros n=" + n + " es :" );
    System.out.print(a + " " + b + " ");
    int cont = 2;
    int aux;

    while(cont <= n){
      aux = b;
      b = b + a;
      System.out.print(b + " ");
      a = aux;
      cont++;
    }

   // CONVERTIR AÑOS EN DIAS
   System.out.println("Dame tu edad en años: ");
   Scanner entrada = new Scanner(System.in);
   int y = entrada.nextInt();

   int d = y * 365;
   System.out.println("tienes : " + d + "dias de edad");






  }



}
