package myblog.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myblog.Comment;
import myblog.model.DataRoom;
import myblog.model.DataRoomDao;

public class ContentAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		DataRoomDao dao = DataRoomDao.getInstance();
		int num = 0;
		int pageNum = 0 ;
		String userID = null;
		DataRoom article = null;
		ArrayList<Comment> commentList = null;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			article = dao.getArticle(num);
			commentList = dao.getCommentList(num);
		}catch(Exception e) {e.printStackTrace();}
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		request.setAttribute("commentList" , commentList);
		return "/databoard/content.jsp";
	}
}
