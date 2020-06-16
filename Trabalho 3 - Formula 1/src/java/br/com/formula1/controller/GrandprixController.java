package br.com.formula1.controller;

import br.com.formula1.domain.Gpposicao;
import br.com.formula1.domain.Grandprix;
import br.com.formula1.domain.Piloto;
import br.com.formula1.service.GrandprixService;
import br.com.formula1.service.PilotoService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="grandprixMB")
@SessionScoped
public class GrandprixController implements Serializable{
    
    private Grandprix grandprix = new Grandprix();
    private Piloto piloto = new Piloto();
    private Gpposicao gpposicao = new Gpposicao();
    private List<Grandprix> grandprixs;
    private List<Gpposicao> gpposicoes;
    private List<Piloto> pilotos;
    private GrandprixService grandprixService = new GrandprixService();
    private PilotoService pilotoService = new PilotoService();
    
    public GrandprixController(){
        listar();
    }
    
    public void listar(){
        grandprixs = grandprixService.listar();
    }
    
    public String novo(){
        grandprix = new Grandprix();
        pilotos = new ArrayList<>();
        piloto = new Piloto();
        gpposicoes = new ArrayList<>();
        gpposicao = new Gpposicao();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Grandprix grandprix){
        gpposicao = new Gpposicao();
        this.grandprix = grandprix;
        this.gpposicoes=grandprixService.listarItens(grandprix);
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(grandprixService.inserir(grandprix,gpposicoes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o grandprix!");
        return null;
    }
    
    public String alterar(){
        if(grandprixService.alterar(grandprix,gpposicoes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o grandprix!");
        return null;
    }
    
    public String excluir(Grandprix grandprix){
        if(grandprixService.excluir(grandprix)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o grandprix!");
        return null;
    }

    public void addPiloto(){
        if(gpposicao.getPiloto()==null||gpposicao.getClassificacao()<=0){
            UtilMensagens.mensagemErro("Erro","Informe o piloto/classificacao");
        }else{
            Boolean condicao=true;
            for(Gpposicao gpp:gpposicoes){
                if((gpp.getClassificacao()==gpposicao.getClassificacao())||(gpp.getPiloto().equals(gpposicao.getPiloto()))){
                    condicao=false;
                    break;
                }
            }
            if(condicao){
                switch(gpposicao.getClassificacao()){
                    case 1:{
                        gpposicao.setPontos(25);
                        break;
                    }
                    case 2:{
                        gpposicao.setPontos(18);
                        break;
                    }
                    case 3:{
                        gpposicao.setPontos(15);
                        break;
                    }
                    case 4:{
                        gpposicao.setPontos(12);
                        break;
                    }
                    case 5:{
                        gpposicao.setPontos(10);
                        break;
                    }
                    case 6:{
                        gpposicao.setPontos(8);
                        break;
                    }
                    case 7:{
                        gpposicao.setPontos(6);
                        break;
                    }
                    case 8:{
                        gpposicao.setPontos(4);
                        break;
                    }
                    case 9:{
                        gpposicao.setPontos(2);
                        break;
                    }
                    case 10:{
                        gpposicao.setPontos(1);
                        break;
                    }
                    default:{
                        gpposicao.setPontos(0);
                        break;
                    }
                }
                gpposicoes.add(gpposicao);
                gpposicao=new Gpposicao();
            }else{
                UtilMensagens.mensagemErro("Erro","Posicao/Piloto ja foi inserido");
            }
        }
    }
    
    public void removePiloto(Gpposicao gpposicao){
        gpposicoes.remove(gpposicao);
    }
    
    public String visualizarGP(Grandprix grandprix){
        gpposicao = new Gpposicao();
        this.grandprix = grandprix;
        this.gpposicoes=grandprixService.listarItens(grandprix);
        return "result.xhtml?faces-redirect=true";
    }
    
    public Grandprix getGrandprix() {
        return grandprix;
    }

    public void setGrandprix(Grandprix grandprix) {
        this.grandprix = grandprix;
    }

    public List<Grandprix> getGrandprixs() {
        return grandprixs;
    }

    public void setGrandprixs(List<Grandprix> grandprixs) {
        this.grandprixs = grandprixs;
    }

    public Gpposicao getGpposicao() {
        return gpposicao;
    }

    public void setGpposicao(Gpposicao gpposicao) {
        this.gpposicao = gpposicao;
    }

    public List<Gpposicao> getGpposicoes() {
        return gpposicoes;
    }

    public void setGpposicoes(List<Gpposicao> gpposicoes) {
        this.gpposicoes = gpposicoes;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }


}