package com.trading;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TradingTransacTester {
	

	public static void main(String args[]) {
		
		List<Transaction> transactionList=getAllTransactions();

//		1. Find all transactions in the year 2011 and sort them by value (small to high)
		System.out.println("--------------all transactions in the year 2011 and sort them by value---------------");
		List<Transaction> AllTransactionsInTheYear2011=transactionList.stream()
				.filter(year->year.getYear()==2011)
				.sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
				.collect(Collectors.toList());
		AllTransactionsInTheYear2011.forEach(list -> System.out.println(list));
		
//		2. What are all the unique cities where the traders work?
		System.out.println("------------all the unique cities where the traders work-----------------");
		List<Trader> getAlltraders=transactionList.stream()
				.map(transaction->transaction.getTrader())
				.distinct()
				.collect(Collectors.toList());
		List<String> getAllTradersCity = getAlltraders.stream()
				.map(trader -> trader.getCity())
				.distinct()
				.collect(Collectors.toList());
			System.out.println(getAllTradersCity);		
		
//		3. Find all traders from delhi and sort them by name.
			System.out.println("--------all traders from delhi and sort them by name-------------");
			List<Trader> AllTraderFromDelhiSortName=getAlltraders.stream()
					.filter(city->city.getCity().equals("delhi"))
					.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
					.collect(Collectors.toList());

			AllTraderFromDelhiSortName.forEach(trader->System.out.println(trader));													

//		4. Return a string of all traders names sorted alphabetically.
			System.out.println("---------- a string of all traders names sorted alphabetically-------------");
			List<Trader> AllTradersSorted=getAlltraders.stream()
					.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
					.collect(Collectors.toList());
			
			System.out.println(AllTradersSorted);
					
//		5. Are any traders based in Jaipur?
			System.out.println("--------traders based in Jaipur-----------");
			boolean anyTraderBasedOnJaipur = getAlltraders
					.stream()
					.anyMatch(trader->trader.getCity().equals("jaipur"));
			if(anyTraderBasedOnJaipur) {
				System.out.println("Yes! some traders are from jaipur");
			} else {
				System.out.println("No traders are from jaipur");
			}
			
//		6. Print all transactions values from the traders living in delhi
			
			System.out.println("----------- all transactions values from the traders living in delhi-------------");
			
			List<Integer> ValueLivingInDelhi = transactionList.stream()
							.filter(city->city.getTrader().getCity().equals("delhi"))
							.map(value -> value.getValue())
							.collect(Collectors.toList());
			
			ValueLivingInDelhi.forEach(getValue->System.out.println(getValue));
//		7. Whats the highest value of all the transactions?
			System.out.println("---------------the highest value of all the transactions-------------------");
			
			OptionalInt maxValueFromTransactions = transactionList.stream()
																.mapToInt(value->value.getValue())
																.max();

			System.out.println(maxValueFromTransactions);
			
			
//		8. Find the transaction with the smallest value
			
			System.out.println("-------------the transaction with the smallest value-------------");
			
			List<Transaction> transactionWithSmallestValue = transactionList.stream()
													.limit(1)
													.sorted((Transaction o1, Transaction o2) ->  Integer.compare(o1.getValue(), o2.getValue()))
													.collect(Collectors.toList());
			
			System.out.println(transactionWithSmallestValue);	
		

	}
	
	private static List<Transaction> getAllTransactions(){
		Trader ram= new Trader("ram", "delhi");
		Trader kapil= new Trader("kapil","noida");
		Trader raj= new Trader("raj","banglore");
		Trader ekta= new Trader("ekta","banglore");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(ram, 2011, 300),
				new Transaction(ram, 2012, 1000),
				new Transaction(kapil, 2011, 400),
				new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700),
				new Transaction(ekta, 2012, 950));
		return transactions;
	}
	
}