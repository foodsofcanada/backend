package ca.foc.dom;

public class MemberResponse {
	
	private boolean isExist;
	private String firstName;
	private String lastName;
	
	public MemberResponse() {
		
	}

	public MemberResponse(boolean isExist, String firstName, String lastName) {
		super();
		this.isExist = isExist;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean getIsExist() {
		return isExist;
	}

	public void setIsExist(boolean isExist) {
		this.isExist = isExist;
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
