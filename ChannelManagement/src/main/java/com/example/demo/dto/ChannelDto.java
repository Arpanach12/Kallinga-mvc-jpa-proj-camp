package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.entity.Channelgroup;


public class ChannelDto {
	private int channelId;
	private String channelName;
	private int channelPrice;
	private List<ShowDto> showList;
	private ChannelgroupDto channelgroup;
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getChannelPrice() {
		return channelPrice;
	}
	public void setChannelPrice(int channelPrice) {
		this.channelPrice = channelPrice;
	}
	public List<ShowDto> getShowList() {
		return showList;
	}
	public void setShowList(List<ShowDto> showList) {
		this.showList = showList;
	}
	public ChannelgroupDto getChannelgroup() {
		return channelgroup;
	}
	public void setChannelgroup(ChannelgroupDto channelgroup) {
		this.channelgroup = channelgroup;
	}
	public ChannelDto(int channelId, String channelName, int channelPrice, List<ShowDto> showList,
			ChannelgroupDto channelgroup) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPrice = channelPrice;
		this.showList = showList;
		this.channelgroup = channelgroup;
	}
	public ChannelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
