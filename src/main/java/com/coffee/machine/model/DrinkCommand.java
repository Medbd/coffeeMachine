package com.coffee.machine.model;


public class DrinkCommand {
	
	private DrinkType  drinkType ;
	private int numberOfSugar ;
	private boolean  isExtraHot ;
	
	public DrinkCommand(DrinkType drinkType, int numberOfSugar , boolean isExtraHot) {
		this.drinkType = drinkType;
		this.numberOfSugar = numberOfSugar;
		this.isExtraHot = isExtraHot;
	}
	
	public boolean isExtraHot() {
		return isExtraHot;
	}

	public void setExtraHot(boolean isExtraHot) {
		this.isExtraHot = isExtraHot;
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

