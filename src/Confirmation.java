import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirmation extends JFrame {

	private JPanel contentPane;
	private boolean confirmed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmation frame = new Confirmation();
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
	public Confirmation() {
		confirmed=false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 97);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAreYouSure = new JLabel("are you sure?");
		lblAreYouSure.setBounds(5, 5, 278, 16);
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAreYouSure);
		
		JButton btnNewButton = new JButton("no");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmed=false;
				getConfirmation();
				System.out.println(getConfirmation());
			}
		});
		btnNewButton.setBounds(15, 33, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("yes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmed=true;
				getConfirmation();
				System.out.println(getConfirmation());
			}
		});
		btnNewButton_1.setBounds(144, 33, 117, 29);
		contentPane.add(btnNewButton_1);
	}
	public boolean getConfirmation()
	{
		return confirmed;
	}
}
