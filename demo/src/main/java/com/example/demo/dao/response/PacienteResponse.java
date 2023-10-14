package com.example.demo.dao.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponse {

	private Long nopaciente;
	private String name;
	private String street;
	private Integer numero_exterior;
	private Integer numero_interior;
	private String colonia;
	private Integer cp;
	private String estado;
	private String poblacion;
	private Long telefono_1;
	private Long telefono_2;
	private Long telefono_3; 
	private String ocupacion;
	private String sexo;
	private String grupo_sanguineo;
	private String rh;
	private Date fecha_de_nacimiento;
	private String lugar_de_nacimiento;
	private Date fecha_de_alta;
	private Date fecha_ultima_visita;
	private String familiar;
	private String recomendado_por;
}
