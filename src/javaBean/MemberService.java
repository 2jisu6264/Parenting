package javaBean;
import javaBean.javaDao;
import javaBean.SimpleBean;

public class MemberService {
	javaDao dao = new javaDao();
	
	public void iventInsert(SimpleBean SimpleBean) {
		dao.insertIvent(SimpleBean);
	}
}
