// Importamos el paquete para el manejo de archivos
import java.io.*;
// Importamos el paquete donde se encuentra el JOptionPane
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
    File archivo = new File("hoy.txt");

    FileWriter escribir;

    PrintWriter linea;

    String nombre = "";
    String apellidos = "";


    if(!archivo.exists()) {
            try {

                // Creamos el archivo
                archivo.createNewFile();

                // Pedimos los datos al usuario a través de un JOptionPane.
                nombre = JOptionPane.showInputDialog(null, "Escribe tu nombre");
                apellidos = JOptionPane.showInputDialog(null,
                        "Escribe apellidos");

                // Escribirmos en el archivo. Como segundo parámetro
                // le pasamos true para que escriba al final del archivo.
                escribir = new FileWriter(archivo, true); //W+ O A

                // Con esta instrucción escribimos en varias lineas.
                linea = new PrintWriter(escribir);

                // Escribimos en el archivo.
                linea.println(nombre + " " + apellidos);

                // Cerramos el objeto de escritura
                linea.close();
                escribir.close();

            } catch (IOException e) {

        e.printStackTrace();
            }
    }

    else {

            try {

                nombre = JOptionPane.showInputDialog(null, "Escribe tu nombre");
                apellidos = JOptionPane.showInputDialog(null,
                        "Escribe apellidos");

                escribir = new FileWriter(archivo, true);


                linea = new PrintWriter(escribir);


                linea.println(nombre + " " + apellidos);


                linea.close();
                escribir.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("Programa finalizado.");

    }

    int numPersonas = 5;
    Scanner entrada = new Scanner(System.in);

    int[] edades = new int[numPersonas];
    String[] nombres = new String[numPersonas];
    String[] apellido = new String[numPersonas];


    try {


      //File
      archivo = new File("hoy.txt");
      //FileWriter
      escribir = new FileWriter(archivo, true);
      //PrintWriter
      linea = new PrintWriter(escribir);


      for(int i = 0; i < numPersonas; i++) {


        System.out.print("Dime la edad del usuario " + (i + 1) + ": \n");
        edades[i] = entrada.nextInt();

        System.out.print("Dime el nombre del usuario " + (i + 1) + ": \n");
        nombres[i] = entrada.next();

        System.out.print("Dime el apellido del usuario " + (i + 1) + ": \n");
        apellido[i] = entrada.next();


        linea.println("Usuario " + (i + 1) + "\tNombre: " + nombres[i] + "\tApellido: "
                  + apellido[i] + "\tEdad: " + edades[i]);
      }

      linea.close();
    } catch(IOException e) {
      e.printStackTrace();
    }

    }
  }
