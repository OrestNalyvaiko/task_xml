package com.nalyvaiko.model;

public class Bank {

  private String name;
  private String country;
  private Type type;
  private String depositor;
  private String accountID;
  private double amountOnDeposit;
  private double profitability;
  private int timeConstraints;

  public void setName(String name) {
    this.name = name;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public void setDepositor(String depositor) {
    this.depositor = depositor;
  }

  public void setAccountID(String accountID) {
    this.accountID = accountID;
  }

  public void setAmountOnDeposit(double amountOnDeposit) {
    this.amountOnDeposit = amountOnDeposit;
  }

  public void setProfitability(double profitability) {
    this.profitability = profitability;
  }

  public void setTimeConstraints(int timeConstraints) {
    this.timeConstraints = timeConstraints;
  }

  public double getAmountOnDeposit() {
    return amountOnDeposit;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bank");
    stringBuilder.append("\nName: ");
    stringBuilder.append(name);
    stringBuilder.append("\nCountry: ");
    stringBuilder.append(country);
    stringBuilder.append("\nType: ");
    stringBuilder.append(type);
    stringBuilder.append("\nDepositor: ");
    stringBuilder.append(depositor);
    stringBuilder.append("\nAccount ID: ");
    stringBuilder.append(accountID);
    stringBuilder.append("\nAmount on deposit: ");
    stringBuilder.append(amountOnDeposit);
    stringBuilder.append("\nProfitability: ");
    stringBuilder.append(profitability);
    stringBuilder.append("%");
    stringBuilder.append("\nTime constraints: ");
    stringBuilder.append(timeConstraints);
    stringBuilder.append("\n\n");
    return stringBuilder.toString();
  }
}
