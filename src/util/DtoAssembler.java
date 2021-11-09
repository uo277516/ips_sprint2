package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.AtletaDto;
import logica.CategoriaDto;
import logica.CompeticionDto;
import logica.InscripcionDto;

public class DtoAssembler {

	public static List<AtletaDto> toAtletaDtoList (ResultSet rs)
	{
		List<AtletaDto> lista = new ArrayList<AtletaDto>();
		try {
			while(rs.next())
			{
				lista.add(cogerDatosAtleta(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	private static AtletaDto cogerDatosAtleta(ResultSet rs) throws SQLException {
		AtletaDto a = new AtletaDto();
		a.setDni(rs.getString("dni"));
		a.setF_nac(rs.getString("f_nac"));
		a.setNombre(rs.getString("nombre"));
		a.setSexo(rs.getString("sexo"));
		a.setEmail(rs.getString("email"));
		return a;
	}
	
	
	
	public static List<CompeticionDto> toCompeticionDtoList (ResultSet rs)
	{
		List<CompeticionDto> lista = new ArrayList<CompeticionDto>();
		try {
			while(rs.next())
			{
				lista.add(cogerDatosCompeticion(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	private static CompeticionDto cogerDatosCompeticion(ResultSet rs) throws SQLException {
		CompeticionDto a = new CompeticionDto();
		if (rs.getString("cuota1") != null)
			a.setCuota1(Float.parseFloat(rs.getString("cuota1")));
		if (rs.getString("cuota2") != null)
			a.setCuota2(Float.parseFloat(rs.getString("cuota2")));
		if (rs.getString("cuota3") != null)
			a.setCuota3(Float.parseFloat(rs.getString("cuota3")));
		a.setDistancia(rs.getString("distancia"));
		a.setF_comp(rs.getString("f_comp"));
		if (rs.getString("f_fin1") != null)
			a.setF_fin1(rs.getString("f_fin1"));
		if (rs.getString("f_fin2") != null)
			a.setF_fin2(rs.getString("f_fin2"));
		if (rs.getString("f_fin3") != null)
			a.setF_fin3(rs.getString("f_fin3"));
		if (rs.getString("f_inicio1") != null)
			a.setF_inicio1(rs.getString("f_inicio1"));
		if (rs.getString("f_inicio2") != null)
			a.setF_inicio2(rs.getString("f_inicio2"));
		if (rs.getString("f_inicio3") != null)
			a.setF_inicio3(rs.getString("f_inicio3"));
		a.setId((rs.getString("id")));
		a.setNombre(rs.getString("nombre"));
		a.setNum_plazas(Integer.parseInt(rs.getString("num_plazas")));
		a.setTipo(rs.getString("tipo"));
		a.setDorsales_vip(Integer.parseInt(rs.getString("dorsales_vip")));
		return a;
	}
	
	public static List<CategoriaDto> toCotegoriaDtoList (ResultSet rs)
	{
		List<CategoriaDto> lista = new ArrayList<CategoriaDto>();
		try {
			while(rs.next())
			{
				lista.add(cogerDatosCategoria(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	private static CategoriaDto cogerDatosCategoria(ResultSet rs) throws SQLException {
		CategoriaDto a = new CategoriaDto();
		
		a.setId((rs.getString("id")));
		a.setNombre(rs.getString("nombre"));
		a.setEdad_min(Integer.parseInt(rs.getString("edad_min")));
		a.setEdad_max(Integer.parseInt(rs.getString("edad_max")));
		a.setSexo(rs.getString("sexo"));
		return a;
	}

	public static List<InscripcionDto> toInscripcionDtoList(ResultSet rs) {
		List<InscripcionDto> lista = new ArrayList<InscripcionDto>();
		try {
			while(rs.next())
			{
				lista.add(cogerDatosInscripcion(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static List<Integer> toListInt(ResultSet rs) throws SQLException {
		List<Integer> list = new ArrayList<>();
		list.add(rs.getInt("maximo"));
		return list;
	}

	
	
	public static InscripcionDto toInscripcionDto(ResultSet rs) throws SQLException {

        return cogerDatosInscripcion(rs);
    }
	
	
	private static InscripcionDto cogerDatosInscripcion(ResultSet rs) throws SQLException {
		InscripcionDto i = new InscripcionDto();
		if (rs.getString("cantidad_pagada")!=null)
			i.setCantidad_pagada(Float.parseFloat(rs.getString("cantidad_pagada")));
		if (rs.getString("categoria")!=null)
			i.setCategoria(rs.getString("categoria"));
		if (rs.getString("dni_a")!=null)
			i.setDni_a(rs.getString("dni_a"));
		if (rs.getString("email")!=null)
			i.setEmail(rs.getString("email"));
		if (rs.getString("fecha")!=null)
			i.setFecha(rs.getString("fecha"));
		if (rs.getString("horas")!=null)	
			i.setHoras(Integer.parseInt(rs.getString("horas")));
		if (rs.getString("id_c")!=null)
			i.setId_c(rs.getString("id_c"));
		if (rs.getString("metodo_pago")!=null)	
			i.setMetodo_pago(rs.getString("metodo_pago"));
		if (rs.getString("minutos")!=null)	
			i.setMinutos(Integer.parseInt(rs.getString("minutos")));
		if (rs.getString("estado")!=null)
			i.setEstado(rs.getString("estado"));
		return i;
	}

	public static AtletaDto toAtletaDto(ResultSet rs) throws SQLException {
		return cogerDatosAtleta(rs);
	}
	
	public static List<CompeticionDto> toCompeticionDtoListPorFecha (ResultSet rs,String fecha) 
	{
		List<CompeticionDto> lista = new ArrayList<CompeticionDto>();
		try {
			while(rs.next())
			{
				try {
					if (rs.getString("f_fin3") != null) {
						if (compararFecha(rs.getString("f_fin3"),fecha,rs.getString("f_inicio3")))
							lista.add(cogerDatosCompeticion(rs));
					}else if(rs.getString("f_fin2") != null) {
						if (compararFecha(rs.getString("f_fin2"),fecha,rs.getString("f_inicio2")))
							lista.add(cogerDatosCompeticion(rs));
					}else
						if (compararFecha(rs.getString("f_fin1"),fecha,rs.getString("f_inicio1")))
							lista.add(cogerDatosCompeticion(rs));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static boolean compararFecha(String ffin, String fecha,String fechaInicio) throws ParseException{
//		String[] fechaFin = ffin.split("/");
//		String[] fechaAcomparar = fecha.split("/");
//		String[] fInicio = fechaInicio.split("/");
		SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaFin2 = formato.parse(ffin);

		Date fecha2 = formato.parse(fecha);
		
		Date fechaI2 = formato.parse(fechaInicio);
		
		if (fechaFin2.before(fecha2)) {
			return false;
		}
		if (fecha2.before(fechaI2))  {
			return false;
		}

		return true;
		

	}

	
}
