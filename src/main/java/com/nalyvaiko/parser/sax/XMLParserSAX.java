package com.nalyvaiko.parser.sax;

import com.nalyvaiko.model.Bank;
import com.nalyvaiko.parser.sax.SAXHandler;
import com.nalyvaiko.parser.sax.SAXValidator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;

import org.xml.sax.SAXException;

public class XMLParserSAX {

  private XMLParserSAX() {
  }

  public static List<Bank> parseXMLBanks(File xmlFile, File xsdFile) {
    List<Bank> banks = new ArrayList<>();
    try {
      SAXValidator.validateXML(xmlFile, xsdFile);
      SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
      SAXParser saxParser = saxParserFactory.newSAXParser();
      SAXHandler saxHandler = new SAXHandler();
      saxParser.parse(xmlFile, saxHandler);
      banks = saxHandler.getBanks();
    } catch (ParserConfigurationException | IOException | SAXException e) {
      e.getMessage();
    }
    return banks;
  }

}
