package RETOFINAL.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import RETOFINAL.persona.Persona;

public class Controller {
	private List<Persona> listUsuarios= List.of(new Persona("Javi","Soto","0000"),
			new Persona("Elena","Rivas","1111"),
			new Persona("Hugo","Marte","2222"),
			new Persona("admin","admin","1234")
			);
	
	@GetMapping(path="/login",produces = "text/event-stream")
	public String login(@RequestParam(value = "usuario") String usuario,@RequestParam(value = "password") String password) {
		
		List<Persona> user = listUsuarios.stream().filter(usur -> (usur.getUsuario().equals(usuario)) && (usur.getPassword().equals(password))).collect(Collectors.toList());
		if(user.get(0).getNombre().equals("admin")) {
			return "Hola " + user.get(1).getNombre() + " esta es la lista de usuarios: " + user;
		}else if(!user.get(0).getNombre().equals("admin") && user.get(0)!=null){
			return "Hola " + user.get(1).getNombre();
		}else {
			return "El usuario no existe";
		}
		
		
	}
	@GetMapping(path="/add", produces = "text/event-stream")
	public void add(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "usuario") String usuario,@RequestParam(value = "password") String password) {
		
			listUsuarios.add(new Persona("nombre","usuario","password"));
	
		
	}
	

}
