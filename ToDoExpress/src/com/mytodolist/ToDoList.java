package com.mytodolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
	private List<Task> tasks;
	private int taskIdCounter;

	public ToDoList() {
		tasks = new ArrayList<>();
		taskIdCounter = 1;
	}

	public void addTask(String description) {
		Task task = new Task(taskIdCounter++, description);
		tasks.add(task);
		System.out.println("Task added: " + task.getDescription());
	}

	public void completeTask(int taskId) {
		for (Task task : tasks) {
			if (task.getId() == taskId) {
				task.markComplete();
				System.out.println("Task completed: " + task.getDescription());
				return;
			}
		}
		System.out.println("Task not found.");
	}

	public void removeTask(int taskId) {
		for (Task task : tasks) {
			if (task.getId() == taskId) {
				tasks.remove(task);
				System.out.println("Task removed: " + task.getDescription());
				return;
			}
		}
		System.out.println("Task not found.");
	}

	public void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks in the to-do list.");
		} else {
			System.out.println("To-Do List:");
			for (Task task : tasks) {
				String status = task.isCompleted() ? "Completed" : "Not Completed";
				System.out.println("Task " + task.getId() + ": " + task.getDescription() + " (" + status + ")");
			}
		}
	}

	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nOptions:");
			System.out.println("1. Add Task");
			System.out.println("2. Complete Task");
			System.out.println("3. Remove Task");
			System.out.println("4. List Tasks");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter task description: ");
				String description = scanner.nextLine();
				toDoList.addTask(description);
				break;
			case 2:
				System.out.print("Enter task ID to mark as complete: ");
				int taskId = scanner.nextInt();
				toDoList.completeTask(taskId);
				break;
			case 3:
				System.out.print("Enter task ID to remove: ");
				taskId = scanner.nextInt();
				toDoList.removeTask(taskId);
				break;
			case 4:
				toDoList.listTasks();
				break;
			case 5:
				System.out.println("Exiting the program.");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
