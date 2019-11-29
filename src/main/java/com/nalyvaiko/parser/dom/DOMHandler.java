package com.nalyvaiko.parser.dom;

import com.nalyvaiko.model.Bank;
import com.nalyvaiko.model.Type;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMHandler {

  public List<Bank> readDOC(Document document) {
    List<Bank> banks = new ArrayList<>();
    Bank bank;
    document.getDocumentElement().normalize();
    NodeList nodeList = document.getElementsByTagName("bank");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        bank = new Bank();
        setFields(element, bank);
        banks.add(bank);
      }
    }
    return banks;
  }

  private void setFields(Element element, Bank bank) {
    bank.setName(
        element.getElementsByTagName("name").item(0).getTextContent());
    bank.setCountry(
        element.getElementsByTagName("country").item(0).getTextContent());
    bank.setType(Type.valueOf(
        element.getElementsByTagName("type").item(0).getTextContent()
            .replaceAll("\\s", "").toUpperCase()));
    bank.setDepositor(
        element.getElementsByTagName("depositor").item(0).getTextContent());
    bank.setAccountID(
        element.getElementsByTagName("accountID").item(0).getTextContent());
    bank.setAmountOnDeposit(Double.parseDouble(
        element.getElementsByTagName("amountOnDeposit").item(0)
            .getTextContent()));
    bank.setProfitability(Double.parseDouble(
        element.getElementsByTagName("profitability").item(0)
            .getTextContent()));
    bank.setTimeConstraints(Integer.parseInt(
        element.getElementsByTagName("timeConstraints").item(0)
            .getTextContent()));
  }
}
