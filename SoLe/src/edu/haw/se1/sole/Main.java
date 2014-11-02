package edu.haw.se1.sole;

import edu.haw.se1.sole.gui.MainWindow;

public class Main {

	public Main() {
		super();
	}

	public static void main(String[] args) {
		DependencyAssembler dAssembler = new DependencyAssembler();
		MainWindow.main(null);
	}
}
