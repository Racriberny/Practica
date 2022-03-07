package com.cristobalbernal.Practica.Ejercicio03;

import com.cristobalbernal.Practica.Lib.Lib;
import com.github.javafaker.Faker;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Instituto {
    private Alumno [] alumnos;
    private int numeroAlumnos;

    public Instituto(){
        alumnos = new Alumno[10];
    }


    public String bajaAlumno(String nia){
        String respuesta;
        for (int i = 0; i < numeroAlumnos ; i++) {
            if (alumnos[i].getNia().equalsIgnoreCase(nia)){
                System.out.println("Desea eliminar el alumno: S/N");
                respuesta = Lib.leerLinea();
                if ("S".equalsIgnoreCase(respuesta)){
                    numeroAlumnos--;
                    alumnos[i] = null;
                }else if ("N".equalsIgnoreCase(respuesta)){
                    return "Has elegido no eliminar el alumno!!";
                }else {
                    return "No has escrito bien la respuesta!!";
                }
            }
        }
        return "No se ha encontrado ningun alumno con ese nia!!!!";
    }

    public void mostrarAlumnos(){
        for (int i = 0; i <numeroAlumnos ; i++) {
            System.out.println(alumnos[i]);
        }
    }

    public void datosDePruebaFaker(int numAlumnos){
        Faker faker = new Faker(Locale.forLanguageTag("es"));
        String nia;
        String nombre;
        String apellidos;
        GregorianCalendar fecha_nacimiento;
        String grupo;
        String telefono;

        for (int i = 0; i <numAlumnos ; i++) {
            nia = faker.idNumber().valid();
            nombre = faker.name().firstName();
            apellidos = faker.name().lastName();
            fecha_nacimiento = new GregorianCalendar();
            fecha_nacimiento.setTime(faker.date().birthday(18,80));
            grupo =
            telefono = faker.phoneNumber().phoneNumber();
            alumnos[numeroAlumnos] = new Alumno(nia,nombre,apellidos,fecha_nacimiento,grupo,telefono);
            numeroAlumnos++;
        }
        for(Alumno alumno: alumnos) {
            System.out.println(alumno.toString());
        }
    }

    public Alumno nuevoAlumno(String nia, String nombre, String apellidos, GregorianCalendar fecha_nacimiento, String grupo, String telefono){
        if (numeroAlumnos == alumnos.length){
            Alumno[] alumnosAux= new Alumno[alumnos.length + 2];
            for (int i = 0; i < alumnos.length; i++) {
                alumnosAux[i]=alumnos[i];
            }
            alumnos = alumnosAux;
        }
        Alumno alumno = new Alumno(nia,nombre,apellidos,fecha_nacimiento,grupo,telefono);
        alumnos[numeroAlumnos] = alumno;
        numeroAlumnos++;

        return alumno;
    }

    public int busquedaPorNia(String nia){
        for (int i = 0; i <numeroAlumnos ; i++) {
            if (alumnos[i].getNia().equalsIgnoreCase(nia)){
                return 1;
            }
        }
        return 0;
    }
    public int encontrarGrupo(String grupo){
        for (int i = 0; i <numeroAlumnos ; i++) {
            if (alumnos[i].getGrupo().equalsIgnoreCase(grupo)){
                return i;
            }
        }
        return 0;
    }
    public Alumno buscarGrupo(String grupo){
        if (encontrarGrupo(grupo) > 0){
            return alumnos[encontrarGrupo(grupo)];
        }
        return null;
    }
    public int encontrarNia(String nia){
        for (int i = 0; i <numeroAlumnos ; i++) {
            if (alumnos[i].getNia().equalsIgnoreCase(nia)){
                return i;
            }
        }
        return 0;
    }
    public Alumno buscarNia(String nia){
        if (encontrarNia(nia) > 0){
            return alumnos[encontrarNia(nia)];
        }
        return null;
    }
    public int encontrarApellido(String apellido){
        for (int i = 0; i <numeroAlumnos ; i++) {
            if (alumnos[i].getApellidos().equalsIgnoreCase(apellido)){
                return i;
            }
        }
        return 0;
    }
    public Alumno buscarApellido(String apellido){
        if (encontrarApellido(apellido) >= 0){
            return alumnos[encontrarNia(apellido)];
        }
        return null;
    }

    public void busquedaEdad(int fecha) {
        int contador = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getEdad() == fecha) {
                contador++;
            }
        }
        if (contador == 1){
            for (Alumno alumno : alumnos) {
                if (alumno.getEdad() == fecha) {
                    System.out.println(alumno);
                }
            }
        }else {
            System.out.println("No existe ninguno");
        }
    }
}
