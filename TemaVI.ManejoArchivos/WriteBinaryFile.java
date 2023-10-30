import java.io.*;
public class WriteBinaryFile{

  public static void main(String[] args) {

      File file = new File("example.bin");

      try(FileOutputStream fos = new FileOutputStream(file)){
          String content = "hoy es 23 de Octubre, queremos paro";
          fos.write(content.getBytes());
      }catch(IOException e){
          e.printStackTrace();
      }


    }


}
