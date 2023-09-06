import java.util.Random;//Importamos para los numeros Random
public class P1Ejercicio1{
	public static void main (String[] args){
        Random a = new Random();
        int b = a.nextInt(20)+1;//Se genera el numero random de 1 a 20
		int aux = b-2;//Aux para manejar los laterales del cuadrado, eliminando los + de los otros dos lados
		int c = 0;
		c = b / 2;//Variable para colocar el centro en el cuadrado, en caso de ser impar
		boolean Par;//Para que el programa sepa cuando colocar el centro
		if (b % 2 == 0){
			System.out.println(b + " Es un numero par");
			Par = true;//Porque efectivamente es par
		} else {
			System.out.println(b + " Es un numero impar");
			Par = false;//El numero random no es par
		}
		if (b == 1){//En caso de que el Random sea 1, solo habra un +
			System.out.print("+ ");
		} else {
			for(int i = 1; i <= b; i++){//for para la parte superior del cuadrado
				System.out.print("+ ");
			}
			System.out.print("\n");//Salto de nivel
			for(int i = 1; i <= b-2; i++){//for para los costados del cuadrado
				System.out.print("+ ");
				while(aux > 0){
					if(aux == c && aux == i && Par == false){//Condición para colocar el centro, solo cuando el numero es Impar
						System.out.print("+ ");
					} else {
						System.out.print("  ");//Los espacios que son el "relleno" del cuadrado
					}
					aux--;
				}
				aux = b-2;//restablecer el valor de aux que se fue reduciendo
				System.out.print("+ ");
				System.out.print("\n");
			}
			for(int i = 1; i <= b; i++){//for para la parte inferior
				System.out.print("+ ");
			}
		}
	}
}