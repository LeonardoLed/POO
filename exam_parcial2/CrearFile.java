import java.util.Random;
import java.io.*;

public class CrearFile{
    public static void main(String[] args) {
      Random n = new Random(100);
      File file = null;
      FileWriter writer = null;
      PrintWriter pw = null;

      try{
        file = new File("lecturas.txt");
        writer = new FileWriter(file);
        pw = new PrintWriter(writer);

        for (int j = 0 ; j < 10; j++){
        for (int i = 0; i < 5; i++){
          pw.print(n.nextInt(100) + "\t");
        }
        pw.print("\n");
      }

    }catch(IOException e){
          e.printStackTrace();
      }finally{

        try{
          if (null != writer){
                writer.close();
          }
        }catch(Exception e2){
          e2.printStackTrace();
        }

    }



  }

}
