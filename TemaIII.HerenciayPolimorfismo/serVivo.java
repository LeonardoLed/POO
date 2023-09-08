public class serVivo{

  private String filo = "";
  private String clase = "";
  private String genero = "";
  private String especie = "";
  private String reino = "Protista";
  // 1 -> autotrofo 2-> heterotrofo 3-> raro
  private int tipoAlimentacion ;

  //0 -> Asexual , 1-> Sexual , 2-> Dos, 3->NO TIENE
  private int tipoReproduccion;


  static final String[] reinos = new String[]{"Animalia", "Fungi","Plantae", "Monera", "Protista"};


  public String getFilo(){ return this.filo;}
  public void setFilo(String filo){ this.filo = filo;}

  public String getReino(){return reino; }
  public void setReino(String r){ this.filo = filo;}

  public String getClase(){ return this.clase;}
  public void setClase(String clase){ this.clase = clase;}

  public String getGenero(){ return this.genero;}
  public void setGenero(String genero){ this.genero = genero;}

  public String getEspecie(){ return this.especie;}
  public void setEspecie(String e){ especie = e;}


  public int getTipoReproduccion(){ return tipoReproduccion;}
  public void setTipoReproduccion(int tr){ tipoReproduccion = tr;}

  public int getTipoAlimentacon(){ return tipoAlimentacion;}
  public void setTipoAlimentacon(int ta){ tipoAlimentacion = ta;}

  //SOBRECARGA DE METODOS

  public serVivo(){}
  public serVivo(String g, String e){this.genero = g; especie = e;}
  public serVivo(String f, String c, String g, String e){
    this.filo = f;
    this.clase = c;
    this.genero = g;
    especie = e;
  }

  public serVivo(String f, String c, String g, int r){
    this.filo = f;
    this.clase = c;
    this.genero = g;
    this.reino = reinos[r];
  }

  public String toString(int j){return "holita";}

  public String toString(){
    return "el ser Vivo es del reino "+ getReino() + " de la familia: " + getFilo() + "de la clase: " + getClase();
    //return "el ser Vivo es del reino "+ reino;
    //return "el ser Vivo es del reino "+ this.reino;
  }





}
