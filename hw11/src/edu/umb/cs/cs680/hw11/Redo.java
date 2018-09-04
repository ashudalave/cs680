package edu.umb.cs.cs680.hw11;

public class Redo implements Command {

	CommandHistory cmdHistory;
	Command lastCommand;

	public Redo(CommandHistory cmdHistory1) {
		this.cmdHistory = cmdHistory1;
	}

	@Override
	public void execute() {
		lastCommand = cmdHistory.pop();
		lastCommand.execute();
	}

}
