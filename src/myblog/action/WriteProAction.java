package myblog.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myblog.model.DataRoom;
import myblog.model.DataRoomDao;

public class WriteProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			HttpSession session = request.getSession();
			String userID = null;
			String title = null;
			String content = null;
			
			DataRoom dr = new DataRoom();
			if(session.getAttribute("userID") !=null)
				userID = (String)session.getAttribute("userID");
			try {
				dr.setTitle(request.getParameter("title"));
				dr.setContent(request.getParameter("content"));
			}catch(Exception e) {e.printStackTrace();}
			dr.setId(userID);
			dr.setReadcount(0);
			dr.setRegdate( new Timestamp(System.currentTimeMillis()));
			DataRoomDao dbPro = DataRoomDao.getInstance();
			dbPro.insertArticle(dr);
			return "/databoard/writePro.jsp";
	}
}
