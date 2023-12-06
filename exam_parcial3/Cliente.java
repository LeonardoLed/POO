import java.util.Random;
public class Cliente implements Runnable{

        Puerta      puerta;
        Almacen     almacen;
        String      nombre;
        Random      generador;
        final int MAX_INTENTOS  =   10;
        public Cliente(Puerta p, Almacen a, String nombre){
                this.puerta     =   p;
                this.almacen    =   a;
                this.nombre     =   nombre;
                generador       =   new Random();
        }

        public void esperar(){
                try {
                        int ms_azar = generador.nextInt(100);
                        Thread.sleep(ms_azar);
                } catch (InterruptedException ex) {
                        System.out.println("Falló la espera");
                }
        }
        @Override
        public void run() {
                for (int i=0; i<MAX_INTENTOS; i++){
                        if (!puerta.estaOcupada()){
                                if (puerta.intentarEntrar()){
                                        esperar();
                                        puerta.liberarPuerta();
                                        if (almacen.cogerProducto()){
                                                System.out.println(
                                                                this.nombre + ": cogí un producto!");
                                                return ;
                                        }
                                        else {
                                                System.out.println(
                                                           this.nombre+
                                                           ": ops, crucé pero no cogí nada");
                                                return ;
                                        } //Fin del else
                                } //Fin del if
                        } else{
                           esperar();
                        }

                } //Fin del for
                //Se superó el máximo de reintentos y abandonamos
                System.out.println(this.nombre+
                                ": lo intenté muchas veces y no pude");
        }

}
