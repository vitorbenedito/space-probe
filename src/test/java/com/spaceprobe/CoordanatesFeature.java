package com.spaceprobe;

import java.util.ArrayList;
import java.util.List;

public class CoordanatesFeature {

	
	public static List<List<String>> getCoordanates(){
		
		List<List<String>> coordanates = new ArrayList<List<String>>();
		
		List<String> higherPoint = new ArrayList<String>();
		higherPoint.add("5");
		higherPoint.add("5");
		
		List<String> firstInitialPosition = new ArrayList<String>();
		firstInitialPosition.add("1");
		firstInitialPosition.add("2");
		firstInitialPosition.add("N");
		
		List<String> firstCommands = new ArrayList<String>();
		firstCommands.add("L");
		firstCommands.add("M");
		firstCommands.add("L");
		firstCommands.add("M");
		firstCommands.add("L");
		firstCommands.add("M");
		firstCommands.add("L");
		firstCommands.add("M");
		firstCommands.add("M");
		
		List<String> secondInitialPosition = new ArrayList<String>();
		secondInitialPosition.add("3");
		secondInitialPosition.add("3");
		secondInitialPosition.add("E");
		
		List<String> secondCommands = new ArrayList<String>();
		secondCommands.add("M");
		secondCommands.add("M");
		secondCommands.add("R");
		secondCommands.add("M");
		secondCommands.add("M");
		secondCommands.add("R");
		secondCommands.add("M");
		secondCommands.add("R");
		secondCommands.add("R");
		secondCommands.add("M");
		
		coordanates.add(higherPoint);
		coordanates.add(firstInitialPosition);
		coordanates.add(firstCommands);
		coordanates.add(secondInitialPosition);
		coordanates.add(secondCommands);
		
		return coordanates;
		
	}
	
}
