import java.util.Scanner;
import java.util.Random;
public class Adivina{
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    Random t = new Random();
    int i = 4;

    int a = t.nextInt(100);
    //a = 4;
    while(i > 0){
      System.out.println("Adivina el numero entre 0-99 : ");
      int b = s.nextInt();

      if (a==b){
        System.out.println("ERES UN PRO! le atinaste al numero aleatorio");
        break;
        //i = -1
      }else{
        System.out.println("un intento menos");
        i--;
        if(a > b)
        { System.out.println("Mas");
        }else{
        System.out.println("menos");
        }
      }


    }

    if (i==0){
      System.out.println("no pudiste!");
    }
    System.out.println("el numero aleatorio es: " + a);
  }

}
