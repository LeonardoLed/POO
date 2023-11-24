public class Cajero{
  private String nombre;

  public Cajero(String nombre){
      this.nombre = nombre;
  }
  // this por que es una varible de instancia
  // this no tiene caso es una variable de clase
  // this no puede utilizar en una varible  de metodo
  public void procesarCompra(Cliente cliente, long tiempo){
    System.out.println("El cajero " + this.nombre + "comienza a procesar la compra en el tiempo: "+ (System.currentTimeMillis() - tiempo / 1000) + " [s]");
    for (int i = 0; i < cliente.getCarroCompra().length; i++){
        this.esperarXsegundos(cliente.getCarroCompra()[i]);
        System.out.println("Procesando el producto " + (i) + "en el tiempo: " +  (System.currentTimeMillis() - tiempo / 1000 ) + " [s]");

    }
    System.out.println("El cajero ha terminado" + this.nombre + "despues de tanto tiempo: "+ (System.currentTimeMillis() - tiempo / 1000) + " [s]");
  }

  public void esperarXsegundos(int segundos){
    try{
      Thread.sleep(segundos * 1000);
    }catch(InterruptedException e){
      // System.out.println(e);
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }

  }

}
