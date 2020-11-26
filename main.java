import Clases.Sistema;

import java.util.Scanner;

import Clases.Procesador;
import Clases.colores;

class main{
    public static void main (String [] args){
        new Sistema();
        new Procesador();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //ponerle colores
        System.out.println(colores.ANSI_WHITE_BOLD + " Simulador de un sistema operativo" + colores.ANSI_RESET);
        System.out.println(colores.ANSI_WHITE + "Bienvenido a la interfaz por consola" + colores.ANSI_RESET);
        System.out.println("Hecho por " + colores.ANSI_WHITE_BOLD + "Inaki etchegarray, Matias Gonzalez y Gaston Landeira" + colores.ANSI_RESET);
        while(!exit){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Inserte el numero de opcion que desea elegir");
            System.out.println("1 -> Casos de prueba");
            System.out.println("2 -> Ayuda(Descrpicion de casos de ayuda)");
            System.out.println("3 -> Salir del programa");
            //colores.ANSI_RED + "No hay mas procesos por ejecutar..." + colores.ANSI_RESET
            int entrada = scanner.nextInt();
            
            switch (entrada){
                case 1:
                    menuPrueba(scanner);
                break;
                case 2:
                    menuAyuda(scanner);
                break;
                case 3:
                    exit = true;
                break;
            }
        }
        scanner.close();

        Sistema sistema = Sistema.Current();
        sistema.ImportarProgramas();
        sistema.crearParticiones();
        sistema.crearProcesos();
        sistema.crearRecursos();
        sistema.inicializarGrafo();
        sistema.crearUsuarios();

        //Loop que use los procesos
        boolean termino = false;
        while(!termino) {
            termino = Procesador.Current().ejecutarProximoProceso();

            sistema.avanzarRecursos();
        }

        System.out.println(colores.ANSI_RED + "No hay mas procesos por ejecutar..." + colores.ANSI_RESET);
        System.out.println(colores.ANSI_RED + "EXIT" + colores.ANSI_RESET);
    }


    /**
     * Logica de usuario:
     * El usuario tiene permisos a procesos y recursos, para esto necesitamos
     * Matriz de bools (True = acceso, False = no) de usuarios y recursos
     * Matriz de bools "" de usuarios y procesos
     * 
     * Uso de las matrices:
     * Cuando vas a ejecutar un proceso ver en la posicion M[u][p] si el usuario tiene permiso, si no tiene printear "No tiene acceso a este proceso" y seguir con el proximo en RR
     * Cuando vas adentro de un proceso vas a PEDIR un recurso fijarse si el usuario tiene permiso para utilizar el recurso, Si lo tiene avanza normal, si no matar proceso
     * 
     * IDEAS:
     * Funcion en sistema permisoRecurso(usuario, recurso)
     * Funcion en sistema permisoProceso(usuario, proceso)
     * Funcion en PCB matarProceso que lo termine y lo saque del scheduller
     * Fijarse si usuario tiene permiso afuera del PCB, si no lo tiene no ejecutar el proceso directamente
     * Fijarse si el usuario tiene permiso para usar el recurso, si no lo tiene, llamar a matarProceso, y sacar proceso de Round Robin 
     */

    public static void menuPrueba(Scanner scanner){
        boolean exitPrueba = false;
        while(!exitPrueba){
            System.out.println("");
            System.out.println("Inserte el numero de opcion que desea elegir");
            System.out.println("1 -> ");
            System.out.println("2 -> ");
            System.out.println("3 -> Salir del programa");

            int entrada = scanner.nextInt();
            
            switch (entrada){
                case 1:
                    
                break;
                case 2:
                    
                break;
                case 3:
                    exitPrueba = true;
                break;
            }
        }
    }

    public static void menuAyuda(Scanner scanner){
        boolean exitAyuda = false;
        while(!exitAyuda){
            System.out.println("");
            System.out.println("Inserte el numero de opcion que desea elegir");
            System.out.println("1 -> ");
            System.out.println("2 -> ");
            System.out.println("3 -> Salir del programa");

            int entrada = scanner.nextInt();
            
            switch (entrada){
                case 1:
                    
                break;
                case 2:
                    
                break;
                case 3:
                    exitAyuda = true;
                break;
            }
        }
    }
}