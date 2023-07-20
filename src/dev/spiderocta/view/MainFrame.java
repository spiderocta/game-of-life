package dev.spiderocta.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1729233823098776690L;
	private GamePanel gamePanel = new GamePanel();
	public MainFrame() {
		super("Conway's Game of Life");
		setLayout(new BorderLayout());
		add(gamePanel, BorderLayout.CENTER);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}