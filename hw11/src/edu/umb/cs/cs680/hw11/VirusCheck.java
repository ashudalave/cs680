package edu.umb.cs.cs680.hw11;

public class VirusCheck implements Command {

	FileSystem filesystem = FileSystem.getFileSystem();

	public VirusCheck(FileSystem filesystem) {
		super();
		this.filesystem = filesystem;
	}

	@Override
	public void execute() {
		VirusCheckingVisitor check = new VirusCheckingVisitor();
		for (FSElement e : filesystem.getCurrent().getChildern()) {
			if (e.isFile()) {
				// check.visit((File).e);
			}
		}
		System.out.println("Quarantined: " + check.getQuarantinedNum());

	}

}
