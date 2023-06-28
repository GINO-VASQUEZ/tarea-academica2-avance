package com.example.backendmentoria.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "horaInicio", length = 60, nullable = false)
    private String horaInicio;

    @Column(name = "horaFin", length = 60, nullable = false)
    private String horaFin;

    @Column(name = "link", length = 60, nullable = false)
    private String link;

    @Column(name = "calificacion", length = 2, nullable = false)
    private String calificacion;

    @Column(name = "anotaciones", length = 300, nullable = false)
    private String anotaciones;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "sesion", fetch = FetchType.LAZY)
    private List<Horario> items;

}
