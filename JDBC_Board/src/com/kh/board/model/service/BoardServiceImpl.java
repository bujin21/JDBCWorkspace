package com.kh.board.model.service;

import static com.kh.board.model.template.JDBCTemplate.close;
import static com.kh.board.model.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Member;
// BoardService 인터페이스를 구현하는 클래스.
// 각 메서드의 설명에 맞게 기능을 작성.
public class BoardServiceImpl implements BoardService{
	
	private BoardDao bDao = new BoardDao();
	@Override
	public int login(String memberId, String memberPwd) {
		Connection conn = getConnection();
		Member m = bDao.login(conn, memberId,memberPwd);
		if(m != null) {
			close(conn);
			return 1;
		}
		close(conn);
		return 0;
	}

	@Override
	public int insertBoard(Board b) {
		int result = 0;
		
		Connection conn = getConnection();
		result = bDao.insertBoard(conn, b);
		close(conn);
		return result;
	}

	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(int boardNo, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
