import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExcludeList extends JFrame {

	private JPanel contentPane;
	private JTable excludeTable;
	private DefaultTableModel model;
	private int selectedRow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcludeList frame = new ExcludeList();
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
	public ExcludeList() {
		selectedRow = -1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 249);
		contentPane.add(scrollPane);

		model = new DefaultTableModel();
		model.addColumn("excluded tricks");
		excludeTable = new JTable(model);
		excludeTable.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(excludeTable);

		JLabel errorMsg = new JLabel("select a trick first!");
		errorMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		errorMsg.setBounds(6, 306, 117, 25);
		errorMsg.setVisible(false);
		contentPane.add(errorMsg);
		
		
		JButton removeTrickBtn = new JButton("remove trick");
		removeTrickBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRow = excludeTable.getSelectedRow();
				if(selectedRow==-1) {
					errorMsg.setVisible(true);
					return;
				}
				String rowVal=(String) excludeTable.getValueAt(selectedRow, 0);
				model.removeRow(selectedRow);// dont forget to display error if user removes trick w/o selecting row
												// first
				try {
					removeLine(rowVal);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// remove from file too
			}
		});
		removeTrickBtn.setBounds(6, 267, 117, 29);
		contentPane.add(removeTrickBtn);

		excludeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		
		JButton clearAllBtn = new JButton("clear all");
		clearAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				conf.setVisible(true);
//				if (conf.getConfirmation() == true) {
//					try {
//						FileWriter exclude = new FileWriter("excluded.txt");
//						model.setRowCount(0);
//					} catch (IOException e1) {
//						System.out.println("Error: " + e1.getMessage());
//					}
//				}
				int option=JOptionPane.showConfirmDialog(null,"clear all?","confirm clear",JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION)
				{
					try {
						FileWriter exclude = new FileWriter("excluded.txt");
						model.setRowCount(0);
						exclude.close();
					} catch (IOException e1) {
						System.out.println("Error: " + e1.getMessage());
					}
					
				}
			}
		});
		clearAllBtn.setBounds(135, 267, 117, 29);
		contentPane.add(clearAllBtn);

		JButton closeExcludeList = new JButton("close window");
		closeExcludeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeExcludeList.setBounds(327, 267, 117, 29);
		contentPane.add(closeExcludeList);
		


		try {
			Scanner sc = new Scanner(new File("excluded.txt"));
			while (sc.hasNextLine()) {
				sort(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void sort(String input) {
//		if (model.getRowCount() == 0) {
			model.insertRow(0, new String[] { input });
//			return;
//		}
//		int current = 0;
//		while ((current < model.getRowCount() && input.compareTo((String) model.getValueAt(current, 0)) > 0))// outofboundsexception
//																												// when
//																												// adding
//																												// to
//																												// very
//																												// last
//																												// row
//		{
//			current++;
//		}
//		System.out.println(current);
//		if (current == model.getRowCount()) {
//			model.addRow(new String[] { input });
//			return;
//		}
//		model.insertRow(current, new String[] { input });
	}
	public void removeLine(String toRemove) throws IOException
	{					
		File current=new File("excluded.txt");
		File temp=new File("temp.txt");
		Scanner sc=new Scanner(current);
		BufferedWriter bw=new BufferedWriter(new FileWriter(temp));
		
		while(sc.hasNextLine())
		{
			String curLine=sc.nextLine();
			if(!curLine.equals(toRemove))
				bw.write(curLine+"\n");
		}
		sc.close();
		bw.close();
		temp.renameTo(current);
	}
}
