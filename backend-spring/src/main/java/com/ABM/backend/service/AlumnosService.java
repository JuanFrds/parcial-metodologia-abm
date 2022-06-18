package com.ABM.backend.service;

import com.ABM.backend.models.Alumno;

import java.util.List;

public interface AlumnosService {
    List<Alumno> getAll();
    Alumno getAlumno(int dni);
    void deteleAlumno(int dni);

    void postAlumno(Alumno alumno);

    void putAlumno(Alumno alumno);
}
