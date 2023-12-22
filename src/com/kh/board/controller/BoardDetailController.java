package com.kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * boardTitle   => 글제목
		 * boardNo 	    => 작성자
		 * count 	    => 조회수
		 * createDate   => 작성일
		 * boardContent => 글내용
		 * 
		 * */
		BoardService service = new BoardServiceImpl();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		HttpSession session = request.getSession();
		 
		// 1. 조회수 증가서비스 호출
		int result = service.increaseCoint(bno);
		// 2. 게시글 상세조회서비스 호출
		if(result > 0) {
			Board b = service.selectBoard(bno);
			
			//request에 데이터 추가
			request.setAttribute("b", b);
			System.out.println(b);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
		}else {
			//게시글 상세조회 실패시 목록 페이지로 리다이렉트
			session.setAttribute("alertMsg", "게시글 상세조회 실패");
			response.sendRedirect("list.bo?currentPage=1");
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
