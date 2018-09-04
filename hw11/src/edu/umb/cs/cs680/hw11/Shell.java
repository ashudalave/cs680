package edu.umb.cs.cs680.hw11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Shell {

	ArrayList<String> parse(String command, String delimtor) {
		ArrayList<String> result = new ArrayList<>();
		if (command.startsWith(delimtor)) {
			command = command.substring(1);
		}
		result.addAll(Arrays.asList(command.split(delimtor)));
		return result;
	}

	CommandHistory ch = new CommandHistory();

	public CommandHistory getCmdHistory() {
		return this.ch;
	}

	public static void main(String[] args) throws IOException {
		Shell shell = new Shell();
		FileSystem filesystem = FileSystem.getFileSystem();
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

		filesystem.setRoot(root);
		filesystem.setCurrent(filesystem.getRoot());
		// filesystem.showAllElements();

		CountingVisitor countingVisitor = new CountingVisitor();
		filesystem.root.accept(countingVisitor);
		

		//VirusCheckingVisitor virusVisitor = new VirusCheckingVisitor();
		//filesystem.root.accept(virusVisitor);

		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		filesystem.root.accept(visitor);

		while (true) {
			System.out.print(">");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String commands = br.readLine();
			ArrayList<String> commands1 = shell.parse(commands, " ");
			if (commands1.size() == 0) {
				return;
			}
			switch (commands) {

			case CommandConstants.PWD:
				Pwd pwd = new Pwd(filesystem);
				pwd.execute();
				shell.ch.push(pwd);
				break;

			case CommandConstants.CD:
				Cd cd = new Cd(filesystem);
				if (commands1.size() >= 2) {
					cd.path = commands1.get(1);
				} else {
					cd.path = "";
				}
				// cd.path= commands1.size() >= 2 ? commands1.get(1) : "";
				cd.fileElementsNames = shell.parse(cd.path, "/");
				System.out.println("cd before execution"); // to delete
				cd.execute();
				System.out.println("cd after execution"); // to delete
				shell.ch.push(cd);
				break;

			case CommandConstants.LS:
				Ls ls = new Ls(filesystem);
				ls.execute();
				shell.ch.push(ls);
				break;

			case CommandConstants.DIR:
				Dir dir = new Dir(filesystem);
				if (commands1.size() >= 2) {
					dir.directory = commands1.get(1);
				} else {
					dir.directory = "";
				}
				dir.execute();
				shell.ch.push(dir);
				break;

			case CommandConstants.MKDIR:
				if (commands1.size() < 2) {
					break;
				}
				Mkdir mkdir = new Mkdir(filesystem, commands1.get(1));
				mkdir.execute();
				shell.ch.push(mkdir);
				break;

			case CommandConstants.RMDIR:
				Rmdir rmdir = new Rmdir(filesystem, commands1.size() >= 2 ? commands1.get(1) : "");
				rmdir.execute();
				shell.ch.push(rmdir);
				break;

			case CommandConstants.CHOWN:
				if (commands1.size() < 2) {
					break;
				} 
				Chown chown = new Chown(filesystem,commands1.get(1));
				if (commands1.size() > 2) {
					chown.path = commands1.get(2);
				} else {
					chown.path = "";
				}
				chown.fileElementsNames = shell.parse(chown.path,"/");
				chown.execute();
				shell.ch.push(chown);
				break;

			case CommandConstants.HISTORY:
				History his = new History(shell.getCmdHistory());
				his.execute();
				shell.ch.push(his);
				break;

			case CommandConstants.REDO:
				Redo redo = new Redo(shell.getCmdHistory());
				redo.execute();
				shell.ch.push(redo);
				break;

			/*case CommandConstants.SORT:
				Comparator cmparator =new AscendingComparator();
				Sort sort = new Sort(filesystem, cmparator);
				sort.execute();
				shell.ch.push(sort);
				break;*/
			case CommandConstants.QUIT:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid type of command, Please enter correct command");
			}
		}

	}
}
