package Logica;

public class Estudiante extends Persona {
    private String grado;

    public Estudiante(){

    }
    public Estudiante(int id, String nombre, String apellido, String grado){
        super(id, nombre, apellido);
        this.grado = grado;
    }

    public String getGrado(){
        return this.grado;
    }
    public void setGrado(String grado){
        this.grado = grado;
    }
}
