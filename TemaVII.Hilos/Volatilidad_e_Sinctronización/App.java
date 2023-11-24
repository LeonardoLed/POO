import java.util.Scanner;

public class App{

  public static void main(String[] args) {

      Processor pro = new Processor();
      pro.start();

      System.out.println("Escribe algo para interrumpir : ");
      new Scanner(System.in).nextLine();

      pro.shutdown();



  }


}
