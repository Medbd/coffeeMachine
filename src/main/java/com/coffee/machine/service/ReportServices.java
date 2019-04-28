package com.coffee.machine.service;

import com.coffee.machine.model.Command;
import com.coffee.machine.model.Report;

public class ReportServices {
	
	public static  Report report = new Report() ;
	
	
    public  void addToReport(Command command) {
        report.addToReport(command);
    }


}
