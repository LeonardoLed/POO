class Fish extends Animal
{
  public void makeSound(){
      System.out.println("glup glup");
  }

  @Override
  public void sleep(){
    super.sleep();
    System.out.println("estoy durmiendo.. Zz Zz");
  }

}
