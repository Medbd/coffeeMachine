package com.coffee.machine.model;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	
	public static final String COLON = ":";
	public static final String ESPACE = " ";
	public static final String TOTAL = "Total";
	
	private List<Command> commandList = new ArrayList<>() ;

	public List<Command> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}
	
	public void addToReport(Command command) {
		commandList.add(command) ;
	}
	
	public long getNumberOfCommandByType(DrinkType drinkType) {
		return commandList.stream().filter(c -> drinkType.equals(c.getDrinkCommand().getDrinkType())).count() ;
	}
	
	public double getTotalOfMoney() {
		return commandList.stream().mapToDouble(c -> c.getDrinkCommand().getDrinkType().getDrinkPrice()).sum() ;
	}
	
    public  String DisplayReport() {
    	StringBuilder reportToDisplay = new StringBuilder() ; 
    	reportToDisplay.append(DrinkType.CHOCOLATE.getDrinkTypeCode());
    	reportToDisplay.append(COLON);
    	reportToDisplay.append(getNumberOfCommandByType(DrinkType.CHOCOLATE));
    	reportToDisplay.append(ESPACE);
    	reportToDisplay.append(DrinkType.COFFEE.getDrinkTypeCode());
    	reportToDisplay.append(COLON);
    	reportToDisplay.append(getNumberOfCommandByType(DrinkType.COFFEE));
    	reportToDisplay.append(ESPACE);
    	reportToDisplay.append(DrinkType.ORANGE_JUICE.getDrinkTypeCode());
    	reportToDisplay.append(COLON);
    	reportToDisplay.append(getNumberOfCommandByType(DrinkType.ORANGE_JUICE));
    	reportToDisplay.append(ESPACE);
    	reportToDisplay.append(DrinkType.TEA.getDrinkTypeCode());
    	reportToDisplay.append(COLON);
    	reportToDisplay.append(getNumberOfCommandByType(DrinkType.TEA));
    	reportToDisplay.append(ESPACE);
    	reportToDisplay.append(TOTAL);
    	reportToDisplay.append(COLON);
    	reportToDisplay.append(getTotalOfMoney());
        return  reportToDisplay.toString();
    }

}
