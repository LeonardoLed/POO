import java.util.*;

interface Board {
//en interfaz por lo general los metodos son default
	String checkWinner();
	void printBoard();
}


// tarea practica
//abstract class Player {}

public class TicTacT implements Board {

	static String[] board;
	static String player; //posible objeto que venga de la clase Player L11


	//override
	public String checkWinner() {

		for(int i=0; i<8; i++) {

			String line = null;
			switch(i) {
				case 0:
					line = board[0] + board[1] + board[2];
				break;

				case 1:
					line = board[3] + board[4] + board[5];
				break;

				case 2:
					line = board[6] + board[7] + board[8];
				break;

				case 3:
					line = board[0] + board[3] + board[6];
				break;

				case 4:
					line = board[1] + board[4] + board[7];
				break;

				case 5:
					line = board[2] + board[5] + board[8];
				break;

				case 6:
					line = board[0] + board[4] + board[8];
				break;

				case 7:
					line = board[2] + board[4] + board[6];
				break;
			} //cerramos switch

			//si gana el jugador X
			if(line.equals("XXX")) {

				return "X";
				//regresa un string por ser así el método
			}
			//si gana el jugador O
			else if(line.equals("OOO")) {

				return "O";
			}

		} //cerramos primer for

		for(int a=0; a<9;a++) {

		if(Arrays.asList(board).contains(String.valueOf(a+1))) {
			break;
		} else if(a==8) {
			return "DRAW";
			}
		}

		System.out.println("Es el turneo de" + player + ", escoge un numero del Gato: ");

		//avisar el turno de X o de O
		return null;
	}
	//imprimir
	/*
	|-------|-------|-------|
	|	1	|	2	|	3	|
	|-------|-------|-------|
	|	4	|	5	|	6	|
	|-------|-------|-------|
	|	4	|	8	|	9	|
	*/

	public void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("|" + board[0] + "  | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("|" + board[3] + "  | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("|" + board[6] + "  | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		board = new String[9];
		player = "X";
		String winner = null;

		TicTacT t = new TicTacT();

		//llenar la matriz board

		for(int i=0;i<9;i++) {
			board[i] = String.valueOf(i+1);
		}
		System.out.println("Bienvenido Tic Tac Toe 3x3");

		t.printBoard();

		System.out.println("Inicia X, ingresa una celda");
		while(winner==null) {
			int numSlot;
			numSlot = in.nextInt();
			if(!(numSlot>0 && numSlot<=9)) { //logica negada
				System.out.println("No te pases de listo xd opcion no valida");
				continue;
			}

			if(board[numSlot-1].equals(String.valueOf(numSlot))) {
				board[numSlot-1] = player; //player vale "X"
				if(player.equals("X")) {
					player = "O";
				}
				else {
					player = "X";
				}
				t.printBoard();
				winner = t.checkWinner();
			}else {
				System.out.println("El slot ya esta ocupado");
			}
		} //cerramos while
		if(winner.equalsIgnoreCase("DRAW")) {
			System.out.println("Nadie gana xd gracias por jugar");
		}

		else {
			System.out.println("Ganaste XD" + winner + " eres un PRO");
		}
		in.close();
	}
}
