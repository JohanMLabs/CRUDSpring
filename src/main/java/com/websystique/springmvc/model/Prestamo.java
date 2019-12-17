package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APP_PRESTAMO")
public class Prestamo implements Serializable{

    
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="PRESTAMO_ID", unique=true, nullable=false)
	private String prestamoId;
	
	@NotEmpty
	@Column(name="USUARIO", unique=true, nullable=false)
	private String usuario;
		
	@NotEmpty
	@Column(name="ESTADO", nullable=false)
	private String estado;
	@NotEmpty
	@Column(name="FECHACREADO", nullable=false)
	private String fechaCreado;
	@NotEmpty
	@Column(name="FECHAMODIFICADO", nullable=false)
	private String fechaModificado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(String prestamoId) {
        this.prestamoId = prestamoId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(String fechaModificado) {
        this.fechaModificado = fechaModificado;
    }

   
	


	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prestamoId == null) ? 0 : prestamoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Prestamo))
			return false;
		Prestamo other = (Prestamo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prestamoId == null) {
			if (other.prestamoId != null)
				return false;
		} else if (!prestamoId.equals(other.prestamoId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", prestamoId=" + prestamoId + ", usuario=" + usuario
				+ ", estado=" + estado + "]";
	}



	
}
