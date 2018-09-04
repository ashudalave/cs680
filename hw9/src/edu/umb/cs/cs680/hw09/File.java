package edu.umb.cs.cs680.hw09;

public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size, true);
	}

	public void show() {
		System.out.println("File : " + this.getName() + ", owner : "+ this.getOwner() +", size : " + this.size);
	}
	
}
