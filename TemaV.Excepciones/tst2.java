class tst2{

  static void fun() throws IlegalAccesException{
          System.out.println("Caught inside fun(). ");
          throw new IlegalAccessException("hi");
  }

  public static void main(String[] args) {

      try{
          fun();
      }catch(IlegalAccessException e){
        System.out.println("Caught in main.");
      }
  }


  }
