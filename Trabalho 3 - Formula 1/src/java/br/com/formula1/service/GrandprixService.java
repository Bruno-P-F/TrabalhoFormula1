package br.com.formula1.service;

import br.com.formula1.dao.GpposicaoDao;
import br.com.formula1.dao.GrandprixDao;
import br.com.formula1.domain.Gpposicao;
import br.com.formula1.domain.GpposicaoPK;
import br.com.formula1.domain.Grandprix;
import br.com.formula1.domain.Piloto;
import java.util.List;

public class GrandprixService {
    
    private GrandprixDao grandprixDao = new GrandprixDao();
    private GpposicaoDao gpposicaoDao = new GpposicaoDao();
    
    public List<Grandprix> listar(){
        return grandprixDao.listar();
    }
    
    public Grandprix consultar(Integer id){
        return grandprixDao.consultar(id);
    }
    
    public boolean inserir(Grandprix grandprix,List<Gpposicao> gpposicoes){
        Integer id=grandprixDao.inserir(grandprix);
        grandprix=grandprixDao.consultar(id);
        int cont=0;
        for (Gpposicao gppos:gpposicoes){
            GpposicaoPK gpposPK=new GpposicaoPK();
            gpposPK.setIdGrandprix(grandprix.getId());
            gpposPK.setIdPiloto(gpposicoes.get(cont).getPiloto().getId());
            gppos.setGpposicaoPK(gpposPK);
            gpposicaoDao.inserir(gppos);
            cont++;
        }
        return true;
    }
    
    public boolean alterar(Grandprix grandprix,List<Gpposicao> gpposicoes){
        gpposicaoDao.excluir(grandprix);
        int cont=0;
        for (Gpposicao gppos:gpposicoes){
            GpposicaoPK gpposPK=new GpposicaoPK();
            gpposPK.setIdGrandprix(grandprix.getId());
            gpposPK.setIdPiloto(gpposicoes.get(cont).getPiloto().getId());
            gppos.setGpposicaoPK(gpposPK);
            gpposicaoDao.inserir(gppos);
            cont++;
        }
        return true;
    }
    
    public boolean excluir(Grandprix grandprix){
        return grandprixDao.excluir(grandprix);
    }
    
    public List<Gpposicao> listarItens(Grandprix grandprix){
        return gpposicaoDao.listar(grandprix);
    }
}