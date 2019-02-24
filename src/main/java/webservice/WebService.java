package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CustomerDAO;
import dao.RoomDAO;
import model.Customer;
import model.Room;
import service.CustomerService;

public class WebService {
	
	public static void register (HttpServletRequest request, HttpServletResponse response)
	{
		String first_name = request.getParameter("first");
		String last_name = request.getParameter("last");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone#");
		String address = request.getParameter("address");
		String hashedPassword = CustomerService.HashPassword(password);
		Customer c = new Customer(0, first_name, last_name, username, hashedPassword, email, phone_number, address);
		CustomerService.addUser(c);	
		ObjectMapper om = new ObjectMapper();
		try
		{
			String message = "You have registered";
			String jsonString = om.writeValueAsString(message);
			response.getWriter().append(jsonString).close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void makeAReservation(HttpServletRequest request, HttpServletResponse response)
	{
		String start_date = request.getParameter("start_Date");
		String end_date = request.getParameter("end Date");
		String rooms = request.getParameter("rooms");
		String[] roomsArray = rooms.split(",");
		ArrayList<Room> roomList = new ArrayList<Room>();
		JSONObject room = new JSONObject(rooms);
		for(int index = 0; index < roomsArray.length; index++)
		{
			String room_id = room.getString("room_id");
			String number_of_beds = room.getString("number_of_beds");
			Room roomObj = new Room(Integer.parseInt(room_id), Byte.parseByte(number_of_beds);
			roomList.add(roomObj);
		}
		ObjectMapper om = new ObjectMapper();
		try
		{
			String message = "You have made a reservation";
			String jsonString = om.writeValueAsString(message);
			response.getWriter().append(jsonString).close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void getAllReservations(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
	
	public static void login(HttpServletRequest request, HttpServletResponse response)
	{
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String hashedPassword = CustomerService.HashPassword(password);
		boolean loggedIn = CustomerService.Login(username, hashedPassword);
		ObjectMapper om = new ObjectMapper();
		if(loggedIn == true)
		{
			try
			{
				String message = "You have logged in";
				String jsonString = om.writeValueAsString(message);
				response.getWriter().append(jsonString).close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}	
		} else 
		{
			try
			{
				String message = "Unsuccessful logon attempt";
				String jsonString = om.writeValueAsString(message);
				response.getWriter().append(jsonString).close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}	
		}
	}
	
	public static void getAvailableRooms(HttpServletRequest request, HttpServletResponse response)
	{
		String start_date = request.getParameter("start_Date");
		String end_date = request.getParameter("end_Date");
		RoomDAO rd = new RoomDAO();
		ArrayList<Room> al = new ArrayList<Room>();
		//al = rd.getAvailableRooms();
		ObjectMapper om = new ObjectMapper();
		try
		{
			String jsonString = om.writeValueAsString(al);
			response.getWriter().append(jsonString).close();
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
