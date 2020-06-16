package br.com.formula1.controller;

import br.com.formula1.domain.Equipe;
import br.com.formula1.service.EquipeService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="equipeMB")
@SessionScoped
public class EquipeController implements Serializable{
    
    private Equipe equipe = new Equipe();
    private List<Equipe> equipes;
    private EquipeService equipeService = new EquipeService();
    
    public EquipeController(){
        listar();
    }
    
    public void listar(){
        equipes = equipeService.listar();
    }
    
    public String novo(){
        equipe = new Equipe();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Equipe equipe){
        this.equipe = equipe;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(equipeService.inserir(equipe)){
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe salva com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar a equipe!");
        return null;
    }
    
    public String alterar(){
        if(equipeService.alterar(equipe)){
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a equipe!");
        return null;
    }
    
    public String excluir(Equipe equipe){
        if(equipeService.excluir(equipe)){
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe excluida com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a equipe!");
        return null;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

}