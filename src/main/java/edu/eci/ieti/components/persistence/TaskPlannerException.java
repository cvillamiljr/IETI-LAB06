package edu.eci.ieti.components.persistence;

public class TaskPlannerException extends Exception{
    final static public String YA_EXISTE_USUARIO="Ya existe un usuario con el respectivo username";
    final static public String NO_EXISTE_USUARIO="No existe un usuario con el respectivo username";
    final static public String CORREO_INVALIDO="El correo no es valido";

    public TaskPlannerException(String message){
        super(message);
    }
}
