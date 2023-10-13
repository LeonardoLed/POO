import java.io.*;
public class MiPrimerArchivo{



  public static void main(String[] args) {
    File fichero = new File("CapsulaTiempo.txt");

    if (fichero.exists()){
      System.out.println("Nombre del archivo es: " + fichero.getName());
      System.out.println("PATH: " + fichero.getPath());
      System.out.println("RUTA ABSOLUTA: " + fichero.getAbsolutePath());
      System.out.println("Se puede escribir: " + fichero.canWrite());
      System.out.println("Size : " + fichero.length());
    }

  }


}
