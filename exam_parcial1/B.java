class B{

  static private int a = 1;
  static final int b = 2;
  protected String[] letras = new String[10];

  public static int getA(){
    return a;
  }
  public static int getA(String c){
    return b;
  }
  protected B(){
    String c = "c";
    String l = "l";
    String s = "s";
    for (int i = 0; i<letras.length; i++){
        letras[i] = (i < 5) ? ( (i%2==0) ? c : s ) : l;
    }
  }

}
