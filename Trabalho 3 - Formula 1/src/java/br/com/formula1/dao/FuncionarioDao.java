package br.com.formula1.dao;

import br.com.formula1.domain.Funcionario;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class FuncionarioDao {
    
    public List<Funcionario> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Funcionario> funcionarios = session.createQuery("from Funcionario order by nome").list();
            session.getTransaction().commit();
            return funcionarios;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Funcionario consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Funcionario funcionario = (Funcionario)session.createQuery("from Funcionario where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return funcionario;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Funcionario funcionario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
    
     public boolean alterar(Funcionario funcionario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
      public boolean excluir(Funcionario funcionario){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}