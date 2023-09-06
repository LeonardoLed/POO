import java.util.Random;

	public class WarOfNumbers {
		public static void main(String[] args) {
        int pares=0; //Inicialimos las variables en 0
		int nones=0;
		int k=1;//añadimos una variable que nos sirva para ir incrementando
        System.out.println("\tWar of Numbers");
        Random r=new Random();//Aqui generamos los numeros aleatorios
        while(k<=10) { //Podemos usar un ciclo for o while, por comodidad usaremos while
            int num = r.nextInt(1000) + 1;	//Genera los numeros de entre 1 y 1000
			System.out.print("\nEl numero "+k+ " es: "+ num); //Aqui sabemos los 10 numeros aleatorios
            if (num % 2 == 0) {	//Si el numero es par, al dividirlo entre 2 su residuo será 0, 
			//de otra forma es impar y va actualizando el valor de la variable
                pares += num;
            } else {
                nones += num;
            }

            k++;//Esta variable va a ir aumentando en 1 haciendo que el ciclo se repita 10 veces y genere 10 aleatorios
        }
		System.out.println(" ");
        System.out.println("La suma de pares es: "+pares);	//Aqui imprimimos los resultados
        System.out.println("La suma de impares es: "+nones);
		
		int parg=pares-nones;	//Creamos 2 variables para imprimir el resultado en caso de que ganen pares o impares
		int nong=nones-pares;
		if(pares==nones){
			System.out.println("Tenemos un empate");
		}else{
			if (pares>nones){
				System.out.println("Ganaron los pares, la diferencia entre ellos es de " + parg);
				}else{
					System.out.println("Ganaron los impares, la diferencia entre ellos es de "+ nong);
					}
		}
    }
}