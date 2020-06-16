package br.com.formula1.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "grandprix")
@XmlRootElement
public class Grandprix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localizacao")
    private String localizacao;

    @NotNull
    @Column(name = "voltas")
    private int voltas;
   
    @NotNull
    @Column(name = "anoCorrida")
    private int anoCorrida;
  
    @NotNull
    @Column(name = "percursoKm")
    private double percursoKm;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grandprix")
    private Collection<Gpposicao> gpposicaoCollection;

    public Grandprix() {
    }

    public Grandprix(Integer id) {
        this.id = id;
    }

    public Grandprix(Integer id, String localizacao, int voltas, int anoCorrida, double percursoKm) {
        this.id = id;
        this.localizacao = localizacao;
        this.voltas = voltas;
        this.anoCorrida = anoCorrida;
        this.percursoKm = percursoKm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    public int getAnoCorrida() {
        return anoCorrida;
    }

    public void setAnoCorrida(int anoCorrida) {
        this.anoCorrida = anoCorrida;
    }

    public double getPercursoKm() {
        return percursoKm;
    }

    public void setPercursoKm(double percursoKm) {
        this.percursoKm = percursoKm;
    }

    @XmlTransient
    public Collection<Gpposicao> getGpposicaoCollection() {
        return gpposicaoCollection;
    }

    public void setGpposicaoCollection(Collection<Gpposicao> gpposicaoCollection) {
        this.gpposicaoCollection = gpposicaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grandprix)) {
            return false;
        }
        Grandprix other = (Grandprix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.formula1.domain.Grandprix[ id=" + id + " ]";
    }
    
}