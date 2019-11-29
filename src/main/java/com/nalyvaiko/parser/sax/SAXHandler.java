package com.nalyvaiko.parser.sax;

import com.nalyvaiko.model.Bank;
import com.nalyvaiko.model.Type;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

  private List<Bank> banks = new ArrayList<>();
  private Bank bank;
  private StringBuilder data;

  private boolean nameIsExist;
  private boolean countryIsExist;
  private boolean typeIsExist;
  private boolean depositorIsExist;
  private boolean accountIDIsExist;
  private boolean amountOnDepositIsExist;
  private boolean profitabilityIsExist;
  private boolean timeConstraintsIsExist;

  @Override
  public void startElement(String uri, String localName, String qName,
      Attributes attributes) {
    if (qName.equalsIgnoreCase("bank")) {
      bank = new Bank();
    } else if (qName.equalsIgnoreCase("name")) {
      nameIsExist = true;
    } else if (qName.equalsIgnoreCase("country")) {
      countryIsExist = true;
    } else if (qName.equalsIgnoreCase("type")) {
      typeIsExist = true;
    } else if (qName.equalsIgnoreCase("depositor")) {
      depositorIsExist = true;
    } else if (qName.equalsIgnoreCase("accountID")) {
      accountIDIsExist = true;
    } else if (qName.equalsIgnoreCase("amountOnDeposit")) {
      amountOnDepositIsExist = true;
    } else if (qName.equalsIgnoreCase("profitability")) {
      profitabilityIsExist = true;
    } else if (qName.equalsIgnoreCase("timeConstraints")) {
      timeConstraintsIsExist = true;
    }
    data = new StringBuilder();
  }

  @Override
  public void endElement(String uri, String localName, String qName) {
    if (nameIsExist) {
      bank.setName(data.toString());
      nameIsExist = false;
    } else if (countryIsExist) {
      bank.setCountry(data.toString());
      countryIsExist = false;
    } else if (typeIsExist) {
      bank.setType(
          Type.valueOf(data.toString().replaceAll("\\s", "").toUpperCase()));
      typeIsExist = false;
    } else if (depositorIsExist) {
      bank.setDepositor(data.toString());
      depositorIsExist = false;
    } else if (accountIDIsExist) {
      bank.setAccountID(data.toString());
      accountIDIsExist = false;
    } else if (amountOnDepositIsExist) {
      bank.setAmountOnDeposit(Double.parseDouble(data.toString()));
      amountOnDepositIsExist = false;
    } else if (profitabilityIsExist) {
      bank.setProfitability(Double.parseDouble(data.toString()));
      profitabilityIsExist = false;
    } else if (timeConstraintsIsExist) {
      bank.setTimeConstraints(Integer.parseInt(data.toString()));
      timeConstraintsIsExist = false;
    }

    if (qName.equalsIgnoreCase("bank")) {
      banks.add(bank);
    }

  }

  @Override
  public void characters(char[] ch, int start, int length) {
    data.append(new String(ch, start, length));
  }


  public List<Bank> getBanks() {
    return banks;
  }
}
