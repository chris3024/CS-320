package modules;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class AppointmentService {
	
	// Getting the Current date and then setting a date 24 hours into the future
	// Information from Date/Time came with help from StackOverflow
	Date currentDate = new Date();
	Date futureDate = new Date(currentDate.getTime() + (1000 * 60 * 60 * 24));
	
	// Array to hold Appointments
	public static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	// Helper Function to view list
	public ArrayList<Appointment> getAppointments(){
		return appointmentList;
	}

	// Displaying list in console for debugging purposes
	public void displayAppointments() {
		for(int i = 0; i < appointmentList.size(); i++) {
			System.out.println("ID: " + getAppointments().get(i).getAppointmentID() + " Appointment Date: "
					+ getAppointments().get(i).getAppointmentDate() + " Task Description: " + getAppointments().get(i).getAppointmentDescription());
		}
	}
	
	// Adding Appointment to the array list with a Unique Id
	public void addAppointment(String appointmentDescription) {
		
		String randomAppointmentIdString = appointmentIdGenerator();
		Appointment apptObj = new Appointment(randomAppointmentIdString, futureDate , appointmentDescription);
		appointmentList.add(apptObj);
		
	}
	
	// Deleting the appointment in the list based on the unique identifier
	public void deleteAppointment(String appointmentId) {
		
		Iterator<Appointment> iterator = appointmentList.iterator();
		while(iterator.hasNext()) {
			Appointment appObj = iterator.next();
			if (appObj.getAppointmentID() == appointmentId) {
				iterator.remove();
			}
		}
	}
	
	// Function generating a unique Id
	public String appointmentIdGenerator() {
		
		String randomAppointmentId = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
		
		for (Appointment i : appointmentList) {
			while (i.getAppointmentID() == randomAppointmentId) {
				randomAppointmentId = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
			}
		}
		return randomAppointmentId;
	}
}
