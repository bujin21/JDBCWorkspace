package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;
import com.kh.board.view.BoardView;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {
	
	// service 변수 선언 및 초기화
	private BoardServiceImpl bService = new BoardServiceImpl();
	
	// view의 login요청을 담당할 메서드
	public int login(String id, String pwd) {
		int login = bService.login(id, pwd);
		return login;
	}
	// view의 selectBoardList요청을 담당할 메서드

	public void selectBoardList() {
		List<Board> list = bService.selectBoardList();
		
		if(list.isEmpty()) {
			new BoardView().displayNodata("보드에 작성된 결과가 없습니다.");
		}else {
			new BoardView().displayList(list);
		}
		
	}

	
	// view의 selectBoard요청을 담당할 메서드
	
	// view의 insertBoard요청을 담당할 메서드
	public void insertBoard(String memberId, String title, String content) {
		Board b =
				new Board(1, title, content, null, memberId, "N");
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			new BoardView().displaySuccess("보드 추가 성공");
		}else {
			new BoardView().displayFail("보드 추가 실패");
		}
		
	}
	
	// view의 updateBoard요청을 담당할 메서드
	
	// view의 deleteBoard요청을 담당할 메서드
	
	
			
}
