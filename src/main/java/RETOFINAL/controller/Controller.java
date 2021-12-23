package RETOFINAL.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import RETOFINAL.persona.Persona;
import reactor.core.publisher.Flux;

public class Controller {
	private List<Persona> listUsuarios= List.of(new Persona("Javi","Soto","0000"),
			new Persona("Elena","Rivas","1111"),
			new Persona("Hugo","Marte","2222"),
			new Persona("admin","admin","1234")
			);
	
	@GetMapping(path="/login",produces = "text/event-stream")
	public Flux<String> login(@RequestParam(value = "usuario") String usuario,@RequestParam(value = "password") String password) {
		
		flux.List<Persona> user = listUsuarios.stream().filter(usur -> (usur.getUsuario().equals(usuario)) && (usur.getPassword().equals(password))).collect(Collectors.toList());
		if(user.user.get(1).getNombre().equals("admin")) {
			return "Hola " + user.get(1).getNombre() + " esta es la lista de usuarios: " + user;
		}else if(user.get(1).getNombre()){
			return "Hola " + user.get(1).getNombre();
		}else {
			return "El usuario no existe";
		}
		
	}
	@GetMapping(path="/add", produces = "text/event-stream")
	public Flux<String> add(@RequestParam(value = "usuario") String usuario,@RequestParam(value = "password") String password) {
		if(usuario=="admin" && password=="admin") {
			listUsuarios.add("usuario","usuario","password");
		}
		
	}
	
	

	@GetMapping(path = "/numbers", produces = "text/event-stream")
	public Flux<Integer> numbers() {

		Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));
		flux.subscribe(n -> subscriber.print(n)); // Suscriptor 1
		flux.subscribe(n -> System.out.println("Subscriber 2: " + n)); // Suscriptor 2

		return flux; // Suscriptor 3
}
}
