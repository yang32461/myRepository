package socket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Myframe extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	JFrame frame=new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myframe frame = new Myframe();
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
	public Myframe() {
		  
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 733);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(66, 71, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(66, 114, 54, 15);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(125, 68, 163, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 111, 163, 21);
		getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(66, 165, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7231\u597D");
		label_3.setBounds(66, 219, 54, 15);
		getContentPane().add(label_3);
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		radioButton.setBounds(125, 161, 60, 23);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(192, 161, 48, 23);
		getContentPane().add(radioButton_1);
		
		
		JCheckBox checkBox = new JCheckBox("\u6E38\u6CF3");
		checkBox.setBounds(124, 215, 54, 23);
		getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u5531\u6B4C");
		checkBox_1.setBounds(192, 215, 60, 23);
		getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u753B\u753B");
		checkBox_2.setBounds(254, 215, 54, 23);
		getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("\u9605\u8BFB");
		checkBox_3.setBounds(323, 215, 54, 23);
		getContentPane().add(checkBox_3);
		
		//JLabel lblNewLabel = new JLabel("New label");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imag=new ImageIcon("e://bg//123.jpg");
		JLabel lblNewLabel = new JLabel(imag);

		lblNewLabel.setBounds(40, 264, 281, 231);
		getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(383, 421, 93, 35);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(506, 421, 93, 35);
		getContentPane().add(button_1);
		

	}
}
