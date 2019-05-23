package myblog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myblog.model.DataRoom;
import myblog.model.DataRoomDao;

public class UpdateProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		DataRoomDao dao = DataRoomDao.getInstance();
		int num = 0;
		int pageNum = 0;
		String tmpContent = null;
		String tmpTitle = null;
		DataRoom dr = null;
		
		try {
		num = Integer.parseInt(request.getParameter("num"));
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		tmpContent = request.getParameter("content");
		tmpTitle = request.getParameter("title");
		dr = dao.updateGetArticle(num);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dr.setContent(tmpContent);
		dr.setTitle(tmpTitle);
		int check = dao.updateArticle(dr);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		return "/databoard/updatePro.jsp";
	}
}
