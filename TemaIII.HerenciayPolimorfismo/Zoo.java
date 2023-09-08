public class Zoo{

    public static void main(String[] args) {
      serVivo cosa = new serVivo();
      serVivo eucalipto = new serVivo("Myrtaceae", "Magnoliopsida", "Eucalyptus", 2);
      System.out.println(eucalipto);
      System.out.println(eucalipto.toString(2));

    }


}
