package com.nalyvaiko.parser.sax;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SAXValidator {

  private SAXValidator() {
  }

  public static void validateXML(File xmlFile, File xsdFile)
      throws SAXException, IOException {
    try {
      Reader reader = Files.newBufferedReader(xmlFile.toPath());
      Validator validator = createSchema(xsdFile).newValidator();
      SAXSource saxSource = new SAXSource(new InputSource(reader));
      validator.validate(saxSource);
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
