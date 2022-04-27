package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DB;

public class ContactDAO {
	
	private DB db; // handle to the Database DB
	
	public ContactDAO() {
		
	}

	public ContactDAO(DB db) {
		this.db = db;
	}
	
	
	public boolean addContact(Contact c) {
		
		String sql = "insert into contacts(name, email, phone) value(?, ?, ?)";
		boolean ok = false;
		
		try {
			Connection con = db.getConnection();
			if(con.isClosed()) {
				db.open();
				con = db.getConnection();
			}
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPhone());
			
			ok = pst.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.err.println("Failed to add Contact");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}
	
	
	public boolean add(Contact c) {
		return addContact(c);
	}
	
	
	public boolean deleteContact(Contact c) {
		boolean ok = false;
		System.out.println("Contact to delete: " + c.getId() + " " + c.getName());
		
		String sql = "delete from contacts where id=?";
		
		try {
			Connection con = db.getConnection();
			if(con.isClosed()) {
				db.open();
				con = db.getConnection();
			}
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, c.getId());
			ok = pst.executeUpdate() > 0;
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return ok;
	}
	
	
	public boolean updateContact(Contact c) {
		boolean ok = false;
		
		String sql = "update contacts set name=?, email=?, phone=? where id=?";
		System.out.println("Update Contact:>> " + c);
		try {
			Connection con = db.getConnection();
			if(con.isClosed()) {
				db.open();
				con = db.getConnection();
			}
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPhone());
			pst.setInt(4, c.getId());
			ok = pst.executeUpdate() > 0;
		}catch(SQLException s) {
			System.err.println("Error updating Contact: ");
			s.printStackTrace();
		}
		
		return ok;
	}
	
	// get a listing of all contacts in DB
	public ArrayList<Contact> getContacts() {
		ArrayList<Contact> ct =  new ArrayList<Contact>();
		
		String sql = "select * from contacts order by name";
		Connection con = db.getConnection();
		try {
			if(con.isClosed()) {
				db.open();
				con = db.getConnection();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Statement st = con.createStatement();
			int id;
			String name, email, phone;
			Contact c;
			ResultSet rs = st.executeQuery(sql);
//			if(rs.next() ) { // check if we have a result set
//				rs.beforeFirst(); // move to before first
				while(rs.next()) {
					id = rs.getInt("id");
					name = rs.getString("name");
					email = rs.getString("email");
					phone = rs.getString("phone");
					c = new Contact(id, name, email);
					c.setPhone(phone);
					//System.out.println("DB contact: " + c);
					ct.add(c);
				}
			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
}
