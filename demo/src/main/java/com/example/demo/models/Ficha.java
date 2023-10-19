package com.example.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ficha")
public class Ficha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado_actual;
	private String evolucion;
	private Date fecha_evolucion;
	private String motivo;
	private String motivo_consulta;
	private String peso ;
	private String presion_dbd;
	private String presion_dbi;
	private String presion_de_pie;
	private String pulso;
	private String respiraciones_por_minuto;
	private String sintomatologia;
	private String talla;
	private String temperatura;
	private Long no_ficha_evolucion;
	private Long pacienteno; 
	//@ManyToOne()
	//@JoinColumn(name="nopaciente_id")
	//private Paciente paciente;
	 
}
