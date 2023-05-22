/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nhat
 */
public class XMLFile {

    public static HashMap<String, String> Read(String fileName) throws ParserConfigurationException, SAXException, IOException {
        File inputFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc;

        inputFile = new File(fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("record");
        HashMap<String, String> answer = new HashMap<>();
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String word = element.getElementsByTagName("word").item(0).getTextContent();
                String meaning = element.getElementsByTagName("meaning").item(0).getTextContent();
                answer.put(word, meaning);
            }

        }
        return answer;
    }

}
