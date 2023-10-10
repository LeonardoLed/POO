import java.util.InputMismatchException;
import java.util.Scanner;

public class MiPrimeraExc{
  public static void main(String[] args) {
      float a = 9;
      float b = 0;
      Scanner entrada = new Scanner(System.in);

      System.out.println("bloque1");
      try{
        float c = a/b;
        System.out.println(a/b);
        System.out.println("bloque2");
      }catch(InputMismatchException e){
        System.out.println("bloque3");
        System.out.println("No esta defina la difición entre cero");
      }

      System.out.println("bloque4");


      try{
          System.out.println("DAME UN NUMERO entero: ");
          int num = entrada.nextInt();
          System.out.println("el cuarado del numero de numero ingresado es:" + (num*num));
    }catch (InputMismatchException chinche){
          System.out.println(chinche.getMessage());
          System.out.println("ENTRADA NO VALIDA ");
      }

  }

}
