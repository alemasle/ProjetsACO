package command;

import receiver.Manager;

public class Defaire implements CommandGeneral {

	Manager manager;

	public Defaire(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void execute() {
		manager.defaire();
	}

}
