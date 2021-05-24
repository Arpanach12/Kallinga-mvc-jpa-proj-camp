package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Channelgroup;
@Repository
public interface ChannelgroupRepository extends JpaRepository<Channelgroup,Integer> {

}
