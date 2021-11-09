package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logica.CategoriaDto;
import logica.CompeticionModel;

public class VentanaClasificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> clasificacion;
	private DefaultListModel<String> model;
	private JComboBox<String> cbCategorias;
	private JScrollPane scrollLista;
	private JLabel label;

	CompeticionModel cm = new CompeticionModel();
	private String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaClasificacion frame = new VentanaClasificacion("2113");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VentanaClasificacion(String id) throws SQLException {
		this.id = id;
		setTitle("Clasificación:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// contentPane.add(getCbCategorias());
		// contentPane.add(getScroll());
		contentPane.add(getListaClasificacion());
		// contentPane.add(getLblCompeticiones());
		crearClasificaciones();
	}

	private JLabel getLblCompeticiones() {
		if (label == null) {
			label = new JLabel("A continuación se muestra la clasificacion de "
					+ (!(cm.getCompeticionById(String.valueOf(id)).isEmpty())
							? (cm.getCompeticionById(String.valueOf(id)).get(0).getNombre())
							: "no hay"));
			label.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			label.setBounds(24, 6, 889, 186);
		}
		return label;
	}

	private JLabel getLblCategoria(String categoria, int n) {
		JLabel labelCategoria = null;
		if (labelCategoria == null) {
			labelCategoria = new JLabel("Categoria " + categoria);
			labelCategoria.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			labelCategoria.setBounds(24, 12 * n, 889, 186);
		}
		return labelCategoria;
	}

	private void crearClasificaciones() throws SQLException {
		List<CategoriaDto> categorias = cm.findCategoriasById(id);
		categorias.forEach(c -> crearClasificacion(c));

	}

	private void crearClasificacion(CategoriaDto c) {
		getLblCategoria(id, 0);
	}

	private JScrollPane getScroll() {
		if (scrollLista == null) {
			scrollLista = new JScrollPane();
			scrollLista.setBounds(10, 148, 656, 271);
			scrollLista.setBounds(10, 180, 656, 221);
			scrollLista.setViewportView(clasificacion);
		}
		return scrollLista;
	}

	private JList<String> getListaClasificacion() {
		if (clasificacion == null) {
			clasificacion = new JList<String>();
			model = new DefaultListModel<String>();
			try {
				cm.getClasificacion(id).forEach(s -> model.addElement(s));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clasificacion.setModel(model);
		return clasificacion;
	}

}
