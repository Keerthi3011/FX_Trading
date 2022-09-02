package com.fxTrading;

import java.util.ArrayList;
import java.util.Scanner;


public class Operations {
	static ArrayList<Options> data = new ArrayList<>();
	static int tradeNo =0;
	public static void dataCollectios()
	{
		data.add(new Options("TradeNo","CustomerName","CurrencyPair","Amount","Rate"));
		Operations.operation(); // calling operation method
	}	
	
	// created the method for the different types of operations(Booking, Printing, Exit)
	public static void operation()  
	{
		final double rate = 66.00;
		double inr;
		String customerName;
		String currencyPair;
		double amount;
		
		Options ojectCreation = new Options();
		Scanner input = new Scanner (System.in);
		
		switch(ojectCreation.getOption())
		{
		case 1:	//Booking the trade
			
			System.out.println("Enter Customer name: ");
			customerName = input.nextLine(); 
			boolean checkName = (customerName.matches(".*\\d.*"));
			if(checkName)
			{
				System.out.println("Enter the proper name");
				Operations.operation();// recursion
			}
			System.out.println("Enter currency pair: ");
			currencyPair = input.next();
			if(!currencyPair.equalsIgnoreCase("usdinr")) 
			{	System.out.println("appropriate error!...enter the valid input");
				Operations.operation();// recursion
			}
			else
			{
				System.out.println("Enter amount to transfer:");
				amount = input.nextDouble();
				inr = amount*rate;
				System.out.println("Do you want to get rate?");
				String getRate = input.next();
				if(getRate.equalsIgnoreCase("yes"))
					System.out.println("You are transferring INR "+inr+" to "+customerName);
				System.out.println("Book/Cancel this trade?");
				String bookOrCancel = input.next();
				if(bookOrCancel.equalsIgnoreCase("book"))
				{
					System.out.println( "Trade for "+currencyPair.toUpperCase()+" has been booked with rate "+rate+", The amount of Rs "+inr+" will  be transferred in 2 working days to "+customerName);
					tradeNo++;
					data.add(new Options(String.valueOf(tradeNo),customerName,currencyPair,String.valueOf(amount),String.valueOf(rate)));
				}
					else
					System.out.println("Trade is Canceled...");
				Operations.operation(); // recursion
			}
			break;
			
		case 2:		// Printing the booked trades
			if(tradeNo==0) System.out.println("No Trade is booked!!");
			else
				for(Options iterator : data)
					System.out.println(iterator);
			Operations.operation(); // recursion
			break;
			
		case 3:		// Exit
			System.out.println("Do you want to exit (Y/N)? ");
			String yOrN = input.next();
			if(yOrN.equalsIgnoreCase("n")) Operations.operation();	// recursion
			
			else if(yOrN.equalsIgnoreCase("y"))
			{	
				System.out.println("Bye.. Have a good day");
				System.exit(0);
			}
			break;
			
		default:	// for invalid options
			{	
				System.out.println("Enter the proper input!");
				Operations.operation();		// recursion
			}
		}
	}
	

}
