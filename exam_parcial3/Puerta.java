import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerta {
        boolean ocupada;

        Puerta(){
                this.ocupada=false;

        }
        public boolean estaOcupada(){
                return this.ocupada;
        }
        public synchronized void liberarPuerta(){
                this.ocupada=false;
        }
        public synchronized boolean intentarEntrar(){
                if (this.ocupada) return false;
                /* Si llegamos aquí, la puerta estaba libre
                pero la pondremos a ocupada un tiempo
                y luego la volveremos a poner a "libre"*/
                this.ocupada=true;
                return true;
        }
}
