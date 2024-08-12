package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Conexion;
import bbdd.EquipoService;
import cadiz.Equipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class FrameDatosCadiz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");
	private ImageIcon estadio = new ImageIcon("img/estadio.jpeg");
	private ImageIcon leyenda = new ImageIcon("img/magico.jpg");
	private JButton btnVolver;
	private JButton btnEntrenador;
	private JButton btnPlantilla;
	private JButton btnHistorial;
	private Equipo equipo;
	private EquipoService service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDatosCadiz frame = new FrameDatosCadiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrameDatosCadiz() throws ClassNotFoundException, SQLException {
		super("Datos generales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		service = new EquipoService();
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Estadio: ");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 88, 239, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Año de fundación:");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 126, 239, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("División actual: ");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(10, 164, 239, 28);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Temporadas en primera: ");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(10, 202, 239, 28);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Leyenda: ");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_4.setBounds(10, 240, 239, 28);
		contentPane.add(lblNewLabel_2_4);
		
		textField = new JTextField();
		textField.setBounds(259, 84, 353, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 122, 353, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 160, 353, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 198, 353, 32);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(259, 236, 353, 32);
		contentPane.add(textField_4);
		
		cargarDatosEquipo(1);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(25, 318, 279, 147);
		lblNewLabel_3.setIcon(new ImageIcon(estadio.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setBounds(367, 318, 279, 147);
		lblNewLabel_3_1.setIcon(new ImageIcon(leyenda.getImage().getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_3_1);
		
		ManejadorEventos manejador = new ManejadorEventos();
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 0));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setBounds(48, 512, 122, 37);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(manejador);
		
		btnEntrenador = new JButton("Entrenador");
		btnEntrenador.setForeground(new Color(255, 255, 0));
		btnEntrenador.setBackground(new Color(0, 0, 255));
		btnEntrenador.setBounds(206, 512, 122, 37);
		contentPane.add(btnEntrenador);
		btnEntrenador.addActionListener(manejador);
		
		btnPlantilla = new JButton("Plantilla");
		btnPlantilla.setForeground(new Color(255, 255, 0));
		btnPlantilla.setBackground(new Color(0, 0, 255));
		btnPlantilla.setBounds(362, 512, 122, 37);
		contentPane.add(btnPlantilla);
		btnPlantilla.addActionListener(manejador);
		
		btnHistorial = new JButton("Historial");
		btnHistorial.setForeground(new Color(255, 255, 0));
		btnHistorial.setBackground(new Color(0, 0, 255));
		btnHistorial.setBounds(518, 512, 128, 37);
		contentPane.add(btnHistorial);
		btnHistorial.addActionListener(manejador);
		
		setVisible(true);
	}
	
	
	private void cargarDatosEquipo(int codigo) throws ClassNotFoundException {
	    Connection con = null;
		try {
	        // Establecer la conexión a la base de datos
	        Conexion conexion = new Conexion();
	        con = conexion.obtener();
	        if (con == null) {
	            JOptionPane.showMessageDialog(this, "Error en la conexión a la base de datos");
	            return;
	        }
	        
	        // Obtener el equipo
	        equipo = service.getEquipo(con, codigo);
	        
	        
	        
	        // Comprobar si el equipo fue encontrado y mostrar los datos en los textFields
	        if (equipo != null) {
	            textField.setText(equipo.getEstadio());
	            textField_1.setText(String.valueOf(equipo.getFundacion()));
	            textField_2.setText(equipo.getDivisionActual());
	            textField_3.setText(String.valueOf(equipo.getTemporadasEnPrimera()));
	            textField_4.setText(equipo.getLeyenda());
	        } else {
	            JOptionPane.showMessageDialog(this, "Equipo no encontrado");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar los datos del equipo");
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
			} else if(e.getSource() == btnPlantilla) {
				FramePlantilla plantilla = new FramePlantilla();
				dispose();
			} else if(e.getSource() == btnHistorial) {
				FrameHistorialTemp temp = new FrameHistorialTemp();
				dispose();
			}
		}
		
	}
	
}
