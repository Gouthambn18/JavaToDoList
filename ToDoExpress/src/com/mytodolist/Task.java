package com.mytodolist;

public class Task {


	private int id;
	private String description;
	private boolean completed;

	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.completed = false;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void markComplete() {
		completed = true;
	}
}




