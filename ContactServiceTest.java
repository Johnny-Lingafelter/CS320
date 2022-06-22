package cs320;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ContactServiceTest {
	
	@Test
	public void addContactTest() throws Exception {
		ContactService service = new ContactService();
		
		service.addContact("00001");
		service.addContact("00002", "Joe", "Montana", "1982909999", "Football City");
		service.addContact("00003");
		service.addContact("00004", "Pat", "Benetar", "1234567890", "Unknown");
		service.addContact("00005");
		
		assertAll( // test that five contacts were added with the correct IDs
			"Add Contact",
				() -> assertEquals(service.getNumContacts(), 5),
				() -> assertEquals(service.getContactByID("00001").getContactID(), "00001"),
				() -> assertEquals(service.getContactByID("00002").getContactID(), "00002"),
				() -> assertEquals(service.getContactByID("00003").getContactID(), "00003"),
				() -> assertEquals(service.getContactByID("00004").getContactID(), "00004"),
				() -> assertEquals(service.getContactByID("00005").getContactID(), "00005")
		);
		
		// test that adding a new contact with an existing ID throws an error
		assertThrows(Exception.class, () -> service.addContact("00001"));
	}
	
	@Test
	public void deleteContactTest() throws Exception {
		ContactService service = new ContactService();
		
		service.addContact("00001");
		service.addContact("00002", "Joe", "Montana", "1982909999", "Football City");
		
		service.deleteContact("00001");
		
		assertAll(
			"delete contact",
				() -> assertEquals(service.getNumContacts(), 1), // contact list length should be 1
				() -> assertEquals(service.getContactByIndex(0).getContactID(), "00002"), // first contact should be
				() -> assertThrows(Exception.class, () -> service.deleteContact("00001")) // test deleting non-existent ID
		);
	}
	
	@Test
	public void updateContactTest() throws Exception {
		ContactService service = new ContactService();
		
		service.addContact("00001");
		
		service.updateFirstName("00001", "Jeff");
		service.updateLastName("00001", "Bridges");
		service.updateNumber("00001", "9998887777");
		service.updateAddress("00001", "Hollywood Blvd, CA");
		
		Contact c = service.getContactByIndex(0);
		
		assertAll(
			"update contact",
				() -> assertEquals(c.getFirstName(), "Jeff"),
				() -> assertEquals(c.getLastName(), "Bridges"),
				() -> assertEquals(c.getNumber(), "9998887777"),
				() -> assertEquals(c.getAddress(), "Hollywood Blvd, CA")
		);
		
		assertAll(
			"bad ID update contact",
				() -> assertThrows(Exception.class, () -> service.updateFirstName("01", "123")),
				() -> assertThrows(Exception.class, () -> service.updateLastName("abcd", "123")),
				() -> assertThrows(Exception.class, () -> service.updateNumber(null, "123")),
				() -> assertThrows(Exception.class, () -> service.updateAddress("99999999", "123"))
		);
	}
}
