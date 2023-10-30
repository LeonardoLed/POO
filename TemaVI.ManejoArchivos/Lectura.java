import java.io.*;
import java.util.Scanner;
public class Lectura{
public static void main(String[] args) {
    File file = new File("hoy.txt");

    //try catch resources
    try(Scanner sc = new Scanner(file)){
      while(sc.hasNextLine()){
          String linea = sc.nextLine();
          System.out.println(linea);
      }

    }catch(IOException e) {
      e.printStackTrace();
    }



}



}
