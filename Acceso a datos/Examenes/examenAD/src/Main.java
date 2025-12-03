import ra1.Ficheros;
import ra2.Jdbc;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Para probar ejercicios JDBC
		Jdbc jdbc = new Jdbc();
//		jdbc.listarDatosTresTablas();
//		jdbc.darProgramaDeAlta();
//		jdbc.eliminarCanal();
//		jdbc.mostrarProgramasGenero();
//		jdbc.mostrarEstadisticasCanales();
		
		//Para probar ejecicios Ficheros
		String rutaFichero = "/home/dam2-2511/Escritorio/examenes/examenADT1-2/examenAD/src/ra1/peliculas.txt";
		String rutaDirectorio = "src";
		float recaudacion = 1000f;
//
		Ficheros ficheros = new Ficheros();

        //EJERCICIO 6
//        List<String> ficherosList;
//          ficherosList = ficheros.obtenerFicherosMasRecientesQueFichero(rutaFichero, rutaDirectorio);
//            if (ficherosList == null) {
//                System.out.println("ES nulo");
//            }
//
//          for (String fichero : ficherosList) {
//              System.out.println(fichero);
//          }
//
		//ficheros.buscarPeliculaMasRecaudacion(rutaFichero, recaudacion);

		ficheros.miniProcesadorTextos();
		
	}

}
