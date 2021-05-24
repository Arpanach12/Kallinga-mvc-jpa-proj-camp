package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChannelDto;
import com.example.demo.dto.ChannelgroupDto;
import com.example.demo.dto.ShowDto;
import com.example.demo.entity.Channel;
import com.example.demo.entity.Channelgroup;
import com.example.demo.entity.Showentity;
import com.example.demo.exception.ServiceException;
import com.example.demo.exception.util.ErrorConstants;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.ChannelgroupRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	ChannelRepository channelrepository;
	@Autowired
	ChannelgroupRepository channelgrouprepository;
	@Autowired
	ShowRepository showrepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public void insertingChannelGroup(ChannelgroupDto channelgroupdto) {
		Channelgroup channelgroup=convertDtoToEntity(channelgroupdto);
		channelgrouprepository.save(channelgroup);

	}

	@Override
	public void insertingChannel(ChannelDto channeldto) {
		Channel channel=convertDtoToEntity(channeldto);
		channelrepository.save(channel);

	}

	@Override
	public void insertingShow(ShowDto showdto) {
		Showentity showentity=convertDtoToEntity(showdto);
		showrepository.save(showentity);
	}
	
	
	
	private Channel convertDtoToEntity(ChannelDto channeldto) {
		return modelMapper.map(channeldto, Channel.class);
	}

	private ChannelDto convertEntityToDto(Channel channel) {

		return modelMapper.map(channel, ChannelDto.class);
	}
	
	
	private Channelgroup convertDtoToEntity(ChannelgroupDto channelgroupdto) {
		return modelMapper.map(channelgroupdto, Channelgroup.class);
	}

	private ChannelgroupDto convertEntityToDto(Channelgroup channelgroup) {

		return modelMapper.map(channelgroup, ChannelgroupDto.class);
	}
	private Showentity convertDtoToEntity(ShowDto showdto) {
		return modelMapper.map(showdto, Showentity.class);
	}

	private ShowDto convertEntityToDto(Showentity showentity) {

		return modelMapper.map(showentity, ShowDto.class);
	}

	@Override
	public void assignChanneltochannelgroup(int channelid, int channelgroupid) throws ServiceException {
		Channel channel=channelrepository.findById(channelid).orElseThrow(()->new ServiceException(ErrorConstants.NoSuchChannelFound));
		Channelgroup channelgroup=channelgrouprepository.findById(channelgroupid).orElseThrow(()->new ServiceException(ErrorConstants.NoSuchChannelGroupFound));
		channel.setChannelgroup(channelgroup);
		channelrepository.saveAndFlush(channel);
	}

	@Override
	public void assignShowtochannel(int showid, int channelid) throws ServiceException {
		Channel channel=channelrepository.findById(channelid).orElseThrow(()->new ServiceException(ErrorConstants.NoSuchChannelFound));
		Showentity showentity=showrepository.findById(showid).orElseThrow(()->new ServiceException(ErrorConstants.NoSuchShowFound));
		showentity.setChannel(channel);
		showrepository.saveAndFlush(showentity);
		
	}

	@Override
	public List<Channel> showChannels(int channelgroupid) {
		Channelgroup channelgroup=channelgrouprepository.findById(channelgroupid).get();
		List<Channel> channel=channelgroup.getChannelList();
		List<ChannelDto> chanel=new ArrayList<ChannelDto>();
		Collections.sort(channel);
		/*
		 * for (Channel channel2 : channel) { ChannelDto
		 * channelDto=convertEntityToDto(channel2); chanel.add(channelDto); }
		 */
		return channel;
	}

	
}
