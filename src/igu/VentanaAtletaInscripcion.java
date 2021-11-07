package igu;

import static java.time.temporal.ChronoUnit.DAYS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.AtletaDto;
import logica.AtletaModel;
import logica.CompeticionDto;
import logica.InscripcionDto;
import logica.InscripcionModel;

public class VentanaAtletaInscripcion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private CompeticionDto competition;
	private JLabel lblTituloInscripciones;
	private JLabel lblDniAtleta;
	private JLabel lblNombre;
	private Panel panel;
	private Panel pnlAtletaInsTitulo;
	private Panel pnlTxtArea;
	private JTable table;
	private JLabel lblCategoria;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private InscripcionModel im;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaAtletaInscripcion frame = new VentanaAtletaInscripcion();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param comp
	 * @throws SQLException
	 */
	public VentanaAtletaInscripcion(CompeticionDto comp) throws SQLException {
		setMinimumSize(new Dimension(550, 200));
		this.competition = comp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLblTituloInscripciones(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		this.im = new InscripcionModel();
		updateEstadosIncripciones();
	}

	private JLabel getLblTituloInscripciones() {
		if (lblTituloInscripciones == null) {
			lblTituloInscripciones = new JLabel("Inscripciones para la " + this.competition.getNombre());
			lblTituloInscripciones.setHorizontalTextPosition(SwingConstants.CENTER);
			lblTituloInscripciones.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		}
		return lblTituloInscripciones;
	}

	private JLabel getLblDniAtleta() {
		if (lblDniAtleta == null) {
			lblDniAtleta = new JLabel("DNI");
			lblDniAtleta.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblDniAtleta;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNombre;
	}

	private AtletaDto getAtleta(String dni) throws SQLException {
		AtletaModel am = new AtletaModel();
		return am.findAtletaByDni(dni);
	}

	private List<InscripcionDto> getInscripciones() throws SQLException {
		InscripcionModel im = new InscripcionModel();
		return im.getInscripcionesDeUnaCompeticion(this.competition.getId());
	}

	private Panel getPanel() throws SQLException {
		if (panel == null) {
			panel = new Panel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPnlAtletaInsTitulo(), BorderLayout.NORTH);
			panel.add(getPanel_1_1(), BorderLayout.CENTER);
		}
		return panel;
	}

	private Panel getPnlAtletaInsTitulo() throws SQLException {
		if (pnlAtletaInsTitulo == null) {
			pnlAtletaInsTitulo = new Panel();
			pnlAtletaInsTitulo.setLayout(new GridLayout(0, 5, 0, 0));
			pnlAtletaInsTitulo.add(getLblDniAtleta());
			pnlAtletaInsTitulo.add(getLblNombre());
			pnlAtletaInsTitulo.add(getLblCategoria());
			pnlAtletaInsTitulo.add(getLblFecha());
			pnlAtletaInsTitulo.add(getLblEstado());
		}
		return pnlAtletaInsTitulo;
	}

	private Panel getPanel_1_1() throws SQLException {
		if (pnlTxtArea == null) {
			pnlTxtArea = new Panel();
			pnlTxtArea.setLayout(new BorderLayout(0, 0));
			pnlTxtArea.add(getTable(), BorderLayout.CENTER);
		}
		return pnlTxtArea;
	}

	private JTable getTable() throws SQLException {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			table.setSelectionBackground(new Color(106, 31, 109));
			table.setBackground(Color.WHITE);
			DefaultTableModel modelo = new DefaultTableModel();
			// tabla cambaida
			table.setModel(modelo);
			modelo.addColumn("DNI");
			modelo.addColumn("Nombre");
			modelo.addColumn("Categoría");
			modelo.addColumn("Fecha");
			modelo.addColumn("Estado");
			String[][] info = new String[getInscripciones().size()][5];
			List<InscripcionDto> inscripciones = getInscripciones();
			AtletaDto a;

			for (int i = 0; i < inscripciones.size(); i++) {
				a = getAtleta(inscripciones.get(i).getDni_a());
				info[i][0] = a.getDni();
				info[i][1] = a.getNombre();
				info[i][2] = inscripciones.get(i).getCategoria();
				info[i][3] = inscripciones.get(i).getFecha();
				info[i][4] = inscripciones.get(i).getEstado();
				modelo.addRow(info[i]);
			}
		}
		return table;
	}

	private JLabel getLblCategoria() {
		if (lblCategoria == null) {
			lblCategoria = new JLabel("Categoría");
		}
		return lblCategoria;
	}

	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha");
		}
		return lblFecha;
	}

	private JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("Estado");
		}
		return lblEstado;
	}

	private void updateEstadosIncripciones() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			archivo = new File("banco" + competition.getNombre().strip().toLowerCase());
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				// Procesar la línea
				updateInscripcion(linea);
				i++;
			}
			System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void updateInscripcion(String linea) {
		// DNI @ dia-mes-año @ cantidad ingresada
		String[] line = linea.split("@");
		String dnia = line[0];

		InscripcionDto ins = im.findInsByDniId(dnia, this.competition.getId());

		float cuota = this.competition.getCuota();
		LocalDate ahora = LocalDate.now();
		String[] dateFichero = line[1].split("-");
		LocalDate date = LocalDate.of(Integer.valueOf(dateFichero[2]), Integer.valueOf(dateFichero[1]),
				Integer.valueOf(dateFichero[0]));
		long dias = DAYS.between(date, ahora);
		if (dias < 3) {
			im.actualizarInscripcionEstado("INSCRITO", dnia, this.competition.getId());
		}
		// TODO
	}
}
