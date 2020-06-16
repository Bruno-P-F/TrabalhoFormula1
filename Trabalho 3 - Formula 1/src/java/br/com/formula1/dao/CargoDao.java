package br.com.formula1.dao;

import br.com.formula1.domain.Cargo;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class CargoDao {
    
    public List<Cargo> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Cargo> cargos = session.createQuery("from Cargo order by funcao").list();
            session.getTransaction().commit();
            return cargos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Cargo consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Cargo cargo = (Cargo)session.createQuery("from Cargo where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return cargo;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(cargo);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
    
     public boolean alterar(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(cargo);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
      public boolean excluir(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(cargo);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}