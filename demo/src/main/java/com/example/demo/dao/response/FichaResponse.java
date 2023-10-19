package com.example.demo.dao.response;

import java.util.Date;
import java.util.List;

import com.example.demo.models.Ficha;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FichaResponse {
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
	
}
