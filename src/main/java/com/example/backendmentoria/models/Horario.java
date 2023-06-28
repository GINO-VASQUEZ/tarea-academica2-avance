package com.example.backendmentoria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha", length = 60, nullable = false)
    private String fecha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sesion_id", nullable = false, foreignKey = @ForeignKey(name = "FK_sesion_horario"))
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "tema_id", nullable = false, foreignKey = @ForeignKey(name = "FK_tema_horario"))
    private Tema tema;

}
