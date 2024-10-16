package com.soomtoon.test;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soomtoon.dao.BoardDao;
import com.soomtoon.dao.WebtoonDao;
import com.soomtoon.dto.BoardDto;
import com.soomtoon.dto.WebtoonDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DaoTest {
	
	@Autowired
	BoardDao bdao;
	
	@Test
	// 게시글 리스트 전체 조회 테스트
	public void testBoardList(){
		ArrayList<BoardDto> bDto = bdao.getBoardAllSelect();
		try {
			for(BoardDto dto : bDto) {
				System.out.println(dto.getWebtoonIdx() + " / "+dto.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	// 게시글 상세페이지 조회 테스트
	public void testBoardDetail(){
		Scanner sc = new Scanner(System.in);
		System.out.print("postIdx : ");
		int input = sc.nextInt();
		ArrayList<BoardDto> bDto = bdao.getBoardDetailSelect(input);
		try {
			for(BoardDto dto : bDto) {
				System.out.println(dto.getUserName());
				sc.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	WebtoonDao wDao;
	
	@Test
	// 웹툰 상세페이지 조회 테스트
	public void testWebtoonDetail() {
		Scanner sc = new Scanner(System.in);
		System.out.print("webtoonIdx : ");
		int input = sc.nextInt();
		ArrayList<WebtoonDto> wDto = wDao.getWebtoonDetailSelect(input);
		try {
			for(WebtoonDto dto : wDto) {
				System.out.println(dto.getWebtoonName());
				sc.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	// 웹툰 상세페이지 - 게시판 테스트
	public void testWebtoonBoardList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("webtoonIdx : ");
		int input = sc.nextInt();
		
		ArrayList<BoardDto> bDto = wDao.getWebtoobBoardListSelect(input);
		try {
			for(BoardDto dto : bDto) {
				System.out.println(dto.getTitle());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
