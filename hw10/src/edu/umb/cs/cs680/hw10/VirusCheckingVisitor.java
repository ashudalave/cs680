package edu.umb.cs.cs680.hw10;

public class VirusCheckingVisitor implements FSVisitor {

	int quarantined = 0;
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
		quarantined++;
	}
	
	public int getQuarantinedNum() {
		return quarantined;
	}

}
