package edu.umb.cs.cs680.hw10;

import static org.junit.Assert.assertEquals;

public class Test {

	@org.junit.Test
	public void test1() {
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
		File f = new File(pictures, "f", "Ashu", 6);
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
	public void test2() {

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
		assertEquals(filesystem.getRoot().getSize(), 21);
	}

}
