package modules;

import java.util.Date;

public class Appointment {

	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		
		// Getting the Current Date
		Date currentDate  = new Date();
		
		// Set of decision branches that are search for any errors that have been provided
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		if (appointmentDate == null || appointmentDate.before(currentDate)) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description Length");
		}
		
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
		
	}

	// Getters and Setters for the Class
	public String getAppointmentID() {
		return appointmentID;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public String getAppointmentDescription() {
		return appointmentDescription;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setAppointmentDescription(String appointmentDescription) {
		this.appointmentDescription = appointmentDescription;
	}

	
	
	
}
