package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

public class AscendingComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement fe1, FSElement fe2) {
		return fe1.getName().toLowerCase().compareTo(fe2.getName().toLowerCase());
	}

}
