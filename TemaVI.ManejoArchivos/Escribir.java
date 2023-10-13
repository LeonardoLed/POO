import java.io.*;
public class Escribir{
  public static void main(String[] args) {


    FileWriter fichero = null;
    PrintWriter pw = null;


    try{
      fichero = new FileWriter("MensajeFuturo.txt");
      pw = new PrintWriter(fichero);

      pw.println("El mundo se terminara por una pandemia mas agresiva que el COVID-19");

      for (int i = 0; i < 10; i = i + 2){
        pw.println("Linea "+ i);
      }
    } catch (Exception e){
      e.printStackTrace();
    }finally{

      try{
        if (null != fichero){
              fichero.close();
        }
      }catch(Exception e2){
        e2.printStackTrace();
      }

    }


  }

}
