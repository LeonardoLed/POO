import java.util.Scanner;//Para leer por teclado
public class P1Ejercicio2{
    public static void main (String[] args){
        System.out.println("Da el valor de n: ");
		Scanner entrada = new Scanner(System.in);
		int a = entrada.nextInt();//Recibe el numero por teclado.
        int b = a;//Variable que use en el ciclo for, por reciclar parte del trabajo en laboratorio.
        int cont = a; //Variables auxiliares para el manejo.
        int aux = 0; //de como se imprimen las cosas.
        if(b < 1){
            System.out.println("El numero no es valido");
        } else {
            for (int i = 1; i <= b; i++){ //ciclo for para imprimir la primera parte de la figura
                int j = 1;
                while(j <= i){
                    while(aux < cont){
                        System.out.print(" "); //espacios para que quede como un rombo
                        aux++;
                    }
                    System.out.print("* ");
                    if(j == i){
                        cont = cont - 1;
                        aux = 0;//se restablece el valor del auxiliar porque sufrio cambios anteriormente
                        System.out.print("\n");//Salto de renglon al hacer figura
                    }
                    j++;
                }
            }
            for (int j = b-1; j >= 1; j--){//Segundo for para la segunda parte de la figura, despues de la linea más grande
                int i = 1;
                cont = cont + 2; //para el manejo de los espacios
                while(i <= j){
                    while(aux < cont){
                        System.out.print(" ");
                        aux++;
                    }
                    System.out.print("* ");
                    if(j == i){
                        cont = cont - 1;
                        aux = 0;
                        System.out.print("\n");
                    }
                    i++;
                }
            }
        }
    }
}