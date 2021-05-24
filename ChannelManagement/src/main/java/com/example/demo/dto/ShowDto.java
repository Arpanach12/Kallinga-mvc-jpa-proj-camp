package com.example.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.example.demo.entity.Channel;

public class ShowDto {
	private int showId;
	private String showName;
	private ChannelDto channel;
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public ChannelDto getChannel() {
		return channel;
	}
	public void setChannel(ChannelDto channel) {
		this.channel = channel;
	}
	public ShowDto(int showId, String showName, ChannelDto channel) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channel = channel;
	}
	public ShowDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
