package lee;

import java.util.ArrayList;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	private ArrayList<Person> userList;
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		
		userList  = (ArrayList<Person>)arg0.getServletContext().getAttribute("userList");

		if(userList==null)
			userList = new ArrayList<Person>();
		
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String sessionId = request.getSession().getId();
		
		if(getUserBySessionId(userList,sessionId)==null){
			Person p = new Person();
			p.setSessionId(sessionId);
			userList.add(p);
		}
		
		arg0.getServletContext().setAttribute("userList", userList);
	}
	
	public Person getUserBySessionId(ArrayList<Person> userList, String sessionIdString) {
		for (int i = 0; i < userList.size(); i++) {
			Person user = userList.get(i);
			if (user.getSessionId().equals(sessionIdString)) {
				return user;
			}
		}
		return null;
	}

}
