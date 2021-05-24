package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Showentity {
	@Id
	private int showId;
	private String showName;
	@JsonIgnoreProperties("showList")
	@ManyToOne(cascade = CascadeType.ALL)
	private Channel channel;
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
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Showentity(int showId, String showName, Channel channel) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.channel = channel;
	}
	public Showentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
