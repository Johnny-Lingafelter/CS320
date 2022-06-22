package cs320;

public class Contact {

	private String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	/*
	 *  Default Constructor
	 *  	Initialize all members with empty string
	 */
	public Contact() {
		this.contactID = "";
		this.firstName = "";
		this.lastName = "";
		this.number = "";
		this.address = "";
	}
	
	/*
	 *  Constructor - set contactID and initialize other members with empyty string
	 *  	+ contactID - a string containing the contact ID of the contact to be created
	 */
	public Contact(String contactID) {
		_setContactID(contactID);
		this.firstName = "";
		this.lastName = "";
		this.number = "";
		this.address = "";
	}
	
	/*
	 *  Constructor
	 *  	+ contactID - a string containing the contact ID of the contact to be created
	 *  	+ firstName - a string containing the first name of the contact
	 *  	+ lastName - a string containing the last name of the contact
	 *  	+ number - a string containing the phone number of the contact
	 *  	+ address - a string containing the address of the contact
	 */
	public Contact(String contactID, String firstName, String lastName, String number, String address) {
		_setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
	}
	
	/* getters */
	public String getContactID() { return this.contactID; }
	
	public String getFirstName() { return this.firstName; }
	
	public String getLastName() { return this.lastName; }

	public String getNumber() { return this.number; }
	
	public String getAddress() { return this.address; }

	/* setters */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Argument is null or exceeds length limit.");
		}
		else {
			this.firstName = firstName;
		}
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Argument is null or exceeds length limit.");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	public void setNumber(String number) {
		if (number == null || number.length() != 10 || !number.matches("[0-9]+")) {
			throw new IllegalArgumentException("Argument is null, contains non-digit chars, or is not exactly 10 characters.");
		}
		else {
			this.number = number;
		}
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Argument is null or exceeds length limit.");
		}
		else {
			this.address = address;
		}
	}
	
	private void _setContactID(String contactID) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Argument is null or exceeds length limit.");
		}
		else {
			this.contactID = contactID;
		}
	}
}