public class GrandesAlmacenes {
        public static void main(String[] args) throws InterruptedException {
                final int NUM_CLIENTES  = 300;
                final int NUM_PRODUCTOS = 100;

                Cliente[]   cliente =   new Cliente[NUM_CLIENTES];
                Almacen     almacen =   new Almacen(NUM_PRODUCTOS);
                Puerta      puerta  =   new Puerta();

                Thread[]    hilosAsociados=new Thread[NUM_CLIENTES];

                for (int i=0; i<NUM_CLIENTES; i++){
                        String nombreHilo   = "Cliente "+i;
                        cliente[i]          = new Cliente(puerta, almacen,
                                                                                                nombreHilo);
                        hilosAsociados[i]   = new Thread(cliente[i]);
                        //Intentamos arrancar el hilo
                        hilosAsociados[i].start();
                } //Fin del for

                //Una vez arrancados esperamos a que todos terminen
                for (int i=0; i<NUM_CLIENTES; i++){
                        hilosAsociados[i].join();
                } //Fin del for
        }
}
