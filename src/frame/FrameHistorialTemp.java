package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import bbdd.Conexion;
import bbdd.EntrenadorService;
import bbdd.JugadorService;
import cadiz.Entrenador;
import cadiz.Jugador;



public class FrameHistorialTemp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ImageIcon escudo = new ImageIcon("img/escudo.jpeg");
	private JButton btnVolver;
	private JButton btnDatos;
	private JButton btnPlantilla;
	private JButton btnEntrenador;
	private Map<String, String> temporadas = new HashMap<>();
	private JLabel lblNewLabel_2_2_3;
	private JTextField textField_3;

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
	public FrameHistorialTemp() {
		super("Historial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		
		JLabel lblNewLabel_2_2 = new JLabel("Temporadas en Primera: ");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 87, 239, 20);
		contentPane.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(259, 84, 353, 23);
		textField.setText("16");
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText("42");
		textField_1.setBounds(259, 117, 353, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText("16");
		textField_2.setBounds(259, 152, 353, 20);
		contentPane.add(textField_2);
		
		
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
		
		btnPlantilla = new JButton("Plantilla");
		btnPlantilla.setForeground(new Color(255, 255, 0));
		btnPlantilla.setBackground(new Color(0, 0, 255));
		btnPlantilla.setBounds(518, 512, 128, 37);
		contentPane.add(btnPlantilla);
		btnPlantilla.addActionListener(manejador);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Temporadas en Segunda: ");
		lblNewLabel_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(10, 117, 239, 20);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Temporadas en Segunda B: ");
		lblNewLabel_2_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2.setBounds(10, 149, 239, 20);
		contentPane.add(lblNewLabel_2_2_2);
		
		lblNewLabel_2_2_3 = new JLabel("Temporadas en Tercera: ");
		lblNewLabel_2_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_3.setBounds(10, 179, 239, 20);
		contentPane.add(lblNewLabel_2_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText("12");
		textField_3.setBounds(259, 182, 353, 20);
		contentPane.add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 235, 532, 234);
		contentPane.add(panel);
		createChartPanel(panel);
		
		
		setVisible(true);
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
			} else if(e.getSource() == btnEntrenador) {
				try {
					FrameEntrenador entrenador = new FrameEntrenador();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			} else if(e.getSource() == btnPlantilla) {
				FramePlantilla plantilla = new FramePlantilla();
				dispose();
			}
		}

	}

	private void createChartPanel(JPanel panel) {
        DefaultCategoryDataset dataset = createDataset(temporadas);
        JFreeChart chart = ChartFactory.createBarChart(
                "Historial de temporadas Cádiz CF",
                "Categoría",
                "División",
                dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.setLayout(new BorderLayout()); 
        panel.removeAll(); 
        panel.add(chartPanel, BorderLayout.CENTER); 
        panel.validate(); 
    }
	
	private DefaultCategoryDataset createDataset(Map<String, String> temporadas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (temporadas == null) {
            return dataset;
        }
    
        temporadas.put("Primera", "16");
        temporadas.put("Segunda", "42ª");
        temporadas.put("Segunda B", "16ª");
        temporadas.put("Tercera", "12ª");
        
        
        for(Map.Entry<String, String> entry : temporadas.entrySet()) {
        	String division = entry.getKey(); 
            String temporadasStr = entry.getValue(); 

            int temporadasInt = Integer.parseInt(temporadasStr.replace("ª", "").trim()); 
            
            dataset.addValue(temporadasInt, "Número de Temporadas", division); 
        }

        return dataset;
    }
}
