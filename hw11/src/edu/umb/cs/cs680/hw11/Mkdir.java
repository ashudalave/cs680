package edu.umb.cs.cs680.hw11;

public class Mkdir implements Command {
	FileSystem fs = FileSystem.getFileSystem();
	String dir_name;

	public Mkdir(FileSystem fs, String name) {
		this.fs = fs;
		this.dir_name = name;
	}

	public void execute() {
		appendChild(this.dir_name);
	}

	public void appendChild(String filelementName) {

		Directory root = new Directory(null, "root", "Ashu");
		root.appendChild(new Directory(fs.getCurrent(), this.dir_name, "Ashu"));
		System.out.println("mkdir " + this.dir_name);

	}

}