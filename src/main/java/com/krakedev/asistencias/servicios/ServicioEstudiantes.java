package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {

	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public Estudiante buscarPorCedula(String cedula) {
		for(Estudiante estudiante: estudiantes) {
			if(estudiante.getCedula().equals(cedula)) {
				return estudiante;
			}
		}
		return null;
	}
	
	// no permite duplicados
	public void agregar(Estudiante estudiante) {
		Estudiante existe = buscarPorCedula(estudiante.getCedula());
		
		if(existe == null) {
			estudiantes.add(estudiante);
			System.out.println("Estudiante agregado correctamente");
		}else {
			System.out.println("Estas ingresando a un estudiante ya registrado");
		}
	}

	public void eliminar(String cedula) {
		Estudiante existe = buscarPorCedula(cedula);
		
		if(existe != null) {
			estudiantes.remove(existe);
			System.out.println("El estudiante fue eliminado correctamente");
		}else {
			System.out.println("Al estudiante que intento eliminar no se encuantra registrado en la base de datos");
		}
	}

	public void actualizar(String cedula, Estudiante nuevo) {
		Estudiante existe = buscarPorCedula(cedula);
		
		if(existe != null) {
			existe.setNombre(nuevo.getNombre());
			existe.setApellido(nuevo.getApellido());
			System.out.println("Estudiante actualizado correctamente");
		}else {
			System.out.println("Al estudiante que intento actualizar no se encuantra registrado en la base de datos");
		}
	}

	public ArrayList<Estudiante> listar() {
		return estudiantes;
	}
}
