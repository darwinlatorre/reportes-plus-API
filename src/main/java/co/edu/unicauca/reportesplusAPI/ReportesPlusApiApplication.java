package co.edu.unicauca.reportesplusAPI;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteGastosPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportesPlusApiApplication implements CommandLineRunner {

	@Autowired
	private ReporteGastosPosDAO test;
	@Autowired
	private ReporteGastosPosService testService;
	public static void main(String[] args) {

		SpringApplication.run(ReportesPlusApiApplication.class, args);
	}

	// funcion para hacer pruebas rapidas
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n\n***************************************** Gastos sin mapear");
		for(ReporteGastosPosEntity gasto:test.findAllReportes())
			System.out.println(gasto.getObservacion().toString());
		System.out.println("\n\n\n***************************************** Gastos mapeados");
		for(GastoDTORes gasto:testService.mapearGastos())
			System.out.println(gasto.toString());
	}

}
