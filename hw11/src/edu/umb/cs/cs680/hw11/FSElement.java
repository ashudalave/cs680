package edu.umb.cs.cs680.hw11;

import java.util.Date;

public abstract class FSElement {

	String Name;
	String Owner;
	final Date created;
	Date lastModified;
	int size;
	boolean file;
	Directory parent;

	public FSElement(Directory parent, String name, String owner, int size, boolean file) {
		super();
		this.parent = parent;
		if (parent != null) {
			this.parent.appendChild(this);
		}
		Name = name;
		Owner = owner;
		this.created = new Date();
		this.lastModified = this.created;
		this.size = size;
		this.file = file;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
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

	abstract public FSElement getTarget();

	public String getPath() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.Name);
		FSElement fe = this.parent;
		while (fe != null) {
			buffer.insert(0, fe.getName() + "/");
			fe = fe.parent;
		}
		return buffer.toString().substring(1);
	}

	public boolean isDir() {
		return this instanceof Directory;
	}

}
