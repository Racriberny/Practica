package com.cristobalbernal.Practica.Ejercicio03;

import com.cristobalbernal.Practica.Lib.Lib;
import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Principal {
    private Instituto instituto;
    public void execute(){
        int opcion;
        String nia;
        instituto = new Instituto();
        instituto.datosDePruebaFaker(10);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1 -> nuevoAlumno();
                case 2 -> {
                    System.out.println("Escribe el nia del alumno que quieres dar de bajaa");
                    nia = Lib.leerLinea();
                    System.out.println(instituto.bajaAlumno(nia));
                }
                case 3 -> consultas();
                case 4 -> instituto.mostrarAlumnos();
            }
        }while (opcion !=0);


    }

    private void nuevoAlumno() {
        String nia;
        int pos;
        String nombre;
        String apellido;
        String fechaFecha;
        GregorianCalendar fecha_nacimiento = null;
        String grupo;
        String telefono;
        boolean valido = false;;

        do {
            System.out.println("Escribe el nia: ");
            nia = Lib.leerLinea();
            valido = nia.length() > 0;
        }while (!valido);

        pos = instituto.busquedaPorNia(nia);

        if (pos >0){
            do {
                System.out.println("Escribe el nombre: ");
                nombre = Lib.leerLinea();
                valido = nombre.length() >0;
            }while (!valido);

            do {
                System.out.println("Escribe el nombre: ");
                apellido = Lib.leerLinea();
                valido = apellido.length() >0;
            }while (!valido);

            do {
                System.out.println("Escribe la fecha dd/mm/yyyy");
                fechaFecha = Lib.leerLinea();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try{
                    Date date = sdf.parse(fechaFecha);
                    fecha_nacimiento = new GregorianCalendar();
                    fecha_nacimiento.setTime(date);
                    valido = true;
                }catch (ParseException pe){
                    valido = false;
                    System.out.println("La fecha es incorrecta");

                }
            }while (!valido);

            do {
                System.out.println("Escribe el grupo: ");
                grupo = Lib.leerLinea();
                valido = grupo.length() >0;
            }while (!valido);

            do {
                System.out.println("Escribe el telefono: ");
                telefono = Lib.leerLinea();
                valido = telefono.length() >0;
            }while (!valido);

            instituto.nuevoAlumno(nia,nombre,apellido,fecha_nacimiento,grupo,telefono);
        }
    }

    private void consultas() {
        int opcion;
        boolean valido;
        String grupo;
        String nia;
        String apellido;
        int edad;
        do {
            opcion = menuConsultas();
            switch (opcion){
                case 1:
                    do {
                        System.out.println("Escribe el grupo: ");
                        grupo = Lib.leerLinea();
                        valido = grupo.length() >0;
                    }while (!valido);
                    System.out.println(instituto.buscarGrupo(grupo));
                break;
                case 2:
                    do {
                        System.out.println("Escribe la edad: ");
                        edad = Lib.leerInt();
                        valido = edad > 0;
                    }while (!valido);
                    instituto.busquedaEdad(edad);
                break;
                case 3:
                    do {
                        System.out.println("Escribe el nia: ");
                        nia = Lib.leerLinea();
                        valido = nia.length() >0;
                    }while (!valido);
                    System.out.println(instituto.buscarNia(nia));
                break;
                case 4:
                    do {
                        System.out.println("Escribe el nia: ");
                        apellido = Lib.leerLinea();
                        valido = apellido.length() >0;
                    }while (!valido);
                    System.out.println(instituto.buscarApellido(apellido));
                break;
            }
        }while (opcion !=0);
    }

    private int menuConsultas() {
        int opcion;
        System.out.println("CONSULTAS!!!");
        System.out.println("1 Grupo:");
        System.out.println("2- Por edad");
        System.out.println("3- Por nia");
        System.out.println("4- Por apellidos!!");
        System.out.println("0- Volver al menu principal");
        System.out.println("Escribe una opcion: ");
        opcion = Lib.leerInt();
        return opcion;
    }

    private int menuPrincipal() {
        int opcion;
        System.out.println("GESTION ALUMNOS");
        System.out.println("***************");
        System.out.println("1- Nuevo alumno...");
        System.out.println("2- Baja de alumno...");
        System.out.println("3- Consultas...");
        System.out.println("----------------");
        System.out.println("0- Salir");
        System.out.println("Seleccione una opcion:");
        opcion = Lib.leerInt();
        return opcion;
    }
}
