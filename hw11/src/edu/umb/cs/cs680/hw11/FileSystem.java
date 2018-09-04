package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class FileSystem {

	Directory root;
	Directory current;
	private CommandHistory ch = new CommandHistory();

	private static FileSystem filesystem_instance = null;

	public static FileSystem getFileSystem() {

		if (filesystem_instance == null)
			filesystem_instance = new FileSystem();

		return filesystem_instance;
	}

	private FileSystem() {
		super();
	}

	public Directory getRoot() {
		return root;
	}

	public void setRoot(Directory root) {
		this.root = root;
	}

	public Directory getCurrent() {
		return current;
	}

	public void setCurrent(Directory current) {
		this.current = current;
	}

	public void showAllElements() {
		this.root.show();
	}

	public ArrayList<FSElement> getChildren() {
		return current.getChildern();
	}

	public void push(Command command) {
		ch.push(command);
	}

	public boolean isEmpty() {
		return ch.isEmpty();
	}

	public Command pop() {
		return ch.pop();
	}

}
