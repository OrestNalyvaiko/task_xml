package com.nalyvaiko;

import com.nalyvaiko.comparator.BankComparator;
import com.nalyvaiko.model.Bank;
import com.nalyvaiko.parser.dom.XMLParserDOM;
import com.nalyvaiko.parser.sax.XMLParserSAX;
import com.nalyvaiko.parser.stax.XMLParserStAX;
import java.io.File;
import java.util.List;

public class Main {

  private String xmlFile = "src\\main\\resources\\bankDeposits.xml";
  private String xsdFile = "src\\main\\resources\\banksXSD.xsd";

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println("SAX");
    main.testSAXParser();
    System.out.println("DOM");
    main.testDOMParser();
    System.out.println("StAX");
    main.testStAXParser();
  }

  private void testSAXParser() {
    List<Bank> banks = XMLParserSAX
        .parseXMLBanks(new File(xmlFile),
            new File(xsdFile));
    banks.stream().sorted(new BankComparator()).forEach(System.out::println);
  }

  private void testDOMParser() {
    List<Bank> banks = XMLParserDOM
        .parseXMLBanks(new File(xmlFile),
            new File(xsdFile));
    banks.stream().sorted(new BankComparator()).forEach(System.out::println);
  }

  private void testStAXParser() {
    List<Bank> banks = XMLParserStAX
        .parseXMLBanks(new File(xmlFile));
    banks.stream().sorted(new BankComparator()).forEach(System.out::println);
  }
}
