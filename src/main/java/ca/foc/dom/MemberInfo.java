package ca.foc.dom;
/**
 * Class to send member information only include email, firstname and lastname
 * @author Claudia Rivera
 * Date: 04-04-202
 *
 */
public class MemberInfo {
	private String email;
	private String firstName;
	private String lastName;
	
	
	public MemberInfo() {
		
	}

	public MemberInfo(String email, String firstName, String lastName) {
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
