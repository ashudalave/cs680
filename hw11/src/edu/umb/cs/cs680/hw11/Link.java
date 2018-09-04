package edu.umb.cs.cs680.hw11;

public class Link extends FSElement {

	FSElement target;

	public Link(Directory parent, String name, String owner, FSElement target) {
		super(parent, name, owner, 0, false);

		this.target = target;

	}

	public int getTargetSize() {

		return this.target.getSize();

	}

	public void accept(FSVisitor v) {
		v.visit(this);
	}

	public void show() {
		System.out.println(
				"Link : " + this.getName() + ", owner : " + this.getOwner() + ", points to : " + this.target.getName());
	}

	@Override
	public FSElement getTarget() {
		return this;
	}

}
