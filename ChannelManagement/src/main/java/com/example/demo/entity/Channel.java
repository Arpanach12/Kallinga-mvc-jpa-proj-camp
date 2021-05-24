package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Channel implements Comparable<Channel> {
	@Id
	private int channelId;
	private String channelName;
	private int channelPrice;
	@JsonIgnoreProperties("channel")
	@OneToMany(mappedBy = "channel",cascade = CascadeType.ALL)
	private List<Showentity> showList;
	@JsonIgnoreProperties("channelList")
	@ManyToOne(cascade = CascadeType.ALL)
	private Channelgroup channelgroup;
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
	public List<Showentity> getShowList() {
		return showList;
	}
	public void setShowList(List<Showentity> showList) {
		this.showList = showList;
	}
	public Channelgroup getChannelgroup() {
		return channelgroup;
	}
	public void setChannelgroup(Channelgroup channelgroup) {
		this.channelgroup = channelgroup;
	}
	public Channel(int channelId, String channelName, int channelPrice, List<Showentity> showList,
			Channelgroup channelgroup) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPrice = channelPrice;
		this.showList = showList;
		this.channelgroup = channelgroup;
	}
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Channel ch) {
		int res=channelPrice-this.channelPrice;
		if(res==0) {
			res=ch.getChannelName().compareToIgnoreCase(this.channelName);
		}
		return res;
	}
	

}
