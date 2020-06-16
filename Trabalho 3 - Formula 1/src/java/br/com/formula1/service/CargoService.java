package br.com.formula1.service;

import br.com.formula1.dao.CargoDao;
import br.com.formula1.domain.Cargo;
import java.util.List;

public class CargoService {
    
    private CargoDao cargoDao = new CargoDao();
    
    public List<Cargo> listar(){
        return cargoDao.listar();
    }
    
    public Cargo consultar(Integer id){
        return cargoDao.consultar(id);
    }
    
    public boolean inserir(Cargo cargo){
        return cargoDao.inserir(cargo);
    }
    
    public boolean alterar(Cargo cargo){
        return cargoDao.alterar(cargo);
    }
    
    public boolean excluir(Cargo cargo){
        return cargoDao.excluir(cargo);
    }
}