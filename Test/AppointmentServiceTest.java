package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.AppointmentService;

class AppointmentServiceTest {

	@DisplayName("Testing Adding Appointment")
	@Test
	void addAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		
		AppointmentService.appointmentList.clear();
		
		appointmentService.addAppointment("Dr. appointment- Root Canal");
		
		assertEquals("Dr. appointment- Root Canal", AppointmentService.appointmentList.get(0).getAppointmentDescription());
		
		appointmentService.displayAppointments();
	}
	
	@DisplayName("Testing Unique Id")
	@Test
	void testUniqueId() {
		AppointmentService appointmentService = new AppointmentService();
		
		AppointmentService.appointmentList.clear();
		
		appointmentService.addAppointment("Dr. appointment- Root Canal");
		appointmentService.addAppointment("Get Taxes COmpleted");
		
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() != AppointmentService.appointmentList.get(1).getAppointmentID());
		assertTrue(AppointmentService.appointmentList.get(0).getAppointmentID() == AppointmentService.appointmentList.get(0).getAppointmentID());
	}
	
	@DisplayName("Testing Appointment Deletion")
	@Test
	void testAppointmentDeletion() {
		AppointmentService appointmentService = new AppointmentService();
		
		AppointmentService.appointmentList.clear();
		
		appointmentService.addAppointment("Dr. appointment- Root Canal");
		appointmentService.addAppointment("Get Taxes COmpleted");
		
		assertEquals(2, AppointmentService.appointmentList.size());
		
		String applicationIdString = AppointmentService.appointmentList.get(0).getAppointmentID();
		appointmentService.deleteAppointment(applicationIdString);
		
		appointmentService.displayAppointments();
	}
}
