package com.ABM.backend.controllers;

import com.ABM.backend.models.Alumno;
import com.ABM.backend.service.AlumnosService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AlumnoController {

    @Autowired
    private AlumnosService alumnosService;

    @GetMapping("getAlumnos")
    public List<Alumno> getAll(){
        return alumnosService.getAll();
    }

    @GetMapping("getAlumno/{dni}")
    public Alumno getAlumno(@PathVariable(name = "dni") int dni){
        return alumnosService.getAlumno(dni);
    }

    @DeleteMapping("deleteAlumno/{dni}")
    public void deleteAlumno(@PathVariable int dni) {
        alumnosService.deteleAlumno(dni);
    }

    @PostMapping("postAlumno")
    public void postAlumno(@RequestBody Alumno alumno){
        alumnosService.postAlumno(alumno);
    }

    @PutMapping("putAlumno")
    public void putAlumno(@RequestBody Alumno alumno) { alumnosService.putAlumno(alumno); }
}
