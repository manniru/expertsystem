package com.habibu.expertsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Algorithms {

	public static void main(String[] args) {
		
		//Collection<Data> collection = new ArrayList<Data>();
		
		//collection.add(new Data("chestpain", "verylow"));
		
		HashMap hm = new HashMap();
		hm.put("chestpain", "verylow");
		hm.put("cholestrol", "verylow");
		hm.put("maxheartrate", "verylow");
		hm.put("bloodpressure", "verylow");
		hm.put("bloodsugar", "low");
		hm.put("oldpeak", "verylow");
				
		Algorithms alg = new Algorithms();
		String results = alg.results(hm);
			
		System.out.println(results);

	}
	
	public String results(HashMap hm) {
		String output = "";
		
		String chestpain = hm.get("chestpain").toString();
		String cholestrol = hm.get("cholestrol").toString();
		String maxheartrate = hm.get("maxheartrate").toString();
		String bloodpressure = hm.get("bloodpressure").toString();
		String bloodsugar = hm.get("bloodsugar").toString();
		String oldpeak = hm.get("oldpeak").toString();

		String result="";
		String precautions="";
		
		// 1
		if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("verylow") && bloodpressure.equals("verylow") && bloodsugar.equals("low") && oldpeak.equals("verylow")) {
			result = "healthy";
			precautions = "Exercise";
		}
		
		// 2
		else if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("verylow") && bloodpressure.equals("verylow") && bloodsugar.equals("low") && oldpeak.equals("low")) {
			result = "healthy";
			precautions = "Exercise";
		}
		
		// 3
		else if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("verylow") && bloodpressure.equals("verylow") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
			result = "low_risk";
			precautions = "Exercise";
		}
		
		// 4
		else if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("verylow") && bloodpressure.equals("high") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
			result = "low_risk";
			precautions = "low_salt_diet";
		}
		
		// 5
		else if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("high") && bloodpressure.equals("high") && bloodsugar.equals("high") && oldpeak.equals("terrible")) {
			result = "moderate_risk";
			precautions = "low_salt_diet";
		}
		
		// 6
		else if(chestpain.equals("verylow") && cholestrol.equals("high") && maxheartrate.equals("high") && bloodpressure.equals("high") && bloodsugar.equals("high") && oldpeak.equals("terrible")) {
			result = "result is risk";
			precautions = "low_salt_diet";
		}
		
		// 7
		else if(chestpain.equals("high") && cholestrol.equals("high") && maxheartrate.equals("high") && bloodpressure.equals("high") && bloodsugar.equals("high") && oldpeak.equals("veryhigh")) {
			result = "result is risk";
			precautions = "low_salt_diet";
		}
		
		// 8
		else if(chestpain.equals("moderate") && cholestrol.equals("medium") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
			result = "moderate_risk";
			precautions = "useoliveoil";
		}
		
		// 9
		else if(chestpain.equals("moderate") && cholestrol.equals("medium") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
			result = "moderate_risk";
			precautions = "useoliveoil";
		}
		
		// 10
		else if(chestpain.equals("veryhigh") && cholestrol.equals("veryhigh") && maxheartrate.equals("veryhigh") && bloodpressure.equals("veryhigh") && bloodsugar.equals("veryhigh") && oldpeak.equals("veryhigh")) {
			result = "is risk";
			precautions = "any other";
		}
		
		// 11
		else if(chestpain.equals("veryhigh") && cholestrol.equals("veryhigh") && maxheartrate.equals("veryhigh") && bloodpressure.equals("veryhigh") && bloodsugar.equals("veryhigh") && oldpeak.equals("terrible")) {
			result = "is risk";
			precautions = "any other";
		}
		
		// 12
		else if(chestpain.equals("veryhigh") && cholestrol.equals("veryhigh") && maxheartrate.equals("veryhigh") && bloodpressure.equals("veryhigh") && bloodsugar.equals("veryhigh") && oldpeak.equals("terrible")) {
			result = "is risk";
			precautions = "any other";
		}
		
		// 13
		else if(chestpain.equals("veryhigh") && cholestrol.equals("veryhigh") && maxheartrate.equals("veryhigh") && bloodpressure.equals("medium") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
		result = "precautions";
		precautions = "is any other";
		}
		
		// 14
		else if(chestpain.equals("veryhigh") && cholestrol.equals("veryhigh") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("normal") && oldpeak.equals("medium")) {
		result = "moderate_risk";
		precautions = "any other";
		}
		
		// 15
		else if(chestpain.equals("veryhigh") && cholestrol.equals("medium") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("normal") && oldpeak.equals("medium")) {
		result = "low_risk";
		precautions = "any other";
		}
		
		// 16
		else if(chestpain.equals("high") && cholestrol.equals("medium") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("normal") && oldpeak.equals("medium")) {
		result = "is risk";
		precautions = "balanceddiet";
		}
		
		// 17
		else if(chestpain.equals("low") && cholestrol.equals("veryhigh") && maxheartrate.equals("veryhigh") && bloodpressure.equals("medium") && bloodsugar.equals("normal") && oldpeak.equals("medium")) {
		result = "precautions";
		precautions = "balanceddiet";
		}
		
		// 18
		else if(chestpain.equals("moderate") && cholestrol.equals("high") && maxheartrate.equals("high") && bloodpressure.equals("veryhigh") && bloodsugar.equals("veryhigh") && oldpeak.equals("risk")) {
		result = "high_risk";
		precautions = "balanceddiet";
		}
		
		// 19
		else if(chestpain.equals("moderate") && cholestrol.equals("high") && maxheartrate.equals("high") && bloodpressure.equals("veryhigh") && bloodsugar.equals("veryhigh") && oldpeak.equals("risk")) {
		result = "risk";
		precautions = "useoliveoil";
		}
		
		// 20
		else if(chestpain.equals("low") && cholestrol.equals("medium") && maxheartrate.equals("medium") && bloodpressure.equals("medium") && bloodsugar.equals("medium") && oldpeak.equals("terrible")) {
		result = "moderate_risk";
		precautions = "useoliveoil";
		}
		
		// 21
		else if(chestpain.equals("low") && cholestrol.equals("verylow") && maxheartrate.equals("verylow") && bloodpressure.equals("medium") && bloodsugar.equals("medium") && oldpeak.equals("medium")) {
		result = "low_risk";
		precautions = "useoliveoil";
		}
		
		// 22
		else if(chestpain.equals("verylow") && cholestrol.equals("verylow") && maxheartrate.equals("high") && bloodpressure.equals("high") && bloodsugar.equals("high") && oldpeak.equals("terrible")) {
		result = "risk";
		precautions = "useoliveoil";
		}
		
		
		else {
			result = "Invalid input!";
			precautions = "Invalid input!";
		}
		
		output = result+":"+precautions;
		
		// (chestpain is ) and ( is very_low) and ( is very_low) and ( is very_low) and ( is low) and ( is very_low) then (result is healthy)(precautions is Exercise)
		/**
		if(op1.equals("veryLow") && op2.equals("veryLow")) {
			output = "<font color='#FF0000'>You have High Risk Heart Attacks</font>";
		}
		
		if(op1.equals("very high") && op2.equals("very high")) {
			output = "<font color='#FF0000'>You have High Risk Heart Attacks</font>";
		}
		
		if(op1.equals("very low") && op2.equals("very low")) {
			output = "<font color='#0000CC'>You are in Good Health</font>";
		}
		
		if(op1.equals("very high") && op2.equals("very low")) {
			output = "<font color='#009933'>Try to be taken medicine, and get enough sleep</font>";
		}
		
		if(op1.equals("very low") && op2.equals("very high")) {
			output = "<font color='#009933'>dont be thinking to much, and get enough sleep</font>";
		}
		*/
		return output;
		
	}



}
