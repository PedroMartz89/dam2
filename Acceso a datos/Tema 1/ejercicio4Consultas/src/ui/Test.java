package ui;

import model.Alumno;
import model.Asignatura;
import model.Profesor;
import model.calculados.MatriculadosAsignatura;
import services.AlumnoServicio;
import services.AlumnoServicio;
import services.AsignaturaServicio;
import services.ProfesorServicio;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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

//            System.out.println("Mostramos listado de asignaturas con número de matriculados");
//

//            List<MatriculadosAsignatura> listado =
//                    alumnoServicio.obtenerRecuentoMatriculadosAsignatura();
//
//            for(MatriculadosAsignatura matriculadoAsignatura: listado) {
//                System.out.println(matriculadoAsignatura);
//            }
            AlumnoServicio alumnoServicio = new AlumnoServicio();
            ProfesorServicio profesorServicio = new ProfesorServicio();
            AsignaturaServicio asignaturaServicio = new AsignaturaServicio();

            System.out.println("1. Obtener alumnos de matriculados en una asignatura solicitada");

            List<Alumno> listado = alumnoServicio.alumnosMatriculadosAsignatura(new Scanner(System.in));

            for (Alumno a : listado) {

                System.out.println(a);
            }

            System.out.println("2. Obtener profesores que imparten clase en un aula");

            List<Profesor> profesores = profesorServicio.obtenerProfesImpartenAula("10");

            for (Profesor p : profesores) {
                System.out.println(p);
            }

            System.out.println("Obtener asignaturas que imparte un departamento.");

            List<Asignatura> asignaturas = asignaturaServicio.obtenerAsignaturasDepto("100");

            for (Asignatura a : asignaturas) {

                System.out.println(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
