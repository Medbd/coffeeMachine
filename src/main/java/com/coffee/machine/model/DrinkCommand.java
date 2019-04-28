package com.coffee.machine.model;


public class DrinkCommand {
	
	private DrinkType  drinkType ;
	private int numberOfSugar ;
	
	public DrinkCommand(DrinkType drinkType, int numberOfSugar) {
		this.drinkType = drinkType;
		this.numberOfSugar = numberOfSugar;
	}
	
	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}

	public int getNumberOfSugar() {
		return numberOfSugar;
	}

	public void setNumberOfSugar(int numberOfSugar) {
		this.numberOfSugar = numberOfSugar;
	}

	

}

