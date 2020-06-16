package br.com.formula1.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "piloto")
public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nacionalidade")
    private String nacionalidade;
    
    @NotNull
    @Column(name = "numero")
    private int numero;
    
    @JoinColumn(name = "idEquipe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipe idEquipe;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piloto")
    private Collection<Gpposicao> gpposicaoCollection;

    public Piloto() {
    }

    public Piloto(Integer id) {
        this.id = id;
    }

    public Piloto(Integer id, String nome, String nacionalidade, int numero, Equipe idEquipe) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.numero = numero;
        this.idEquipe = idEquipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Equipe getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Equipe idEquipe) {
        this.idEquipe = idEquipe;
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
        if (!(object instanceof Piloto)) {
            return false;
        }
        Piloto other = (Piloto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.formula1.domain.Piloto[ id=" + id + " ]";
    }
    
}