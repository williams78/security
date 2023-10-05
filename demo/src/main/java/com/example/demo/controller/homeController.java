package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class homeController {

	private static final Logger logger = LoggerFactory.getLogger(homeController.class);
	
	@GetMapping("/basic")
	public ResponseEntity<?> basic(){
				return ResponseEntity.ok("Hello");		
	} 
	
	/*Example Authentication*/
	@GetMapping("/autenticacion")
	public String autenticacion(){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		logger.info(authentication.toString());
		logger.info("Estas autenticado" + authentication.isAuthenticated());
		
		if(authentication.isAuthenticated()) {
			
			logger.info("Nombre de Usuario:" + authentication.getName() );
			logger.info("Datos Personales:" + authentication.getPrincipal() );
			logger.info("Permisos:" + authentication.getAuthorities() );
			
		}
		/*ResponseEntity.ok("Home");*/
		return authentication.getPrincipal().toString();
		
	} 

	/*Example Get Rol*/
	@GetMapping("/rol")
	public boolean rol(HttpServletRequest request) {
		
		System.out.println(request.isUserInRole("ROLE_admin"));
		if (request.isUserInRole("ROLE_admin")) {
			
			logger.info("El usuario tiene el Rol Admin");
			
		}
		   
		
		return request.isUserInRole("ROLE_admin");
	}

	
	@GetMapping("/public")
	public String endPointPublico(HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String msg = "Estás accediendo al end point sin realizar una autentificación ya que es un end point publico";
		
		if(auth.isAuthenticated() &&  !auth.getName().equals("anonymousUser")) {
			msg = "Pese a no necesitarse ya que es un end point publico estás autentificado como " + auth.getName();
		}
		return msg;
	}
	
	@GetMapping("/private")
	public String endPointPrivate(HttpServletRequest request) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return "Estas autentificado " + auth.getName().toString();
		
	}
	
	@GetMapping("/admin")
	public String roleAdmin(HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(request.isUserInRole("ROLE_admin")) {
			logger.info("El usuario " + auth.getName() + " tiene rol de Administrador");
		}else {
			logger.info("El usuario " + auth.getName() + " no tiene rol de Administrador");
		}
		
		return "Puedes Acceder a este Recurso";
	}
	
}
