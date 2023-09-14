package p1;
public class A{
  private int priva;
  protected int protb;
  public int pubc;
  int paqd;

  private void MetPriv(){}
  protected void MetProt(){}
  public void MetPub(){
    this.MetPriv();
    this.MetProt();
  }

  void MetPaq(){}

  public void setPrivx(int a){
    priva = a;
  }

}
