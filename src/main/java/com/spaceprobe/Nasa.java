package com.spaceprobe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Nasa {
	
	private static final Logger logger = Logger.getLogger(Nasa.class);
	
	private Map<String, SpaceProbe> spaceProbeMap = new LinkedHashMap<String, SpaceProbe>();
	
	public Nasa launchSpaceProbeWithCoordanates(List<List<String>> coordanates){
		
		String probeId = null;
		
		for(List<String> coordanate: coordanates){
			if(coordanate.size() > 2){
				if(probeId == null){
					probeId = startSpaceProbe(coordanate);
				}else{
					sendCommands(probeId, coordanate);
					probeId = null;
				}	
			}
		}
		
		return this;
		
	}

	private void sendCommands(String probeId, List<String> coordanate) {
		
		String actualPosition = "";
		for(String command: coordanate){
			SpaceProbe spaceProbe = spaceProbeMap.get(probeId);
			actualPosition = spaceProbe.sendCommand(command);
		}
		logger.info(actualPosition);
	}

	private String startSpaceProbe(List<String> coordanate) {
		SpaceProbe probe = SpaceProbe.start( 
				Integer.parseInt( coordanate.get(0) ), 
				Integer.parseInt( coordanate.get(1) ), 
				Direction.valueOf( coordanate.get(2) )
		);
		
		spaceProbeMap.put(probe.getId(), probe);
		return probe.getId();	
	}

	public Map<String, SpaceProbe> getSpaceProbeMap() {
		return spaceProbeMap;
	}
	
	public List<SpaceProbe> getSpaceProbes() {
		return new ArrayList<SpaceProbe>(spaceProbeMap.values());
	}

	public void setSpaceProbeMap(Map<String, SpaceProbe> spaceProbeMap) {
		this.spaceProbeMap = spaceProbeMap;
	}

}
