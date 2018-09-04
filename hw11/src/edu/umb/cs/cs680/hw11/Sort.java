package edu.umb.cs.cs680.hw11;

import java.util.Collections;
import java.util.Comparator;

public class Sort implements Command {

	private Comparator<FSElement> comparator;
	private FileSystem filesystem;

	public Sort(FileSystem filesystem, Comparator<FSElement> comparator) {
		this.filesystem = filesystem;
		this.comparator = comparator;
	}

	@Override
	public void execute() {
		Collections.sort(filesystem.getChildren(), this.comparator);
		for (FSElement fse : filesystem.getChildren())
			System.out.println(fse.getName());
	}
}
