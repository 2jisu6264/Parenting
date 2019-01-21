package calendar;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class EventControl extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		EventDAO dao = new DBEventDAO();
		String address = null;
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		if(action == null || action.equals("list")) {
			ArrayList<EventBean> list = dao.getAllEvent();
			request.setAttribute("eventlist", list);
			address = "/ch08/eventview_list.jsp";
		}else if(action.equals("view")) {
			EventBean event = dao.getEvent(request.getParameter("fairid"));
			request.setAttribute("event", event);
			address = "/ch08/eventview_view.jsp";
		}else if(action.contentEquals("add")) {
			EventBean event = new EventBean();
			event.setId(Integer.parseInt(request.getParameter("fairid")));
			event.setName(request.getParameter("fairname"));
			event.setDate(request.getParameter("fairdate"));
			event.setPlace(request.getParameter("fairplace"));
			dao.addEvent(event);
			request.setAttribute("event", event);
			address = "/ch08/eventview_add.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}
