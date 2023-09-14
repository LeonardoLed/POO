class Main{
  public static void main(String[] args) {
    Dog Loki = new Dog();
    Dog Baxter = new Dog();
    Cat Garfield = new Cat();
    Fish Dori = new Fish();

    // Esto es invalido
    //Dog Solovino = new Cat();
    //UPCASTING
    Animal x = new Animal();
    Animal y = new Dog();
    y.sleep();
    y.hello();

    //DOWNCASTING

    //Animal e = new Animal();

    Loki.makeSound();
    Loki.eat();
    Garfield.sleep();

    Dori.sleep();

  }
}
