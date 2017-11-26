package command;

import receiver.Manager;

public class Refaire implements CommandGeneral {

	Manager manager;

	public Refaire(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void execute() {
		manager.refaire();
	}

}
