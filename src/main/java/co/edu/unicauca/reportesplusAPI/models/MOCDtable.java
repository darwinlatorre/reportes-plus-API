package co.edu.unicauca.reportesplusAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOCD")
public class MOCDtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer MOCDCDEM;
    private String MOCDCDTD;
    private Integer MOCDCDND;
    private Integer MOCDSECU;
    private Date MOCDFECH;
    private String MOCDTIMO;
    private Integer MOCDCUPR;
    private String MOCDCUMO;
    private Double MOCDVAIN;
    private Double MOCDVAAD;
    private Double MOCDVAAC;
    private Double MOCDVADE;
    private Double MOCDSALD;
    private String MOCDOBSE;
    private String MOCDDEST;
    private String MOCDCEIN;
    private String MOCDTERM;
    private String MOCDDIGI;
    private Date MOCDFESI;
    private String MOCDESTA;
}
