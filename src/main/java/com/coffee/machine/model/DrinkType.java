package com.coffee.machine.model;

public enum DrinkType {
	COFFEE ("C" , 0.6) , 
	TEA("T" , 0.4) ,
	CHOCOLATE("H",0.5),
	ORANGE_JUICE("O" , 0.6);
	private String drinkTypeCode ;
	private double drinkPrice ;

	private DrinkType(String drinkTypeCode ,double drinkPrice) {
		this.drinkTypeCode = drinkTypeCode;
		this.drinkPrice = drinkPrice;
	}
	
	public String getDrinkTypeCode() {
		return this.drinkTypeCode ;
	}
	
	public double getDrinkPrice() {
		return this.drinkPrice ;
	}
	

}