package edu.umb.cs.cs680.hw11;

public class Ls implements Command {

	FileSystem filesystem;

	public Ls(FileSystem filesystem) {
		this.filesystem = filesystem;
	}

	@Override
	public void execute() {
		System.out.println("Current directory: " + filesystem.getCurrent().getName());
		if (filesystem.getCurrent().getChildern().size() < 1)
			System.out.println("empty directory");
		else
			for (FSElement fse : filesystem.getCurrent().getChildern()) {
				System.out.println(String.format("%-20s", fse.getName()));
			}
	}
}
