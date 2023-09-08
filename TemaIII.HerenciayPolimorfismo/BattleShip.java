import java.util.Scanner;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BattleShip{

  public static void main(String[] args){

  
    try{
      Clip sonido = AudioSystem.getClip();
      sonido.open(AudioSystem.getAudioInputStream(new File("transformer.wav")));
      sonido.start();
      Player yo = new Player();
      //Thread.currentThread().sleep(3000000);
      sonido.close();
    }catch(Exception e){
      System.out.println("" + e);
    }


    /*
    Clip sonido = AudioSystem.getClip();
    sonido.open(AudioSystem.getAudioInputStream(new File("batalla.wav")));
    sonido.start();
    Player yo = new Player();
    //Thread.currentThread().sleep(30000);
    sonido.close();
    throw new Exception("Error en audio");
    */

  }


}
