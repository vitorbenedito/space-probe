package com.spaceprobe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceprobe.Nasa;
import com.spaceprobe.SpaceProbe;
import com.spaceprobe.controllers.parsers.SpaceProbeParser;

@Controller
@RequestMapping("/spaceprobe")
public class SpaceProbeController {

  @Autowired
  private SpaceProbeParser spaceProbeParser;
  
  @Autowired
  private Nasa nasa;
  
  @ResponseBody
  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public List<SpaceProbe> create(@RequestBody String body) {
	  return nasa.launchSpaceProbeWithCoordanates( spaceProbeParser.parse(body) ).getSpaceProbes();
  }
  
  @ResponseBody
  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public List<SpaceProbe> list() {
	  return nasa.getSpaceProbes();
  }
  
  @ResponseBody
  @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
  public SpaceProbe load(@PathVariable("id") String id) {
	  return nasa.getSpaceProbeMap().get(id);
  }
  
}
