package com.coffee.machine.service;

import com.coffee.machine.model.DrinkCommand;

public class DrinkMakerServices {
	
	public static final String COLON = ":";
	public static final String ZERO = "0";
	public static final String M = "M";
	
	
	public static String translateOrder(final DrinkCommand drinkCommand) {
		if(drinkCommand == null)
			throw new IllegalArgumentException(DrinkMakerResource.ARGUMENT_SHOULD_NOT_BE_NULL.name());
		if(drinkCommand.getDrinkType() == null)
			throw new IllegalArgumentException(DrinkMakerResource.DRINK_TYPE_SHOULD_NOT_BE_NULL.name());
		StringBuilder command = new StringBuilder() ; 
		command.append(drinkCommand.getDrinkType().getDrinkTypeCode()) ;
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
	
	public static String displayMessage(String message) {
		StringBuilder messageResult = new StringBuilder() ;
		messageResult.append(M);
		messageResult.append(COLON);
		messageResult.append(message);
		return messageResult.toString();
	}
	
	public static String command(final DrinkCommand drinkCommand) {
		return translateOrder(drinkCommand) ;
		
	}		

}
