package com.soomtoon.dao;

import java.util.ArrayList;

import com.soomtoon.dto.SoomtoonDto;

public interface SoomtoonDao {
	
	ArrayList<SoomtoonDto> getSoomtoonList(String day_week);
}
