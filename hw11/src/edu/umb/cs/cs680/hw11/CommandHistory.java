package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandHistory {

	ArrayList<Command> c;

	public CommandHistory() {
		this.c = new ArrayList<Command>();
	}

	public void push(Command cmd) {
		c.add(cmd);
	}

	public Command pop() {
		if (c.size() > 0) {
			return c.get(c.size() - 1);
		}
		return null;

	}

	public boolean isEmpty() {
		return c.isEmpty();
	}

	public void print() {
		for (Iterator<Command> iter = c.iterator(); iter.hasNext();) {
			iter.next();
		}
	}
}
