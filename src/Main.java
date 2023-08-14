import Logica.Estudiante;
import Logica.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // los arreglos deben de ser globales para que se pueda usar en los diferentes metodos y
    // deben de ser privados y estaticos
    private static List<Estudiante> estudianteList = new ArrayList<Estudiante>();
    private static List<Profesor> profesorList = new ArrayList<Profesor>();

    public static void main(String[] args) {
        menuAcciones();
    }

    public static void menuAcciones(){

        Scanner scanner = new Scanner(System.in);

        int accion = 0;
        boolean ejecucion = true;

        do{
            System.out.println("****** MENU ACCIONES ********");
            System.out.println("* [1] Agregar      *");
            System.out.println("* [2] Mostrar      *");
            System.out.println("* [3] Editar       *");
            System.out.println("* [4] Eliminar     *");
            System.out.println("********************");
            System.out.println("Ingrese un numero o ingrese -1 para salir");
            accion = scanner.nextInt();
            // resetear la clase scanner
            scanner.nextLine();
            // finalizar la ejecucion si el usuario ingreso -1
            if(accion != -1){
                // invocar el metodo del menu
                menuPersona(scanner, accion);
            }else{
                ejecucion = false;
                System.out.println("----------------------------------------");
                System.out.println("- MUCHAS GRACIAS POR USAR EL PROGRAMA  -");
                System.out.println("----------------------------------------");
                scanner.close();
            }

        }while (ejecucion);
    }

    public static void menuPersona(Scanner scanner, int accion){

        int tipoPersona = 0;
        System.out.println("****** MENU PERSONA ********");
        System.out.println("* [1] Estudiante           *");
        System.out.println("* [2] Profesor             *");
        System.out.println("****************************");
        System.out.println("Ingrese un numero del menu: ");
        tipoPersona = scanner.nextInt();

        if(accion == 1){
            if(tipoPersona == 1){
                crearDatosEstudiante(scanner);
            }else{
                crearDatosProfesor(scanner);
            }
        }

        if(accion == 2){
            if(tipoPersona == 1){
                mostrarDatosEstudiante();
            }else{
                mostrarDatosProfesor();
            }
        }

        if(accion == 3){
            if(tipoPersona == 1){
                actualizarEstudiante(scanner);
            }else{
                actualizarProfesor(scanner);
            }
        }

        if(accion == 4){
            if(tipoPersona == 1){
                eliminarDatosEstudiante(scanner);
            }else{
                eliminarDatosProfesor(scanner);
            }
        }
    }

    public static void mostrarDatosEstudiante(){
        if (!estudianteList.isEmpty()){
            System.out.println("****** Datos estudiantes *******\n");

            // recorrer cada uno de los estudiantes de la lista
            System.out.println("-----------------------------------------------------------");
            System.out.println("|  Id  |     Nombre     |     Apellido    |     Grado     |");
            System.out.println("-----------------------------------------------------------");
            for (Estudiante estudiante : estudianteList){
                System.out.println("-----------------------------------------------------------");
                System.out.println("|  "+ estudiante.getId() +"  |     "+ estudiante.getNombre() +"     |     "+ estudiante.getApellido() +"    |     "+ estudiante.getGrado() +"     |");
            }
            System.out.println("-----------------------------------------------------------\n");

        }else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("A un no hay estudiantes para mostrar, ingrese un estudiante");
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public static void mostrarDatosProfesor(){
        if (!profesorList.isEmpty()){
            System.out.println("****** Datos profesores *******\n");

            // recorrer cada uno de los profesores de la lista
            System.out.println("-----------------------------------------------------------");
            System.out.println("|  Id  |     Nombre     |     Apellido    |     Materia     |");
            System.out.println("-----------------------------------------------------------");
            for (Profesor profesor  : profesorList){
                System.out.println("-----------------------------------------------------------");
                System.out.println("|  "+ profesor.getId() +"  |     "+ profesor.getNombre() +"     |     "+ profesor.getApellido() +"    |     "+ profesor.getMateria() +"     |");
            }
            System.out.println("-----------------------------------------------------------\n");
        }else{
            System.out.println("--------------------------------------------------------");
            System.out.println("A un no hay profesores para mostrar, ingrese un profesor");
            System.out.println("---------------------------------------------------------\n");
        }
    }

    public static void crearDatosEstudiante(Scanner scanner){

        Estudiante estudiante = new Estudiante();

        System.out.println("***** Agregar un nuevo estudiante ********\n");
        System.out.println("Ingrese el id del estudiante: ");
        estudiante.setId(scanner.nextInt());
        // resetear la clase scanner
        scanner.nextLine();
        System.out.println("Ingrese el nombre del estudiante: ");
        estudiante.setNombre(scanner.nextLine());
        System.out.println("Ingrese el apellido del estudiante: ");
        estudiante.setApellido(scanner.nextLine());
        System.out.println("Ingrese el grado del estuadiante: ");
        estudiante.setGrado(scanner.nextLine());

        // agregar el nuevo estudiante al arreglo
        estudianteList.add(estudiante);
    }

    public static void crearDatosProfesor(Scanner scanner){
        Profesor profesor = new Profesor();

        System.out.println("***** Agregar un nuevo profesor ********\n");
        System.out.println("Ingrese el id del profesor: ");
        profesor.setId(scanner.nextInt());
        // resetear la clase scanner
        scanner.nextLine();
        System.out.println("Ingrese el nombre del profesor: ");
        profesor.setNombre(scanner.nextLine());
        System.out.println("Ingrese el apellido: ");
        profesor.setApellido(scanner.nextLine());
        System.out.println("Ingrese la materia del profesor: ");
        profesor.setMateria(scanner.nextLine());

        //agregar el nuevo profesor al arreglo
        profesorList.add(profesor);
    }

    public static void actualizarEstudiante(Scanner scanner){

        if(!estudianteList.isEmpty()){

            Estudiante actualizarEstudiante = new Estudiante();
            String seleccion = "S";

            while (seleccion.equals("S")){
                int id = 0;
                System.out.println("***** Actualizar estudiante ********\n");
                System.out.println("Ingrese el id del estudiante a actaulizar: ");
                id = scanner.nextInt();

                // resetear la clase scanner
                scanner.nextLine();

                for (int i = 0; i < estudianteList.size(); i++){
                    if(estudianteList.get(i).getId() == id){
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Estudiante a actualizar es " + estudianteList.get(i).getNombre() +" "+" con id " + estudianteList.get(i).getId());
                        System.out.println("---------------------------------------------------------\n");
                        // solictar nuevos datos para actualizar
                        System.out.println("***** Actualizar estudiante ********\n");
                        System.out.println("Ingrese el nuevo nombre del estudiante: ");
                        actualizarEstudiante.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del estudiante: ");
                        actualizarEstudiante.setApellido(scanner.nextLine());
                        System.out.println("Ingrese el nuevo grado del estuadiante: ");
                        actualizarEstudiante.setGrado(scanner.nextLine());

                        System.out.println("Estas seguro de actualizar [S/N]: ");
                        seleccion = scanner.next();
                        if(seleccion.equals("S")){
                            // moficicar los datos del estudiante
                            estudianteList.get(i).setNombre(actualizarEstudiante.getNombre());
                            estudianteList.get(i).setApellido(actualizarEstudiante.getApellido());
                            estudianteList.get(i).setGrado(actualizarEstudiante.getGrado());
                            seleccion = "N";
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Estudiante actualizado con exito");
                            System.out.println("---------------------------------------------------------\n");
                        }else{
                            seleccion = "N";
                        }
                    }else{
                        System.out.println("--------------------------------------------------------");
                        System.out.println("No se encontro ningun estudiante con el id ingresado");
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Desea ingresar nuevamente el id del usuario [S/N]: ");
                        seleccion = scanner.nextLine();
                    }
                }
            }
        }else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("A un no hay estudiantes para actualizar, ingrese un estudiante");
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public static void actualizarProfesor(Scanner scanner){
        if(!profesorList.isEmpty()){

            Profesor actualizarProfesor = new Profesor();
            String seleccion = "S";

            while (seleccion.equals("S")){
                int id = 0;
                System.out.println("***** Actualizar profesor ********\n");
                System.out.println("Ingrese el id del profesor a actaulizar: ");
                id = scanner.nextInt();

                // resetear la clase scanner
                scanner.nextLine();

                for (int i = 0; i < profesorList.size(); i++){
                    if(profesorList.get(i).getId() == id){
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Profesor a actualizar es " + profesorList.get(i).getNombre() +" "+" con id " + profesorList.get(i).getId());
                        System.out.println("---------------------------------------------------------\n");
                        // solictar nuevos datos para actualizar
                        System.out.println("***** Actualizar estudiante ********\n");
                        System.out.println("Ingrese el nuevo nombre del estudiante: ");
                        actualizarProfesor.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del estudiante: ");
                        actualizarProfesor.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la nueva materia del estuadiante: ");
                        actualizarProfesor.setMateria(scanner.nextLine());

                        System.out.println("Estas seguro de actualizar [S/N]: ");
                        seleccion = scanner.next();
                        if(seleccion.equals("S")){
                            // moficicar los datos del estudiante
                            profesorList.get(i).setNombre(actualizarProfesor.getNombre());
                            profesorList.get(i).setApellido(actualizarProfesor.getApellido());
                            profesorList.get(i).setMateria(actualizarProfesor.getMateria());
                            seleccion = "N";
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Profesor actualizado con exito");
                            System.out.println("---------------------------------------------------------\n");
                        }else{
                            seleccion = "N";
                        }
                    }else{
                        System.out.println("--------------------------------------------------------");
                        System.out.println("No se encontro ningun profesor con el id ingresado");
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Desea ingresar nuevamente el id del usuario [S/N]: ");
                        seleccion = scanner.nextLine();
                    }
                }
            }
        }else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("A un no hay profesores para actualizar, ingrese un estudiante");
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public static void eliminarDatosEstudiante(Scanner scanner){
        if(!estudianteList.isEmpty()){

            String seleccion = "S";

            while (seleccion.equals("S")){
                int id = 0;
                System.out.println("***** Eliminar un estudiante ********\n");
                System.out.println("Ingrese el id del estudiante a eliminar: ");
                id = scanner.nextInt();

                // resetear la clase scanner
                //scanner.nextLine();

                for (int i = 0; i < estudianteList.size(); i++){
                    if(estudianteList.get(i).getId() == id){
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Estudiante a eliminar es " + estudianteList.get(i).getNombre() +" "+" con id " + estudianteList.get(i).getId());
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Estas seguro de eliminar [S/N]: ");
                        seleccion = scanner.next();
                        if(seleccion.equals("S")){
                            estudianteList.remove(estudianteList.get(i));
                            seleccion = "N";
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Estudiante eliminado con exito");
                            System.out.println("---------------------------------------------------------\n");
                            break;
                        }else{
                            seleccion = "N";
                        }
                    }else{
                        System.out.println("--------------------------------------------------------");
                        System.out.println("No se encontro ningun estudiante con el id ingresado");
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Desea ingresar nuevamente el id del usuario [S/N]: ");
                        seleccion = scanner.next();
                    }
                }
            }
        }else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("A un no hay estudiantes para eliminar, ingrese un estudiante");
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public static void eliminarDatosProfesor(Scanner scanner){
        if(!profesorList.isEmpty()){

            String seleccion = "S";

            while (seleccion.equals("S")){
                int id = 0;
                System.out.println("***** Eliminar un estudiante ********\n");
                System.out.println("Ingrese el id del estudiante a eliminar: ");
                id = scanner.nextInt();

                // resetear la clase scanner
                //scanner.nextLine();

                for (int i = 0; i < profesorList.size(); i++){
                    if(profesorList.get(i).getId() == id){
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Profesor a eliminar es " + profesorList.get(i).getNombre() +" "+" con id " + profesorList.get(i).getId());
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Estas seguro de eliminar [S/N]: ");
                        seleccion = scanner.next();
                        if(seleccion.equals("S")){
                            profesorList.remove(profesorList.get(i));
                            seleccion = "N";
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Profesor eliminado con exito");
                            System.out.println("---------------------------------------------------------\n");
                            break;
                        }else{
                            seleccion = "N";
                        }
                    }else{
                        System.out.println("--------------------------------------------------------");
                        System.out.println("No se encontro ningun profesor con el id ingresado");
                        System.out.println("---------------------------------------------------------\n");
                        System.out.println("Desea ingresar nuevamente el id del usuario [S/N]: ");
                        seleccion = scanner.next();
                    }
                }
            }
        }else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("A un no hay profesores para eliminar, ingrese un profesor");
            System.out.println("-----------------------------------------------------------\n");
        }
    }
}