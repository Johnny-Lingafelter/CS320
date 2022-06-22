package cs320;

import java.util.*;

public class ContactService {
	
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public void addContact(String contactID) throws Exception {
		if (_contactExists(contactID))
			throw new Exception("Contact ID already in use.");
		else
			contacts.add(new Contact(contactID));
	}

	public void addContact(String contactID, String firstName, String lastName, String number, String address) throws Exception {
		if (_contactExists(contactID))
			throw new Exception("Contact ID already in use.");
		else
			contacts.add(new Contact(contactID, firstName, lastName, number, address));
	}
	
	public void deleteContact(String contactID) throws Exception {
		contacts.remove(_findContact(contactID));
	}
	
	public void updateFirstName(String contactID, String firstName) throws Exception {
		_findContact(contactID).setFirstName(firstName);
	}
	
	public void updateLastName(String contactID, String lastName) throws Exception {
		_findContact(contactID).setLastName(lastName);
	}

	public void updateNumber(String contactID, String number) throws Exception {
		_findContact(contactID).setNumber(number);
	}

	public void updateAddress(String contactID, String address) throws Exception {
		_findContact(contactID).setAddress(address);
	}
	
	public Contact getContactByIndex(int index) {
		return contacts.get(index);
	}

	public Contact getContactByID(String contactID) throws Exception {
		return _findContact(contactID);
	}
	
	public int getNumContacts() {
		return contacts.size();
	}

	private Contact _findContact(String contactID) throws Exception {
		for (Contact c : contacts) {
			if (c.getContactID() == contactID) {
				return c;
			}
		}
		throw new Exception("Contact not found.");
	}
	
	private boolean _contactExists(String contactID) {
		for (Contact c : contacts) {
			if (c.getContactID() == contactID) {
				return true;
			}
		}
		return false;
	}
}
