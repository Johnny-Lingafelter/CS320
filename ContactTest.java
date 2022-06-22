package cs320;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ContactTest {

	private String contactID, firstName, lastName, number, address;
	private String badContactID, badFirstName, badLastName, badNumber, badAddress;
	
	@BeforeEach
	public void init() {
		contactID = "0123456789";
		badContactID = "01234567891111111111";
		firstName = "Jane";
		badFirstName = null;
		lastName = "Doe";
		badLastName = "Lingafelter";
		number = "8883925567";
		badNumber = "444hi";
		address = "21 Rice Hill, Sup, AK 10101";
		badAddress = "214 Evergreen Terrace, Anytown, AK 10101";
	}
	
	@Test
	public void defaultConstructorTest() {
		Contact c = new Contact();
		assertAll( // test that all members are not null
			"Default Constructor",
				() -> assertNotNull(c.getContactID()),
				() -> assertNotNull(c.getFirstName()),
				() -> assertNotNull(c.getLastName()),
				() -> assertNotNull(c.getNumber()),
				() -> assertNotNull(c.getAddress())
		);
	}

	@Test
	public void idOnlyConstructorTest() {
		Contact c = new Contact(contactID);
		assertAll( // test that contactID is set and other members are not null
			"contactID only Constructor",
				() -> assertEquals(contactID, c.getContactID()),
				() -> assertNotNull(c.getFirstName()),
				() -> assertNotNull(c.getLastName()),
				() -> assertNotNull(c.getNumber()),
				() -> assertNotNull(c.getAddress())
		);
		
		// test that exceptions for illegal arguments are thrown
		assertThrows(IllegalArgumentException.class, () -> new Contact(badContactID));
		assertThrows(IllegalArgumentException.class, () -> new Contact(null));
	}
	
	@Test
	public void allArgsConstructorTest() {
		Contact c = new Contact(contactID, firstName, lastName, number, address);
		assertAll(
			"All arguments constructor test",
				() -> assertEquals(contactID, c.getContactID()),
				() -> assertEquals(firstName, c.getFirstName()),
				() -> assertEquals(lastName, c.getLastName()),
				() -> assertEquals(number, c.getNumber()),
				() -> assertEquals(address, c.getAddress())
		);
		
		assertAll(
			"Bad arguments full constructor test",
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(badContactID, firstName, lastName, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, badFirstName, lastName, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, badLastName, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, lastName, badNumber, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, lastName, number, badAddress))
		);

		assertAll(
			"Null arguments full constructor test",
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(null, null, null, null, null)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(null, firstName, lastName, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, null, lastName, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, null, number, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, lastName, null, address)),
				() -> assertThrows(IllegalArgumentException.class,
					() -> new Contact(contactID, firstName, lastName, number, null))
		);
	}
	
	@Test
	public void updateTest() {
		Contact c = new Contact(contactID);
		c.setFirstName(firstName);
		assertAll(
			"update firstName test",
				() -> assertEquals(firstName, c.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setFirstName(badFirstName))
		);
		c.setLastName(lastName);
		assertAll(
			"update lastName test",
				() -> assertEquals(lastName, c.getLastName()),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setLastName(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setLastName(badLastName))
		);
		c.setNumber(number);
		assertAll(
			"update number test",
				() -> assertEquals(number, c.getNumber()),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setNumber(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setNumber(badNumber))
		);
		c.setAddress(address);
		assertAll(
			"update address test",
				() -> assertEquals(address, c.getAddress()),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setAddress(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> c.setAddress(badAddress))
		);
	}
}
