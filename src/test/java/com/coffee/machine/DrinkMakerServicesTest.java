package com.coffee.machine;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.coffee.machine.model.DrinkCommand;
import com.coffee.machine.model.DrinkType;
import com.coffee.machine.service.DrinkMakerResource;
import com.coffee.machine.service.DrinkMakerServices;

public class DrinkMakerServicesTest {
	
	@Test
	public void throw_exception_when_drink_command_is_null() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
			DrinkMakerServices.translateOrder(null));
	      assertEquals(DrinkMakerResource.ARGUMENT_SHOULD_NOT_BE_NULL.name(), exception.getMessage());
		
	}
	
	@Test
	public void throw_exception_when_drink_command_Type_is_null() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
			DrinkMakerServices.translateOrder(new DrinkCommand(null, 0)));
	      assertEquals(DrinkMakerResource.DRINK_TYPE_SHOULD_NOT_BE_NULL.name(), exception.getMessage());	
	}
	
	
	@Test
	public void should_return_T_colon_colon_when_command_tea_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA,0); 
		String Command = DrinkMakerServices.command(drinkCommand);
		assertEquals("T::" , Command);
	}
	
	@Test
	public void should_return_H_colon_colon_when_command_chocolate_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.CHOCOLATE,0); 
		String Command = DrinkMakerServices.command(drinkCommand);
		assertEquals("H::" , Command);
	}
	
	@Test
	public void should_return_C_colon_colon_when_command_chocolate_without_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE,0); 
		String Command = DrinkMakerServices.command(drinkCommand);
		assertEquals("C::" , Command);
	}
	
	@Test
	public void should_return_T_colon_one_colon_zero_when_command_tea_with_one_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.TEA,1); 
		String Command = DrinkMakerServices.command(drinkCommand);
		assertEquals("T:1:0" , Command);
	}
	
	@Test
	public void should_return_C_colon_two_colon_zero_when_command_coffee_with_two_sugar() {
		DrinkCommand drinkCommand = new DrinkCommand(DrinkType.COFFEE,2); 
		String Command = DrinkMakerServices.command(drinkCommand);
		assertEquals("C:2:0" , Command);
	}
	@Test
	public void should_return_M_colon_test_when_message_is_test() {
		String Command = DrinkMakerServices.displayMessage("test");
		assertEquals("M:test" , Command);
	}
	
	

}
