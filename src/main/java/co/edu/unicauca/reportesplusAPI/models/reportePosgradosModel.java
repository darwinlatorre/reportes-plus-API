package co.edu.unicauca.reportesplusAPI.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reportePosgradosModel")
@Schema(description = "Entidad que representa un reporte de posgrados")
public class reportePosgradosModel {

    // RECORDATORIO: Siempre documentar cada atributo de la clase-entidad - Swagger
    // EJEMPLO
    /**
     * Identificador único.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id", unique = true)
    @Schema(description = "Identificador único", example = "1")
    private Integer id;

}
