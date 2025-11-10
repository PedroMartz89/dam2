import data.AsignaturaDAOImpl;
import data.CursoDAOImpl;
import data.GrupoDAOImpl;
import data.TurnoDAOImpl;
import model.Asignatura;
import model.Curso;
import model.Grupo;
import model.Turno;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static GrupoDAOImpl grupoDAO = new GrupoDAOImpl();
    public static AsignaturaDAOImpl asignaturaDAO = new AsignaturaDAOImpl();
    public static TurnoDAOImpl turnoDAO = new TurnoDAOImpl();
    public static CursoDAOImpl cursoDAO = new CursoDAOImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuPrincipal(sc, asignaturaDAO, cursoDAO, grupoDAO, turnoDAO);
    }

    public static void menuPrincipal(Scanner sc,
                                     AsignaturaDAOImpl asignaturaDAO,
                                     CursoDAOImpl cursoDAO,
                                     GrupoDAOImpl grupoDAO,
                                     TurnoDAOImpl turnoDAO) {

        boolean salir = false;

        while (!salir) {
            System.out.println("""
                =======================================
                     MENÚ PRINCIPAL - INSTITUTO
                =======================================
                1. CRUD de la tabla Asignatura
                2. CRUD de la tabla Curso
                3. CRUD de la tabla Grupo
                4. CRUD de la tabla Turno
                5. Salir
                =======================================
                Elige una opción:
                """);

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido (1-5).");
                continue;
            }

            switch (option) {
                case 1 -> crudAsignatura(sc, asignaturaDAO);
                case 2 -> crudCurso(sc, cursoDAO);
                case 3 -> crudGrupo(sc, grupoDAO);
                case 4 -> crudTurno(sc, turnoDAO);
                case 5 -> {
                    System.out.println("Saliendo del programa.");
                    salir = true;
                }
                default -> System.out.println("Elige una opción válida (1-5).");
            }
        }
    }


    public static void crudAsignatura(Scanner sc, AsignaturaDAOImpl asignaturaDAO) {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                Operando en la tabla asignatura.

                1. Create
                2. Read
                3. Update
                4. Delete
                5. Atrás
                Elije una opción:
                """);

            //consume el salto de línea para que no de escepción
            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (option) {
                case 1: {
                    try {
                        Asignatura a = datosAsignatura(sc);
                        asignaturaDAO.create(a);
                        System.out.println("Asignatura creada.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Código de asignatura a leer: ");
                        String cod = sc.nextLine().trim();
                        Asignatura a = new Asignatura();
                        a.setCodAsignatura(cod);
                        asignaturaDAO.read(a);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    try {
                        Asignatura a = datosAsignatura(sc);
                        asignaturaDAO.update(a);
                        System.out.println("Asignatura actualizada.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Código de asignatura a borrar (int): ");
                        String codStr = sc.nextLine().trim();
                        int cod = Integer.parseInt(codStr);
                        asignaturaDAO.delete(cod);
                        System.out.println("Asignatura borrada (si existía).");
                    } catch (NumberFormatException nfe) {
                        System.out.println("El código debe ser numérico (int).");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce una opción adecuada.");
            }
        }
    }

    public static void crudCurso(Scanner sc, CursoDAOImpl cursoDAO) {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                Operando en la tabla curso.

                1. Create
                2. Read
                3. Update
                4. Delete
                5. Atrás
                Elije una opción:
                """);

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (option) {
                case 1: {
                    try {
                        Curso c = datosCurso(sc);
                        cursoDAO.create(c);
                        System.out.println("Curso creado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Código de curso a leer: ");
                        String cod = sc.nextLine().trim();
                        Curso c = new Curso();
                        c.setCodCurso(cod);
                        cursoDAO.read(c);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    try {
                        Curso c = datosCurso(sc);
                        cursoDAO.update(c);
                        System.out.println("Curso actualizado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Código de curso a borrar (int, según tu delete): ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        cursoDAO.delete(id);
                        System.out.println("Curso borrado (si existía).");
                    } catch (NumberFormatException nfe) {
                        System.out.println("El código debe ser numérico (int) para este delete().");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce una opción adecuada.");
            }
        }
    }


    public static void crudGrupo(Scanner sc, GrupoDAOImpl grupoDAO) {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                Operando en la tabla grupo.

                1. Create
                2. Read
                3. Update
                4. Delete
                5. Atrás
                Elije una opción:
                """);

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (option) {
                case 1: {
                    try {
                        Grupo g = datosGrupo(sc);
                        grupoDAO.create(g);
                        System.out.println("Grupo creado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Código de grupo a leer: ");
                        String cod = sc.nextLine().trim();
                        Grupo g = new Grupo();
                        g.setCodGrupo(cod);
                        grupoDAO.read(g);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    try {
                        Grupo g = datosGrupo(sc);
                        grupoDAO.update(g);
                        System.out.println("Grupo actualizado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Código de grupo a borrar (int, según tu delete): ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        grupoDAO.delete(id);
                        System.out.println("Grupo borrado (si existía).");
                    } catch (NumberFormatException nfe) {
                        System.out.println("El código debe ser numérico (int) para este delete().");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce una opción adecuada.");
            }
        }
    }


    public static void crudTurno(Scanner sc, TurnoDAOImpl turnoDAO) {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                Operando en la tabla turno.

                1. Create
                2. Read
                3. Update
                4. Delete
                5. Atrás
                Elije una opción:
                """);

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (option) {
                case 1: {
                    try {
                        Turno t = datosTurno(sc);
                        turnoDAO.create(t);
                        System.out.println("Turno creado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Código de turno a leer: ");
                        String cod = sc.nextLine().trim();
                        Turno t = new Turno();
                        t.setCodTurno(cod);
                        turnoDAO.read(t);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    try {
                        Turno t = datosTurno(sc);
                        turnoDAO.update(t);
                        System.out.println("Turno actualizado.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Código de turno a borrar (int, según tu delete): ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        turnoDAO.delete(id);
                        System.out.println("Turno borrado (si existía).");
                    } catch (NumberFormatException nfe) {
                        System.out.println("El código debe ser numérico (int) para este delete().");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Introduce una opción adecuada.");
            }
        }
    }


    public static Asignatura datosAsignatura(Scanner sc) {

        System.out.println("Introduce el código de asignatura: ");
        String codAsignatura = sc.nextLine();
        System.out.println("Introduce el código interno: ");
        String codInterno = sc.nextLine();
        System.out.println("Introduce la descripción: ");
        String descripcion = sc.nextLine();
        System.out.println("Introduce en Nº de horas: ");
        int nHoras = sc.nextInt();
        System.out.println("Introduce el código de curso: ");
        String codCurso = sc.nextLine();

        System.out.println("Se han introducido los datos correctamente, pulse enter para continuar.");
        sc.nextLine();

        return new Asignatura(codAsignatura, codInterno, descripcion, nHoras, codCurso);
    }

    private static Curso datosCurso(Scanner sc) {
        System.out.print("cod_curso (p.e. DAW1): ");
        String cod = sc.nextLine().trim();

        System.out.print("nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("descripcion: ");
        String desc = sc.nextLine().trim();

        return new Curso(cod, nombre, desc);
    }

    private static Grupo datosGrupo(Scanner sc) {
        System.out.print("cod_grupo: ");
        String codGrupo = sc.nextLine().trim();

        System.out.print("cod_curso (FK): ");
        String codCurso = sc.nextLine().trim();

        System.out.print("nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("cod_turno (FK): ");
        String codTurno = sc.nextLine().trim();

        System.out.print("nMaxAlumnos (int): ");
        int nMax;
        try {
            nMax = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            nMax = 0;
        }
        return new Grupo(codGrupo, codCurso, nombre, codTurno, nMax);
    }

    private static Turno datosTurno(Scanner sc) {
        System.out.print("cod_turno: ");
        String codTurno = sc.nextLine().trim();

        System.out.print("horario: ");
        String horario = sc.nextLine().trim();

        return new Turno(codTurno, horario);
    }

}