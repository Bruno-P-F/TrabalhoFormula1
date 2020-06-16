package br.com.formula1.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gpposicao")
public class Gpposicao implements Serializable {

    @EmbeddedId
    protected GpposicaoPK gpposicaoPK;
    
    @NotNull
    @Column(name = "classificacao")
    private int classificacao;
    
    @NotNull
    @Column(name = "pontos")
    private int pontos;
    
    @JoinColumn(name = "idGrandprix", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grandprix grandprix;
    
    @JoinColumn(name = "idPiloto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Piloto piloto;

    public Gpposicao() {
    }

    public Gpposicao(GpposicaoPK gpposicaoPK) {
        this.gpposicaoPK = gpposicaoPK;
    }

    public Gpposicao(GpposicaoPK gpposicaoPK, int classificacao, int pontos) {
        this.gpposicaoPK = gpposicaoPK;
        this.classificacao = classificacao;
        this.pontos = pontos;
    }

    public Gpposicao(int idPiloto, int idGrandprix) {
        this.gpposicaoPK = new GpposicaoPK(idPiloto, idGrandprix);
    }

    public GpposicaoPK getGpposicaoPK() {
        return gpposicaoPK;
    }

    public void setGpposicaoPK(GpposicaoPK gpposicaoPK) {
        this.gpposicaoPK = gpposicaoPK;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Grandprix getGrandprix() {
        return grandprix;
    }

    public void setGrandprix(Grandprix grandprix) {
        this.grandprix = grandprix;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gpposicaoPK != null ? gpposicaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gpposicao)) {
            return false;
        }
        Gpposicao other = (Gpposicao) object;
        if ((this.gpposicaoPK == null && other.gpposicaoPK != null) || (this.gpposicaoPK != null && !this.gpposicaoPK.equals(other.gpposicaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.formula1.domain.Gpposicao[ gpposicaoPK=" + gpposicaoPK + " ]";
    }
    
}