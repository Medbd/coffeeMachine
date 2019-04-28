package com.coffee.machine;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.coffee.machine.model.Command;
import com.coffee.machine.model.DrinkCommand;
import com.coffee.machine.model.DrinkType;
import com.coffee.machine.service.DrinkMakerResource;
import com.coffee.machine.service.DrinkMakerServices;

public class DrinkMakerServicesTest {
	
	DrinkMakerServices drinkMakerServices = new DrinkMakerServices();
	@Test
	public void throw_exception_when_drink_command_is_null() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
	      drinkMakerServices.handleCommand(new Command(null, 0.0)));
	      assertEquals(DrinkMakerResource.ARGUMENT_SHOULD_NOT_BE_NULL.name(), exception.getMessage());
		
	}
	
	@Test
	public void throw_exception_when_drink_command_Type_is_null() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
	      drinkMakerServices.handleCommand(new Command(new DrinkCommand(null, 0,false), 0.0)));
	      assertEquals(DrinkMakerResource.DRINK_TYPE_SHOULD_NOT_BE_NULL.name(), exception.getMessage());	
	}
	
	
	@Test
	public void should_return_T_colon_colon_when_command_tea_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA,0,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("T::" , Command);
	}
	
	@Test
	public void should_return_H_colon_colon_when_command_chocolate_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.CHOCOLATE,0,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("H::" , Command);
	}
	
	@Test
	public void should_return_C_colon_colon_when_command_chocolate_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE,0,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("C::" , Command);
	}
	
	@Test
	public void should_return_T_colon_one_colon_zero_when_command_tea_with_one_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA,1,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("T:1:0" , Command);
	}
	
	@Test
	public void should_return_C_colon_two_colon_zero_when_command_coffee_with_two_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE,2,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("C:2:0" , Command);
	}
	@Test
	public void should_return_M_colon_test_when_message_is_test() {
		String Command = drinkMakerServices.displayMessage("test");
		assertEquals("M:test" , Command);
	}
	
	@Test
	public void should_return_message_M_colon_money_is_not_enough_01_when_money_of_tea_command_is_not_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA, 1,false) ;
		Command command = new Command(drinkCommand, 0.3) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		String rightMessage = DrinkMakerResource.MONEY_IS_NOT_ENOUGH.name() + (command.getDrinkCommand().getDrinkType().getDrinkPrice() - command.getMoney()) ;
		assertEquals(drinkMakerServices.displayMessage(rightMessage) , CommandMessage);
	}
	@Test
	public void should_return_message_M_colon_money_is_not_enough_05_when_money_of_coffee_command_is_not_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE, 1,false) ;
		Command command = new Command(drinkCommand, 0.1) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		String rightMessage = DrinkMakerResource.MONEY_IS_NOT_ENOUGH.name() + (command.getDrinkCommand().getDrinkType().getDrinkPrice() - command.getMoney()) ;
		assertEquals(drinkMakerServices.displayMessage(rightMessage) , CommandMessage);
	}
	@Test
	public void should_return_message_M_colon_money_is_not_enough_04_when_money_of_chocolate_command_is_not_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.CHOCOLATE, 1,false) ;
		Command command = new Command(drinkCommand, 0.1) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		String rightMessage = DrinkMakerResource.MONEY_IS_NOT_ENOUGH.name() + (command.getDrinkCommand().getDrinkType().getDrinkPrice() - command.getMoney()) ;
		assertEquals(drinkMakerServices.displayMessage(rightMessage) , CommandMessage);
	}
	
	@Test
	public void should_return_order_has_been_processed_when_money_of_cofee_command_is_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE, 1, false) ;
		Command command = new Command(drinkCommand, 0.7) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		assertEquals(DrinkMakerResource.ORDER_HAS_BEEN_PROCESSED.name() , CommandMessage);
	}
	@Test
	public void should_return_order_has_been_processed_when_money_of_tea_command_is_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA, 1,false) ;
		Command command = new Command(drinkCommand, 0.5) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		assertEquals(DrinkMakerResource.ORDER_HAS_BEEN_PROCESSED.name() , CommandMessage);
	}
	
	@Test
	public void should_return_order_has_been_processed_when_money_of_chocolate_command_is_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.CHOCOLATE, 1,false) ;
		Command command = new Command(drinkCommand, 0.5) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		assertEquals(DrinkMakerResource.ORDER_HAS_BEEN_PROCESSED.name() , CommandMessage);
	}
	
	@Test
	public void should_return_O_colon_colon_when_command_orange_juice_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.ORANGE_JUICE,0,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("O::" , Command);
	}
	
	@Test
	public void should_return_O_colon_one_colon_zero_when_command_orange_juice_with_one_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.ORANGE_JUICE,1,false); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("O:1:0" , Command);
	}
	
	@Test
	public void should_return_order_has_been_processed_when_money_of_orange_juice_command_is_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.ORANGE_JUICE, 1,false) ;
		Command command = new Command(drinkCommand, 0.6) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		assertEquals(DrinkMakerResource.ORDER_HAS_BEEN_PROCESSED.name() , CommandMessage);
	}
	
	@Test
	public void should_return_message_M_colon_money_is_not_enough_01_when_money_of_orange_juice_command_is_not_enough() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.ORANGE_JUICE, 1,false) ;
		Command command = new Command(drinkCommand, 0.5) ;
		String CommandMessage = drinkMakerServices.handleCommand(command);
		String rightMessage = DrinkMakerResource.MONEY_IS_NOT_ENOUGH.name() + (command.getDrinkCommand().getDrinkType().getDrinkPrice() - command.getMoney()) ;
		assertEquals(drinkMakerServices.displayMessage(rightMessage) , CommandMessage);
	}
	@Test
	public void should_return_Ch_colon_colon_when_command_coffee_extra_hot_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE,0,true); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("Ch::" , Command);
	}
	@Test
	public void should_return_Hh_colon_one_colon_zero_when_command_chocolate_extra_hot_with_one_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.CHOCOLATE,1,true); 
		String Command = drinkMakerServices.translateOrder(drinkCommand);
		assertEquals("Hh:1:0" , Command);
	}
	
	

}
