package com.ABM.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table ( name = "alumnos" )
public class Alumno {
    @Id
    @Column( name = "dni_alumno" )
    private int dni;

    @Column( name = "nombre_alumno" )
    private String nombre;

    @Column( name = "apellido_alumno" )
    private String apellido;

    @Column( name = "curso_alumno" )
    private String curso;

    @Column( name = "fecha_nacimiento_alumno" )
    private LocalDate fechaNacimiento;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
