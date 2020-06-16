package br.com.formula1.dao;

import br.com.formula1.domain.Grandprix;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class GrandprixDao {
    
    public List<Grandprix> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Grandprix> grandprixs = session.createQuery("from Grandprix order by id").list();
            session.getTransaction().commit();
            return grandprixs;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Grandprix consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Grandprix grandprix = (Grandprix)session.createQuery("from Grandprix where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return grandprix;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Integer inserir(Grandprix grandprix){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Integer id=(Integer)session.save(grandprix);
            session.getTransaction().commit();
            return id;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }    
    
     public boolean alterar(Grandprix grandprix){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(grandprix);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
      public boolean excluir(Grandprix grandprix){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(grandprix);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}