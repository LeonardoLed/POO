class Program{

  static void fun(){

      try{
          throw new NullPointerException("hi");
      }catch(NullPointerException e){
          System.out.println("Caught inside fun(). ");
          throw e;
      }

  }

  public static void main(String[] args) {

      try{
          fun();
      }catch(NullPointerException e){
        System.out.println("Caught in main.");
      }
  }


}
