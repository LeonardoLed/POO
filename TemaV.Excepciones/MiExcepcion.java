
public class MiExcepcion extends Exception{

  private int codigoError;

  public MiExcepcion(int codigoError){
    super(); // llamando al método constructor de la superclase
    this.codigoError = codigoError;
  }

  @Override
  public String getMessage(){
    String mensaje = "";

    switch(codigoError){
      case 1:
        mensaje = "Error, el numero esta entre 0-10";
        break;
      case 2:
        mensaje = "Error, el numero esta entre 11-20";
        break;
      case 3:
        mensaje = "Error, el numero esta entre 21 y 30";
        break;
    }

    return mensaje;


  }


}
