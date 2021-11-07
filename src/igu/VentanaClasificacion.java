package igu;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logica.CompeticionModel;

public class VentanaClasificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JList<String> clasificacion;
	private DefaultListModel<String> model;
	private JTable table;
	private JScrollPane scrollLista;
	private JLabel label;

	CompeticionModel cm = new CompeticionModel();
	private String id;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaClasificacion frame = new VentanaClasificacion(2113);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaClasificacion(String id) {
		this.id = id;
		setTitle("Clasificación:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getListaClasificacion());
		contentPane.add(getScroll());
		contentPane.add(getLblCompeticiones());
	}

	private JLabel getLblCompeticiones() {
		if (label == null) {
			label = new JLabel("A continuación se muestra la clasificacion de "
					+ (cm.getCompeticionById(String.valueOf(id)).get(0).getNombre()));
			label.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			label.setBounds(24, 6, 889, 186);
		}
		return label;
	}

	private JScrollPane getScroll() {
		if (scrollLista == null) {
			scrollLista = new JScrollPane();
			scrollLista.setBounds(10, 148, 656, 271);
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

//	private JTable getTable() {
//		if (table == null) {
//			table = new JTable();
//			table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
//			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			table.setSelectionBackground(Color.YELLOW);
//			table.setBackground(Color.LIGHT_GRAY);
//			DefaultTableModel modelo = new DefaultTableModel();
//			table.setModel(modelo);
//			modelo.addColumn("Iden");modelo.addColumn("Nombre");modelo.addColumn("Fecha Comp");modelo.addColumn("Tipo");modelo.addColumn("Distancia");modelo.addColumn("Cuota");modelo.addColumn("Fecha Fin Insc");modelo.addColumn("Plazas");
//			List<CompeticionDto> competiciones = comp.getCompetcionesFechaLista(textFecha.getText());
//			String[][] info = new String[competiciones.size()][8];
//			//List<AtletaDto> atletas = getAtletas();
//			//List<InscripcionDto> inscripciones = getInscripciones();
//			
//			for(int i = 0; i < competiciones.size(); i++) {
//				info[i][0] = String.valueOf(competiciones.get(i).getId());
//				info[i][1] = competiciones.get(i).getNombre();info[i][2] = competiciones.get(i).getF_comp();
//				info[i][3] = competiciones.get(i).getTipo();info[i][4] = competiciones.get(i).getDistancia()+"km";
//				info[i][5] = String.valueOf(competiciones.get(i).getCuota())+"\u20AC";info[i][6] = competiciones.get(i).getF_fin();
//				info[i][7] = String.valueOf(competiciones.get(i).getNum_plazas());
//				modelo.addRow(info[i]);
//			}
//		}
//		
//		return table;
//	}
}
