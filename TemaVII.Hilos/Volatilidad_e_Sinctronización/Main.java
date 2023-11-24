public class  Main{

    public static void main(String[] args) {

        Cliente Samuel = new Cliente("Samuel M", new int[]{2,2,3,5,1,1});
        Cliente Joana = new Cliente("Joana M", new int[]{1,3,3,8});

        Cajero cajero1 = new Cajero("Abundis");
        Cajero cajero2 = new Cajero("Abner");

        // marcamos el tiempo
        long tiempo_inicial = System.currentTimeMillis();

        cajero1.procesarCompra(Samuel, tiempo_inicial);
        cajero2.procesarCompra(Joana, tiempo_inicial);



    }
}
