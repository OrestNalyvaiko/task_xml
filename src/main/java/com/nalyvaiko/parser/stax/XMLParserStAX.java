package com.nalyvaiko.parser.stax;

import com.nalyvaiko.model.Bank;
import com.nalyvaiko.model.Type;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLParserStAX {

  public static List<Bank> parseXMLBanks(File xmlFile) {
    List<Bank> banks = new ArrayList<>();
    Bank bank = null;

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    try {
      XMLEventReader xmlEventReader = xmlInputFactory
          .createXMLEventReader(new FileInputStream(xmlFile));
      while (xmlEventReader.hasNext()) {
        XMLEvent xmlEvent = xmlEventReader.nextEvent();
        if (xmlEvent.isStartElement()) {
          StartElement startElement = xmlEvent.asStartElement();
          String name = startElement.getName().getLocalPart();
          switch (name) {
            case "bank":
              bank = new Bank();
              break;
            case "name":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setName(xmlEvent.asCharacters().getData());
              break;
            case "country":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setCountry(xmlEvent.asCharacters().getData());
              break;
            case "type":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setType(Type.valueOf(
                  xmlEvent.asCharacters().getData().replaceAll("\\s", "")
                      .toUpperCase()));
              break;
            case "depositor":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setDepositor(xmlEvent.asCharacters().getData());
              break;
            case "accountID":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setAccountID(xmlEvent.asCharacters().getData());
              break;
            case "amountOnDeposit":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setAmountOnDeposit(
                  Double.parseDouble(xmlEvent.asCharacters().getData()));
              break;
            case "profitability":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setProfitability(
                  Double.parseDouble(xmlEvent.asCharacters().getData()));
              break;
            case "timeConstraints":
              xmlEvent = xmlEventReader.nextEvent();
              bank.setTimeConstraints(
                  Integer.parseInt(xmlEvent.asCharacters().getData()));
              break;
          }
        }

        if (xmlEvent.isEndElement()) {
          EndElement endElement = xmlEvent.asEndElement();
          if (endElement.getName().getLocalPart().equals("bank")) {
            banks.add(bank);
          }
        }
      }

    } catch (FileNotFoundException | XMLStreamException e) {
      e.printStackTrace();
    }
    return banks;
  }
}
