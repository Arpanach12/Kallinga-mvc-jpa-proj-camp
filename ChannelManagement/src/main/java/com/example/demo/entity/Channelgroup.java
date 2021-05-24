package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Channelgroup {
	@Id
	private int channegrouplId;
	private String channegroupName;
	@JsonIgnoreProperties("channelgroup")
	@OneToMany(mappedBy = "channelgroup",cascade = CascadeType.ALL)
	private List<Channel> channelList;
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
	public List<Channel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	public Channelgroup(int channegrouplId, String channegroupName, List<Channel> channelList) {
		super();
		this.channegrouplId = channegrouplId;
		this.channegroupName = channegroupName;
		this.channelList = channelList;
	}
	public Channelgroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
