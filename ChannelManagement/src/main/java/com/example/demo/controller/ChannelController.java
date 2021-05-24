package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChannelDto;
import com.example.demo.dto.ChannelgroupDto;
import com.example.demo.dto.ShowDto;
import com.example.demo.entity.Channelgroup;
import com.example.demo.entity.Showentity;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.ChannelService;

@RestController
public class ChannelController {
	@Autowired
	ChannelService channelservice;
	@PostMapping("/insertchannelgroup")
	public String insertChannelGroup(@RequestBody ChannelgroupDto channelgroupdto) {
		channelservice.insertingChannelGroup(channelgroupdto);
		return "inserted Successfully";
	}
	
	@PostMapping("/insertchannel")
	public String insertChannel(@RequestBody ChannelDto channeldto) {
		channelservice.insertingChannel(channeldto);
		return "inserted Successfully";
	}

	@PostMapping("/insertshow")
	public String insertshow(@RequestBody ShowDto showdto) {
		channelservice.insertingShow(showdto);
		return "inserted Successfully";
	}
	
	@PostMapping("/assignchanneltochannelgroup/{channelid}/{channelgroupid}")
	public String assignChanneltochannelgroup(@PathVariable int channelid,@PathVariable int channelgroupid) throws ServiceException {
		channelservice.assignChanneltochannelgroup(channelid,channelgroupid);
		return "inserted Successfully";
	}
	
	@PostMapping("/assignshowtochannel/{showid}/{channelid}")
	public String assignShowtochannel(@PathVariable int showid,@PathVariable int channelid) throws ServiceException {
		channelservice.assignShowtochannel(showid,channelid);
		return "inserted Successfully";
	}
	
	
	@GetMapping("/showchannels/{channelgroupid}")
	public ResponseEntity<Map<String,Object>> showChannels(@PathVariable int channelgroupid){
		
		Map<String,Object> response=new LinkedHashMap<>();
		response.put("header", "channel");
		response.put("Error", false);
		response.put("message",channelservice.showChannels(channelgroupid));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	
	

}















