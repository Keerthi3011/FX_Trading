package com.fxTrading;

import java.util.Scanner;
// pojo class for storing the booked trades in an arraylist
public class Options 
{
	private String tradeNo;
	private String CurrencyPair;
	private String CustomerName;
	private String amount;
	private String rate;
	
	public Options() {}
	
	public Options(String tradeNo, String customerName, String currencyPair , String amount, String rate) {
		super();
		this.tradeNo = tradeNo;
		CurrencyPair = currencyPair;
		CustomerName = customerName;
		this.amount = amount;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return tradeNo + "	" + CurrencyPair.toUpperCase() + "	" + CustomerName + "	" + amount + "	" + rate ;
	}

	// created the method to get the option from the user
	public int getOption()
	{
		try {
		System.out.println("****************************************************************");
		Scanner input = new Scanner (System.in);
		System.out.println("1 - Book Trade\n2 - Print Trade\n3 - Exit\n Enter the option(1 or 2 or 3):");
		int option = input.nextInt();
		return option;
		}
		catch(Exception variable) {}
		
		return 0;
	}
}
