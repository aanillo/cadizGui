package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.Conexion;
import bbdd.EquipoService;
import bbdd.JugadorService;
import cadiz.Equipo;
import cadiz.Jugador;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class FramePlantilla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");
	private JButton btnVolver;
	private JButton btnEntrenador;
	private JButton btnDatos;
	private JButton btnHistorial;
	private List<Jugador> jugadores;
	private JugadorService service;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePlantilla frame = new FramePlantilla();
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
	public FramePlantilla() {
		super("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		service = new JugadorService();
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 129, 59);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		lblNewLabel.setIcon(new ImageIcon(escudo.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);
		
		JTextField txtCadiz = new JTextField("CÁDIZ CF");
		txtCadiz.setForeground(new Color(255, 255, 0));
		txtCadiz.setBackground(new Color(0, 0, 255));
		txtCadiz.setBounds(149, 7, 525, 59);
		txtCadiz.setHorizontalAlignment(JTextField.CENTER); // Centrar el texto
        txtCadiz.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		txtCadiz.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(txtCadiz);
		
		JLabel lblNewLabel_2_1 = new JLabel("Plantilla temporada 2024/2025:");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2_1.setBounds(10, 76, 664, 28);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		ManejadorEventos manejador = new ManejadorEventos();
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 0));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setBounds(48, 512, 122, 37);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(manejador);
		
		btnDatos = new JButton("Datos");
		btnDatos.setForeground(new Color(255, 255, 0));
		btnDatos.setBackground(new Color(0, 0, 255));
		btnDatos.setBounds(206, 512, 122, 37);
		contentPane.add(btnDatos);
		btnDatos.addActionListener(manejador);
		
		btnEntrenador = new JButton("Entrenador");
		btnEntrenador.setForeground(new Color(255, 255, 0));
		btnEntrenador.setBackground(new Color(0, 0, 255));
		btnEntrenador.setBounds(362, 512, 122, 37);
		contentPane.add(btnEntrenador);
		btnEntrenador.addActionListener(manejador);
		
		btnHistorial = new JButton("Historial");
		btnHistorial.setForeground(new Color(255, 255, 0));
		btnHistorial.setBackground(new Color(0, 0, 255));
		btnHistorial.setBounds(518, 512, 128, 37);
		contentPane.add(btnHistorial);
		btnHistorial.addActionListener(manejador);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 114, 609, 376);
		contentPane.add(scrollPane);
		
		table = new JTable();
		mostrarPlantilla();
		scrollPane.setViewportView(table);
		
		setVisible(true);
	}
	
	
	private void mostrarPlantilla() {
		try {
			this.jugadores = this.service.getJugadores(Conexion.obtener());
			table.setModel(new DefaultTableModel(new Object[][] {

			}, new String[] { "Nombre", "Posición", "Edad", "Dorsal", "Nacionalidad" }));
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			for (int i = 0; i < this.jugadores.size(); i++) {
				dtm.addRow(new Object[] { 
						this.jugadores.get(i).getNombre(), 
						this.jugadores.get(i).getPosicion(),
						this.jugadores.get(i).getEdad(),
						this.jugadores.get(i).getDorsal(),
						this.jugadores.get(i).getNacionalidad()
				});
			}
	
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}
	
	
	
	private class ManejadorEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnVolver) {
				FrameMenu menu = new FrameMenu();
				dispose();
			} else if(e.getSource() == btnEntrenador) {
				try {
					FrameEntrenador entren = new FrameEntrenador();
					dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btnDatos) {
				try {
					FrameDatosCadiz datos = new FrameDatosCadiz();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			} else if(e.getSource() == btnHistorial) {
				FrameHistorialTemp temp = new FrameHistorialTemp();
				dispose();
			}
		}
		
	}
}
