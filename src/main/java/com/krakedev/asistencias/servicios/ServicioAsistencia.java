package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {

	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	private final ServicioEstudiantes servicioEstudiantes;
	
	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
		if(estudiante == null) {
			return null;
		}
			//Buscar estudiante por cedula, en servicioEstudiantes
			// si no existe el estudiante retorna null
			//crea la asistencia, con la fecha y hora actuales
			Asistencia asistencia = new Asistencia(
			LocalDate.now(),
			LocalDateTime.now(),
			"P"
			);
			//crea un registro asistencia, agrega a la lista, retorna el registro creado
			RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);
			registros.add(registro);
			return registro;
			}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		ArrayList<Asistencia> resultado = new ArrayList<>();
		
		for(RegistroAsistencia registro : registros) {
			if(registro.getEstudiante().getCedula().equals(cedula)) {
				resultado.add(registro.getAsistencia());
			}
		}
		return resultado;
	}
}
