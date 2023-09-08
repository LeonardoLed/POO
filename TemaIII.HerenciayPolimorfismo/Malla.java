public class Malla{

  private int [][] matrix = new int[10][10];


  public Malla(){
    Inicio();
  }

  public int[][] getMatrix(){return matrix;}
  public void setMatrix(int[][] m){this.matrix = m;}

  public void setNaveMatrix(int x, int y, int iNave){
    this.matrix[x][y] = iNave+1;
  }
  public int getNaveMatrix(int x, int y){
    return this.matrix[x][y];
  }

  public void Inicio(){
    for (int i = 0; i< matrix.length; i++){
      for (int j =0; j< matrix[0].length; j++){
        matrix[i][j] = 0; //es mar
      }
    }
  }

  public void PaintMalla(){
    for (int i = 0; i< matrix.length; i++){
      for (int j =0; j< matrix[0].length; j++){
        if (matrix[i][j] == 0){
          System.out.print(" ▩ ");
        }else if (matrix[i][j] != 0) {
          System.out.print(" "+ matrix[i][j] +" ");
        }
      }
      System.out.println("");
      System.out.println("");
    }
  }

  public void PaintMalla(int[][] matrixB){

    System.out.println("            TU JUEGO             |          TU RIVAL      ");
    System.out.println();


    for (int i = 0; i< matrix.length; i++){
      for (int j =0; j< matrix[0].length; j++){
        if (matrix[i][j] > 0){
          System.out.print(" "+ matrix[i][j] +" ");
          //System.out.print(" ▩ ");
        }else if (matrix[i][j] == 0) {
          System.out.print(" ▩ ");
        }else if (matrix[i][j] == -1){
          System.out.print(" "+ Nave.explorado +" ");
        }else{
          // siempre va tener el valor matrixB[i][j] -> -2
          System.out.print(" "+ Nave.fire +" ");
        }
      }

      System.out.print("   |   ");

      for (int j =0; j< matrixB[0].length; j++){
        if (matrixB[i][j] >= 0){
          System.out.print(" ▩ ");
        }else if (matrixB[i][j] == -1) {
          System.out.print(" "+ Nave.explorado +" ");
        }else{
          // siempre va tener el valor matrixB[i][j] -> -2
          System.out.print(" "+ Nave.fire +" ");
        }
      }

      System.out.println("");
      System.out.println("");
    }
  }

}
