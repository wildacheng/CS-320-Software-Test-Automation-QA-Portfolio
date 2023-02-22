package testContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.ContactService;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		assertAll("add contact",
				() -> assertNotNull(service.getContactList().get(0).getContactId()),
				() -> assertEquals("Wilda", service.getContactList().get(0).getFirstName()),
				() -> assertEquals("Cheng", service.getContactList().get(0).getLastName()),
				() -> assertEquals("6461238888", service.getContactList().get(0).getPhoneNumber()),
				() -> assertEquals("123 W, New York, NY 11233", service.getContactList().get(0).getAddress())
				);
		service.addContact("ABC123", "Wilda", "Cheng", "0123456789", "123 West, NY, 13355");
		assertNotSame("ABC123", service.getContactId());
	}
	
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.deleteContact("XYZ123"));
		assertAll("delete contact", 
				() -> service.deleteContact(
				service.getContactList().get(0).getContactId()));
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("XYZ123", "Linda"));
		assertAll("update first name",
				() -> service.updateFirstName(service.getContactList().get(0).getContactId(), "Linda"),
				() -> assertEquals("Linda", service.getContactList().get(0).getFirstName())
				);
	}
	
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateLastName("XYZ123", "Zheng"));
		assertAll("update last name",
				() -> service.updateLastName(service.getContactList().get(0).getContactId(), "Zheng"),
				() -> assertEquals("Zheng", service.getContactList().get(0).getLastName())
				);
	}
	
	@Test
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("XYZ123", "6463218888"));
		assertAll("update phone number",
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), "6463218888"),
				() -> assertEquals("6463218888", service.getContactList().get(0).getPhoneNumber())
				);
	}
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("ABC123", "Wilda", "Cheng", "6461238888", "123 W, New York, NY 11233");
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateAddress("XYZ123", "321 N, New York, NY 11233"));
		assertAll("update address",
				() -> service.updateAddress(service.getContactList().get(0).getContactId(), "321 N, New York, NY 11233"),
				() -> assertEquals("321 N, New York, NY 11233", service.getContactList().get(0).getAddress())
				);
	}

}
