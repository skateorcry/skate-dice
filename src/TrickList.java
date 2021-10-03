import java.awt.BorderLayout;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TrickList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrickList frame = new TrickList();
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
	public TrickList() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("stance");
		lblNewLabel.setBounds(21, 21, 67, 25);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("regular");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 58, 51, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("fakie");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(118, 58, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("switch");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(191, 58, 61, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("nollie");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(264, 58, 61, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblDirection = new JLabel("direction");
		lblDirection.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblDirection.setBounds(21, 102, 158, 25);
		contentPane.add(lblDirection);
		
		JLabel lblNewLabel_1_1 = new JLabel("frontside");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(55, 139, 75, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("backside");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setBounds(142, 139, 87, 16);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblRotation = new JLabel("rotation");
		lblRotation.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRotation.setBounds(21, 186, 158, 25);
		contentPane.add(lblRotation);
		
		JLabel lblNewLabel_1_2 = new JLabel("180");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(55, 223, 51, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_4 = new JLabel("360");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setBounds(118, 223, 61, 16);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("bigspin");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBounds(191, 223, 61, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("sex change");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setBounds(264, 223, 75, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("shuv");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1.setBounds(351, 223, 75, 16);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		JLabel lblTrick = new JLabel("trick");
		lblTrick.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTrick.setBounds(21, 273, 158, 25);
		contentPane.add(lblTrick);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 310, 405, 322);
		contentPane.add(tabbedPane);
		
		JPanel flatPanel = new JPanel();
		tabbedPane.addTab("flat", null, flatPanel, null);
		flatPanel.setLayout(null);
		
		JTextPane txtpnFlat = new JTextPane();
		txtpnFlat.setEditable(false);
		txtpnFlat.setBounds(10, 10, 380, 275);
		flatPanel.add(txtpnFlat);
		
		JPanel ledgePanel = new JPanel();
		tabbedPane.addTab("ledge/curb/rail", null, ledgePanel, null);
		ledgePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 372, 264);
		ledgePanel.add(scrollPane);
		
		JTextPane txtpnLedge = new JTextPane();
		txtpnLedge.setEditable(false);
		scrollPane.setViewportView(txtpnLedge);
		
		JPanel trannyPanel = new JPanel();
		tabbedPane.addTab("transition", null, trannyPanel, null);
		trannyPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 6, 372, 264);
		trannyPanel.add(scrollPane_1);
		
		JTextPane textPnTranny = new JTextPane();
		textPnTranny.setEditable(false);
		scrollPane_1.setViewportView(textPnTranny);
		
		String total="";
		try {
			Scanner sc=new Scanner(new File("tricksFlat.txt"));
			while(sc.hasNextLine())
			{
					total=total+sc.nextLine()+"\n";
			}
			txtpnFlat.setText(total);
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String totalLedge="";
		try {
			Scanner scLedge=new Scanner(new File("tricksLedge.txt"));
			while(scLedge.hasNextLine())
			{
				String next=scLedge.nextLine();
				if((next.equals("/m")))
					next=scLedge.nextLine();
				totalLedge=totalLedge+next+"\n";
			}
			txtpnLedge.setText(totalLedge);
			scLedge.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		String totalTran="";
		try {
			Scanner scTran=new Scanner(new File("tricksTranny.txt"));
			while(scTran.hasNextLine())
			{
				String next=scTran.nextLine();
				if((next.equals("/m"))||(next.equals("/h")))
					next=scTran.nextLine();
				totalTran=totalTran+next+"\n";
			}
			textPnTranny.setText(totalTran);
			scTran.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton closeWindow = new JButton("close window");
		closeWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeWindow.setBounds(309, 620, 117, 29);
		contentPane.add(closeWindow);
	}
}
