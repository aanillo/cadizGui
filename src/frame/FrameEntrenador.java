package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.Conexion;
import bbdd.EntrenadorService;
import bbdd.EquipoService;
import cadiz.Entrenador;
import cadiz.Equipo;


public class FrameEntrenador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");
	private ImageIcon entrenadorImg = new ImageIcon("img/entrenador.jpeg");
	private JButton btnVolver;
	private JButton btnDatos;
	private JButton btnPlantilla;
	private JButton btnHistorial;
	private Entrenador entrenador;
	private EntrenadorService service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEntrenador frame = new FrameEntrenador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public FrameEntrenador() throws ClassNotFoundException {
		super("Entrenador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		service = new EntrenadorService();
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(10, 87, 239, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Edad:");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(10, 141, 239, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nacionalidad: ");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(10, 200, 239, 28);
		contentPane.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(259, 84, 353, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 138, 353, 48);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 196, 353, 50);
		contentPane.add(textField_2);
		
		cargarDatosEntrenador(1);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(189, 294, 279, 157);
		lblNewLabel_3.setIcon(new ImageIcon(entrenadorImg.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_3);
		
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
	
	
	private void cargarDatosEntrenador(int codigo) throws ClassNotFoundException {
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
	        entrenador = service.getEntrenador(con, codigo);
	        
	        
	        // Comprobar si el equipo fue encontrado y mostrar los datos en los textFields
	        if (entrenador != null) {
	            textField.setText(entrenador.getNombre());
	            textField_1.setText(String.valueOf(entrenador.getEdad()));
	            textField_2.setText(entrenador.getNacionalidad());
	        } else {
	            JOptionPane.showMessageDialog(this, "Equipo no encontrado");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar los datos del entrenador");
	    }
	}
	
	
	private class ManejadorEventos implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnVolver) {
				FrameMenu menu = new FrameMenu();
				dispose();
			} else if(e.getSource() == btnDatos) {
				try {
					FrameDatosCadiz datos = new FrameDatosCadiz();
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
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
