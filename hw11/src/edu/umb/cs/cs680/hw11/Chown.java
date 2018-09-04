package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
//import java.util.Scanner;

public class Chown implements Command {

	FileSystem filesystem = FileSystem.getFileSystem();
	private String ownName;
	public ArrayList<String> fileElementsNames;
	public String path;

	public Chown(FileSystem fs, String ownName) {
		this.filesystem = fs;
		this.ownName = ownName;
		this.fileElementsNames = new ArrayList<String>();
	}

	@Override
	public void execute() {
		
		if (this.path.equals("..")) {
			if (filesystem.getCurrent().getParent() != null) {
				filesystem.getCurrent().getParent().setOwner(this.ownName);
			}
			return;
		}
		if (this.path.equals(".")||this.path.equals("")) {
			filesystem.getCurrent().setOwner(this.ownName);
			return;
		}
		Directory cur = filesystem.getCurrent();
		FSElement fe = null;
		if (path.startsWith("/"))
			cur = filesystem.getRoot();
		for (int i = 0; i < fileElementsNames.size(); i++) {
			String name = fileElementsNames.get(i);
			boolean isFind = false;
			for (FSElement child : cur.getChildern()) {
				if (isFind) {
					break;
				}
				if (child.getName().equals(name)) {
					if (i == fileElementsNames.size() - 1) {
						fe = child;
						isFind = true;
					} else {
						switch (child.getClass().getName()) {
						case "Directory": {
							cur = (Directory) child;
							isFind = true;
							break;
						}
						case "Link": {
							FSElement target = child.getTarget();
							if (target instanceof Directory) {
								cur = (Directory) target;
								isFind = true;
								break;
							} else {
								continue;
							}
						}
						default: {
							continue;
						}
						}
					}
				}
			}
			if (!isFind) {
				System.out.println("Cannot find this target address");
			}
		}
		fe.setOwner(this.ownName);
	}
		/*System.out.println("Enter the name of New Owner: ");
		Scanner name = new Scanner(System.in);
		String owner = name.nextLine();
		filesystem.getCurrent().setOwner(owner);
		System.out.println("Owner is changed to: " + owner + " for file: " + filesystem.getCurrent().getName());*/

	}


