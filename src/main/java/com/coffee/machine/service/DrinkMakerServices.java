package com.coffee.machine.service;

import com.coffee.machine.model.Command;
import com.coffee.machine.model.DrinkCommand;


public class DrinkMakerServices {
	
	public static final String COLON = ":";
	public static final String ZERO = "0";
	public static final String M = "M";
	public static final String H = "h";
	public static final String ESPACE = " ";
	public static final String TOTAL = "Total";
	
	private  BeverageQuantityChecker beverageQuantityChecker  ;
	private  EmailNotifier emailNotifier;
	
    public static ReportServices reportServices = new ReportServices() ;
	
	public  String translateOrder(final DrinkCommand drinkCommand) {
		StringBuilder command = new StringBuilder() ; 
		command.append(drinkCommand.getDrinkType().getDrinkTypeCode()) ;
		if(drinkCommand.isExtraHot())
			command.append(H);
		command.append(COLON);
		if(drinkCommand.getNumberOfSugar() > 0) {
			command.append(drinkCommand.getNumberOfSugar());
			command.append(COLON);
			command.append(ZERO);
		} else {
			command.append(COLON);
		}
		return command.toString() ;
	}
	
	public  String displayMessage(String message) {
		StringBuilder messageResult = new StringBuilder() ;
		messageResult.append(M);
		messageResult.append(COLON);
		messageResult.append(message);
		return messageResult.toString();
	}
	
	public  String handleCommand(final Command command) {
		if(command.getDrinkCommand() == null)
			throw new IllegalArgumentException(DrinkMakerResource.ARGUMENT_SHOULD_NOT_BE_NULL.name());
		if(command.getDrinkCommand().getDrinkType() == null)
			throw new IllegalArgumentException(DrinkMakerResource.DRINK_TYPE_SHOULD_NOT_BE_NULL.name());
		
		/*if (beverageQuantityChecker.isEmpty(command.getDrinkCommand().getDrinkType().getDrinkTypeCode())) {
            emailNotifier.notifyMissingDrink(command.getDrinkCommand().getDrinkType().getDrinkTypeCode());
            return displayMessage(DrinkMakerResource.PROBLEM_OF_SHORTAGE_AND_NOTIFICATION_HAS_BEEN_SENT.name()) ;
        }*/
		if(checkIfEnoughMoney(command)) {
			reportServices.addToReport(command) ;
			return sendOrder(translateOrder(command.getDrinkCommand())) ;
		}
		return displayMessage(DrinkMakerResource.MONEY_IS_NOT_ENOUGH.name() 
				+ (command.getDrinkCommand().getDrinkType().getDrinkPrice() - command.getMoney())) ;
		
		
	}
	
	public  boolean checkIfEnoughMoney(final Command command) {
		if(command.getMoney() >= command.getDrinkCommand().getDrinkType().getDrinkPrice())
			return true ; 
		return false ;
		
	}
	
	public  String sendOrder(final String order) {
		// send order to drink maker
		return DrinkMakerResource.ORDER_HAS_BEEN_PROCESSED.name();	
	}


}
