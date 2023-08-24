
import java.util.Scanner;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class rockcola{

public static void main(String[] args) {


  int bandera = 1;
  Scanner entrada = new Scanner(System.in);
  String cancion="";
  String extension =".wav";

  System.out.println("####################################################");
  System.out.println("############### ROCKCOLA  UNAM #####################");
  System.out.println("########## EL VERDADERO ROCK !!!!!!!!###############");
  System.out.println("####################################################");
  System.out.println("####################################################");

  System.out.println("                      Menu                          ");
  System.out.println("A. AC / DC");
  System.out.println("H. ASIA ");
  System.out.println("D. DAFT PUNK ");
  System.out.println("M. MICHAEL JACKSON");
  System.out.println("V. VAN HALEN");
  System.out.println("L. LED ZEPPELIN ");
  System.out.println("####################################################");

  while (bandera == 1){

    System.out.println("Que quieres escuchar?:  ");
    char opcion = entrada.next().charAt(0);

    switch(opcion){

      case 'A':
        cancion = "thunderstruck_acdc";
        break;
      case 'D':
        cancion = "getlucky_daftpunk";
        break;
      case 'H':
        cancion = "Heatof_asia";
        break;
      case 'L':
        cancion = "isong_ledz";
        break;
      case 'M':
        cancion = "bjean_michaelj";
        break;
      case 'V':
        cancion = "jump_van";
        break;
      default:
        System.out.println("opcion No Valida");
        return;
    }


    try{
      Clip sonido = AudioSystem.getClip();
      sonido.open(AudioSystem.getAudioInputStream(new File("SOUNDS/"+cancion+extension)));
      sonido.start();
      Thread.currentThread().sleep(30000);
      sonido.close();
    }catch(Exception e){
      System.out.println("" + e);
    }


    System.out.println("Quieres escuchar algo mas? [S/N, cualquier otra tecla]");
    char pregunta = entrada.next().charAt(0);

    if (pregunta != 'S'){
      bandera = 0;
    }



  }





}


}
