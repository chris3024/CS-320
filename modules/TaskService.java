/* Christopher Sharp
* CS:320 - Software Test Automation & QA
* Dr. Kyle Morton 
*/


package modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class TaskService {
	
	public static ArrayList<Task> taskList = new ArrayList<Task>();
	
	
	public ArrayList<Task> getTasks() {
		return taskList;
	}
	
	public void displayTasks() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println("ID: " + getTasks().get(i).getTaskId() + " Task Name: " + getTasks().get(i).getTaskName()
					+ " Task Description: " + getTasks().get(i).getTaskDescription());
			}
	}
	
	public void addTask(String taskName, String taskDescription) {
		
		String randomTaskId = taskIdGenerator();
		Task taskObj = new Task(randomTaskId, taskName, taskDescription);
		taskList.add(taskObj);
	}

	public void deleteTask(String taskId) {
		
		Iterator<Task> iterator = taskList.iterator();
		while(iterator.hasNext()) {
			Task taskObj = iterator.next();
			if (taskObj.getTaskId() == taskId) {
				iterator.remove();
			}
		}
	}
	
	public void updateTaskName(String taskID, String taskName) {
		
		Iterator<Task> iterator = taskList.iterator();
		while(iterator.hasNext()) {
			Task taskObj = iterator.next();
			if (taskObj.getTaskId() == taskID) {
				taskObj.setTaskName(taskName);
			}
		}
	}
	
	public void updateTaskDecription(String taskId, String taskDescription) {
		
		Iterator<Task> iterator = taskList.iterator();
		while(iterator.hasNext()) {
			Task taskObj = iterator.next();
			if (taskObj.getTaskId() == taskId) {
				taskObj.setTaskDescription(taskDescription);
			}
		}
	}
	
	public String taskIdGenerator() {
		
		String randomTaskId = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
		
		for (Task i : taskList) {
			while (i.getTaskId() == randomTaskId) {
				randomTaskId = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999));
			}
		}
		return randomTaskId;
	}
}
