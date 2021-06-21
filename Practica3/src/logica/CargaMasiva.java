package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import objetos.*;

public class CargaMasiva {

    public static Alumno[] alumnos;
    public static Curso[] cursos;
    public static Nota[] notas;
    public static Scanner scanner = new Scanner(System.in);

    public CargaMasiva() {
        alumnos = new Alumno[200];
        cursos = new Curso[200];
        notas = new Nota[200];
    }

    private String cargaDatos() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            System.out.println("Ingrese el nombre del archivo: ");
            String ruta = scanner.nextLine();
            //Leyendo el csv
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            //Guardando los datos del csv
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                //linea = linea.replaceAll(" ", "");
                content += linea + "\n";
            }
            return content;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private void cargaAlumnos(String content) {
        //Partiendo cada dato por medio de punto y coma (;)
        String filas[] = content.split("\n");
        String[] columnas = filas[0].split(",");
        //asignando cada dato a un atributo de la clase correspondiente       
        for (int i = 1; i < filas.length; i++) {
            try {
                columnas = filas[i].split(",");
                int id = Integer.parseInt(columnas[0]);
                int carnet = Integer.parseInt(columnas[1]);
                String nombre = columnas[2];
                String fNacimiento = columnas[3];
                String genero = columnas[4];
                if (genero.equals("M") || genero.equals("F")) {
                    for (int j = 0; j < alumnos.length; j++) {
                        if (alumnos[j] == null) {
                            alumnos[j] = new Alumno(id, carnet, nombre, fNacimiento, genero);
                            for (int k = 0; k < alumnos.length - 1; k++) {
                                for (int l = k + 1; l < alumnos.length; l++) {
                                    if (alumnos[k] != null) {
                                        if (alumnos[l] != null) {
                                            if (alumnos[k].getId() == alumnos[l].getId()) {
//                                                 String log = "Fecha: " + fechaHoraActuales
//                                                        + "\r\nEsta línea se ha cargado anteriormente: " + (l + 1) + "\r\n\r\n";
//                                                addToEndFile("Logs.log", log);
//                                                System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                                                alumnos[l] = null;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            for (int k = 0; k < alumnos.length - 1; k++) {
                                for (int l = k + 1; l < alumnos.length; l++) {
                                    if (alumnos[k] != null) {
                                        if (alumnos[l] != null) {
                                            if (alumnos[k].getCarnet() == alumnos[l].getCarnet()) {
//                                                String log = "Fecha: " + fechaHoraActuales
//                                                        + "\r\nEsta línea se ha cargado anteriormente: " + (l + 1) + "\r\n\r\n";
//                                                addToEndFile("Logs.log", log);
//                                                System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                                                alumnos[l] = null;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                } else {
//                    String log = "Fecha: " + fechaHoraActuales
//                            + "\r\nSe escribió un género inexistente en la línea: " + i + ") " + filas[i] + "\r\n\r\n";
//                    addToEndFile("Logs.log", log);
//                    System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
//                 String log = "Fecha: " + fechaHoraActuales
//                        + "\r\nNo se ha definido un género: " + i + ") " + filas[i] + "\r\n\r\n";
//                addToEndFile("Logs.log", log);
//                System.out.println("Hubo errores en la carga de archivos, revisar el log. ");
            } catch (NumberFormatException e) {
//                String log = "Fecha: " + fechaHoraActuales
//                        + "\r\nSe escribió una letra donde debería ir un número en la línea: " + i + ") " + filas[i] + "\r\n\r\n";
//                addToEndFile("Logs.log", log);
//                System.out.println("Hubo errores en la carga de archivos, revisar el log. ");
            }
        }
        System.out.println("Los alumnos han sido cargado con éxito :D");
    }

    private void cargaCursos(String content) {
        //Partiendo cada dato por medio de punto y coma (;)
        String filas[] = content.split("\n");
        String[] columnas = filas[0].split(",");
        //asignando cada dato a un atributo de la clase correspondiente
        for (int i = 1; i < filas.length; i++) {
            try {
                columnas = filas[i].split(",");
                int id = Integer.parseInt(columnas[0]);
                int codigo = Integer.parseInt(columnas[1]);
                String nombre = columnas[2];

                for (int j = 0; j < cursos.length; j++) {
                    if (cursos[j] == null) {
                        cursos[j] = new Curso(id, codigo, nombre);
                        for (int k = 0; k < cursos.length - 1; k++) {
                            for (int l = k + 1; l < cursos.length; l++) {
                                if (cursos[k] != null) {
                                    if (cursos[l] != null) {
                                        if (cursos[k].getId() == cursos[l].getId()) {
//                                            String log = "Fecha: " + fechaHoraActuales
//                                                    + "\r\nEsta línea se ha cargado anteriormente: " + (l + 1) + "\r\n\r\n";
//                                            addToEndFile("Logs.log", log);
//                                            System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                                            cursos[l] = null;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        for (int k = 0; k < cursos.length - 1; k++) {
                            for (int l = k + 1; l < cursos.length; l++) {
                                if (cursos[k] != null) {
                                    if (cursos[l] != null) {
                                        if (cursos[k].getCodigo() == cursos[l].getCodigo()) {
//                                             String log = "Fecha: " + fechaHoraActuales
//                                                    + "\r\nEsta línea se ha cargado anteriormente: " + (l + 1) + "\r\n\r\n";
//                                            addToEndFile("Logs.log", log);
//                                            System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                                            cursos[l] = null;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            } catch (NumberFormatException e) {
//               String log = "Fecha: " + fechaHoraActuales
//                        + "\r\nSe escribió una letra donde debería ir un número en la línea: " + i + ") " + filas[i] + "\r\n\r\n";
//                addToEndFile("Logs.log", log);
//                System.out.println("Hubo errores en la carga de archivos, revisar el log. ");
            }
        }
        System.out.println("Los cursos han sido cargado con éxito :D");
    }
    
    private void cargaNotas(String content) {

        //Partiendo cada dato por medio de punto y coma (;)
        String filas[] = content.split("\n");
        int cantidadDatos = filas.length - 1;
        String[] columnas = filas[0].split(";");
        //asignando cada dato a un atributo de la clase correspondiente
        for (int i = 1; i < filas.length; i++) {
            try {
                columnas = filas[i].split(",");
                int idAlumno = Integer.parseInt(columnas[0]);
                int idCurso = Integer.parseInt(columnas[1]);
                double nota = Double.parseDouble(columnas[2]);
                if (nota >= 0 || nota <= 100) {
                    for (int j = 0; j < notas.length; j++) {
                        if (notas[j] == null) {
                            notas[j] = new Nota(idAlumno, idCurso, nota);
                            for (int k = 0; k < notas.length - 1; k++) {
                                for (int l = k + 1; l < notas.length; l++) {
                                    if (notas[k] != null) {
                                        if (notas[l] != null) {
                                            if (notas[k].getIdAlumno() == notas[l].getIdAlumno() && notas[k].getIdCurso() == notas[l].getIdCurso()) {
//                                                String log = "Fecha: " + fechaHoraActuales
//                                                        + "\r\nEsta línea se ha cargado anteriormente: " + (l + 1) + "\r\n\r\n";
//                                                addToEndFile("Logs.log", log);
                                                System.out.println("Hubo errores en la carga de archivos, revisar el log.");
                                                notas[l] = null;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                } else {
//                    String log = "Fecha: " + fechaHoraActuales
//                            + "\r\nSe ingresó una nota fura de rango en la línea: " + i + ") " + filas[i] + "\r\n\r\n";
//                    addToEndFile("Logs.log", log);
                    System.out.println("Hubo errores en la carga de archivos, revisar el log. ");
                }
            } catch (NumberFormatException e) {
//                String log = "Fecha: " + fechaHoraActuales
//                        + "\r\nSe escribió una letra donde debería ir un número en la línea: " + i + ") " + filas[i] + "\r\n\r\n";
//                addToEndFile("Logs.log", log);
                System.out.println("Hubo errores en la carga de archivos, revisar el log. ");
            }
        }
        System.out.println("Las notas han sido cargadas con éxito :D");
    }

}
