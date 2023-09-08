public class Nave{

  private int life;
  private int angle;

  public static final String figure = "🚢";
  public static final String fire = "x";
  public static final String explorado = "-";
  public static final int[] lifesize = new int[]{2,3,3,4,5}

  // tipos de barco de:
  // 1 de 2 pix : xx
  // 2 de 3 pix : xxx
  // 1 de 4 pix : xxxx
  // 1 de 5 pix : xxxx

  public void setLife(int n){this.life=n;}
  public int getLife(){return life;}
  public void setAngle(int s){this.angle=s;}
  public int getAngle(){return angle;}


  public Nave(){}
  public Nave(int dim){setLife(dim);}
  //public Nave(String ac){System.out.prinln(ac);}
  public void assigLife(int dim){setLife(dim);};


}
