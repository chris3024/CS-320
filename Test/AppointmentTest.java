package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.Appointment;

class AppointmentTest {

	@DisplayName("Testing Contructor")
	@Test
	void testAppointment() {
		Date currentDate = new Date();
		Date futureDate = new Date(currentDate.getTime() + (1000 * 60 * 60 * 24));
		
		Appointment testAppointment = new Appointment("1", futureDate, "DR. Appointment");
		assertTrue(testAppointment.getAppointmentID().equals("1"));
		assertTrue(testAppointment.getAppointmentDate().equals(futureDate));
		assertTrue(testAppointment.getAppointmentDescription().equals("DR. Appointment"));
	}

	@DisplayName("Appointment ID Null")
	@Test
	void testAppointmentIdNull() {
		Date date = new Date();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, date, "DR. Appointment");
		});
	}
	
	@DisplayName("Appointment ID Null")
	@Test
	void testAppointmenyIdLength() {
		Date date = new Date();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("11111111111", date, "DR. Appointment");
		});
	}
	
	@DisplayName("Testing Date Not in Past")
	@Test
	void testAppointmentDate() {
		Date date = new Date();
		Date pastDate = new Date(date.getTime() - (1000 * 60 * 60 * 24));
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1", pastDate, "Dr. Appointment");
		});
	}
	
	@DisplayName("Date is not Null")
	@Test
	void testDateNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1", null, "DR. Appointment");
		});
	}
	
	@DisplayName("Testing Description Length")
	@Test
	void testAppointmentLengthGreaterFifty() {
		Date date = new Date();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1", date, "This is a test for the length that is greater than fifty characters");
		});
	}
	
	@DisplayName("Testing Description is not Null")
	@Test
	void testDescriptionNotNull() {
		Date date = new Date();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1", date, null);
		});
	}
}
