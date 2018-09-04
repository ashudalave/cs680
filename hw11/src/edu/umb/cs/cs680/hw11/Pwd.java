package edu.umb.cs.cs680.hw11;

public class Pwd implements Command {

	FileSystem filesystem;

	public Pwd(FileSystem filesystem) {
		this.filesystem = filesystem;
	}

	@Override
	public void execute() {
		System.out.println("Current working directory: " + filesystem.getCurrent().getName());
	}

}
