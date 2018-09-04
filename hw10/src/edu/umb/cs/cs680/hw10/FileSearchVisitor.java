package edu.umb.cs.cs680.hw10;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {

	String extension;
	ArrayList<File> foundFiles;

	public FileSearchVisitor(String extension) {
		super();
		this.extension = extension;
		foundFiles = new ArrayList<File>();
	}

	public ArrayList<File> getFoundFiles() {
		return this.foundFiles;
	}

	@Override
	public void visit(Link link) {
		return;

	}

	@Override
	public void visit(Directory dir) {
		return;

	}

	@Override
	public void visit(File file) {

		if (file.getName().contains(extension)) {
			this.foundFiles.add(file);
		}

	}

}
