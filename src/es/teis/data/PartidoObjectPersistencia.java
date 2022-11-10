/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.data;

import es.teis.model.Partido;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author san_j
 */
public class PartidoObjectPersistencia implements IPersistencia {

    @Override
    public void escribir(ArrayList<Partido> partidos, String ruta) {
        for(Partido partido:partidos){
        if (partidos != null) {
            
            try (FileOutputStream fos= new FileOutputStream(ruta,true);) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeLong(partido.getId());
                
                String sb = partido.getNombre();
                oos.writeChars(sb);
                
                oos.writeInt(partido.getVotos());
                
                oos.writeFloat(partido.getPorcentaje());

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Se ha producido una excepción: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Se ha producido una excepción: " + ex.getMessage());
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }}

    @Override
    public ArrayList<Partido> leerTodo(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
