
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APP_HARDWARE")
@NamedQuery(name = "Hardware.findByIdh", query = "SELECT u FROM Hardware u WHERE u.id=:hardwareId")
public class Hardware implements Serializable{

    
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="HARDWARE_ID", unique=true, nullable=false)
	private String hardwareId;
	
	@NotEmpty
	@Column(name="DESCRIPCION", unique=true, nullable=false)
	private String descripcion;
		
	@NotEmpty
	@Column(name="OBSERVACION", nullable=false)
	private String observacion;
	@NotEmpty
	@Column(name="ESTADO_ID", nullable=false)
	private String estadoId;

   	@NotEmpty
	@Column(name="ESTADOOBJETO", nullable=false)
	private String estadoObjeto;

    public Hardware() {
    }

    public Hardware(Integer id, String hardwareId, String descripcion, String observacion, String estadoId, String estadoObjeto, String prestamoId, String marca, String modelo, String asignacionId, String fechaCreado, String fechaModificado, String userId, String bodegaId) {
        this.id = id;
        this.hardwareId = hardwareId;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.estadoId = estadoId;
        this.estadoObjeto = estadoObjeto;
        this.prestamoId = prestamoId;
        this.marca = marca;
        this.modelo = modelo;
        this.asignacionId = asignacionId;
        this.fechaCreado = fechaCreado;
        this.fechaModificado = fechaModificado;
        this.userId = userId;
        this.bodegaId = bodegaId;
    }
        
	@NotEmpty
	@Column(name="PRESTAMO_ID", nullable=false)
	private String prestamoId;

	@NotEmpty
	@Column(name="MARCA", nullable=false)
	private String marca;

		@NotEmpty
	@Column(name="MODELO", nullable=false)
	private String modelo;
	@NotEmpty
	@Column(name="ASIGNACION_ID", nullable=false)
	private String asignacionId;
	@NotEmpty
	@Column(name="FECHACREADO", nullable=false)
	private String fechaCreado;

        	@NotEmpty
	@Column(name="FECHAMODIFICADO", nullable=false)
	private String fechaModificado;
	@NotEmpty
	@Column(name="USER_ID", nullable=false)
	private String userId;
        
        	@NotEmpty
	@Column(name="BODEGA_ID", nullable=false)
	private String bodegaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoObjeto() {
        return estadoObjeto;
    }

    public void setEstadoObjeto(String estadoObjeto) {
        this.estadoObjeto = estadoObjeto;
    }

    public String getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(String prestamoId) {
        this.prestamoId = prestamoId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(String asignacionId) {
        this.asignacionId = asignacionId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBodegaId() {
        return bodegaId;
    }

    public void setBodegaId(String bodegaId) {
        this.bodegaId = bodegaId;
    }



	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((hardwareId == null) ? 0 : hardwareId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		Hardware other = (Hardware) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (hardwareId == null) {
			if (other.hardwareId != null)
				return false;
		} else if (!hardwareId.equals(other.hardwareId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Hardware [id=" + id + ", hardwareId=" + hardwareId + ", observacion=" + observacion
				+ ", descripcion=" + descripcion + "]";
	}



	
}