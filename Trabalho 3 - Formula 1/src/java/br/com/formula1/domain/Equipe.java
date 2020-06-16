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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {

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
    @Column(name = "pais")
    private String pais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipe")
    private Collection<Funcionario> funcionarioCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipe")
    private Collection<Piloto> pilotoCollection;

    public Equipe() {
    }

    public Equipe(Integer id) {
        this.id = id;
    }

    public Equipe(Integer id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @XmlTransient
    public Collection<Piloto> getPilotoCollection() {
        return pilotoCollection;
    }

    public void setPilotoCollection(Collection<Piloto> pilotoCollection) {
        this.pilotoCollection = pilotoCollection;
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.formula1.domain.Equipe[ id=" + id + " ]";
    }
    
}