package Logica;

public class Profesor extends Persona {
    private String materia;

    public Profesor(){

    }
    public Profesor(int id, String nombre, String apellido, String materia){
        super(id, nombre, apellido);
        this.materia = materia;
    }

    public String getMateria(){
        return this.materia;
    }
    public void setMateria(String materia){
        this.materia = materia;
    }
}
