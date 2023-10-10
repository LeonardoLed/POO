import java.util.Scanner;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.sound.sampled.*;
import java.io.*;

public class sonido{

public static void main(String[] args) {
//throws UnsupportedAudioFileException, InterruptedException, LineUnavailableException, IOException
    try{
      Clip sonido = AudioSystem.getClip();
      sonido.open(AudioSystem.getAudioInputStream(new File("lostcause.wav")));
      sonido.start();
      Thread.currentThread().sleep(30000);
      sonido.close();
    }catch (Exception e) {
      System.out.println(e);
    }


}


}
