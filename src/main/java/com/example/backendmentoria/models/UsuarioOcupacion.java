package com.example.backendmentoria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
@Table(name = "usuarioOcupacion")
public class UsuarioOcupacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_orden"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ocupacion_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ocupacion_orden"))
    private Ocupacion ocupacion;

    public UsuarioOcupacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }
}
