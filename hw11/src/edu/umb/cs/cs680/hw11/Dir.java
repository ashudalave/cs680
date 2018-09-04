package edu.umb.cs.cs680.hw11;

public class Dir implements Command {

	FileSystem filesystem;
	String directory = "";

	public Dir(FileSystem filesystem) {
		this.filesystem = filesystem;
		directory = filesystem.getRoot().getName();
	}

	@Override
	public String toString() {
		return "dir: " + (directory.equals(filesystem.getCurrent().getName()) == true ? "" : directory);
	}

	@Override
	public void execute() {
		if (directory.equals("")) {
			for (FSElement fse : filesystem.getCurrent().getChildern()) {
				System.out.println("\nDirectory Name: " + fse.getName() + "\n" + "Directory Size: " + fse.getSize()
						+ "\n" + "Direcotry Owner: " + fse.getOwner());
			}
		} else if (directory.equals("..")) {
			for (FSElement fse : filesystem.getCurrent().getParent().getChildern()) {
				System.out.println("\nDirectory Name: " + fse.getName() + "\n" + "Directory Size: " + fse.getSize()
						+ "\n" + "Direcotry Owner: " + fse.getOwner());
			}
		} else
			System.out.println("Cannot find this dir/file");
	}
}
