package com.spaceprobe.controllers.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SpaceProbeParser {

	public List<List<String>> parse(String request){
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		List<String> lines = Arrays.asList( request.split("\n") );
		
		List<String> higherPoint = new ArrayList<String>();
		higherPoint.addAll( Arrays.asList( lines.get(0).split(" ") ) );
		list.add(higherPoint);
		
		boolean initial = true;
		
		for(int i = 1; i < lines.size(); i++){
			List<String> commands = new ArrayList<String>();
			if(initial){
				commands.addAll( Arrays.asList( lines.get(i).split(" ") ) );
				initial = false;
			}else{
				commands.addAll( Arrays.asList( lines.get(i).split("") ) );
				initial = true;
			}
			list.add(commands);
		}
		
		return list;
		
	}

	
}
