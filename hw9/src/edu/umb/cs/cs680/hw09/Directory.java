package edu.umb.cs.cs680.hw09;

import java.util.ArrayList;

public class Directory extends FSElement {

	ArrayList<FSElement> childern;

	public Directory(Directory parent, String name, String owner) {
		super(parent, name, owner, 0, false);

		childern = new ArrayList<>();

	}

	public ArrayList<FSElement> getChildern() {
		return childern;
	}

	public void appendChild(FSElement child) {
		this.childern.add(child);
	}

	public int getSize() {

		int size = 0;

		for (FSElement e : this.childern) {

			size = size + e.getSize();

		}

		return size;

	}

	public void show() {

		System.out.println("Directory : " + this.getName() + ", owner : " + this.getOwner());

		for (FSElement e : this.childern) {

			 e.show();

		}

	}

}
