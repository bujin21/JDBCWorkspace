package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;
import com.kh.board.view.BoardView;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {
	
	// service 변수 선언 및 초기화
	private BoardService bService = new BoardServiceImpl();
	
	// view의 login요청을 담당할 메서드
	public boolean login(String id, String pwd) {
		int result = bService.login(id, pwd);
		if(result > 0) {
			return true;
		}
		return false;
	}
	// view의 selectBoardList요청을 담당할 메서드

	public List<Board> selectBoardList() {
		return bService.selectBoardList();
		
	}

	
	// view의 selectBoard요청을 담당할 메서드
	
	// view의 insertBoard요청을 담당할 메서드
	public int insertBoard(String memberId, String title, String content) {
		Board b =new Board();
		b.setTitle(title);
		b.setContent(content);
		b.setWriter(memberId);
		
		int result = bService.insertBoard(b);
		
		return result;
		
	}
	
	// view의 updateBoard요청을 담당할 메서드
	
	// view의 deleteBoard요청을 담당할 메서드
	
	
			
}
