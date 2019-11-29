package com.nalyvaiko.comparator;

import com.nalyvaiko.model.Bank;
import java.util.Comparator;

public class BankComparator implements Comparator<Bank> {

  @Override
  public int compare(Bank o1, Bank o2) {
    return Double.compare(o2.getAmountOnDeposit(), o1.getAmountOnDeposit());
  }
}
