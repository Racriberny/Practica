package com.cristobalbernal.Practica.Ejercicio03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alumno {
    private String nia;
    private String nombre;
    private String apellidos;
    private GregorianCalendar fecha_nacimiento;
    private String grupo;
    private String telefono;

    public Alumno(String nia, String nombre, String apellidos, GregorianCalendar fecha_nacimiento, String grupo, String telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Alumno{" +
                "nia='" + nia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento=" + simpleDateFormat.format(fecha_nacimiento.getTime()) +
                ", grupo='" + grupo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    public int getEdad(){
        LocalDate hoy = LocalDate.now();
        int anyo = fecha_nacimiento.get(Calendar.YEAR);
        int mes = fecha_nacimiento.get(Calendar.MONTH) + 1;
        int dia = fecha_nacimiento.get(Calendar.DAY_OF_MONTH);
        LocalDate cumple = LocalDate.of(anyo , mes , dia);
        Period periodo = Period.between(cumple, hoy);
        return periodo.getYears();
    }
}
