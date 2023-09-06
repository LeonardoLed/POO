 import java.util.Scanner;
public class Triangulo_Equilatero {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("\tTRIANGULO EQUILATERO");
        System.out.print("Ingrese el tamaño del triangulo: ");
        int n = s.nextInt();
        boolean band;       

        for (int x = 0; x < n; x++){  //for encargado de los saltos de linea 
            band = true;

            for (int i = 0; i < x+1; i++){    //for encargado de la impresion de los asteriscos *

                for (int j = x; j < n; j++){        //for encargado de generar los espacios
                    if (band == true){      //condicional para hacer que no se repitan los espacios después la primer pasada
                        System.out.print(" ");
                    }
                }
                band = false;
                System.out.print("* ");
            }

            System.out.print("\n");
        }
    }
}