

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.Contact;



class ContactTest {
	
	
	 @DisplayName("Valid Constructor")
	 @Test 
	 void testContact() { 
		 Contact testContact = new Contact("1", "Chris", "Sharp", "1121234567", "1118 James St.");
		 assertTrue(testContact.getContactId().equals("1"));
		 assertTrue(testContact.getFirstName().equals("Chris"));
		 assertTrue(testContact.getLastName().equals("Sharp"));
		 assertTrue(testContact.getPhoneNumber().equals("1121234567"));
		 assertTrue(testContact.getAddress().equals("1118 James St."));
	  
	  }
	 
	
	
	@DisplayName("contactId Null")
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Chris", "Sharp", "11212345678", "1118 James St.");
		});
	}
	
	@DisplayName("ContactId Greater Than Ten")
	@Test
	void testContactIdGreaterThanTen() {
		 Assertions.assertThrows(IllegalArgumentException.class, () ->{
			 new Contact("11111111111", "Chris", "Sharp", "11212345678", "1118 James St.");
		 });
	}
	
	@DisplayName("FirstName Null")
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", null, "Sharp", "11212345678", "1118 James St."); 
		}); 
	 }
	
	@DisplayName("FirstName Greater Than Ten")  
	 @Test 
	 void testFirstNameGreaterThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Christopolis", "Douglas", "11212345678", "1118 James St."); 
		}); 
	  }
	 
	 @DisplayName("LastName Null")
	 @Test
	 void testLastNameIsNull() {
		 Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			 new Contact("1", "Beth", null, "11212345678", "1118 James St."); 
		 }); 
	}
		
	@DisplayName("LastName Greater Than Ten")  
	@Test 
	void testLastNameGreaterThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Elizabethian", "11212345678", "1118 James St."); 
		}); 
	}
	
	@DisplayName("phoneNumber Null")
	@Test
	 void testphoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Jones", null, "1118 James St."); 
		}); 
	}
		
	@DisplayName("phoneNumber Greater Than Ten")  
	@Test 
	void testphoneNumberGreaterThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Jones", "12345678901", "1118 James St."); 
		}); 
	}
	
	@DisplayName("phoneNumber Less Than Ten")  
	@Test 
	void testphoneNumberLessThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Jones", "11212345", "1118 James St."); 
		}); 
	}
	
	@DisplayName("Address Null")  
	@Test 
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Jones", "112123456789", null); 
		}); 
	}
	
	@DisplayName("Address Greater Than Ten")  
	@Test 
	void testAddressGreaterThanThirty() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{ 
			new Contact("1", "Beth", "Jones", "1121234567", "1118 James St. SW Jacksonville, FL"); 
		}); 
	}
	 
}
