/*Christopher Sharp
* CS:320 - Software Test Automation & QA
* Dr. Kyle Morton
* September 13, 2023
*/


package modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class ContactService {
	
	
	public static ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	// Helper getter
	/*
	 * public ArrayList<Contact> getContacts(){ return contactList; }
	 */
	
	// Adding Contact to ArrayList with UniqueGUID
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		
		String randomGUID = contactIdGenerator();
		Contact contactObj = new Contact(randomGUID, firstName, lastName, phoneNumber, address);
		contactList.add(contactObj);
	}
	
	// Helper method to display that contacts are added to ArrayList
	/*
	 * public void displayContacts() { for(int i = 0; i < contactList.size(); i++) {
	 * System.out.println("ID: " + getContacts().get(i).getContactId() + " Name: " +
	 * getContacts().get(i).getFirstName() + " " +
	 * getContacts().get(i).getLastName() + " Phone Number: " +
	 * getContacts().get(i).getPhoneNumber() + " Address: " +
	 * getContacts().get(i).getAddress()); } if(contactList.isEmpty()) {
	 * System.out.println("No contacts to display"); } }
	 */
	
	// Deleting the Contact by using the ContactID number 
	public void deleteContact(String contactId) {
		
		// Creating iterator to go through ArrayList
		Iterator<Contact> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			Contact contactObj = iterator.next();
			if (contactObj.getContactId() == contactId) {
				iterator.remove();
			}
		}
	}
	
	// Updating the FirstName by searching for the ContactId then updating 
	public void updateFirstName(String contactId, String firstName) {
		
		Iterator<Contact> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			Contact contactObj = iterator.next();
			if (contactObj.getContactId() == contactId) {
				contactObj.setFirstName(firstName);
			}
		}
		
	}
	
	// Updating the LastName by seaching for the ContactId then updating
	public void updateLastName(String contactId, String lastName) {
		
		Iterator<Contact> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			Contact contactObj = iterator.next();
			if (contactObj.getContactId() == contactId) {
				contactObj.setLastName(lastName);
			}
		}
		
	}
	
	// Updating Phone Number by searching for ID then updating
	public void updatePhoneNumber(String contactId, String phoneNumber) {
		
		Iterator<Contact> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			Contact contactObj = iterator.next();
			if (contactObj.getContactId() == contactId) {
				contactObj.setPhoneNumber(phoneNumber);
			}
		}
		
	}
	
	public void updateAddress(String contactId, String address) {
		
		Iterator<Contact> iterator = contactList.iterator();
		while(iterator.hasNext()) {
			Contact contactObj = iterator.next();
			if (contactObj.getContactId() == contactId) {
				contactObj.setAddress(address);
			}
		}
		
	}
	
	
	// genertating a random ContactId and then checking that it isnt already present
	public String contactIdGenerator() { 
	  
		String randomGUID = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
		  
		// Checking for duplicate GUID
		for (Contact i : contactList) {
			while(i.getContactId() == randomGUID) {
				randomGUID = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
			}
		}
		return randomGUID;
		}
	 
	
}
