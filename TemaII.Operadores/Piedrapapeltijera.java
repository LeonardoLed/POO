import java.util.Scanner;
import java.util.Random;

public class Piedrapapeltijera{
  public static void main(String[] args) {

      // instancear un objeto de clase Scanner
      Scanner answer = new Scanner(System.in);
      Random rand = new Random();

      // 0-> Piedra, 1-> Papel, 2-> Tijera
      int a = rand.nextInt(3);

      System.out.println("Que quieres escoger:");
      System.out.println("0. Piedra");
      System.out.println("1. Papel");
      System.out.println("2. Tijera");
      int b = answer.nextInt();
      //a = 2;

      if (b <= 2 && b>=0){

        if (b==0){System.out.println("Tu elección es: 🪨"); }
        else if(b==1){System.out.println("Tu elección es: ✋");}
        else{System.out.println("Tu elección es: ✄");}

        if (a==0){System.out.println("La elección PC es: 🪨"); }
        else if(a==1){System.out.println("La elección PC es: ✋");}
        else{System.out.println("La elección PC es: ✄");}

        if ((b == 0 && a == 2)|| (b == 1 && a == 0 )||( b==2 && a == 1)){
          System.out.println("Ganaste!! 🤟");
        }else if(b == a){
          System.out.println("Empate");
        }
        else{
          System.out.println("Perdiste!! 😞");
        }
    }else{
      System.out.println("no te pases de listo, da una opcion valida");
    }

  }
}
