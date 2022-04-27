
package data;

/**
 * Pass: Bean
 * the password info
 * @author J. Ismail
 *
 */
public class Pass {

	private int id;
	private String title;
	private String loginid;
	private String password;
	private String notes;
	
	public Pass() {
		id = 0;
		title = "";
		loginid = "";
		password = "";
		notes = "";
	}
	
	/**
	 * 
	 * @param x int ID
	 * @param t String Title
	 * @param loginid String LoginID
	 * @param p String Password
	 */
	public Pass(int x, String t, String loginid, String p) {
		this.id = x;
		this.title = t;
		this.loginid = loginid;
		this.password = p;
	}


	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}


	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Pass [title=" + title + ", loginid=" + loginid + ", password=" + password + "]";
	}
	
	
}
