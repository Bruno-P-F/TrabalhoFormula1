package br.com.formula1.controller;

import br.com.formula1.domain.Cargo;
import br.com.formula1.service.CargoService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cargoMB")
@SessionScoped
public class CargoController implements Serializable{
    
    private Cargo cargo = new Cargo();
    private List<Cargo> cargos;
    private CargoService cargoService = new CargoService();
    
    public CargoController(){
        listar();
    }
    
    public void listar(){
        cargos = cargoService.listar();
    }
    
    public String novo(){
        cargo = new Cargo();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Cargo cargo){
        this.cargo = cargo;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(cargoService.inserir(cargo)){
            UtilMensagens.mensagemSucesso("Sucesso", "Cargo salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o cargo!");
        return null;
    }
    
    public String alterar(){
        if(cargoService.alterar(cargo)){
            UtilMensagens.mensagemSucesso("Sucesso", "Cargo alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o cargo!");
        return null;
    }
    
    public String excluir(Cargo cargo){
        if(cargoService.excluir(cargo)){
            UtilMensagens.mensagemSucesso("Sucesso", "Cargo excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o cargo!");
        return null;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    
}