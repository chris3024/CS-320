package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.Task;

class TaskTest {

	@DisplayName("Valid Constructor")
	@Test
	void testTask() {
		Task testTask = new Task("1", "Mow Yard", "Mow the complete yard and weedeat the edges");
		assertTrue(testTask.getTaskId().equals("1"));
		assertTrue(testTask.getTaskName().equals("Mow Yard"));
		assertTrue(testTask.getTaskDescription().equals("Mow the complete yard and weedeat the edges"));
		
	}
	
	@DisplayName("Task ID Null")
	@Test
	void testTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task(null, "Clean Room", "Please Clean Room so that it is spotless");
		});
	}
	
	@DisplayName("Task Id is Not Greater Than Ten")
	@Test
	void testTaskIdGreaterThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("11111111111", "Clean Room", "Please Clean Room so that it is spotless");
		});
	}
	
	@DisplayName("Task Name not Null")
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("1", null, "Please Clean Room so that it is spotless");
		});
	}
	
	@DisplayName("Task Name is not Greater Than Twenty")
	@Test
	void testTaskNameGreaterThanTwenty() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("1", "Cleaning Master Bedroom", "Please Clean Room so that it is spotless");
		});
	}
	
	@DisplayName("Task Description is not Null")
	@Test
	void testTaskDescriptionNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("1", "Clean Room", null);
		});
	}
	
	@DisplayName("Task Description is Not Greater Than Fifty")
	@Test
	void testTaskDescriptionNotGreaterThanFifty() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("1", "Clean Room", "Please clean the room, which includes cleaning all the floors and making the bed");
		});
	}

}
