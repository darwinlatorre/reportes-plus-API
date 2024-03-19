package co.edu.unicauca.reportesplusAPI.services.ReportePosgrados;

import co.edu.unicauca.reportesplusAPI.models.ReporteGastosModel;
import co.edu.unicauca.reportesplusAPI.repositories.IReportePosgradosRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

//A la hora de utilizar estas clases de servicios, utilizar la interfaz y no la implementacion

@Service
@RequiredArgsConstructor
public class ReportePosgradosServiceImpl implements ReportePosgradosService {

    @Autowired
    private IReportePosgradosRepository reporteGastosRepository;

    @Override
    public List<ReporteGastosModel> findAll() {
        return reporteGastosRepository.findAll();
    }

    @Override
    public ReporteGastosModel findByModel(String id) {
        return reporteGastosRepository.findById(id).orElse(null);
    }
}
