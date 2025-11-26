import ejFicheros.Jdbc;
import ejJDBC.Ficheros;

public class Main {

	public static void main(String[] args) {
		//Para probar ejercicios JDBC
		Jdbc jdbc = new Jdbc();
		jdbc.listarDatosTodasTablas();
		//jdbc.darLibroDeAlta();
		//jdbc.eliminarEscritor();
		//jdbc.mostrarLibrosEscritor();
		//jdbc.mostrarEstadisticasPaginas();
		
		//Para probar ejecicios Ficheros
		String rutaFicheroTxt = ""; //poner ruta fichero txt
		String rutaFicheroBinario = ""; // poner ruta fichero binario
		int identificadorRegistro = 0; //id del registro
		
		Ficheros ficheros = new Ficheros();
		//ficheros.copiarFicheroTxt2Raf(rutaFicheroTxt, rutaFicheroBinario);
		//ficheros.listarRegistros(rutaFicheroBinario);
		//ficheros.buscarRegistroPorCodigo(rutaFicheroBinario, identificadorRegistro);
		
	}

}
