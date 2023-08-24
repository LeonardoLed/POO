public class Operadores{
  public static void main(String[] args) {

    // Operadores aritmeticos
    // -,+ | * | / | %


    // Operadores aritmeticos incrementales / decrem..
    // ++, --
    // POSTFIJA b--, a--
    // PREFIJA  --a, --b


    // Operadores asignacion
    // =, +=, -=, *=, /=, %=

    // Operadores de relacion
    // ==, !=, <,> ,<=, >=

    //Operadores logicos o booleanos
    // ! (UNARIO)
    // &, |  operaciones completas
    // &&, || operaciones en corto circuito
    // ^ XOR


    int a = 7;
    int b = 12;
    int suma = a+b;
    System.out.print(suma+"\n");
    //System.out.print(a+b);

    //operador ternario
    // condicion ? sentenciaVERDADERA : setenciaFalsa
    System.out.println((a > b ? "a es mayor que b": "a puede que sea igual o menor que b"));

    int c = (a > b ? 6: 7);

    System.out.println(c);

    //Operaciones bit a bit
    // &, |, ^
    // <<, >>, >>>
    int z = a | b;
    int w = a & b;
    int y = a ^ b;
    System.out.println("A and B:" + w);
    System.out.println("A or B:" + z);
    System.out.println("A xor B:" + y);

    int j = -12;
    int p = j >>> 1 ;
    System.out.println(p);

  }
}
