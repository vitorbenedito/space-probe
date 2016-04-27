package com.spaceprobe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Nasa {
	
	private static final Logger logger = Logger.getLogger(Nasa.class);
	
	private Map<String, SpaceProbe> spaceProbeMap = new HashMap<String, SpaceProbe>();
	
	public void launchSpaceProbeWithCoordanates(List<List<String>> coordanates){
		
		String probeId = null;
		
		for(List<String> coordanate: coordanates){
			if(coordanate.size() > 2){
				if(probeId == null){
					
					SpaceProbe probe = SpaceProbe.start( 
							Integer.parseInt( coordanate.get(0) ), 
							Integer.parseInt( coordanate.get(1) ), 
							Direction.valueOf( coordanate.get(2) )
					);
					
					probeId = probe.getId();
					spaceProbeMap.put(probe.getId(), probe);
					
				}else{
					String actualPosition = "";
					for(String command: coordanate){
						SpaceProbe spaceProbe = spaceProbeMap.get(probeId);
						actualPosition = spaceProbe.sendCommand(command);
					}
					probeId = null;
					logger.info(actualPosition);
				}	
			}
		}
		
	}

	public Map<String, SpaceProbe> getSpaceProbeMap() {
		return spaceProbeMap;
	}

	public void setSpaceProbeMap(Map<String, SpaceProbe> spaceProbeMap) {
		this.spaceProbeMap = spaceProbeMap;
	}

}
