package com.soomtoon.test;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soomtoon.dao.BoardDao;
import com.soomtoon.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BoardDaoTest {
	
	@Autowired
	BoardDao dao;
	
	@Test
	public void testBoardDao() {
		
		try {
			System.out.println(dao != null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(dao == null);
		}
	}
	
	@Test
	public void testBoardList(){
		ArrayList<BoardDto> bDto = dao.getBoardAllSelect();
		try {
			for(BoardDto dto : bDto) {
				System.out.println(dto.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBoardDetail(){
		Scanner sc = new Scanner(System.in);
		System.out.print("postIdx : ");
		int input = sc.nextInt();
		ArrayList<BoardDto> bDto = dao.getBoardDetailSelect(input);
		try {
			for(BoardDto dto : bDto) {
				System.out.println(dto.getUserName());
				sc.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
