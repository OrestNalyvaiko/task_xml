package com.nalyvaiko.parser.dom;

import com.nalyvaiko.model.Bank;
import com.sun.java.browser.plugin2.DOM;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParserDOM {

  private XMLParserDOM() {
  }

  public static List<Bank> parseXMLBanks(File xmlFile, File xsdFile) {
    List<Bank> banks = new ArrayList<>();
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      DOMValidator.validateXML(document, xsdFile);
      DOMHandler domHandler = new DOMHandler();
      banks = domHandler.readDOC(document);
    } catch (ParserConfigurationException | IOException | SAXException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return banks;
  }
}
