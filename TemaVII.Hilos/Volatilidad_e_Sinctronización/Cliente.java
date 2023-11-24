public class Cliente{
  private String nombre;
  private int[] carroCompra;

  public Cliente(String nombre, int[] carroCompra){
    this.nombre = nombre;
    this.carroCompra = carroCompra; 
  }
  //getters
  public String getNombre(){return this.nombre;}
  public int[] getCarroCompra(){ return this.carroCompra;}

  //setters
  public void setNombre(String nombre){this.nombre = nombre;}
  public void setCarroCompra(int[] carroCompra){carroCompra = carroCompra;}


}
