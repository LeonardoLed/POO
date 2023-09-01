import java.util.Scanner;

public class Ejercicio3{

  static String ordenamiento = "000000";
  static int a,b,c,d,e,f,g = 0;

  public static int menor(int amenor, int actual){
    return (actual < amenor) ? actual : amenor;
  }

  public static int mayor(int amayor, int actual){
    return (actual > amayor) ? actual : amayor;
  }

  public static void reordernar(int i, int ii){

    String aux = ordenamiento;
    String aux_p1 = "" ;
    String aux_p2 = "";

    //System.out.println(aux);
    for(int j = 0; j < aux.length()-1; j++){
      if (j < i){ aux_p1 += aux.charAt(j);} //lugares antes de b
      else if(j == i){aux_p1 += Integer.toString(ii+1); aux_p2 += aux.charAt(j); } // intercambiamos a por b
      else{ aux_p2 += aux.charAt(j); } //copiamos el resto de la cadena
    }

    aux = aux_p1 + aux_p2;
    ordenamiento = aux;
    //System.out.println(ordenamiento);

  }



  public static void ordenar(int actual, int val){

    boolean flag = true;

    for(int i = 0; i < ordenamiento.length()-1; i++ ){
        if (ordenamiento.charAt(i) != '0' && flag){
          switch (ordenamiento.charAt(i)){
            case '1':
              if (a > actual){
                  //System.out.println("entro 1");
                  //System.out.println(i+"," +val + "," + ordenamiento.charAt(i) );
                  reordernar(i, val);
                  flag = false;
              }
              break;

            case '2':
              if (b > actual){
                  //System.out.println(i+"," +val);
                  reordernar(i, val);
                  flag = false;
              }
              break;
            case '3':
              if (c > actual){
                //System.out.println(i+"," +val);
                reordernar(i, val);
                flag = false;
              }
              break;
            case '4':
              if (d > actual){
                //System.out.println(i+"," +val);
                reordernar(i,val);
                flag = false;
              }
              break;
            case '5':
              if (e > actual){
                //System.out.println(i+"," +val);
                reordernar(i,val);
                flag = false;
              }
              break;
            default:
              System.out.println("Aqui nunca entra");
              break;
          }


        }else{

          if(flag){
            //System.out.println(val);
            //System.out.println("entro " + i + " " + val );
            reordernar(i,val);
            flag = false;
          }

        }


    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n; // cuantos numeros vamos a recibir
    int menor = 0;
    int mayor = 0;
    int mediana = 0;


    System.out.println("Cuantos numeros quieres ingresar para comparar [2-6]");
    n = sc.nextInt();

    if (n >= 2 && n<=6){
    for (int i = 1; i <= n; i++){
      int x = 0;
      do{
        System.out.println("Dame el numero " + i + ":");
        x = sc.nextInt();

        if (x<=0){
          System.out.println("el numero tiene que ser un entero positivo");
        }else{
          if (i == 1){
            menor = x;
            mayor = x;
            a = x;
            ordenamiento = "100000";
          }else{


            switch (i){
              case 2:
                b = x;
                break;
              case 3:
                c = x;
                break;
              case 4:
                d = x;
                break;
              case 5:
                e = x;
                break;
              case 6:
                f = x;
                break;
              default:
                System.out.println("Aqui nunca entra");
                break;
            }


            //actualizamos variables estado
            menor = menor(menor, x);
            mayor = mayor(mayor, x);
            //System.out.println(x+"," + (i-1) );
            ordenar(x,i-1);

            //System.out.println(ordenamiento);
          }
        }
      }while(x <= 0);
    }


    int cursor_mediana = (int) Math.ceil(n/2);
    char mediana_i = ordenamiento.charAt(cursor_mediana);

    switch (mediana_i){
      case '1':
        mediana = a;
        break;
      case '2':
        mediana = b;
        break;
      case '3':
        mediana = c;
        break;
      case '4':
        mediana = d;
        break;
      case '5':
        mediana = e;
        break;
      case '6':
        mediana = f;
        break;
      default:
        System.out.println("Aqui nunca entra");
        break;
    }

    System.out.println("De la serie que ingresaste....");
    System.out.println("El valor menor es:" + menor);
    System.out.println("El valor mayor es: " + mayor);
    System.out.println("La mediana es: " + mediana);
    System.out.println("Ordenamiento: " + ordenamiento);

    }else{
      System.out.println("recuerda ingresar entre 2 a 6 numeros enteros positivos");
    }
  }

}
