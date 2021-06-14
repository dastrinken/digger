package mainGame;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.UIManager;

public class MainMenu {
	public static JFrame mainFrame;
	
	public static ImageIcon icon = new ImageIcon("./images/solid.png");
	static ImageIcon background = new ImageIcon("./images/background.png");
	static Font customFontRegular = GameManager.createCustomFont(12f);
	static Font customFontSmall = GameManager.createCustomFont(7f);

	public static void main(String[] args) {
		SoundManager.playMusic();
		setFrame();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void setFrame() {
		mainFrame = new JFrame();
		mainFrame.setIconImage(icon.getImage());
		
		mainFrame.setSize(510, 302);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);

		@SuppressWarnings("serial")
		JDesktopPane desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, this);
			}
		};
		desktopPane.setBounds(0, 0, 504, 273);
		mainFrame.getContentPane().add(desktopPane);
		
		JButton btnStart = new JButton("New Game");
		btnStart.setBackground(UIManager.getColor("Button.background"));
		btnStart.setToolTipText("Start a new Game at Lvl.1");
		btnStart.setFont(customFontRegular);
		btnStart.setBounds(new Rectangle(10, 0, 400, 75));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartGame.main(null);
				mainFrame.setVisible(false);
			}
		});
		btnStart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.menuBtnSound();
			}
		});
		btnStart.setBounds(50, 108, 400, 35);
		desktopPane.add(btnStart);
		
		JButton btnContinueGame = new JButton("Continue");
		btnContinueGame.setFont(customFontRegular);
		btnContinueGame.setToolTipText("Load your latest savegame");
		btnContinueGame.setBounds(50, 154, 400, 35);
		btnContinueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				StartGame.loadSaveGame();
			}
		});
		btnContinueGame.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.menuBtnSound();
			}
		});
		desktopPane.add(btnContinueGame);
		
		JButton btnHighscore = new JButton("Highscore");
		btnHighscore.setFont(customFontRegular);
		btnHighscore.setToolTipText("Show Highscore");
		btnHighscore.setBounds(50, 200, 194, 35);
		btnHighscore.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.menuBtnSound();
			}
		});
		desktopPane.add(btnHighscore);

		JButton optionsBtn = new JButton("Settings");
		optionsBtn.setBounds(256, 200, 194, 35);
		optionsBtn.setFont(customFontRegular);
		optionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuManager.showOptionsMenu();
			}
		});
		optionsBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				SoundManager.menuBtnSound();
			}
		});
		desktopPane.add(optionsBtn);
		
		JLabel lblNewLabel = new JLabel("Digger V1.0 - A project by Sebastian Z. & Armin P.");
		lblNewLabel.setFont(customFontSmall);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 248, 490, 14);
		desktopPane.add(lblNewLabel);
		
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}