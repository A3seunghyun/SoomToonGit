package com.soomtoon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomtoon.dao.SoomtoonDao;
import com.soomtoon.dto.SoomtoonDto;

@Service
public class SoomtoonServiceImpl implements SoomtoonService {
	@Autowired
	SoomtoonDao dao;
	
	@Override
	public ArrayList<SoomtoonDto> getSoomtoonList(String day_week) {
		return dao.getSoomtoonList(day_week);
	}

}
