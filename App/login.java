import java.util.Scanner;

class Main {

  public static int inicioAplicacion(){
    Scanner kb = new Scanner(System.in);
    int opt;
    
    header();
    System.out.println("1. Inciar Sesión");
    System.out.println("2. Crear cuenta");
    System.out.println("0. Salir\n");
    System.out.print("Elige una opción: ");
    opt = kb.nextInt();
    return opt;
  }

  public static String[][] iniciarSesion(String[][] Usuarios){
    Scanner kb = new Scanner(System.in);
    String[][] usuario = {
      {"Usuario a retornar","Contraseña a retornar"},
      {"1","1"}
    };
    int opt;
    do{
      header();
      System.out.println("El usuario y la contraseña no pueden contener espacios\n");
      System.out.print("Ingrese el usuario: ");
      usuario[0][0] = kb.next();
      System.out.print("\n");
      System.out.print("Ingrese la contraseña: ");
      usuario[0][1] = kb.next();
      System.out.print("\n");

      if (usuario[0][0].equals("") || usuario[0][1].equals("")) {
        System.out.println("Debe ingresar un usuario y una contraseña");
        return iniciarSesion(Usuarios); 
      }

      for(int i = 0; i < Usuarios.length; i++){
        if(Usuarios[i][0].equals(usuario[0][0]) && Usuarios[i][1].equals(usuario[0][1])){
          usuario[1][0] = "0";
          usuario[1][1]= "0";
          return usuario;
        }
      }
      System.out.println("Usuario y contraseña incorrectos\n"); 
      System.out.println("1. Reintentar"); 
      System.out.println("0. Atrás\n"); 
      System.out.print("Ingrese la opción que desea: ");
      opt = kb.nextInt();
      
    }while(opt != 0);
    return usuario;
  }  
  
  public static String[][] crearCuenta(String[][] Usuarios, int posicionUsuario){
    Scanner kb = new Scanner(System.in);
    String[][] usuario = {
      {"Usuario a retornar","Contraseña a retornar"},
      {"1","1"}
    };
    String repeticion = " ";
    int opt = 1;
    do{
      header();
      System.out.println("Creando una cuenta\n");
      System.out.print("¿Cuál es su nombre de usuario?: ");
      usuario[0][0] = kb.next();
      boolean condicion = false;
      for(int j = 0; j < Usuarios.length; j++){
        if(Usuarios[j][0].equals(usuario[0][0])){
          header();
          try {
            System.out.print("\n\n\n\n La cuenta ya existe, pruebe otro");
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          condicion = true;
          break;
        }
      }
      if(condicion){
        continue;
      }
      do{
        header();
        System.out.println("El usuario y la contraseña no pueden contener espacios\n");
        System.out.print("Ingrese la contraseña: ");
        usuario[0][1] = kb.next();
        System.out.print("\n");
        System.out.print("Ingrese la misma contraseña: ");
        repeticion = kb.next();
        if(usuario[0][1].equals(repeticion)){
          break;
        }
        try {
          System.out.print("\nContraseñas diferentes, intente nuevamente");
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }while(true);
      try {
        System.out.print("Usuario creado con éxtio");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      opt = 0;
      
    }while(opt != 0);

    Usuarios[posicionUsuario] = usuario[0];
    
    return usuario;
  }
}
