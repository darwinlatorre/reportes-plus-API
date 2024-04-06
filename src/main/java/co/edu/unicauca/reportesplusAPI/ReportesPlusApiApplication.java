package co.edu.unicauca.reportesplusAPI;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportesPlusApiApplication implements CommandLineRunner {

	//@Autowired
	//private ReporteGastosPosDAO test;
	public static void main(String[] args) {

		SpringApplication.run(ReportesPlusApiApplication.class, args);
	}

	// funcion para hacer pruebas rapidas
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		//test.findAllReportes();
	}

}
