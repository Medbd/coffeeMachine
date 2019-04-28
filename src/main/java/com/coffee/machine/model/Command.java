package com.coffee.machine.model;

public class Command {
	
	private DrinkCommand drinkCommand ;
	private double money ;
	
	public Command(DrinkCommand drinkCommand, double money) {
		this.drinkCommand = drinkCommand;
		this.money = money;
	}
	public DrinkCommand getDrinkCommand() {
		return drinkCommand;
	}
	public void setDrinkCommand(DrinkCommand drinkCommand) {
		this.drinkCommand = drinkCommand;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

}
