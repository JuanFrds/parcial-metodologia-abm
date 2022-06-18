<template>
    <div>
        <div class="card">
            <div class="card-header">
                Alumnos
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Curso</th>
                            <th>Fecha de nacimiento</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr v-for="alumno in alumnos" :key="alumno.dni">
                            <td>{{alumno.dni}}</td>
                            <td>{{alumno.nombre}}</td>
                            <td>{{alumno.apellido}}</td>
                            <td>{{alumno.curso}}</td>
                            <td>{{alumno.fechaNacimiento}}</td>
                            <td>

                                <div class="btn-group" role="group" aria-label="">
                                    <router-link :to="{name: 'Update', params : {dni:alumno.dni}}" class="btn btn-info">Editar</router-link>
                                    <button type="button" v-on:click="eliminarAlumno(alumno.dni)" class="btn btn-danger">Borrar</button>
                                </div>

                            </td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import moment from 'moment';

export default {
    data(){
        return {
            alumnos:[]
        }
    },

    created: function(){
        this.consultarAlumnos();
    },

    methods: {
        consultarAlumnos(){
            fetch('http://localhost:3000/rest/getAlumnos')
                .then( response => response.json())
                .then( data => {
                    this.alumnos = data
                } )
                .catch( console.log )
        },
        eliminarAlumno(dni){
            console.log(dni)
            fetch(`http://localhost:3000/rest/deleteAlumno/${dni}`, {
                method:'DELETE'
            })
            .then( resp => {
                window.location.href = 'list';
            })
        }

    }
    
}
</script>


