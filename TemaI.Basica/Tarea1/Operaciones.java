public class Operaciones{

  public int n;
  public double factorial;
  public double suma;

  public Operaciones(int n){
    this.factorial = 1;
    this.suma = 0;
    this.n = n;
  }

  public double factorial(){
    factorial = 1;
    if (n>0){
      //ciclo for incremental
      for(int i = 1; i <= n; i++){
          this.factorial *= i;
      }
    }

    return factorial;
  }

  //overloading
  public static double factorial(int n){
    double factorial = 1;
    if (n>0){
      //ciclo for incremental
      for(int i = 1; i <= n; i++){
          factorial *= i;
      }
    }

    return factorial;
  }

  public void suma(){
    suma = 0;
    if (n>0){
      //ciclo for decremental
      for(int i = n; i >= 1; i--){
          this.suma += i;
      }
    }

    System.out.println("la suma [Guassiana] de sus antecesores es: " + suma);
  }


  @Override
  public String toString(){
    return "el numero: " + this.n + " tiene el factorial de valor: " + this.factorial + "  y su suma es: " + this.suma;
  }

//sobrecarga del metodo.
  public void suma(int t){
    suma = 0;
    if (t>0){
      //ciclo for decremental
      for(int i = t; i >= 1; i--){
          this.suma += i;
      }
    }

    System.out.println("la suma [Guassiana] de sus antecesores es: " + suma);
  }



}
