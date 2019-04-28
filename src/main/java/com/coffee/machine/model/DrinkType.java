package com.coffee.machine.model;

public enum DrinkType {
	COFFEE ("C") , 
	TEA("T") ,
	CHOCOLATE("H") ;
	private String drinkTypeCode ;

	private DrinkType(String drinkTypeCode) {
		this.drinkTypeCode = drinkTypeCode;
	}
	
	public String getDrinkTypeCode() {
		return this.drinkTypeCode ;
	}
	

}