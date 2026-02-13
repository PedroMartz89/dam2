package com.pberna.aad.exameneva2;

import com.pberna.aad.exameneva2.data.pojos.Actor;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;
import com.pberna.aad.exameneva2.mongo.ComponentesBD;
import com.pberna.aad.exameneva2.services.ServiceActores;
import com.pberna.aad.exameneva2.services.ServiceDirectores;
import com.pberna.aad.exameneva2.services.ServicePeliculaActor;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Inicialización de Servicios
        ServiceDirectores serviceDirectores = new ServiceDirectores();
        ServiceActores serviceActores = new ServiceActores();
        ServicePeliculaActor servicePeliculaActor = new ServicePeliculaActor();
        List<RentabilidadDirector> rentabilidades = serviceDirectores.getRentabilidadDirector();
        System.out.println("=== TEST 1: Rentabilidad de Directores (HQL con DTO) ===");

        if (rentabilidades != null && !rentabilidades.isEmpty()) {
            for (RentabilidadDirector r : rentabilidades) {
                System.out.println("Director: " + r.getNombreRentDirector() +
                                   " | Total: " + r.getTotalRecaudacion() +
                                   " | Rentabilidad: " + r.getRentabilidadMedia());
            }
        } else {
            System.out.println("No se obtuvieron datos de rentabilidad.");
        }

        System.out.println("\n=== TEST 2: Borrado Seguro (Validación de Integridad) ===");
        // ID 1 suele ser Christopher Nolan en tu SQL
        String resultadoBorrado = serviceDirectores.delete(1);
        System.out.println("Resultado (ID 1): " + resultadoBorrado);

        System.out.println("\n=== TEST 3: Actores por Película (NamedQuery) ===");
        // Película con ID 1
        List<Actor> actoresPeli = serviceActores.getActoresPelicula(1);
        if (actoresPeli != null) {
            System.out.print("Actores encontrados: ");
            actoresPeli.forEach(a -> System.out.print(a.getNombre() + " | "));
            System.out.println();
        }

        System.out.println("\n=== TEST 4: Papeles de un Actor (HQL ordenado) ===");
        // Actor con ID 1 (Leonardo DiCaprio)
        List<PeliculaActor> papeles = servicePeliculaActor.getPapelesActor(1);
        if (papeles != null) {
            papeles.forEach(p -> System.out.println("Personaje: " + p.getPersonaje() +
                                                   " | Salario: " + p.getSalario()));
        }

        System.out.println("\n=== PRUEBAS HIBERNATE FINALIZADAS ===");

        // --- SECCIÓN MONGODB (Añadido) ---
        System.out.println("\n=== INICIANDO PRUEBAS MONGODB ===");
        ComponentesBD componentesBD = new ComponentesBD();

        // 1. Crear la base de datos y las colecciones con datos iniciales
        System.out.println("-> Ejecutando: Crear colecciones y datos...");
        componentesBD.crearColeccionesConDatos();

        // 2. Asignar precio a un procesador (Solicitará datos por consola)
        System.out.println("\n-> Ejecutando: Asignar precio a procesador...");
        componentesBD.asignarCampoPrecioProcesadores();

        // 3. Borrar un disco duro (Solicitará el modelo por consola)
        System.out.println("\n-> Ejecutando: Borrar disco duro...");
        componentesBD.borrarDiscoDuro();

        System.out.println("\n=== TODAS LAS PRUEBAS (HIBERNATE & MONGODB) FINALIZADAS ===");
    }
}