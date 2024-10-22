package com.soomtoon.service;

import java.util.ArrayList;

import com.soomtoon.dto.SoomtoonDto;

public interface SoomtoonService {
	ArrayList<SoomtoonDto> getSoomtoonList(String day_week);
}
