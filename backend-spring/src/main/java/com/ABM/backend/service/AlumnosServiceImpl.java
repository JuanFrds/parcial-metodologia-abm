package com.ABM.backend.service;

import com.ABM.backend.dao.AlumnoDAO;
import com.ABM.backend.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosServiceImpl implements AlumnosService {
    @Autowired
    private AlumnoDAO alumnoDAO;


    @Override
    public List<Alumno> getAll() {
        return (List<Alumno>) alumnoDAO.findAll();
    }

    @Override
    public Alumno getAlumno(int dni) {
        return alumnoDAO.findById(dni).get();
    }

    @Override
    public void deteleAlumno(int dni) {
        alumnoDAO.deleteById(dni);
    }

    @Override
    public void postAlumno(Alumno alumno) {
        alumnoDAO.save(alumno);
    }

    @Override
    public void putAlumno(Alumno alumno) {
        alumnoDAO.save(alumno);
    }


}
