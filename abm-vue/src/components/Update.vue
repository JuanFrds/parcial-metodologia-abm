<template>
    <div class="container">
        
        <div class="card">
            <div class="card-header">
                Actualizar alumno
            </div>
            <div class="card-body">
                <form v-on:submit.prevent="actualizarAlumno">

                    <div class="form-group">
                      <label for="dni">DNI:</label>
                      <input type="text"
                        class="form-control" required name="dni" v-model="alumno.dni" id="dni" aria-describedby="helpId" placeholder="">
                      <small id="helpId" class="form-text text-muted">Escribe el dni</small>
                    </div>

                    <div class="form-group">
                      <label for="nombre">Nombre:</label>
                      <input type="text"
                        class="form-control" required name="nombre" v-model="alumno.nombre" id="nombre" aria-describedby="helpId" placeholder="">
                      <small id="helpId" class="form-text text-muted">Coloca el nombre</small>
                    </div>

                    <div class="form-group">
                      <label for="nombre">Apellido:</label>
                      <input type="text"
                        class="form-control" required name="apellido" v-model="alumno.apellido" id="apellido" aria-describedby="helpId" placeholder="">
                      <small id="helpId" class="form-text text-muted">Coloca el apellido</small>
                    </div>

                    <div class="form-group">
                      <label for="nombre">Curso:</label>
                      <input type="text"
                        class="form-control" required name="curso" v-model="alumno.curso" id="curso" aria-describedby="helpId" placeholder="">
                      <small id="helpId" class="form-text text-muted">Coloca el nombre</small>
                    </div>

                    <div class="form-group">
                      <label for="nombre">Fecha:</label>
                      <input type="date"
                        class="form-control" required name="fecha" v-model="alumno.fechaNacimiento" id="fecha" aria-describedby="helpId" placeholder=""/>
                      <small id="helpId" class="form-text text-muted">Coloca el nombre</small>
                    </div>

                    <div class="btn-group" role="group" aria-label="">
                        <button type="submit" class="btn btn-success">Agregar</button>
                        <router-link :to="{name: 'List'}" class="btn btn-danger">Cancelar</router-link>
                    </div>

                </form>
            </div>
        </div>
        
    </div>
</template>

<script>
import { useRoute } from 'vue-router'
export default {
    
     data(){
        const route = useRoute();

        return{
            dni: route.params.dni,
            alumno: {}
        }
    },

    created: function(){
        this.consultarAlumno(this.dni);
    },

    methods: {
        actualizarAlumno(){

            // console.log(this.alumno.nombre)
            const dataEnviar = {
                dni: this.alumno.dni, 
                nombre: this.alumno.nombre,
                apellido: this.alumno.apellido,
                curso: this.alumno.curso
                };
            console.log(dataEnviar);

            fetch(`http://localhost:3000/rest/putAlumno`, {
                method: 'PUT',
                headers: {
                    'Content-type' : 'application/json'
                },
                body: JSON.stringify(dataEnviar)
            })
                .then(() => {
                    this.$router.push("/list");
                })
            
        },
        consultarAlumno(dni){
            fetch(`http://localhost:3000/rest/getAlumno/${dni}`)
                .then( response => response.json())
                .then( data => {
                  this.alumno = data;
                  console.log(this.alumno); 
                  })
                .catch( console.log )
        }
    }

}
</script>