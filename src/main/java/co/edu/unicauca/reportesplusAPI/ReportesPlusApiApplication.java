package co.edu.unicauca.reportesplusAPI;

import co.edu.unicauca.reportesplusAPI.models.GastoModel;
import co.edu.unicauca.reportesplusAPI.repositories.IReportePosgradosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportesPlusApiApplication implements CommandLineRunner {

	//@Autowired
	//private IReportePosgradosRepository test;
	public static void main(String[] args) {

		SpringApplication.run(ReportesPlusApiApplication.class, args);
	}

	//funcion para hacer pruebas de rapidas
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(test.obtenerMovimientos());
		//for(GastoModel a:test.obtenerMovimientos()){
	//		System.out.println(a.toString());
	//	}
		System.out.println("Hola mundo");
	}


}
