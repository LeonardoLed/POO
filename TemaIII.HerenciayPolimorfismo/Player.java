import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Player{
  private Nave[] flota = new Nave[5];
  private Nave[] flota_pc = new Nave[5];
  private Malla Malla_player = new Malla();
  private Malla Malla_player_pc = new Malla();
  private ArrayList<Integer> memory_x = new ArrayList<Integer> ();
  private ArrayList<Integer> memory_y = new ArrayList<Integer> ();


  // Jugador Uno

  public Player(){
    assigPlay();
    createBoot();
    start(); //este puede vivir en otra clase
    finish();
  }

  public void start(){
    System.out.println("INICIA JUEGO....");
    start_game();

  }

  private int check_memory(ArrayList<Integer> lista, int b){

    int cont = 0;
    int indice = -1;

    if (lista.size() > 0){
      for(int r: lista){
        if (r == b){
          indice = cont;
        }
        cont++;
      }

    }

  return indice;
  }

  private void finish(){
    System.out.println("EL juego termino... quedo asi");
    Malla_player.PaintMalla(Malla_player_pc.getMatrix());
    // determinar quien gano
    if (check_ships(flota)){
      System.out.println("PERDISTE... =()");
    }else{
      System.out.println("GANASTE!!.....)");
    }
  }

  private void start_game(){
    Random a = new Random();
    int volado = a.nextInt(2);
    volado = 0;


    do{

      if (volado == 0){
        System.out.println("TU TURNO........");
        Scanner entrada = new Scanner(System.in);
        //iniciamos
        //preguntamos una coordenada (x,y)
        int d_rival = 0;
        int d_own = 0;

        for (Nave nave: flota ){
          if (nave.getLife() == 0){ d_own++;}
        }
        for (Nave nave: flota_pc ){
          if (nave.getLife() == 0){ d_rival++;}
        }


        System.out.println("NAVES EN FLOTA RIVAL DESTRUIDAS = " + d_rival);
        System.out.println("NAVES EN TU FLOTA DESTRUIDAS = " + d_own );

        Malla_player.PaintMalla(Malla_player_pc.getMatrix());

        try{
          System.out.println("Dime la coordena en x de la nave? ");
          int res_x = entrada.nextInt();
          System.out.println("Dime la coordena en y de la nave? ");
          int res_y = entrada.nextInt();
          int valor_esperado = Malla_player_pc.getNaveMatrix(res_x, res_y);
          if ( valor_esperado > 0 ){
            Malla_player_pc.setNaveMatrix(res_x, res_y, -3);
            flota_pc[valor_esperado-1].setLife( (flota_pc[valor_esperado-1].getLife()) -1);
            if (flota_pc[valor_esperado-1].getLife() == 0){
              System.out.println("ESO! DESTRUISTE UNA NAVE!");
            }
          }else{
            Malla_player_pc.setNaveMatrix(res_x, res_y, -2);
          }


        } catch (ArrayIndexOutOfBoundsException e1){
          System.out.println("valor fuera del rango");
        } catch (InputMismatchException e2){
          System.out.println("no seas menso, pon numeros");
        }



        volado = 1;
      }else{
        // inicia la PC
        // algoritmo aleatorio
        System.out.println("EL TURNO DEL BOOT........");


        int a_x = a.nextInt(10);
        int a_y = a.nextInt(10);
        boolean flagA = true;
        int index_x = check_memory(memory_x,a_x);
        int index_y = check_memory(memory_y,a_y);

        do{
        if ((index_x != index_y) || (index_x ==-1 && index_y == -1 ) ) //nueva coordenada
        {
          memory_x.add(a_x);
          memory_y.add(a_y);

          int valor_esperado = Malla_player.getNaveMatrix(a_x,a_y);
          System.out.println("Boot dice: ["+ a_x + "," + a_y + "]");

          if (valor_esperado > 0){
            Malla_player.setNaveMatrix(a_x, a_y, -3);
            flota[valor_esperado-1].setLife( (flota[valor_esperado-1].getLife()) -1);
            if (flota[valor_esperado-1].getLife() == 0){
              System.out.println("TE DESTRUYERON UNA NAVE =( QUE TRISTE CAMPEON....");
            }

          }else{
            Malla_player.setNaveMatrix(a_x, a_y, -2);
          }

          flagA = false;
        }else{
          flagA = true;
        }

      } while(flagA);



        volado = 0;
      }

    }while(!(check_ships(flota) || check_ships(flota_pc)));
      // check_ships -> false si hay naves y true si no hay naves
      // false y false -> false -> true
      // false y true -> true -> false
      // true y false -> true -> false
      // true y true -> no existe -> true -> false

  }

  private boolean check_ships(Nave[] flota){
    boolean finish = true;

    for (int i = 0; i < flota.length; i++){
        if ( flota[i].getLife() != 0){
          finish = false;
        }
    }

    return finish;

  }

  private boolean asking(int inave, int o, int x, int y){

    boolean flag = true;
    boolean flagN = false;

    if (( x >=0 && x <= 9) && ( y >= 0 && y <= 9) && (o >= 0 && o <= 1)){
      // buscamos que esa posicion ya no se haya ocupado
      if (o == 0){
        if (x+Nave.lifesize[inave] -1 <= 9) {
          //System.out.print("entre");
          for (int k=0; k<=inave; k++){
            //System.out.println(Malla_player_pc.getNaveMatrix(x+k, y) + "," + x+k + ","+y + "," +flagN);
            if (Malla_player_pc.getNaveMatrix(x+k, y) != 0 ){
              flagN = true;
            }
          }
          if (flagN){ flag = true;}else{flag = false;}

        }
      }else{
        if(y + Nave.lifesize[inave] -1 <= 9){

          for (int k =0; k<=inave; k++){
            //System.out.println(Malla_player.getNaveMatrix(x, y+k) + "," + x + "," + y+k + "," + flagN);
            if (Malla_player_pc.getNaveMatrix(x, y+k) != 0 ){
              flagN = true;
            }
          }
          if (flagN){ flag = true;}else{flag = false;}


        }
      }
    }

    return flag;

  }

  private int[] asking(int inave){
    boolean flag = true;
    boolean flagN = false;
    int [] posicion = new int[3];
    Scanner entrada = new Scanner(System.in);
    int x, y, o;

    do{
      flagN = false;
      System.out.println("Dame la posicion x inicial");
      x = entrada.nextInt();
      System.out.println("Dame la posicion y inicial");
      y = entrada.nextInt();
      System.out.println("Dame la orientacion [0 -> vertical] y [1-> horizontal]");
      o = entrada.nextInt();

      if (( x >=0 && x <= 9) && ( y >= 0 && y <= 9) && (o >= 0 && o <= 1)){
        // buscamos que esa posicion ya no se haya ocupado
        if (o == 0){
          if (x+Nave.lifesize[inave] -1 <= 9) {
            //System.out.print("entre");
            for (int k=0; k<=inave; k++){
              //System.out.println(Malla_player.getNaveMatrix(x+k, y) + "," + x+k + ","+y + "," +flagN);
              if (Malla_player.getNaveMatrix(x+k, y) != 0 ){
                flagN = true;
              }
            }
            if (flagN){ flag = true;}else{flag = false;}

          }
        }else{
          if(y + Nave.lifesize[inave] -1 <= 9){

            for (int k =0; k<=inave; k++){
              //System.out.println(Malla_player.getNaveMatrix(x, y+k) + "," + x + "," + y+k + "," + flagN);
              if (Malla_player.getNaveMatrix(x, y+k) != 0 ){
                flagN = true;
              }
            }
            if (flagN){ flag = true;}else{flag = false;}


          }
        }
      }

      if (flag){
        System.out.println("Inserta una coordenada correcta ");
      }else{
        posicion[0] = x;
        posicion[1] = y;
        posicion[2] = o;
      }

    }while(flag);

    return posicion;
  }

  //nuestro jugador acomoda los barcos en la Malla
  private void assigPlay(){
    int posicion[];
    System.out.println("Recuerda que las naves son:");
    System.out.println("Nave 1: tamaño 2");
    System.out.println("Nave 2 y 3: tamaño 3");
    System.out.println("Nave 4: tamaño 4");
    System.out.println("Nave 5: tamaño 5");

    for(int i = 0; i < flota.length; i++){
      System.out.println("Ubicacion de la nave "+ i );
      posicion = asking(i);
      int x = posicion[0];
      int y = posicion[1];
      int z = posicion[2];

      switch(i){
        case 0:
          flota[i] = new Nave(2);

          //Malla[x][y] = 1;
          Malla_player.setNaveMatrix(x,y,i);
          if (z==0){
            flota[i].setAngle(0);
            //Malla[x+1][y] = 1;
            Malla_player.setNaveMatrix(x+1,y,i);
          }else{
            flota[i].setAngle(1);
            //Malla[x][y+1] = 1;
            Malla_player.setNaveMatrix(x,y+1,i);
          }

        break;
        case 1:
          flota[i] = new Nave(3);
          //Malla[x][y] = 1;
          Malla_player.setNaveMatrix(x,y,i);
          if (z==0){
            flota[i].setAngle(0);
            //Malla[x+1][y] = 1;
            Malla_player.setNaveMatrix(x+1,y,i);
            //Malla[x+2][y] = 1;
            Malla_player.setNaveMatrix(x+2,y,i);
          }else{
            flota[i].setAngle(1);
            //Malla[x][y+1] = 1;
            Malla_player.setNaveMatrix(x,y+1,i);
            //Malla[x][y+2] = 1;
            Malla_player.setNaveMatrix(x,y+2,i);
          }

        break;
        case  2:
          flota[i] = new Nave(3);
          //Malla[x][y] = 1;
          Malla_player.setNaveMatrix(x,y,i);
          if (z==0){
            flota[i].setAngle(0);
            //Malla[x+1][y] = 1;
            Malla_player.setNaveMatrix(x+1,y,i);
            //Malla[x+2][y] = 1;
            Malla_player.setNaveMatrix(x+2,y,i);
          }else{
            flota[i].setAngle(1);
            //Malla[x][y+1] = 1;
            Malla_player.setNaveMatrix(x,y+1,i);
            //Malla[x][y+2] = 1;
            Malla_player.setNaveMatrix(x,y+2,i);
          }

        break;

        case 3:

          flota[i] = new Nave(4);
          //Malla[x][y] = 1;
          Malla_player.setNaveMatrix(x,y,i);
          if (z==0){
            flota[i].setAngle(0);
            //Malla[x+1][y] = 1;
            Malla_player.setNaveMatrix(x+1,y,i);
            //Malla[x+2][y] = 1;
            Malla_player.setNaveMatrix(x+2,y,i);
            //Malla[x+3][y] = 1;
            Malla_player.setNaveMatrix(x+3,y,i);
          }else{
            flota[i].setAngle(1);
            //Malla[x][y+1] = 1;
            Malla_player.setNaveMatrix(x,y+1,i);
            //Malla[x][y+2] = 1;
            Malla_player.setNaveMatrix(x,y+2,i);
            //Malla[x][y+3] = 1;
            Malla_player.setNaveMatrix(x,y+3,i);
          }

        break;
        case 4:
        flota[i] = new Nave(5);
        //Malla[x][y] = 1;
        Malla_player.setNaveMatrix(x,y,i);
        if (z==0){
          flota[i].setAngle(0);
          //Malla[x+1][y] = 1;
          Malla_player.setNaveMatrix(x+1,y,i);
          //Malla[x+2][y] = 1;
          Malla_player.setNaveMatrix(x+2,y,i);
          //Malla[x+3][y] = 1;
          Malla_player.setNaveMatrix(x+3,y,i);
          //Malla[x+4][y] = 1;
          Malla_player.setNaveMatrix(x+4,y,i);
        }else{
          flota[i].setAngle(1);
          //Malla[x][y+1] = 1;
          Malla_player.setNaveMatrix(x,y+1,i);
          //Malla[x][y+2] = 1;
          Malla_player.setNaveMatrix(x,y+2,i);
          //Malla[x][y+3] = 1;
          Malla_player.setNaveMatrix(x,y+3,i);
          //Malla[x][y+4] = 1;
          Malla_player.setNaveMatrix(x,y+4,i);
        }

        break;

      }

      Malla_player.PaintMalla();
    }

  }


  //Jugador PC
  private void createBoot(){
    Random a = new Random();
    boolean flag;
    int a_o = 0;
    int a_x = 0;
    int a_y = 0;
    for (int i = 0; i<5; i++){

      do{

        a_o = a.nextInt(2);
        a_x = a.nextInt(10);
        a_y = a.nextInt(10);
        flag = asking(i, a_o, a_x, a_y);
        //System.out.println(i+ ","+ a_o + ","  +a_x + "," + a_y + "," + flag) ;

      }while(flag);

      if (!flag){
        int x = a_x;
        int y = a_y;
        int z = a_o;

        switch(i){
          case 0:
            flota_pc[i] = new Nave(2);

            //Malla[x][y] = 1;
            Malla_player_pc.setNaveMatrix(x,y,i);
            if (z==0){
              flota_pc[i].setAngle(0);
              //Malla[x+1][y] = 1;
              Malla_player_pc.setNaveMatrix(x+1,y,i);
            }else{
              flota_pc[i].setAngle(1);
              //Malla[x][y+1] = 1;
              Malla_player_pc.setNaveMatrix(x,y+1,i);
            }

          break;
          case 1:
            flota_pc[i] = new Nave(3);
            //Malla[x][y] = 1;
            Malla_player_pc.setNaveMatrix(x,y,i);
            if (z==0){
              flota_pc[i].setAngle(0);
              //Malla[x+1][y] = 1;
              Malla_player_pc.setNaveMatrix(x+1,y,i);
              //Malla[x+2][y] = 1;
              Malla_player_pc.setNaveMatrix(x+2,y,i);
            }else{
              flota_pc[i].setAngle(1);
              //Malla[x][y+1] = 1;
              Malla_player_pc.setNaveMatrix(x,y+1,i);
              //Malla[x][y+2] = 1;
              Malla_player_pc.setNaveMatrix(x,y+2,i);
            }

          break;
          case  2:
            flota_pc[i] = new Nave(3);
            //Malla[x][y] = 1;
            Malla_player_pc.setNaveMatrix(x,y,i);
            if (z==0){
              flota_pc[i].setAngle(0);
              //Malla[x+1][y] = 1;
              Malla_player_pc.setNaveMatrix(x+1,y,i);
              //Malla[x+2][y] = 1;
              Malla_player_pc.setNaveMatrix(x+2,y,i);
            }else{
              flota_pc[i].setAngle(1);
              //Malla[x][y+1] = 1;
              Malla_player_pc.setNaveMatrix(x,y+1,i);
              //Malla[x][y+2] = 1;
              Malla_player_pc.setNaveMatrix(x,y+2,i);
            }

          break;

          case 3:

            flota_pc[i] = new Nave(4);
            //Malla[x][y] = 1;
            Malla_player_pc.setNaveMatrix(x,y,i);
            if (z==0){
              flota_pc[i].setAngle(0);
              //Malla[x+1][y] = 1;
              Malla_player_pc.setNaveMatrix(x+1,y,i);
              //Malla[x+2][y] = 1;
              Malla_player_pc.setNaveMatrix(x+2,y,i);
              //Malla[x+3][y] = 1;
              Malla_player_pc.setNaveMatrix(x+3,y,i);
            }else{
              flota_pc[i].setAngle(1);
              //Malla[x][y+1] = 1;
              Malla_player_pc.setNaveMatrix(x,y+1,i);
              //Malla[x][y+2] = 1;
              Malla_player_pc.setNaveMatrix(x,y+2,i);
              //Malla[x][y+3] = 1;
              Malla_player_pc.setNaveMatrix(x,y+3,i);
            }

          break;
          case 4:
          flota_pc[i] = new Nave(5);
          //Malla[x][y] = 1;
          Malla_player_pc.setNaveMatrix(x,y,i);
          if (z==0){
            flota_pc[i].setAngle(0);
            //Malla[x+1][y] = 1;
            Malla_player_pc.setNaveMatrix(x+1,y,i);
            //Malla[x+2][y] = 1;
            Malla_player_pc.setNaveMatrix(x+2,y,i);
            //Malla[x+3][y] = 1;
            Malla_player_pc.setNaveMatrix(x+3,y,i);
            //Malla[x+4][y] = 1;
            Malla_player_pc.setNaveMatrix(x+4,y,i);
          }else{
            flota_pc[i].setAngle(1);
            //Malla[x][y+1] = 1;
            Malla_player_pc.setNaveMatrix(x,y+1,i);
            //Malla[x][y+2] = 1;
            Malla_player_pc.setNaveMatrix(x,y+2,i);
            //Malla[x][y+3] = 1;
            Malla_player_pc.setNaveMatrix(x,y+3,i);
            //Malla[x][y+4] = 1;
            Malla_player_pc.setNaveMatrix(x,y+4,i);
          }

          break;

        }


    }

    }
   //System.out.println("---------------------------");
   //Malla_player_pc.PaintMalla();

  }

}
