/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.dataXML;

import es.teis.data.exceptions.LecturaException;
import es.teis.dataXML.IXMLService;
import es.teis.model.Partido;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author a20santiagojfc
 */
public class DOMXMLService implements IXMLService {

    public static final String PARTIDO_TAG = "partido";
    public static final String PARTIDO_VOTOS_NUM_TAG = "votos_numero";
    public static final String PARTIDO_VOTOS_PORC_TAG = "votos_porciento";
    public static final String PARTIDO_NOMBRE_TAG = "nombre";

    public static final String PARTIDO_ATT_ID = "id";

    private static final String PARTIDO_INPUT_FILE = Paths.get("src", "docs", "elecciones.xml").toString();

    @Override
    public ArrayList<Partido> leerPartidos(String ruta, float umbral) throws LecturaException {

        ArrayList<Partido> partidos = new ArrayList<>();
        int contador = 1;

        long id = 0l;
        String nombre; //No es necesario inicializar
        int votos = 0;
        float porcentaje = 0.0f;

        try {

            File inputFile = new File(PARTIDO_INPUT_FILE);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            System.out.println("Elemento raiz: "
                    + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName(PARTIDO_TAG);

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //Se hace un cast de node para acceder a los elementos
                    Element eElement = (Element) nNode;

                    id = Long.parseLong(eElement.getAttribute(PARTIDO_TAG));
                    nombre = eElement.getElementsByTagName(PARTIDO_NOMBRE_TAG).item(0).getTextContent();
                    votos = Integer.parseInt(eElement.getElementsByTagName(PARTIDO_VOTOS_NUM_TAG).item(0).getTextContent());
                    porcentaje = Float.parseFloat(eElement.getAttribute(PARTIDO_VOTOS_PORC_TAG));

                    //if de umbral
                    Partido partido = new Partido(id, nombre, votos, porcentaje);

                    partidos.add(partido);
                }
            }

            for (Partido p : partidos) {
                System.out.println("Partido: " + contador + " " + p);
                contador++;
            }   
        } catch (Exception ex ) {
            throw new LecturaException (ex.getMessage(), ruta) ;
        }
        return partidos;
    }
}
