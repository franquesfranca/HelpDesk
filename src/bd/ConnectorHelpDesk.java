/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import entidades.Caso;
import entidades.Chamado;
import entidades.Descricaocaso;
import entidades.Solucaocaso;


import entidades.Usuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CaseBaseFilter;
import jcolibri.cbrcore.Connector;
import jcolibri.exception.InitializingException;
import org.hibernate.Session;

/**
 *
 * @author Assunção
 */
public class ConnectorHelpDesk implements Connector {

    //Usado no caso configuração com arquivo XML
    @Override
    public void initFromXMLfile(URL url) throws InitializingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        s.close();
    }

    @Override
    public void storeCases(Collection<CBRCase> clctn) {
        //Cria uma nova Sessao
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //Inicia uma transacao
        s.beginTransaction();
        //Percorre a lista transformando CBRCases em Casos e salva no BD
        for (CBRCase c : clctn) {
            Caso caso = (Caso) c;
            s.save(caso);
        }
        //Comita a transacao
        s.getTransaction().commit();

    }

    public void storeUser(Usuario user) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //Inicia uma transacao
        s.beginTransaction();

        s.save(user);
        s.getTransaction().commit();
    }

    public void deleteUser(String matr) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.createSQLQuery("DELETE FROM USUARIO WHERE matricula= :matr ").setString("matr", matr).list();

        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Usuário: " + matr + "Excluído com sucesso!");

    }

    public void storeRequest(Chamado cham) {
        //Cria uma nova Sessao
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //Inicia uma transacao
        s.beginTransaction();

        s.save(cham);
        s.getTransaction().commit();
    }

    public void storeCaseDescription(Descricaocaso desc){
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //Inicia uma transacao
        s.beginTransaction();

        s.save(desc);
        s.getTransaction().commit();
    }
    
    public void storeCaseSolution(Solucaocaso sol){
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //Inicia uma transacao
        s.beginTransaction();

        s.save(sol);
        s.getTransaction().commit();
    }
    
    public Chamado retrieveRequest(Integer id) {
        Chamado cham;
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.createSQLQuery("SELECT FROM CHAMADO WHERE id= :id ").setInteger("id", id);        
        cham = (Chamado) s.get(Chamado.class, id);
        s.getTransaction().commit();


        return cham;
    }

    public void deleteRequest(Integer id) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.createSQLQuery("DELETE FROM CHAMADO WHERE idChamado= :id ").setInteger("id", id).executeUpdate();        

        s.getTransaction().commit();
        //JOptionPane.showMessageDialog(null, "Usuário: " + id + "Excluído com sucesso!");

    }
    
    @Override
    public void deleteCases(Collection<CBRCase> clctn) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        for (CBRCase c : clctn) {
            Caso caso = (Caso) c;
            int identificador = caso.getIdCaso();

            s.createSQLQuery("DELETE FROM CASO WHERE idCaso= :identificador ").setInteger("identificador", identificador).executeUpdate();


        }
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Caso(s) Excluído(s) com sucesso!");
    }

    @Override
    public Collection<CBRCase> retrieveAllCases() {
        ArrayList<CBRCase> lista = new ArrayList<CBRCase>();

        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();

        s.beginTransaction();

        Integer tamanho = s.createSQLQuery("SELECT * FROM CASO").list().size();
        
        List<Integer> listaIds = s.createSQLQuery("SELECT idCaso FROM CASO").list();
        
        
        
        
        
        for (int i = 1; i < tamanho; i++) {
            Caso c = (Caso) s.get(Caso.class, listaIds.get(i)); 
            Descricaocaso descricaoCaso = new Descricaocaso();
            descricaoCaso.setDescricao(c.getDescricaocaso().getDescricao());
            descricaoCaso.setTitulo(c.getDescricaocaso().getTitulo());
            descricaoCaso.setIdDescricaoCaso(c.getDescricaocaso().getIdDescricaoCaso());
            descricaoCaso.preencherCampos();      
            //descricaoCaso.setIdDescricaoCaso(c.getDescricaocaso().getIdDescricaoCaso());                                    
            c.setSolution(c.getSolucaocaso());              
            c.setDescription(descricaoCaso);
            lista.add(c);
        
        }
        
        return lista;
        
    }

    @Override
    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter cbf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
