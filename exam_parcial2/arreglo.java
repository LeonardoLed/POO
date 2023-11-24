import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class NotValidLine extends Exception{
  public NotValidLine(String s){
    super(s);
  }
}
class BadReading extends Exception{
  public BadReading(String s){
    super(s);
  }
}

abstract class GeneralExp{
    abstract void search(Hashtable<Integer, ArrayList<Integer>> A) throws BadReading;

    void not_readable() throws NotValidLine{
        throw new NotValidLine("not valid line");
    }

}

class MyExp extends GeneralExp{

  @Override
  void search(Hashtable<Integer, ArrayList<Integer>> tabla) throws BadReading{
      tabla.forEach((k,e) -> {
        try {
          if (e.contains(0)){
            throw new BadReading("bad reading!");}
          else if(e.contains(95)){not_readable();} // <- AQUI
          else{System.out.println("not errors =)");}
          }catch(BadReading t){
            System.out.print(t+"\n");
          }catch(NotValidLine t){
            System.out.print(t+"\n");}

        });

  }
}


class arreglo{
    public static void main(String[] args) throws BadReading {

      Hashtable<Integer, ArrayList<Integer>> data = new Hashtable<Integer, ArrayList<Integer>>();

      try(BufferedReader br =  new BufferedReader(new FileReader(new File("lecturas.txt")))){
        String linea;
        int cont = 0;

        while((linea = br.readLine()) != null){
          String[] elements = linea.split("\t");
          ArrayList<Integer> lec = new ArrayList<Integer>();
          Arrays.stream(elements).forEach(s -> {lec.add(Integer.parseInt(s));});
          data.put(cont, lec);
          cont++;
        }
      }catch(IOException e){
          e.printStackTrace();
      }

      MyExp rev = new MyExp();
      rev.search(data);


    }
}
