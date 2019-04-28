package com.coffee.machine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.coffee.machine.model.Command;
import com.coffee.machine.model.DrinkCommand;
import com.coffee.machine.model.DrinkType;
import com.coffee.machine.model.Report;

public class ReportServicesTest {
	
	public Report report = new Report();
	
	@Test
	public void check_count_total_of_money_is_zero_when_report_is_empty() {
		assertTrue(report.getTotalOfMoney()== 0.0);
	}
	
	@Test
	public void check_count_of_each_type_is_zero_when_report_is_empty() {
		assertTrue(report.getNumberOfCommandByType(DrinkType.CHOCOLATE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.COFFEE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.ORANGE_JUICE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.TEA) == 0);	
	}
	
	@Test
	public void check_count_of_Chocolate_is_one_when_report_has_one_chocolate_command() {
		report.addToReport(new Command(new DrinkCommand(DrinkType.CHOCOLATE, 1, false), 0.8));
		assertTrue(report.getNumberOfCommandByType(DrinkType.CHOCOLATE) == 1);
		assertTrue(report.getNumberOfCommandByType(DrinkType.COFFEE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.ORANGE_JUICE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.TEA) == 0);	
	}
	
	@Test
	public void check_count_of_coffee_is_two_and_tea_is_one_when_report_has_two_chocolate_command_and_one_tea_command() {
		report.addToReport(new Command(new DrinkCommand(DrinkType.CHOCOLATE, 1, false), 0.8));
		report.addToReport(new Command(new DrinkCommand(DrinkType.CHOCOLATE, 1, false), 0.7));
		report.addToReport(new Command(new DrinkCommand(DrinkType.TEA, 1, false), 0.7));
		assertTrue(report.getNumberOfCommandByType(DrinkType.TEA) == 1);	
		assertTrue(report.getNumberOfCommandByType(DrinkType.CHOCOLATE) == 2);
		assertTrue(report.getNumberOfCommandByType(DrinkType.COFFEE) == 0);
		assertTrue(report.getNumberOfCommandByType(DrinkType.ORANGE_JUICE) == 0);
	}
	
	@Test
	public void check_count_total_is_1_0_when_report_has_one_coffee_command_and_one_tea_command() {
		report.addToReport(new Command(new DrinkCommand(DrinkType.COFFEE, 1, false), 0.8));
		report.addToReport(new Command(new DrinkCommand(DrinkType.TEA, 1, false), 0.7));
		assertTrue(report.getTotalOfMoney()== 1.0);

	}
	
	@Test
	public void check_dispay_report_complet_when_report_is_emply() {
		assertEquals("H:0 C:0 O:0 T:0 Total:0.0", report.displayReport());

	}
	
	@Test
	public void check_dispay_report_complet() {
		report.addToReport(new Command(new DrinkCommand(DrinkType.COFFEE, 1, false), 0.8));
		report.addToReport(new Command(new DrinkCommand(DrinkType.TEA, 1, false), 0.7));
		report.addToReport(new Command(new DrinkCommand(DrinkType.TEA, 1, false), 0.7));
		report.addToReport(new Command(new DrinkCommand(DrinkType.ORANGE_JUICE, 1, false), 0.7));
		report.addToReport(new Command(new DrinkCommand(DrinkType.CHOCOLATE, 1, false), 0.7));
		assertEquals("H:1 C:1 O:1 T:2 Total:2.5", report.displayReport());

	}

}
