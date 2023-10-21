import java.util.Scanner;

class Main {

  public static void header(){
    String clear = " ";
    for(int i = 0; i < 100;i++){
      clear = clear + "\n";
    }
    System.out.println(clear);
    System.out.println("==========================");
    System.out.println("       Menú principal");
    System.out.println("==========================\n");
  }

  public static int menu(){
    Scanner kb = new Scanner(System.in);
    int opcion;
    System.out.println("5. Cerra sesión");
    System.out.println("0. Salir \n");
    System.out.print("Ingresar la opción: ");
    opcion = kb.nextInt();

    if (opcion < 0 || opcion > 5) {
      System.out.println("Opción inválida");
      opcion = menu(); 
    }

     else if (opcion == 5) {
    System.out.println("Cerrando sesión...");
        Thread.sleep(4000);
     }
     System.out.println("Sesión cerrada");
   }
}
