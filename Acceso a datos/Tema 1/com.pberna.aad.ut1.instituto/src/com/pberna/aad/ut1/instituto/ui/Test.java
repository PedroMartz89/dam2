package com.pberna.aad.ut1.instituto.ui;

import java.util.List;
import java.util.Scanner;

import com.pberna.aad.ut1.instituto.model.Alumno;
import com.pberna.aad.ut1.instituto.model.calculados.MatriculadosAsignatura;
import com.pberna.aad.ut1.instituto.services.AlumnoServicio;

public class Test {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			/*System.out.println("Introduce un código de curso");
			String codCurso = scanner.nextLine();
			
			AlumnoServicio alumnoServicio = new AlumnoServicio();
			
			List<Alumno> listaAlumnos = 
					alumnoServicio.buscarPorCurso(codCurso);
			
			System.out.println("Mostrando los alumnos del curso con código " +
					codCurso + " encontrados " + listaAlumnos.size());
			
			for(Alumno alumno: listaAlumnos) {
				System.out.println(alumno);
			}*/
			
			/*System.out.println("Introduce un nombre de alumno");
			String nombre = scanner.nextLine();
			
			AlumnoServicio alumnoServicio = new AlumnoServicio();
			
			List<Alumno> listaAlumnos = 
					alumnoServicio.buscarPorNombre(nombre);
			
			System.out.println("Mostrando los alumnos que contienen en su nombre las letras " +
					nombre + " encontrados " + listaAlumnos.size());
			
			for(Alumno alumno: listaAlumnos) {
				System.out.println(alumno);
			}*/
			
			System.out.println("Mostramos listado de asignaturas con número de matriculados");
			
			AlumnoServicio alumnoServicio = new AlumnoServicio();
			
			List<MatriculadosAsignatura> listado = 
					alumnoServicio.obtenerRecuentoMatriculadosAsignatura();
			
			for(MatriculadosAsignatura matriculadoAsignatura: listado) {
				System.out.println(matriculadoAsignatura);
			}
			
		}
	}

}
