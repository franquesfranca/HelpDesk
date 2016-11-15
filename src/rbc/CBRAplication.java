/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;
import bd.ConnectorHelpDesk;
import entidades.Caso;
import entidades.Descricaocaso;
import java.util.Collection;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.exception.ExecutionException;
import jcolibri.extensions.textual.lucene.LuceneIndex;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;

import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;

import jcolibri.method.retrieve.NNretrieval.similarity.local.textual.LuceneTextSimilarity;


import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.selection.SelectCases;

/**
 *
 * @author Assunção
 */
public class CBRAplication implements StandardCBRApplication {

    public Connector conector;
    public CBRCaseBase baseCasos;
    Collection<RetrievalResult> resultado;
    LuceneIndex lucene;
    
    @Override
    public void configure() throws ExecutionException {
        //instancia o conector e a base de casos
        try{
            conector = new ConnectorHelpDesk();
            baseCasos= new LinealCaseBase();
            
        }catch(Exception e){
            throw new ExecutionException(e);
        }
    }

    @Override
    public CBRCaseBase preCycle() throws ExecutionException {
        
        
        baseCasos.init(conector);
        System.out.println("====OK====");
        
        lucene = jcolibri.method.precycle.LuceneIndexCreator.createLuceneIndex(baseCasos);
        
        return baseCasos;
        
    }

    @Override
    public void cycle(CBRQuery cbrq) throws ExecutionException {
        Collection <CBRCase> casos = baseCasos.getCases();
        
        
                
        NNConfig configuracaoSimilaridade = new NNConfig();
        configuracaoSimilaridade.setDescriptionSimFunction(new Average());
          
        
        
        Attribute atributoDescricao = new Attribute("descricaoCaso", Descricaocaso.class);
        Attribute atributoTitulo = new Attribute("tituloCaso", Descricaocaso.class);
        
        
        
        
        //configuracaoSimilaridade.setWeight(atributoTitulo, 0.8);
        
        configuracaoSimilaridade.addMapping(atributoDescricao, new LuceneTextSimilarity(lucene, cbrq, atributoDescricao, true));
        configuracaoSimilaridade.addMapping(atributoTitulo, new LuceneTextSimilarity(lucene, cbrq, atributoTitulo, true));
        
        Collection<RetrievalResult> listaResultadoConsulta = NNScoringMethod.evaluateSimilarity(casos, cbrq, configuracaoSimilaridade);
        
        listaResultadoConsulta = SelectCases.selectTopKRR(listaResultadoConsulta, 10);
        
        resultado = listaResultadoConsulta;
        
        
        
    }

    @Override
    public void postCycle() throws ExecutionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Collection<RetrievalResult> getResultado(){
        return this.resultado;
    }
}
