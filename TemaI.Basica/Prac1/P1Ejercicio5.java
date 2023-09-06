import java.util.Scanner;//Para leer por teclado
public class P1Ejercicio5{
    public static void main(String[] args){
        System.out.println("Ingrese numero entero:");
        Scanner numero = new Scanner(System.in); //Scanner para ingresar el numero desde el teclado

        int nOriginal = numero.nextInt(); //Numero del cual se quiere conocer sus digitos
        int aux = nOriginal; //Copia del numero original
        int digitos = 0; //Contador de digitos

        if (aux < 0){ //En caso de que sea un numero negativo se multiplica *-1 para volverlo positivo y se almacena en aux
            aux = aux * -1;
        }

        while (aux > 0){ 
            aux = aux / 10; //El numero se dividirá entre diez hasta que sea menor a 0
            digitos = digitos + 1; //Cada vez que se repite el ciclo se suma un digito
        }
        System.out.println("El numero " + nOriginal + " tiene " + digitos + " digitos");
    }
}
