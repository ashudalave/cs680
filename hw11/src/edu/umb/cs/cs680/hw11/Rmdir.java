package edu.umb.cs.cs680.hw11;

public class Rmdir implements Command {
	String name;
	FileSystem filesystem = FileSystem.getFileSystem();

	public Rmdir(FileSystem fs, String name) {
		this.filesystem = fs;
		this.name = name;
	}

	public void execute() {
		if (name.isEmpty()) {
			System.out.println("invalid mkdir command");
			return;
		}
		Directory current = filesystem.getCurrent();
		FSElement elm = null;
		for (FSElement fse : current.getChildern()) {
			if (fse.getName().equals(name) && fse.isDir()) {
				elm = fse;
			}
		}
		if (elm == null)
			return;
		current.getChildern().remove(elm);
	}
}
