package com.nalyvaiko.parser.dom;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMValidator {

  private DOMValidator() {
  }

  public static void validateXML(
      Document document, File xsdFile) throws SAXException, IOException {
    try {
      Validator validator = createSchema(xsdFile).newValidator();
      validator.validate(new DOMSource(document));
    } catch (IOException | SAXException e) {
      System.out.println("The document failed to validate");
      throw e;
    }
  }

  private static Schema createSchema(File xsdFile) {
    Schema schema = null;
    try {
      String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
      SchemaFactory factory = SchemaFactory.newInstance(language);
      schema = factory.newSchema(xsdFile);
    } catch (SAXException ex) {
      ex.printStackTrace();
    }
    return schema;
  }
}
