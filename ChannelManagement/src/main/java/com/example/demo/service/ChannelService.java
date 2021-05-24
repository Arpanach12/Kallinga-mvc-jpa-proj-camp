package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChannelDto;
import com.example.demo.dto.ChannelgroupDto;
import com.example.demo.dto.ShowDto;
import com.example.demo.entity.Channel;
import com.example.demo.entity.Channelgroup;
import com.example.demo.exception.ServiceException;

public interface ChannelService {

	void insertingChannelGroup( ChannelgroupDto channelgroupdto);

	void insertingChannel(ChannelDto channeldto);

	void insertingShow(ShowDto showdto);

	void assignChanneltochannelgroup(int channelid, int channelgroupid) throws ServiceException;

	void assignShowtochannel(int showid, int channelid)throws ServiceException;

	List<Channel> showChannels(int channelgroupid);

}
