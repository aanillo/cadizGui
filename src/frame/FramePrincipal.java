package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		super("Cádiz CF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBackground(new Color(255, 255, 128));
		lblNewLabel.setBounds(55, 100, 508, 172);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		lblNewLabel.setIcon(new ImageIcon(escudo.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		textField.setBackground(new Color(0, 0, 255));
		textField.setForeground(new Color(255, 255, 0));
        textField.setBounds(66, 24, 464, 52);
        textField.setHorizontalAlignment(JTextField.CENTER); // Centrar el texto
        textField.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setText("CÁDIZ CF");
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(217, 282, 175, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FrameMenu frameMenu = new FrameMenu();
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	
}
