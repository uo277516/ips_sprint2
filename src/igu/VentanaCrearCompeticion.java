package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import logica.CompeticionModel;

@SuppressWarnings("serial")
public class VentanaCrearCompeticion extends JFrame {

	private JPanel contentPane;
	private CompeticionModel comp;
	private JTextArea txtAreaInfo;
	private JPanel pnDatosBasicos;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblFechaComp;
	private JTextField txtFechaComp;
	private JLabel lblFormato;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblDistancia;
	private JTextField txtDistancia;
	private JLabel lblPlazas;
	private JTextField txtPlazas;
	private JButton btnValidar;
	private JLabel lblTiposCarreras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearCompeticion frame = new VentanaCrearCompeticion();
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
	public VentanaCrearCompeticion() {
		comp = new CompeticionModel();
		setTitle("Creaci\u00F3n de competiciones:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 726);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtAreaInfo());
		contentPane.add(getPnDatosBasicos());
	}
	private JTextArea getTxtAreaInfo() {
		if (txtAreaInfo == null) {
			txtAreaInfo = new JTextArea();
			txtAreaInfo.setEditable(false);
			txtAreaInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtAreaInfo.setText("Para crear una nueva competici\u00F3n deber\u00E1 ingresar los siguientes datos b\u00E1sicos: \r\nnombre, fecha competici\u00F3n, tipo carrera, distancia y plazas.\r\nUna vez introducidos se deber\u00E1n planificar los plazos de isncripci\u00F3n. M\u00EDnimo uno y m\u00E1ximo 3.\r\nPor \u00FAltimo se han de especificar las distintas categor\u00EDas que tendr\u00E1 la competici\u00F3n.");
			txtAreaInfo.setBounds(20, 11, 561, 82);
		}
		return txtAreaInfo;
	}
	private JPanel getPnDatosBasicos() {
		if (pnDatosBasicos == null) {
			pnDatosBasicos = new JPanel();
			pnDatosBasicos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos b\u00E1sicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosBasicos.setBackground(Color.WHITE);
			pnDatosBasicos.setBounds(30, 111, 551, 290);
			pnDatosBasicos.setLayout(null);
			pnDatosBasicos.add(getLblNombre());
			pnDatosBasicos.add(getTxtNombre());
			pnDatosBasicos.add(getLblFechaComp());
			pnDatosBasicos.add(getTxtFechaComp());
			pnDatosBasicos.add(getLblFormato());
			pnDatosBasicos.add(getLblTipo());
			pnDatosBasicos.add(getTxtTipo());
			pnDatosBasicos.add(getLblDistancia());
			pnDatosBasicos.add(getTxtDistancia());
			pnDatosBasicos.add(getLblPlazas());
			pnDatosBasicos.add(getTxtPlazas());
			pnDatosBasicos.add(getBtnValidar());
			pnDatosBasicos.add(getLblTiposCarreras());
		}
		return pnDatosBasicos;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:\r\n");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNombre.setBounds(10, 26, 68, 22);
		}
		return lblNombre;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtNombre.setBounds(103, 26, 307, 22);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	private JLabel getLblFechaComp() {
		if (lblFechaComp == null) {
			lblFechaComp = new JLabel("Fecha Comp:\r\n");
			lblFechaComp.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFechaComp.setBounds(10, 77, 84, 22);
		}
		return lblFechaComp;
	}
	private JTextField getTxtFechaComp() {
		if (txtFechaComp == null) {
			txtFechaComp = new JTextField();
			txtFechaComp.setBounds(103, 78, 121, 22);
			txtFechaComp.setColumns(10);
		}
		return txtFechaComp;
	}
	private JLabel getLblFormato() {
		if (lblFormato == null) {
			lblFormato = new JLabel("dd/MM/aaaa --- posterior a la actual");
			lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblFormato.setBounds(247, 82, 192, 17);
		}
		return lblFormato;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTipo.setBounds(10, 124, 68, 22);
		}
		return lblTipo;
	}
	private JTextField getTxtTipo() {
		if (txtTipo == null) {
			txtTipo = new JTextField();
			txtTipo.setBounds(103, 125, 121, 22);
			txtTipo.setColumns(10);
		}
		return txtTipo;
	}
	private JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Distancia:");
			lblDistancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDistancia.setBounds(10, 172, 68, 22);
		}
		return lblDistancia;
	}
	private JTextField getTxtDistancia() {
		if (txtDistancia == null) {
			txtDistancia = new JTextField();
			txtDistancia.setBounds(103, 173, 121, 23);
			txtDistancia.setColumns(10);
		}
		return txtDistancia;
	}
	private JLabel getLblPlazas() {
		if (lblPlazas == null) {
			lblPlazas = new JLabel("Plazas:");
			lblPlazas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPlazas.setBounds(10, 220, 68, 25);
		}
		return lblPlazas;
	}
	private JTextField getTxtPlazas() {
		if (txtPlazas == null) {
			txtPlazas = new JTextField();
			txtPlazas.setBounds(103, 222, 121, 22);
			txtPlazas.setColumns(10);
		}
		return txtPlazas;
	}
	private JButton getBtnValidar() {
		if (btnValidar == null) {
			btnValidar = new JButton("Validar");
			btnValidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtNombre.getText().equals("") && txtTipo.getText().equals("") || txtFechaComp.getText().equals("") || txtPlazas.getText().equals("")|| txtDistancia.getText().equals("")) {
						System.out.println("Hola");
						mostrarCamposVacios();
					}else {
						try {
							if(!soloNumerosFecha(txtFechaComp.getText())) {
								mostrarErrorFecha();
								txtFechaComp.setText(""); 
								
							}else if(!comprobarTipo(getTxtTipo().getText())) {
								mostrarErrorTipo();
								txtTipo.setText("");
							}else if (!compruebaSoloNumeros(getTxtDistancia().getText())) {
								mostrarErrorDistancia();
								txtDistancia.setText("");
							}else if (!compruebaSoloNumeros(getTxtPlazas().getText())) {
								mostrarErrorPlazas();
								txtPlazas.setText("");
							}else {
								insertarDatosBasicos();
								mostrarDatosBasicosCorrectos();
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					}
					
				}						
			});
			btnValidar.setForeground(Color.WHITE);
			btnValidar.setBackground(Color.GREEN);
			btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnValidar.setBounds(421, 257, 101, 22);
		}
		return btnValidar;
	}
	
	private void insertarDatosBasicos() {
		String id = UUID.randomUUID().toString();
		String tipo = sacarTipo();
		comp.insertarDatosBasicos(id,getTxtNombre().getText(), getTxtFechaComp().getText(), 
				tipo, Integer.parseInt(getTxtDistancia().getText()), Integer.parseInt(getTxtPlazas().getText()));
		
	}

	private String sacarTipo() {
		String tipo = getTxtTipo().getText();
		if (tipo.equals("montaña")|| tipo.equals("Montaña") || tipo.equals("MONTAÑA"))
			return "montaña";
		return "asfalto";
	}

	private boolean comprobarTipo(String text) {
		if (text.equals("montaña") || text.equals("asfalto") || text.equals("Montaña") || text.equals("Asfalto") || text.equals("MONTAÑA") || text.equals("ASFALTO"))
			return true;
		return false;
	}
	
	private void mostrarDatosBasicosCorrectos() {
		JOptionPane.showMessageDialog(this, "Se han validado los datos básicos");
	}
	
	private void mostrarErrorPlazas() {
		JOptionPane.showMessageDialog(this, "Error: Plazas incorrectas, introduzca solo números.");
		
	}
	
	private void mostrarErrorDistancia() {
		JOptionPane.showMessageDialog(this, "Error: Distancia incorrecta, introduzca solo números.");
		
	}
	
	private void mostrarCamposVacios() {
		JOptionPane.showMessageDialog(this, "Error: Campos vacios.");
		
	}
	
	private void mostrarErrorTipo() {
		JOptionPane.showMessageDialog(this, "Error: Tipo de carrera incorrecto.");
		
	}
	
	private void mostrarErrorFecha() {
		JOptionPane.showMessageDialog(this, "Error: Fecha incorrecta.");
		
	}
	
	private boolean compruebaSoloNumeros(String text) {
		String numero="";
		String minumero="";
		int textsize = text.length();
		String[] numeros= {"0","1","2","3","4","5","6","7","8","9"};
		for (int i=0;i<text.length();i++) {
			numero=text.substring(i,i+1);
			for (int j=0;j<numeros.length;j++) {
				if (numero.equals(numeros[j])) {
					minumero=minumero+numeros[j];
				}
			}
		}
		if (minumero.length()==textsize) {
			return true;
		}else
			return false;
	}

	private boolean soloNumerosFecha(String fecha) throws ParseException {
		String numero="";
		int contador =0;
		String minumero="";
		String[] posiciones = new String[fecha.length()];
		String[] numeros= {"0","1","2","3","4","5","6","7","8","9"};
		for (int i=0;i<fecha.length();i++) {
			numero=fecha.substring(i,i+1);
			for (int j=0;j<numeros.length;j++) {
				if (numero.equals(numeros[j])) {
					minumero=minumero+numeros[j];
				}
			}
			if (numero.equals("/")) {
				posiciones[i] = "/";
				contador++;
			}
		}
		SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaTarjeta = formato.parse(fecha);
		Date fechaActual = formato.parse(cambiarFormatoFecha());
		
		if (fechaTarjeta.before(fechaActual)) {
			return false;
		}
		
		if (contador==2 && minumero.length()==8) {
			if (posiciones[2] != null && posiciones[5]!=null) {
				return true;
			}else
				return false;
		}else
			return false;
	}
	
	private String cambiarFormatoFecha() {
		String fechaString = String.valueOf(LocalDate.now());
		String[] fechaPartida = fechaString.split("-");
		String result ="";
		for (int i = 0; i < fechaPartida.length; i++) {
			result="/"+fechaPartida[i]+result;
		}
		return result.substring(1);
		
	}
	
	private JLabel getLblTiposCarreras() {
		if (lblTiposCarreras == null) {
			lblTiposCarreras = new JLabel("monta\u00F1a/asfalto");
			lblTiposCarreras.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblTiposCarreras.setBounds(247, 129, 95, 17);
		}
		return lblTiposCarreras;
	}
}
