import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

public class Skatedice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Skatedice frame = new Skatedice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int numTricksValue;
	private String difficultyValue;
	private String obstacleValue;
	private boolean berricsOn;
	private History hist;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Skatedice() throws IOException {
		difficultyValue="";
		obstacleValue="";
		hist=new History();
		berricsOn=false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel skateDiceLabel = new JLabel("Skate Dice");
		skateDiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		skateDiceLabel.setBounds(322, 0, 107, 39);
		contentPane.add(skateDiceLabel);
		
		SpinnerNumberModel sm = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner numTricks = new JSpinner(sm);
		numTricksValue=1;
		numTricks.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numTricksValue = (int) (numTricks.getValue());
			}
		});
		numTricks.setBounds(299, 95, 34, 26);
		contentPane.add(numTricks);

		String[] difficulty = { "select difficulty", "easy", "medium", "hard" };
		JComboBox difficultyCombo = new JComboBox(difficulty);
		difficultyCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficultyValue=(String)difficultyCombo.getSelectedItem();
				if(difficultyValue.equals("difficulty"))
					difficultyValue="";
			}
		});
		difficultyCombo.setToolTipText("");
		difficultyCombo.setBounds(32, 96, 121, 27);
		contentPane.add(difficultyCombo);

		JComboBox obstacleCombo = new JComboBox();
		obstacleCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obstacleValue=(String)(obstacleCombo.getSelectedItem());
				if(obstacleValue.equals("obstacle"))
					obstacleValue="";
			}
		});
		obstacleCombo.setModel(new DefaultComboBoxModel(new String[] {"select obstacle", "flat", "ledge/curb/rail", "transition"}));
		obstacleCombo.setBounds(166, 96, 121, 27);
		contentPane.add(obstacleCombo);

		JButton excludeBtn = new JButton("exclude");
		excludeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcludeTricks excl=new ExcludeTricks();
				excl.setVisible(true);
			}
		});
		excludeBtn.setBounds(345, 95, 117, 29);
		contentPane.add(excludeBtn);

		JButton viewTricksBtn = new JButton("view tricks");
		viewTricksBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrickList tricks=new TrickList();
				tricks.setVisible(true);
			}
		});
		viewTricksBtn.setBounds(474, 95, 117, 29);
		contentPane.add(viewTricksBtn);

		JLabel gameofskate = new JLabel("S.K.A.T.E.");
		gameofskate.setHorizontalAlignment(SwingConstants.CENTER);
		gameofskate.setBounds(267, 127, 217, 86);
		gameofskate.setFont(gameofskate.getFont().deriveFont(40.0f));
		contentPane.add(gameofskate);

		JLabel player1 = new JLabel("Player 1");
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		player1.setBounds(16, 204, 107, 39);
		contentPane.add(player1);

		
		JTextArea letters = new JTextArea();
		letters.setEditable(false);
		letters.setBounds(129, 215, 152, 28);
		contentPane.add(letters);
		
		SkateLetters letter;

		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 21, 21);
		contentPane.add(tabbedPane);
		
		JTextArea letters_1 = new JTextArea();
		letters_1.setEditable(false);
		letters_1.setBounds(127, 266, 152, 28);
		contentPane.add(letters_1);
		
		SkateLetters letter_1;

		String current="";
		String current2="";
		try {//loads saved game
			Scanner sc=new Scanner(new File("letters.txt"));//initialize skateLetters objects in here
			 current=sc.nextLine();
			if(current.equals("0")) {//player 1
				current="";
			}
			current2=sc.nextLine();
			if(current2.equals("0"))//player 2
			{
				current2 = "";
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		letters.setText(current);
		letter=new SkateLetters(current.length(),current);
		
		letters_1.setText(current2);
		letter_1=new SkateLetters(current2.length(),current2);
		
		JButton addLetter = new JButton("+letter");
		addLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letter.addLetter();
				letters.setText(letter.getLetters());
				
			}
		});
		addLetter.setBounds(293, 210, 78, 29);
		contentPane.add(addLetter);

		JButton subtractLetter = new JButton("-letter");
		subtractLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letter.subtractLetter();
				letters.setText(letter.getLetters());
			}
		});
		subtractLetter.setBounds(365, 210, 78, 29);
		contentPane.add(subtractLetter);
		
		JButton subtractLetter_1 = new JButton("-letter");
		subtractLetter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letter_1.subtractLetter();
				letters_1.setText(letter_1.getLetters());
			}
		});
		subtractLetter_1.setBounds(363, 261, 78, 29);
		contentPane.add(subtractLetter_1);
		
		JButton addLetter_1 = new JButton("+letter");
		addLetter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letter_1.addLetter();
				letters_1.setText(letter_1.getLetters());
			}
		});
		addLetter_1.setBounds(291, 261, 78, 29);
		contentPane.add(addLetter_1);
		
		JLabel player2 = new JLabel("Player 2");
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		player2.setBounds(14, 255, 107, 39);
		contentPane.add(player2);
		
		BerricsRules rules=new BerricsRules();
		JButton viewRules = new JButton("view rules");
		viewRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BerricsRules rules=new BerricsRules();
				rules.setVisible(true);
			}
		});
		viewRules.setBounds(495, 254, 117, 29);
		contentPane.add(viewRules);
		viewRules.setVisible(false);
		
		JCheckBox enableBerrics = new JCheckBox("enable berrics rules");
		enableBerrics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(viewRules.isVisible()==false)
					viewRules.setVisible(true);
				else
					viewRules.setVisible(false);
				if(berricsOn==true)
				{
					berricsOn=false;
					System.out.println(false);
				}
				else {
					berricsOn=true;
					System.out.println(true);
				}
			}
		});
		enableBerrics.setHorizontalAlignment(SwingConstants.CENTER);
		enableBerrics.setBounds(453, 204, 192, 49);
		contentPane.add(enableBerrics);
		
		JButton historyBtn = new JButton("history");
		historyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hist.setVisible(true);
			}
		});
		historyBtn.setBounds(603, 95, 117, 29);
		contentPane.add(historyBtn);
		
		JButton wildCardBtn = new JButton("Wild Card");
		wildCardBtn.setBounds(22, 50, 91, 29);
		contentPane.add(wildCardBtn);

		JButton rollBtn = new JButton("Roll");//dont forget exclude functionality!
		rollBtn.setBounds(121, 50, 91, 29);
		contentPane.add(rollBtn);
		
		JButton saveSkate = new JButton("save game");
		saveSkate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fwHistory=new FileWriter("letters.txt");
					BufferedWriter writer=new BufferedWriter(fwHistory);
					String player1=letter.getLetters();
					String player2=letter_1.getLetters();
					if(player1.equals(""))
						writer.write("0"+"\n");
					else
						writer.write(player1+"\n");
					if(player2.equals(""))
						writer.write("0"+"\n");
					else
						writer.write(player2+"\n");					
//					writer.write(player1+"\n"+player2+"\n");
					writer.close();
					fwHistory.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		saveSkate.setBounds(16, 314, 117, 29);
		contentPane.add(saveSkate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 36, 506, 49);
		contentPane.add(scrollPane);
		
				JTextArea trickOutput = new JTextArea();
				scrollPane.setViewportView(trickOutput);
				trickOutput.setWrapStyleWord(true);
				trickOutput.setEditable(false);
				trickOutput.setLineWrap(true);

		wildCardBtn.addActionListener(new ActionListener() {//wild and roll button only add a row to table, loading from txt file to table goes somewhere else
			public void actionPerformed(ActionEvent e) {
				WildCard wild = new WildCard();
				String finalTrick = "";
				String trick = "";
				for (int i = 0; i < numTricksValue; i++) {
					trick = wild.getTrick();
					finalTrick = finalTrick + trick + ", ";
				}
				finalTrick = finalTrick.substring(0, finalTrick.length() - 2);
				trickOutput.setText(finalTrick);
				hist.newHistory(0, difficultyValue, obstacleValue, finalTrick);
				try {
					FileWriter fwHistory=new FileWriter("history.txt", true);
					BufferedWriter writer=new BufferedWriter(fwHistory);
					writer.write("w/"+finalTrick+"\n");
					writer.close();
					fwHistory.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		rollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(difficultyValue.equals("")||obstacleValue.equals("")) {					
					return;
				}
				Roll rollTrick=new Roll();
				String finalTrick = "";
				String trick = "";
				for (int i = 0; i < numTricksValue; i++) {
					trick = rollTrick.getTrick(difficultyValue,obstacleValue,berricsOn);
					boolean hasExcl=true;//so it can enter the loop
					try//this is a really stupid way to check for excluded
					{
						while(hasExcl==true)//as long as trick contains excluded
						{
							hasExcl=false;//assumes trick doesn't contain excluded
							Scanner sc=new Scanner(new File("excluded.txt"));
							while(sc.hasNextLine())//running thru file
							{
								if(trick.contains(sc.nextLine()))
								{
									hasExcl=true;//true if trick contains excluded
									trick = rollTrick.getTrick(difficultyValue,obstacleValue,berricsOn);//re-roll
								}
							}
							//go thru each line in excluded.txt
							//if trick contains excluded trick re-roll and start from beginning of file
							sc.close();
						}
						
					}catch(IOException e1)
					{
						System.out.println("Error: "+e1.getMessage());
					}
					finalTrick = finalTrick + trick + ", ";
				}
				finalTrick = finalTrick.substring(0, finalTrick.length() - 2);
				trickOutput.setText(finalTrick);
				hist.newHistory(0, difficultyValue, obstacleValue, finalTrick);
//				if(finalTrick=="")//does not save blank rolls to history; does not work
//					return;
				try {
					FileWriter fwHistory=new FileWriter("history.txt", true);
					BufferedWriter writer=new BufferedWriter(fwHistory);
					writer.write(difficultyValue+" "+obstacleValue+" "+finalTrick+"\n");
					writer.close();
					fwHistory.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});


	}
}
