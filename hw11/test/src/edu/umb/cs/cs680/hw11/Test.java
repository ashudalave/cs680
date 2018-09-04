package edu.umb.cs.cs680.hw11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;

public class Test {

	private FileSystem fs;
	private CommandHistory history;
	private String path;

	@Before
	public void CommandTest() {
		fs = FileSystem.getFileSystem();
		Directory root = new Directory(null, "root", "Ashu");
		Directory home = new Directory(root, "home", "Ashu");
		Directory system = new Directory(root, "system", "Ashu");
		Directory pictures = new Directory(home, "pictures", "Ashu");

		root.appendChild(home);
		root.appendChild(system);
		root.appendChild(pictures);

		File a = new File(system, "a.txt", "Ashu", 1);
		File b = new File(system, "b.txt", "Ashu", 2);
		File c = new File(system, "c.html", "Ashu", 3);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);

		File d = new File(home, "d.php", "Ashu", 4);
		Link x = new Link(home, "x", "Ashu", home);

		home.appendChild(d);
		home.appendChild(x);

		File e = new File(pictures, "e.py", "Ashu", 5);
		File f = new File(pictures, "f.java", "Ashu", 6);
		Link y = new Link(pictures, "y", "Ashu", e);

		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);
		fs.setRoot(root);
		history = new CommandHistory();
		this.path = "/home/system";
	}

	@org.junit.Test
	public void testShowAll() {
		Directory root = new Directory(null, "root", "Ashu");
		Directory home = new Directory(root, "home", "Ashu");
		Directory system = new Directory(root, "system", "Ashu");
		Directory pictures = new Directory(home, "pictures", "Ashu");

		root.appendChild(home);
		root.appendChild(system);
		root.appendChild(pictures);

		File a = new File(system, "a.txt", "Ashu", 1);
		File b = new File(system, "b.txt", "Ashu", 2);
		File c = new File(system, "c.html", "Ashu", 3);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);

		File d = new File(home, "d.php", "Ashu", 4);
		Link x = new Link(home, "x", "Ashu", home);

		home.appendChild(d);
		home.appendChild(x);

		File e = new File(pictures, "e.py", "Ashu", 5);
		File f = new File(pictures, "f.java", "Ashu", 6);
		Link y = new Link(pictures, "y", "Ashu", e);

		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);

		FileSystem filesystem = FileSystem.getFileSystem();
		filesystem.setRoot(root);
		filesystem.showAllElements();

		CountingVisitor countingVisitor = new CountingVisitor();
		filesystem.root.accept(countingVisitor);

		System.out.println("\nThe filesystem has:" + "\n");

		System.out.println(countingVisitor.getDirNum() + " Diretories" + "\n");
		System.out.println(countingVisitor.getFileNum() + " Files" + "\n");
		System.out.println(countingVisitor.getLinkNum() + " Links" + "\n");

		VirusCheckingVisitor virusVisitor = new VirusCheckingVisitor();
		filesystem.root.accept(virusVisitor);
		System.out.println("Total size of fs:" + virusVisitor.getQuarantinedNum() + "\n");

		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		filesystem.root.accept(visitor);
		System.out.println("Number of files with extension .txt: " + visitor.getFoundFiles().size());
	}

	@org.junit.Test
	public void testFileSize() {

		Directory root = new Directory(null, "root", "Ashu");
		Directory home = new Directory(root, "home", "Ashu");
		Directory system = new Directory(root, "system", "Ashu");
		Directory pictures = new Directory(home, "pictures", "Ashu");

		root.appendChild(home);
		root.appendChild(system);
		root.appendChild(pictures);

		File a = new File(system, "a", "Ashu", 1);
		File b = new File(system, "b", "Ashu", 2);
		File c = new File(system, "c", "Ashu", 3);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);

		File d = new File(home, "d", "Ashu", 4);
		Link x = new Link(home, "x", "Ashu", home);

		home.appendChild(d);
		home.appendChild(x);

		File e = new File(pictures, "e", "Ashu", 5);
		Link y = new Link(pictures, "y", "Ashu", e);
		File f = new File(pictures, "f", "Ashu", 6);

		pictures.appendChild(y);
		pictures.appendChild(e);
		pictures.appendChild(f);

		FileSystem filesystem = FileSystem.getFileSystem();
		filesystem.setRoot(root);
		assertEquals(filesystem.getRoot().getSize(), 106);
	}

	@org.junit.Test
	public void testCdExecute() {
		Cd cd = new Cd(fs);
		cd.path = this.path;
		cd.execute();
		this.history.push(cd);
		assertThat(fs.getCurrent().getName(), is("root"));
	}

	@org.junit.Test
	public void testCdRootExecute() {
		Cd cd = new Cd(fs);
		cd.path = "";
		cd.execute();
		this.history.push(cd);
		assertThat(fs.getCurrent().getName(), is("root"));
	}

	@org.junit.Test
	public void testMkdirExecute() {
		int c = fs.getChildren().size();
		Mkdir mkdir = new Mkdir(fs, "test1");
		mkdir.execute();
		this.history.push(mkdir);
		assertThat(fs.getChildren().size(), is(c));
	}

}
