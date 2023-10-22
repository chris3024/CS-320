package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.ContactService;

class ContactServiceTest {
	

	@Test
	void testAddContact() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1224567890", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		assertEquals("Chris", ContactService.contactList.get(0).getFirstName());
		assertEquals("Jack", ContactService.contactList.get(1).getFirstName());
		//contactService.displayContacts();
	}
	
	@Test
	void testUniqueId() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1224567890", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		assertTrue(ContactService.contactList.get(0).getContactId() != ContactService.contactList.get(1).getContactId());
		assertTrue(ContactService.contactList.get(1).getContactId() != ContactService.contactList.get(2).getContactId());
	}
	
	@DisplayName("Test Contact Deletion")
	@Test
	void testContactDeletion() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1224567890", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		assertEquals(3,ContactService.contactList.size());
		
		String contactId = ContactService.contactList.get(0).getContactId();
		contactService.deleteContact(contactId);
		
		assertEquals(2, ContactService.contactList.size());
		
		//contactService.displayContacts();
	}
	
	@DisplayName("Updating First Name")
	@Test
	void testUpdatingFirstName() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1112223335", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		String contactId = ContactService.contactList.get(0).getContactId();
		
		assertEquals("Chris", ContactService.contactList.get(0).getFirstName());
		contactService.updateFirstName(contactId, "Jason");
		
		assertEquals("Jason", ContactService.contactList.get(0).getFirstName());
		
		//contactService.displayContacts();
		
	}
	
	@DisplayName("Updating Last Name")
	@Test
	void testUpdatingLastName() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1112223335", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		String contactId = ContactService.contactList.get(0).getContactId();
		
		assertEquals("Sharp", ContactService.contactList.get(0).getLastName());
		contactService.updateLastName(contactId, "Bourne");
		
		assertEquals("Bourne", ContactService.contactList.get(0).getLastName());
		
		//contactService.displayContacts();
		
	}
	
	@DisplayName("Updating Phone Number")
	@Test
	void testUpdatingPhoneNumber() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1112223335", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		String contactId = ContactService.contactList.get(0).getContactId();
		
		assertEquals("1112223334", ContactService.contactList.get(0).getPhoneNumber());
		contactService.updatePhoneNumber(contactId, "1111111111");
		
		assertEquals("1111111111", ContactService.contactList.get(0).getPhoneNumber());
		
		//contactService.displayContacts();
		
	}
	
	@DisplayName("Updating Address")
	@Test
	void testUpdatingAddress() {
		ContactService contactService = new ContactService();
		
		ContactService.contactList.clear();
		contactService.addContact("Chris", "Sharp", "1112223334", "1118 James St.");
		contactService.addContact("Jack", "Skelly", "1112223335", "125 Pumpkin Way");
		contactService.addContact("Betty", "Sanderson", "1234567890", "125 Witchy Dr");
		
		String contactId = ContactService.contactList.get(0).getContactId();
		
		assertEquals("1118 James St.", ContactService.contactList.get(0).getAddress());
		contactService.updateAddress(contactId, "1325 Wallaby Way");
		
		assertEquals("1325 Wallaby Way", ContactService.contactList.get(0).getAddress());
		
		//contactService.displayContacts();
		
	}
	
}
