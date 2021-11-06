package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.BaseDatos;
import util.DtoAssembler;

public class CompeticionModel {

	public static String sql1 = "select * from competicion";
	public static String sql2ById = "select * from competicion where id=?";
	public static String sqlActualizarPlazas = "update competicion set num_plazas = num_plazas-1 where id =?";
	public static String sqlInsertarCompeticionBasicos = "insert into competicion (nombre,f_comp,tipo,distancia,num_plazas,id) values (?,?,?,?,?,?)";
	
	private InscripcionModel im = new InscripcionModel();
	private AtletaModel am = new AtletaModel();

	public List<CompeticionDto> getCompeticiones() throws SQLException {
		return getAllCompeticiones();
	}

	public CompeticionDto[] getCompeticionesArray() {
		CompeticionDto[] articulos = null;
		try {
			articulos = getAllCompeticiones().toArray(new CompeticionDto[getAllCompeticiones().size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articulos;
	}

	private List<CompeticionDto> getAllCompeticiones() throws SQLException {
		List<CompeticionDto> listaCompeticiones = new ArrayList<CompeticionDto>();

		// Conexi�n a la base de datos
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = BaseDatos.getConnection();
			pst = c.prepareStatement(sql1);
			rs = pst.executeQuery();

			// A�adimos los pedidos a la lista
			listaCompeticiones = DtoAssembler.toCompeticionDtoList(rs);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
			c.close();
		}

		for (CompeticionDto atletaDto : listaCompeticiones) {
			System.out.println(atletaDto);
		}
		return listaCompeticiones;
	}

	public CompeticionDto[] getCompetcionesFecha(String fecha) {
		CompeticionDto[] articulos = null;
		try {
			articulos = filtrarPorFecha(fecha).toArray(new CompeticionDto[getAllCompeticiones().size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articulos;
	}

	public List<CompeticionDto> getCompetcionesFechaLista(String fecha) {
		List<CompeticionDto> articulos = null;
		try {
			articulos = filtrarPorFecha(fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articulos;
	}
	
	public void insertarDatosBasicos(String id,String nombre, String fecha,String tipo, int distancia,int plazas) {
		try {
			insertarDatosBasicosPrivado(id, nombre, fecha, tipo, distancia, plazas);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void insertarDatosBasicosPrivado(String id,String nombre, String fecha,String tipo, int distancia,int plazas) throws SQLException {
		// Conexi�n a la base de datos
		Connection c = null;
		PreparedStatement pst = null;
		try {
			c = BaseDatos.getConnection();
			pst = c.prepareStatement(sqlInsertarCompeticionBasicos);
			if (pst != null)
				System.out.println("Adios");
			
			pst.setString(1, nombre);
			pst.setString(2, fecha);
			pst.setString(3, tipo);
			pst.setInt(4, distancia);
			pst.setInt(5, plazas);
			pst.setString(6, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
			c.close();
		}
	}

	private List<CompeticionDto> filtrarPorFecha(String fecha) throws SQLException {
		List<CompeticionDto> listaCompeticiones = new ArrayList<CompeticionDto>();

		// Conexi�n a la base de datos
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = BaseDatos.getConnection();
			pst = c.prepareStatement(sql1);
			rs = pst.executeQuery();

			// A�adimos los pedidos a la lista
			listaCompeticiones = DtoAssembler.toCompeticionDtoListPorFecha(rs, fecha);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
			c.close();
		}

//        for (AtletaDto atletaDto : listaPedidos) {
//			System.out.println(atletaDto.getDni() + " " + atletaDto.getF_nac()
//			);
//		}
		return listaCompeticiones;
	}

	public List<CompeticionDto> getCompeticionById(String id) {
		List<CompeticionDto> listaCompeticiones = null;
		try {
			listaCompeticiones = getCompeticionByIdP(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCompeticiones;
	}

	public List<CompeticionDto> getCompeticionByIdP(String identificador) throws SQLException {
		List<CompeticionDto> listaCompeticiones = new ArrayList<CompeticionDto>();

		// Conexi�n a la base de datos
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = BaseDatos.getConnection();
			pst = c.prepareStatement(sql2ById);
			pst.setString(1, identificador);
			rs = pst.executeQuery();

			// A�adimos los pedidos a la lista
			listaCompeticiones = DtoAssembler.toCompeticionDtoList(rs);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			pst.close();
			c.close();
		}

		for (CompeticionDto atletaDto : listaCompeticiones) {
			System.out.println(atletaDto);
		}
		return listaCompeticiones;
	}

	public void actualizarPlazas(String id) {
		try {
			actualizarPlazasP(id);
		} catch (SQLException e) {
			System.out.println("no se pudo actuliazar");
			e.printStackTrace();
		}
	}

	private void actualizarPlazasP(String id) throws SQLException {
		// Conexi�n a la base de datos
		Connection c = null;
		PreparedStatement pst = null;
//        ResultSet rs = null;
		try {
			c = BaseDatos.getConnection();
			pst = c.prepareStatement(sqlActualizarPlazas);
			pst.setString(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			pst.close();
			c.close();
		}

	}

	public void listarClasificacion(String carreraId) throws SQLException {
		AtletaDto a;
		List<InscripcionDto> inscripciones = im.getInscripcionesPorTiempo(carreraId);
		System.out.println("----- Clasificacion general -----");
		for (InscripcionDto i : inscripciones) {
			a = am.findAtletaByDni(i.getDni_a());
			if (i.getHoras() == 0 && i.getMinutos() == 0)
				System.out.println("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: --- ");
			else
				System.out.println("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: " + i.getHoras()
						+ "h " + i.getMinutos() + " minutos");
		}
	}

	public void listarClasificacionPorCategoria(int carreraId, String sql) throws SQLException {
		listarClasificacionPorSexo(carreraId, "masculino");
		listarClasificacionPorSexo(carreraId, "femenino");
	}

	public void listarClasificacionPorSexo(int carreraId, String sexo) throws SQLException {
		AtletaDto a;
		List<InscripcionDto> inscripciones = im.getInscripcionesPorTiempoYSexo(carreraId, sexo);
		System.out.println("----- Clasificacion sexo " + sexo + " -----");
		for (InscripcionDto i : inscripciones) {
			a = am.findAtletaByDni(i.getDni_a());
			if (i.getHoras() == 0 && i.getMinutos() == 0)
				System.out.println("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: --- ");
			else
				System.out.println("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: " + i.getHoras()
						+ "h " + i.getMinutos() + " minutos");
		}
	}

	public List<String> getClasificacion(String carreraId) throws SQLException {
		List<String> clasificacion = new ArrayList<String>();
		AtletaDto a;
		List<InscripcionDto> inscripciones = im.getInscripcionesPorTiempo(carreraId);
		System.out.println("----- Clasificacion general -----");
		for (InscripcionDto i : inscripciones) {
			a = am.findAtletaByDni(i.getDni_a());
			if (i.getHoras() == 0 && i.getMinutos() == 0)
				clasificacion.add("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: --- ");
			else
				clasificacion.add("Nombre: " + a.getNombre() + " - Sexo: " + a.getSexo() + " - Tiempo: " + i.getHoras()
						+ "h " + i.getMinutos() + " minutos");
		}
		return clasificacion;
	}
}
