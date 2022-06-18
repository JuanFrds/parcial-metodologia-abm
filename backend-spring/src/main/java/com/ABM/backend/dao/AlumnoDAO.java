package com.ABM.backend.dao;

import com.ABM.backend.models.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDAO extends CrudRepository<Alumno, Integer> {
}
