/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.data;

import es.teis.model.Partido;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author san_j
 */
public class PartidoObjectPersistencia implements IPersistencia {

    @Override
    public void escribir(ArrayList<Partido> partidos, String ruta) {
        FileOutputStream fos=null; 
        long longitudBytes = 0;
        if (partidos != null) {
            
            try (
                ObjectOutputStream oos = new ObjectOutputStream(ruta);
                        new FileOutputStream(fos)); 
                longitudBytes = raf.length();
                raf.seek(longitudBytes);
                for (Persona persona : personas) {

                    raf.writeLong(persona.getId());
                    StringBuilder sb = new StringBuilder(persona.getDni());
                    sb.setLength(Persona.MAX_LENGTH_DNI);
                    raf.writeChars(sb.toString());

                    sb = new StringBuilder(persona.getNombre());
                    sb.setLength(Persona.MAX_LENGTH_NOMBRE);
                    raf.writeChars(sb.toString());

                    raf.writeInt(persona.getEdad());
                    raf.writeFloat(persona.getSalario());

                    raf.writeBoolean(persona.isBorrado());

                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Se ha producido una excepción: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Se ha producido una excepción: " + ex.getMessage());
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Partido> leerTodo(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
