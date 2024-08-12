package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bbdd.Conexion;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

public class FrameMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[] botones;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");
	private ImageIcon datos = new ImageIcon("img/datosIcon.png");
	private ImageIcon futbol = new ImageIcon("img/futbolIcon.png");
	private ImageIcon libro = new ImageIcon("img/libroIcon.png");
	private ImageIcon reloj = new ImageIcon("img/relojIcon.png");
	private JTextField textField;
	private JButton btnDatos;
	private JButton btnEntrenador;
	private JButton btnPlantilla;
	private JButton btnHistoria;
	private Connection con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMenu frame = new FrameMenu();
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
	public FrameMenu() {
		super("Menú principal");
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cádiz CF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(28, 103, 75, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(10, 145, 116, 154);
		lblNewLabel_1.setIcon(new ImageIcon(escudo.getImage().getScaledInstance(116, 194, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1910");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setBounds(47, 333, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setBounds(296, 403, 121, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cerrarConexion();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		panel.setBounds(136, 77, 576, 316);
		contentPane.add(panel);
		
		ManejadorEventos manejador = new ManejadorEventos();
		
		btnDatos = new JButton("Datos");
		btnDatos.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDatos.setForeground(new Color(0, 0, 255));
		btnDatos.setBackground(new Color(255, 255, 0));
        btnDatos.setIcon(datos);
        btnDatos.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDatos.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel.add(btnDatos);
		btnDatos.addActionListener(manejador);
		
		btnPlantilla = new JButton("Plantilla");
		btnPlantilla.setBackground(new Color(255, 255, 0));
		btnPlantilla.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlantilla.setForeground(new Color(0, 0, 255));
        btnPlantilla.setIcon(futbol);
        btnPlantilla.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPlantilla.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel.add(btnPlantilla);
		btnPlantilla.addActionListener(manejador);
		
		btnEntrenador = new JButton("Entrenador");
		btnEntrenador.setBackground(new Color(255, 255, 0));
		btnEntrenador.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEntrenador.setForeground(new Color(0, 0, 255));
        btnEntrenador.setIcon(libro);
        btnEntrenador.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEntrenador.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel.add(btnEntrenador);
		btnEntrenador.addActionListener(manejador);
		
		btnHistoria = new JButton("Historia");
		btnHistoria.setForeground(new Color(0, 0, 255));
		btnHistoria.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHistoria.setBackground(new Color(255, 255, 0));
        btnHistoria.setIcon(reloj);
        btnHistoria.setHorizontalTextPosition(SwingConstants.CENTER);
        btnHistoria.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel.add(btnHistoria);
		btnHistoria.addActionListener(manejador);
		
		textField = new JTextField();
		textField.setText("Quien está contra el Cádiz, está contra la humanidad");
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setForeground(new Color(255, 255, 0));
		textField.setBackground(new Color(0, 0, 255));
		textField.setBounds(31, 21, 681, 46);
		textField.setHorizontalAlignment(JTextField.CENTER); // Centrar el texto
        textField.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		contentPane.add(textField);
		textField.setColumns(10);
		
		setVisible(true);
		
	}
	
	private class ManejadorEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnDatos) {
				try {
					FrameDatosCadiz datos = new FrameDatosCadiz();
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btnEntrenador) {
				try {
					FrameEntrenador entre = new FrameEntrenador();
					dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btnPlantilla) {
				FramePlantilla plantilla = new FramePlantilla();
				dispose();
			} else if(e.getSource() == btnHistoria) {
				FrameHistorialTemp temp = new FrameHistorialTemp();
				dispose();
			}
		}
		
	}

	private void cerrarConexion() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
