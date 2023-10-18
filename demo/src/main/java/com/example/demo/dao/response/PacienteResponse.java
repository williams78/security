package com.example.demo.dao.response;




import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

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
	private int numero_exterior;
	private int numero_interior;
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
	@JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
	private String fecha_de_nacimiento;
	private String lugar_de_nacimiento;
	@JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
	private String fecha_de_alta;
	@JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
	private String fecha_ultima_visita;
	private String familiar;
	private String recomendado_por;
}
