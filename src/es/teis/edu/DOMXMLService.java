/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.teis.edu;

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

    ArrayList<Partido> partidos = new ArrayList<>();
    int contador = 1;

    @Override
    public ArrayList<Partido> leerPartidos(String ruta, float umbral) throws LecturaException {

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

                    id = Long.parseLong(eElement.getAttribute());
                    nombre = eElement.getElementsByTagName(VERSION_NOMBRE_TAG).item(0).getTextContent();
                    api = Integer.parseInt(eElement.getElementsByTagName(VERSION_API_TAG).item(0).getTextContent());

                    partidos = new Partido(numero, nombre, api);

                    partidos.add(partidos);
                }
            }

            for (Partido p : partidos) {
                System.out.println("Partido: " + contador + " " + p);
                contador++;

            }
        } catch (SAXException ex) {
            Logger.getLogger(DOMXMLService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOMXMLService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMXMLService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partidos;
    }

}
}
