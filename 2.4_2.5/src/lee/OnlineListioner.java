package lee;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListioner implements HttpSessionListener {

	private int userNumber = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		userNumber++;
		arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		userNumber--;
		arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);
		ArrayList<Person> userList = null;
		userList = (ArrayList<Person>)arg0.getSession().getServletContext().getAttribute("userList");
		if(getUserBySessionId(userList, arg0.getSession().getId())!=null){
			userList.remove(getUserBySessionId(userList, arg0.getSession().getId()));
		}
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
