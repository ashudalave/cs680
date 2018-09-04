package edu.umb.cs.cs680.hw10;

import java.util.Date;

public class FSElement {

	String Name;
	String Owner;
	final Date created;
	Date lastModified;
	int size;
	boolean file;
	Directory parent;

	public FSElement(Directory parent, String name, String owner, int size, boolean file) {
		super();
		Name = name;
		Owner = owner;
		this.created = new Date();
		this.lastModified = this.created;
		this.size = size;
		this.file = file;
	}

	public boolean isFile() {
		return this.file;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getCreated() {
		return created;
	}

	public void show() {
	}

	public void accept(FSVisitor v) {

	}

}
