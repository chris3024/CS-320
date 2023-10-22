/*Christopher Sharp
* CS:320 - Software Test Automation & QA
* Dr. Kyle Morton
* September 13, 2023
*/




package modules;

public class Contact {

	// Creating the variables with contactID not being updatable after set
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Defining 
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		
		// Asserting 
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact Id");
		}
		
		//
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		//
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		//
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		//
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// Setting the information after checks have been run
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	

	// setters
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// getters
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
	
	
	
}
