package contactService;

import java.util.ArrayList;
import java.math.BigInteger;
import java.util.UUID;

import contact.Contact;

public class ContactService {
	private String contactId = generateId();
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	private String generateId() {
		//generate random UUID
		//convert to string with length of 10 
		String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
		return generateUUIDNo.substring( generateUUIDNo.length() - 10);
	}
	
	public String getContactId() {
		return contactId;
	}
	
	private Contact findContact(String contactId) {
		int index = 0;
		while (index < contactList.size()) {
			if (contactId.equals(contactList.get(index).getContactId())) {
				return contactList.get(index);
			} else {
				index++;
			}
		}

		throw new IllegalArgumentException("contact not found") ; 
	}
	
	private boolean matchContactId(String contactId) {
		int index = 0;
		while (index < contactList.size()) {
			if (contactId.equals(contactList.get(index).getContactId())) {
				return true;
			} else {
				index++;
			}
		}
		return false; 
	}
	
	public ArrayList<Contact> getContactList() {
		return contactList;
	}
	
	public void addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		if (!matchContactId(contactId)) {
			Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
			contactList.add(contact);
		} else {
			contactId = generateId();
		}	
	}
	
	public void deleteContact(String contactId) throws Exception {
		contactList.remove(findContact(contactId));
	}
	
	public void updateFirstName(String contactId, String firstName) throws Exception {
		findContact(contactId).setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) throws Exception {
		findContact(contactId).setLastName(lastName);	
	}

	public void updatePhoneNumber(String contactId, String phoneNumber) throws Exception {
		findContact(contactId).setPhoneNumber(phoneNumber);	
	}
	
	public void updateAddress(String contactId, String address) throws Exception {
		findContact(contactId).setAddress(address);
	}
}
