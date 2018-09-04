package edu.umb.cs.cs680.hw11;

public class CountingVisitor implements FSVisitor {

	int dirNum = 0;
	int fileNum = 0;
	int linkNum = 0;

	@Override
	public void visit(Link link) {
		this.linkNum++;
	}

	@Override
	public void visit(Directory dir) {
		this.dirNum++;
	}

	@Override
	public void visit(File file) {
		fileNum++;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(int linkNum) {
		this.linkNum = linkNum;
	}

	public void setDirNum(int dirNum) {
		this.dirNum = dirNum;
	}

	public int getDirNum() {
		return this.dirNum;
	}

}
