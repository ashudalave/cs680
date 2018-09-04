package edu.umb.cs.cs680.hw10;

public class FileSystem {

	Directory root;
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

	public void showAllElements() {
		this.root.show();
	}
	

}
