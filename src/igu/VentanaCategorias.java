package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaCategorias extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrPuedeCrearO;
	private JLabel lblCategoriasDefecto;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblCategorias;
	private JButton btnAñadir;
	private JButton btnConfirmar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategorias frame = new VentanaCategorias();
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
	public VentanaCategorias() {
		setTitle("Ventana categorias:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtrPuedeCrearO());
		contentPane.add(getLblCategoriasDefecto());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getLblCategorias());
		contentPane.add(getBtnAñadir());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getBtnModificar());
	}
	private JTextArea getTxtrPuedeCrearO() {
		if (txtrPuedeCrearO == null) {
			txtrPuedeCrearO = new JTextArea();
			txtrPuedeCrearO.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtrPuedeCrearO.setText("Puede crear o modificar las categorias que desee. Para ello puede usar las categorias por defecto o crear una propia de la categoria. \r\nPara que el sistema valide los rangos de edades estos han de ser continuos.");
			txtrPuedeCrearO.setBounds(38, 22, 880, 70);
		}
		return txtrPuedeCrearO;
	}
	private JLabel getLblCategoriasDefecto() {
		if (lblCategoriasDefecto == null) {
			lblCategoriasDefecto = new JLabel("Categorias por defecto:");
			lblCategoriasDefecto.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCategoriasDefecto.setBounds(38, 97, 139, 20);
		}
		return lblCategoriasDefecto;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 152, 415, 225);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(503, 152, 415, 225);
		}
		return scrollPane_1;
	}
	private JLabel getLblCategorias() {
		if (lblCategorias == null) {
			lblCategorias = new JLabel("Categorias competicion:");
			lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCategorias.setBounds(503, 101, 166, 20);
		}
		return lblCategorias;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.setForeground(Color.WHITE);
			btnAñadir.setBackground(Color.GREEN);
			btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAñadir.setBounds(364, 386, 89, 23);
		}
		return btnAñadir;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnConfirmar.setBackground(Color.GREEN);
			btnConfirmar.setBounds(821, 388, 97, 23);
		}
		return btnConfirmar;
	}
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar");
			btnModificar.setForeground(Color.WHITE);
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnModificar.setBackground(Color.YELLOW);
			btnModificar.setBounds(714, 388, 97, 23);
		}
		return btnModificar;
	}
}
