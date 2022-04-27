/**
 * Contact - Bean
 */
package data;

/**
 * @author J. Ismail
 *
 */
public class Contact {
	
	private String name;
	private String email;
	private String phone;
	private int id;
	
	private int length = 30;
	
	/**
	 * Default Constructor
	 */
	public Contact() {
		name = "";
		email = "";
		phone = "";
		id = 0;
	}
	
	/**
	 * Take a Name and Email
	 * @param n String - Name
	 * @param e String - Email
	 */
	public Contact(String n, String e) {
		if(n.length() > length) {
			name = n.substring(0, length);
			System.out.println("new name:> " + name);
			System.out.println("name length:> " + name.length());
		}else
			this.name = n;
		
		this.email = e;
	}

	/**
	 * 
	 * @param id int
	 * @param n String 
	 * @param e String
	 */
	public Contact(int id, String n, String e) {
//		this.name = n;
//		this.email = e;
		this(n, e);
		this.id = id;
	}
	
	

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String na) {
		if(na.length() > length) {
			na = na.substring(0, length);
		}
		this.name = na;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
