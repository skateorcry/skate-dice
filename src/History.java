import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable historyTable;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 260);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("difficulty");
		model.addColumn("obstacle");
		model.addColumn("trick(s)");
		historyTable = new JTable(model);
		scrollPane.setViewportView(historyTable);
		
		JButton closeHistory = new JButton("close window");
		closeHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeHistory.setBounds(327, 276, 117, 29);
		contentPane.add(closeHistory);
		
		JButton clearHistory = new JButton("clear history");
		clearHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
				{
				int option=JOptionPane.showConfirmDialog(null,"clear all?","confirm clear",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION)
				{
					try {
						FileWriter history=new FileWriter("history.txt");
						model.setRowCount(0);
						history.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
						}
		});
		clearHistory.setBounds(6, 276, 117, 29);
		contentPane.add(clearHistory);
		
		try {
		Scanner sc=new Scanner(new File("history.txt"));
		while(sc.hasNextLine())
		{
			String fullTrick=sc.nextLine();
			if(fullTrick.substring(0,2).equals("w/"))
				model.insertRow(0, new String[] {"","",fullTrick.substring(2)});
			else
			{
				String difficulty="";
				String obstacle="";
				for(int i=0;i<2;i++)
				{
					int nextInd=fullTrick.indexOf(" ");
					switch(i)
					{
					case 0: difficulty=fullTrick.substring(0,nextInd);
						break;
					case 1: obstacle=fullTrick.substring(0,nextInd);
					}
					
					fullTrick=fullTrick.substring(nextInd+1);
				}
				if(difficulty.equals("difficulty"))
					difficulty="";
				if(obstacle.equals("obstacle"))
					obstacle="";
				model.insertRow(0, new String[] {difficulty,obstacle,fullTrick});
			}
		}
		sc.close();
		}catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void newHistory(int row, String difficulty, String obstacle, String trick) 
	{
		model.insertRow(row, new String[] {difficulty,obstacle,trick});
	}
	}
