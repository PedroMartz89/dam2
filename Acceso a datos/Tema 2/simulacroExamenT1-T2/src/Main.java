import ejJDBCdao.Jdbc;
import ejFicheros.Ficheros;
import ejFicheros.Registro;

public class Main {

	public static void main(String[] args) {
		//Para probar JDBC
		Jdbc jdbc = new Jdbc();
		//jdbc.listarDatosTodasTablas();
//		jdbc.darLibroDeAlta();
//		jdbc.eliminarEscritor();
		jdbc.mostrarLibrosEscritor();
		
		//Para probar Ficheros
//		String rutaFicheroTxt = "src/fichero.txt"; //poner ruta fichero txt
//		String rutaFicheroBinario = "src/registros.dat"; // poner ruta fichero binario
//		int identificadorRegistro = 2; //id del registro
//
//		Ficheros ficheros = new Ficheros();
//		ficheros.copiarFicheroTxt2Raf(rutaFicheroTxt, rutaFicheroBinario);
//		ficheros.listarRegistros(rutaFicheroBinario);
//		Registro r = ficheros.buscarRegistroPorCodigo(rutaFicheroBinario, identificadorRegistro);
//        System.out.println(r);
	}

}
