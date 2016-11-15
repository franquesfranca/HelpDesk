/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import bd.NewHibernateUtil;
import entidades.Caso;
import entidades.Descricaocaso;
import entidades.Solucaocaso;
import gui.JanelaMenu;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.hibernate.Session;
import temp.CsvReader;
import temp.TextExtractor;


/**
 *
 * @author Assunção
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JanelaMenu janela = new JanelaMenu();
        janela.setVisible(true);
        
        //Código utilizado para obter os registros do csv e inserir no Banco de Dados
        /*CsvReader casos = new CsvReader("glpi.csv");

        casos.setDelimiter(';');
        casos.readHeaders();
        //le a base de casos e cria objetoc ChamadoDescription com o conteudo;
        while (casos.readRecord()) {
            
            Caso caso = new Caso();
            Descricaocaso descricaoCaso = new Descricaocaso();
            //descricaoCaso.setIdDescricaoCaso(id);
            caso.setDescricaocaso(descricaoCaso);
            Solucaocaso solucaoCaso = new Solucaocaso();
            //solucaoCaso.setIdSolucaoCaso(id);
            caso.setSolucaocaso(solucaoCaso);
            //---
            //caso.setId(Integer.parseInt(casos.get("ID").replaceAll(" ", "").trim()));
            //--


            String stirar = "(" + caso.getIdCaso() + ")";
            String stitulo = casos.get("NAME").replaceAll(stirar, "");
            stitulo = stitulo.replace('(', ' ').replace(')', ' ');

            //----
            System.out.println(stitulo);
            caso.getDescricaocaso().setTitulo(stitulo);
            
            //----

            //----
            caso.getDescricaocaso().setDescricao(casos.get("CONTENT"));
            caso.setDescription(caso.getDescricaocaso());
            //---



            TextExtractor extrator = new TextExtractor();
            try {
                extrator.parse(casos.get("SOLUTION"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            caso.getSolucaocaso().setSolucao(new String(extrator.getText()));
            caso.setSolution(caso.getSolucaocaso());

            Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            System.out.println(caso.getDescricaocaso().getDescricao());
            s.save(descricaoCaso);
            s.save(solucaoCaso);
            s.save(caso);
            s.getTransaction().commit();

        }*/

    }
}
