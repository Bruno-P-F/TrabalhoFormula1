package br.com.formula1.service;

import br.com.formula1.dao.FuncionarioDao;
import br.com.formula1.domain.Funcionario;
import java.util.List;

public class FuncionarioService {
    
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    
    public List<Funcionario> listar(){
        return funcionarioDao.listar();
    }
    
    public Funcionario consultar(Integer id){
        return funcionarioDao.consultar(id);
    }
    
    public boolean inserir(Funcionario funcionario){
        return funcionarioDao.inserir(funcionario);
    }
    
    public boolean alterar(Funcionario funcionario){
        return funcionarioDao.alterar(funcionario);
    }
    
    public boolean excluir(Funcionario funcionario){
        return funcionarioDao.excluir(funcionario);
    }
}