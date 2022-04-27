package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DB;
import data.Contact;
import data.ContactDAO;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DB db;
	
	private ContactDAO cd;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Servlet init
    public void init() {
    	db = new DB();
		 cd = new ContactDAO(db);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		
		String c = request.getContextPath();
		String action = request.getServletPath();
		System.out.println("Context Path: " + c);
		System.out.println("Servlet Path: " + action);
		
		switch(action) {
		case "/listall.jsp":
			listall(request, response);
			break;
		case "/delete":
			delete(request, response);
			break;
		case "/add":
			add(request, response);
			break;
		case "/update":
			update(request, response);
			break;
		case "/addpass":
			addpass(request, response);
			break;
		default:
			listall(request, response);
			break;
		}
		
		
		
		
		
//		String listing = "";
//		ArrayList<Contact> contacts   =  cd.getContacts();
//		if(contacts.isEmpty()) {
//			System.out.println("contacts is empty");
//			listing = "empty";
//			request.setAttribute("listing", listing);
//		}else {
//			System.out.println("contacts NOT empty");
//			listing = "not empty";
//			int size = contacts.size();
//			request.setAttribute("listing", listing);
//			request.setAttribute("contacts", contacts);
//			request.setAttribute("size", size);
//		}
//		System.out.println("Name length: " + name.length() );
//		name = name.substring(0, 5); // make a new name string of length 5, so it will only have 5 characters
//		System.out.println("Name: " + name);
//		System.out.println("Email: " + email);
		
//		if( db.addContact(name, email)) {
//			// add to DB was success
//			String message = "Success adding Contact to DB";
//			request.setAttribute("message", message);
//		}else {
//			String message = "Failed to add Contact to DB";
//			request.setAttribute("message", message);
//		}
		
//		db.close();
//		
//		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// list all contacts
	private void listall(HttpServletRequest request, HttpServletResponse response) {
		
			String listing = "";
			ArrayList<Contact> contacts   =  cd.getContacts();
			if(contacts.isEmpty()) {
				System.out.println("contacts is empty");
				listing = "empty";
				request.setAttribute("listing", listing);
			}else {
				System.out.println("contacts NOT empty");
				listing = "not empty";
				int size = contacts.size();
				request.setAttribute("listing", listing);
				request.setAttribute("contacts", contacts);
				request.setAttribute("size", size);
			}
			
			db.close();
			
			
			try {
				RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	// delete a contact
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		int xid = 0;
		if(id != null) {
			id = id.strip().stripLeading();
			xid = Integer.parseInt(id);
		}
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println("Name length: " + name.length() );
		Contact contact = null;
		
		if(xid == 0) {
			contact = new Contact(name, email);
			contact.setPhone(phone);
		}else {
			contact = new Contact(xid, name, email);
			contact.setPhone(phone);
		}
		
		
			System.out.println("Delete called");
			if(cd.deleteContact(contact)) {
				String message = "Success Deleted Contact from DB: " + name;
				request.setAttribute("message", message);
				
			}else {
				String message = "failed to delete Contact from DB: " + name;
				request.setAttribute("message", message);
			}
		
			listall(request, response);
	}
	
	// add a contact
	private void add(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println("Name length: " + name.length() );
		Contact contact = new Contact(name, email);
		contact.setPhone(phone);
		
			if( cd.add(contact)) {
				// add to DB was success
				String message = "Success adding Contact to DB";
				request.setAttribute("message", message);
				listall(request, response);
			}else {
				String message = "Failed to add Contact to DB";
				request.setAttribute("message", message);
				listall(request, response);
			}				
		
	}
	
	// update a contact
	private void update(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		System.out.println("Name length: " + name.length() );
		Integer xid = Integer.parseInt(id.strip().trim());
		Contact contact = new Contact(xid.intValue(), name, email);
		contact.setPhone(phone);
		
		System.out.println("Update called");
			if(cd.updateContact(contact)) {
				String message = "Success Updating Contact in DB: " + contact.getName();
				request.setAttribute("message", message);
			}else {
				String message = "Failed Updating Contact in DB: " + contact.getName();
				request.setAttribute("message", message);
			}
		
			db.close();
			
			listall(request, response);			
	}
	
	
	// add a password
	private void addpass(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
