package com.example.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nopaciente;
	@Column(length = 80)
	private String name; 
	@Column(length = 80)
	private String street;
	@Column(length = 4)
	private Integer numero_exterior;
	@Column(length = 4)
	private Integer numero_interior;
	@Column(length = 50)
	private String colonia;
	@Column(length = 5)
	private Integer cp;
	@Column(length = 50)
	private String estado;
	@Column(length = 80)
	private String poblacion;
	private Long telefono_1;
	private Long telefono_2;
	private Long telefono_3; 
	@Column(length = 100)
	private String ocupacion;
	@Column(length = 3)
	private String sexo;
	@Column(length = 3)
	private String grupo_sanguineo;
	@Column(length = 3)
	private String rh;
	private Date fecha_de_nacimiento;
	private String lugar_de_nacimiento;
	private Date fecha_de_alta;
	private Date fecha_ultima_visita;
	@Column(length = 120)
	private String familiar;
	@Column(length = 80)
	private String recomendado_por;
	//@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = false)
	//private List<Ficha> fichas; 
	
	
}
