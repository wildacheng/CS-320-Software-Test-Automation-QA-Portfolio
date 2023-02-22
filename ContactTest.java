package testContact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	//contact class
	@Test
	void testContactClass() {
		Contact contact = new Contact("ABC0012345", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");
		assertAll("contact class",
				() -> assertEquals("ABC0012345", contact.getContactId()),
				() -> assertEquals("Wilda", contact.getFirstName()),
				() -> assertEquals("Cheng", contact.getLastName()),
				() -> assertEquals("6461112345", contact.getPhoneNumber()),
				() -> assertEquals("1 North, Queens, NY 01234", contact.getAddress()),
				() -> assertNotNull(contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress())
				);
	}
	
	//contact inputs must be in required length range
	@Test
	void testContactInputsToLong() {
		assertAll("all required contact inputs should not be too long",
				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("ABC00123456", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("ABC0012345", "Wilda123456", "Cheng", "6461112345", "1 North, Queens, NY 01234");}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("ABC0012345", "Wilda", "Cheng123456", "6461112345", "1 North, Queens, NY 01234");}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("ABC0012345", "Wilda", "Cheng", "64611123456", "1 North, Queens, NY 01234");}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("ABC00123456", "Wilda", "Cheng", "6461112345", "123 South Ocean Breeze, Fort Lauderdale, Florida 01234");})
				);
	}
	
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("ABC0012345", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");
		contact.setFirstName("Linda");
		assertAll("first name",
				() -> assertEquals("Linda", contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setFirstName(null);}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setFirstName("Linda123456");})
				);
	}
	
	@Test
	void testSetLastName() {
		Contact contact = new Contact("ABC0012345", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");
		contact.setLastName("Zheng");
		assertAll("last name",
				() -> assertEquals("Zheng", contact.getLastName()),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setLastName(null);}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setLastName("Zheng123456");})
				);
	}
	
	@Test
	void testSetPhoneNumber() {
		Contact contact = new Contact("ABC0012345", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");
		contact.setPhoneNumber("9191234567");
		assertAll("phone number",
				() -> assertEquals("9191234567", contact.getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setPhoneNumber(null);}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setPhoneNumber("19191234567");})
				);
	}
	
	@Test
	void testSetAddress() {
		Contact contact = new Contact("ABC0012345", "Wilda", "Cheng", "6461112345", "1 North, Queens, NY 01234");
		contact.setAddress("357 West, Queens, NY 01234");
		assertAll("address",
				() -> assertEquals("357 West, Queens, NY 01234", contact.getAddress()),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setAddress(null);}),
				() -> assertThrows(IllegalArgumentException.class, () -> {
					contact.setAddress("123 South Ocean Breeze, Fort Lauderdale, Florida 01234");})
				);
	}
}
