import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BerricsRules extends JFrame {
//hi
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BerricsRules frame = new BerricsRules();
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
	
	public BerricsRules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		
		JTextArea rulesText = new JTextArea();
		rulesText.setWrapStyleWord(true);
		rulesText.setLineWrap(true);
		rulesText.setText("1. Flat ground only, but, that does not mean everything on flat ground counts\n\n\n2. No feet on the ground. That means no No Complys, no Hand plants, no Bonelesses, no grabs, and no manuals\n\n\n3. No doing tricks that slide on the ground if your opponent popped their trick\n\n\n4. Last letter gets two tries\n\n\n5. Offensive toe drag gets one do over\n\n\n6. Defensive toe drag has a bigger margin of error but will ultimately be decided by the referee\n\n\n7. If trick maker does not pop the trick but is still landed, the trick still counts\n");
		rulesText.setEditable(false);
		rulesText.setBounds(6, 6, 438, 389);
		contentPane.add(rulesText);
		
		JButton closeRules = new JButton("close window");
		closeRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeRules.setBounds(327, 400, 117, 29);
		contentPane.add(closeRules);
		
	}
}




														









