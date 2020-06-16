package br.com.formula1.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class GpposicaoPK implements Serializable {

    
    @NotNull
    @Column(name = "idPiloto")
    private int idPiloto;
    
    @NotNull
    @Column(name = "idGrandprix")
    private int idGrandprix;

    public GpposicaoPK() {
    }

    public GpposicaoPK(int idPiloto, int idGrandprix) {
        this.idPiloto = idPiloto;
        this.idGrandprix = idGrandprix;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public int getIdGrandprix() {
        return idGrandprix;
    }

    public void setIdGrandprix(int idGrandprix) {
        this.idGrandprix = idGrandprix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPiloto;
        hash += (int) idGrandprix;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GpposicaoPK)) {
            return false;
        }
        GpposicaoPK other = (GpposicaoPK) object;
        if (this.idPiloto != other.idPiloto) {
            return false;
        }
        if (this.idGrandprix != other.idGrandprix) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.formula1.domain.GpposicaoPK[ idPiloto=" + idPiloto + ", idGrandprix=" + idGrandprix + " ]";
    }
    
}