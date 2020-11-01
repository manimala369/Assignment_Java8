package com.trading;

public class Transaction {
			private Trader trader;
			private int year;
			private int value;
			
			public Transaction(Trader trader, int year, int value) {
				this.trader = trader;
				this.year = year;
				this.value = value;
			}
			
			public Trader getTrader() {
				return trader;
			}
			public int getYear() {
				return year;
			}
			public int getValue() {
				return value;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append("Transaction [trader=");
				sb.append(trader);
				sb.append(", year=");
				sb.append(year);
				sb.append(", value=");
				sb.append(value);
				sb.append("]");
				return sb.toString();
				
			}
}