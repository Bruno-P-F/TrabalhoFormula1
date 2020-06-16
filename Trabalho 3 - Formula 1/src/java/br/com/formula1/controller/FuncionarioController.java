package br.com.formula1.controller;

import br.com.formula1.domain.Funcionario;
import br.com.formula1.service.FuncionarioService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="funcionarioMB")
@SessionScoped
public class FuncionarioController implements Serializable{
    
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> funcionarios;
    private FuncionarioService funcionarioService = new FuncionarioService();
    
    public FuncionarioController(){
        listar();
    }
    
    public void listar(){
        funcionarios = funcionarioService.listar();
    }
    
    public String novo(){
        funcionario = new Funcionario();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Funcionario funcionario){
        this.funcionario = funcionario;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(funcionarioService.inserir(funcionario)){
            UtilMensagens.mensagemSucesso("Sucesso", "Funcionario salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o funcionario!");
        return null;
    }
    
    public String alterar(){
        if(funcionarioService.alterar(funcionario)){
            UtilMensagens.mensagemSucesso("Sucesso", "Funcionario alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o funcionario!");
        return null;
    }
    
    public String excluir(Funcionario funcionario){
        if(funcionarioService.excluir(funcionario)){
            UtilMensagens.mensagemSucesso("Sucesso", "Funcionario excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o funcionario!");
        return null;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}