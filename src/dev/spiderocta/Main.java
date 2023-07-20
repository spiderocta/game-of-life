package dev.spiderocta;

import javax.swing.SwingUtilities;

import dev.spiderocta.view.MainFrame;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame();
			}

		});
	}
}
