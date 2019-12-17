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
@Table(name="APP_ASIGNACION")
public class Asignacion implements Serializable{

    
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="ASIGNACION_ID", unique=true, nullable=false)
	private String asignacionId;
	
		
	@NotEmpty
	@Column(name="USUARIOFK", nullable=false)
	private String usuarioFk;
	@NotEmpty
	@Column(name="FECHACREADO", nullable=false)
	private String fechaCreado;
	@NotEmpty
	@Column(name="FECHAMODIFICADO", nullable=false)
	private String fechaModificado;
	@NotEmpty
	@Column(name="HARDWAREFK", nullable=false)
	private String hardwareFk;

    public String getHardwareFk() {
        return hardwareFk;
    }

    public void setHardwareFk(String hardwareFk) {
        this.hardwareFk = hardwareFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(String asignacionId) {
        this.asignacionId = asignacionId;
    }

    public String getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(String usuarioFk) {
        this.usuarioFk = usuarioFk;
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
		result = prime * result + ((asignacionId == null) ? 0 : asignacionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Asignacion))
			return false;
		Asignacion other = (Asignacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (asignacionId == null) {
			if (other.asignacionId != null)
				return false;
		} else if (!asignacionId.equals(other.asignacionId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", asignacionId=" + asignacionId + ", usuarioFk=" + usuarioFk +", hardwareFk=" + hardwareFk + "]";
	}



	
}
