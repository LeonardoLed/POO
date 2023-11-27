package sounds;


import javax.sound.sampled.*;
import java.io.IOException;

public class Sound {

	//for individual wav sounds (not looped)
	//http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
	public static synchronized void playSound(final String strPath) {
	    new Thread(() -> {
          try {
            Clip clp = AudioSystem.getClip();

            AudioInputStream aisStream =
                    AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(strPath));


            clp.open(aisStream);
            clp.start();
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
        }).start();
	  }
	
	
	//for looping wav clips
	//http://stackoverflow.com/questions/4875080/music-loop-in-java
	public static Clip clipForLoopFactory(String strPath){
		
		Clip clp = null;
		
		// this line caused the original exceptions
		
		try {
			AudioInputStream aisStream = 
					  AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(strPath));
			clp = AudioSystem.getClip();
		    clp.open( aisStream );
				
		} catch(Exception exp){
			System.out.println("error");
		}
		
		return clp;
		
	}
	
	


}
