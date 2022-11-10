/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.teis.edu;

import es.teis.model.Partido;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Main {

    private static String  ELECCIONES_INPUT_FILE = Paths.get("src", "docs", "elecciones.xml").toString();
    private static String ELECCIONES_OUTPUT_FILE = Paths.get("src", "docs", "elecciones_output.dat").toString();

    private static float UMBRAL_PORCENTAJE = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Partido> partidosRecuperados = new ArrayList<>();
        IPersistencia daop = new DataIOPersistencia();
        if (Files.exists(ELECCIONES_INPUT_FILE)) {

            escribir();
            partidosRecuperados = daop.leerTodo(ELECCIONES_OUTPUT_FILE.toString());
            int contador = 1;
            for (Partido p : partidosRecuperados) {
                System.out.println("Partido recuperado " + contador + ": " + p);
                contador++;
            }

        } else {
            System.out.println("No existe el fichero en la ruta: " + ELECCIONES_INPUT_FILE);
        }

//completa aquí: 
        mostrar(partidos);

    }

    private static void mostrar(ArrayList<Partido> partidos) {
        System.out.println("Se han leído: ");
        for (Partido partido : partidos) {
            System.out.println(partido);

        }
    }

}
