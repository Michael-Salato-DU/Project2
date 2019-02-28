package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.WebService;

public class RequestHelper 
{
	public static void process(HttpServletRequest request, HttpServletResponse response)
	{
		String uri = request.getRequestURI();
		System.out.println("GOING INTO SWITCH STATEMENT");
		switch(uri)
		{
			case "/Project2/register.do" : {WebService.register(request, response);break;}
			case "/Project2/login.do" : {WebService.login(request, response);break;}
			case "/Project2/makeAReservation.do" : {WebService.makeAReservation(request, response);break;}
			case "/Project2/getAvailableRooms.do" : {WebService.getAvailableRooms(request, response);break;}
			case "/Project2/getAllReservationsByCustomerId.do" : {
				System.out.println("IN SWITCH STATEMENT");
				WebService.getAllReservationsByCustomerId(request, response); break;}
		}
	}
}
