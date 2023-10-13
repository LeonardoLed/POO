import java.util.Random;

public class Ejemplo{
  public static void main(String[] args) {

      Random r = new Random();
      int num;

      num = r.nextInt(101);
      try{
        if (num >=0 && num <= 10){throw new MiExcepcion(1);}
        if (num > 10 && num <= 20){throw new MiExcepcion(2);}
        if (num > 20 && num <= 30){throw new MiExcepcion(3);}
      }catch (MiExcepcion ex) {
        System.out.println(ex.getMessage());
      }finally{
        System.out.println("el random es: " + num);
        System.out.println("salimos...");
      }


  }
}
