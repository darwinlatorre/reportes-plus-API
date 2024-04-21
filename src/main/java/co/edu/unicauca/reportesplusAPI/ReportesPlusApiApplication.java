package co.edu.unicauca.reportesplusAPI;

import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteGastosPosgrados.ReporteGastosPosEntity;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosDAO;
import co.edu.unicauca.reportesplusAPI.DAO.reporteIngresoPosgrados.ReporteIngresosPosEntity;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.GastoDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteGastosPos.ReportesGastosPosDTORes;
import co.edu.unicauca.reportesplusAPI.dtos.reporteIngresosPos.IngresoDTORes;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteGastosPosService;
import co.edu.unicauca.reportesplusAPI.services.reporteGastosPos.ReporteIngresosPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ReportesPlusApiApplication implements CommandLineRunner {

	@Autowired
	private ReporteIngresosPosDAO test;
	@Autowired
	private ReporteGastosPosService testService;
	@Autowired
	private ReporteIngresosPosService testIngresosService;
	public static void main(String[] args) {

		SpringApplication.run(ReportesPlusApiApplication.class, args);
	}

	// funcion para hacer pruebas rapidas
	@Override
	public void run(String... args) throws Exception {

	/*
		System.out.println("\n\n\n***************************************** Ingresos sin mapear");
		for (ReporteIngresosPosEntity ingreso : test.findAllIncomeReport())
			System.out.println(ingreso);/*

		/*
		System.out.println("\n\n\n***************************************** Gastos mapeados by carrenio");
		for(GastoDTORes gasto:testService.mapearGastos())
			System.out.println(gasto.toString()); */

		/*
		System.out.println("\n\n\n***************************************** Gastos mapeados por fecha");
		List<GastoDTORes> gastosMapeados = testService.mapearGastosPorFechas(fechaInicio, fechaFin, "1432007");
		for (GastoDTORes gasto : gastosMapeados)
			System.out.println(gasto.toString());
		System.out.println("------------------------------------------------");
		System.out.println(fechaInicio + "fecha inicio");
		System.out.println(fechaFin + "fecha fin");


		//Prueba del objeto
		Date fechaInicio = new Date(2022-1900, 01, 1); // Año, mes, día (mes es zero-based)
		// Crear fecha de fin del primer trimestre de 2019
		Date fechaFin = new Date(2022-1900, 06, 1); // Año, mes, día (mes es zero-based)
		//Codigo
		String codigo = "1431001";
		System.out.println("\n\n\n***************************************** DTO por fecha");
		ReportesGastosPosDTORes reporte = testService.generarReporte(fechaInicio,fechaFin,codigo);
		System.out.println("DTO de tipo:  " + reporte +"\n\n");
		*/

		System.out.println("\n\n\n***************************************** Ingresos mapeados");
		for (IngresoDTORes ingreso : testIngresosService.mapearIngresos())
			System.out.println(ingreso.getId());
	}

}
