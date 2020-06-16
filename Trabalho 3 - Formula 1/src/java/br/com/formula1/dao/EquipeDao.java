package br.com.formula1.dao;

import br.com.formula1.domain.Equipe;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class EquipeDao {
    
    public List<Equipe> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Equipe> equipes = session.createQuery("from Equipe order by nome").list();
            session.getTransaction().commit();
            return equipes;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Equipe consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Equipe equipe = (Equipe)session.createQuery("from Equipe where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return equipe;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Equipe equipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(equipe);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
    
     public boolean alterar(Equipe equipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(equipe);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
      public boolean excluir(Equipe equipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(equipe);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}