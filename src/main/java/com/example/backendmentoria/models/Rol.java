package com.example.backendmentoria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="rol")
public class Rol {

    @Id
    private Long rolID;
    private String rol;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol(){

    }

    public Long getRolID() {
        return rolID;
    }

    public void setRolID(Long rolID) {
        this.rolID = rolID;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String nombre) {
        this.rol = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

}
