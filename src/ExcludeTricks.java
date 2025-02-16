import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExcludeTricks extends JFrame {

	private JPanel contentPane;
	private JTextField excludeTricksField;
	private String exclTrick;
	private ExcludeList exclList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcludeTricks frame = new ExcludeTricks();
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
	public ExcludeTricks() {
		exclList=new ExcludeList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("invisible");
		btnNewButton.setEnabled(true);
		btnNewButton.setBounds(493, 6, 1, 1);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(true);
		
		excludeTricksField = new HintTxtField("enter trick to exclude");
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel clicked=(JPanel)e.getSource();
				clicked.requestFocusInWindow();
			}
		});
		excludeTricksField.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		excludeTricksField.setBounds(6, 35, 438, 38);
		contentPane.add(excludeTricksField);
		excludeTricksField.setColumns(10);

		
		JButton seeExcl = new JButton("see excluded tricks");
		seeExcl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exclList.setVisible(true);
			}
		});
		seeExcl.setBounds(6, 85, 166, 29);
		contentPane.add(seeExcl);
		
		JButton enterBtn = new JButton("enter");

		
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exclTrick=excludeTricksField.getText();
				if(exclTrick.equals(""))
					return;
				exclList.insert(exclTrick);
				try {
					FileWriter fwExcl=new FileWriter("excluded.txt",true);
					BufferedWriter writer=new BufferedWriter(fwExcl);
					writer.write(exclTrick+"\n");
					writer.close();
					fwExcl.close();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
				excludeTricksField.setText("");
			}
		});
		enterBtn.setBounds(166, 85, 117, 29);
		contentPane.add(enterBtn);
		
		JLabel lblNewLabel = new JLabel("exclude tricks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 6, 127, 16);
		contentPane.add(lblNewLabel);
		
		JButton closeExcludeTricks = new JButton("close window");
		closeExcludeTricks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeExcludeTricks.setBounds(327, 85, 117, 29);
		contentPane.add(closeExcludeTricks);
		

	}
}
