class Processor extends Thread{


  private volatile boolean running = true;

  public void run(){

    while(running){
      System.out.println("I am Running =)");
      try{
        System.out.println("Estado: runnable -> Not Runnabale");
        Thread.sleep(50);
      }catch (InterruptedException e) {
        e.printStackTrace();
        assert running = false;
      }

    }



  }

  public void shutdown(){
    System.out.println("valor de running:" + running);
    running = false;
    System.out.println("lo cambie? : " + running);

  }

}
