package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.example.demo.entity.Channel;

public class ChannelgroupDto {
	private int channegrouplId;
	private String channegroupName;
	private List<ChannelDto> channelList;
	public int getChannegrouplId() {
		return channegrouplId;
	}
	public void setChannegrouplId(int channegrouplId) {
		this.channegrouplId = channegrouplId;
	}
	public String getChannegroupName() {
		return channegroupName;
	}
	public void setChannegroupName(String channegroupName) {
		this.channegroupName = channegroupName;
	}
	public List<ChannelDto> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<ChannelDto> channelList) {
		this.channelList = channelList;
	}
	public ChannelgroupDto(int channegrouplId, String channegroupName, List<ChannelDto> channelList) {
		super();
		this.channegrouplId = channegrouplId;
		this.channegroupName = channegroupName;
		this.channelList = channelList;
	}
	public ChannelgroupDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
