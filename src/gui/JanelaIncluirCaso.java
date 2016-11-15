/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bd.ConnectorHelpDesk;
import entidades.Caso;
import entidades.Descricaocaso;
import entidades.Solucaocaso;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jcolibri.cbrcore.CBRCase;

/**
 *
 * @author Assunção
 */
public class JanelaIncluirCaso extends javax.swing.JFrame {

    /**
     * Creates new form JanelaIncluirCaso
     */
    
    Integer idChamado;
    public JanelaIncluirCaso() {
        initComponents();
        setTitle("Incluir Caso");
        URL url = this.getClass().getResource("a.png");  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconeTitulo);
    }
    
    public JanelaIncluirCaso(String titulo, String descricao, Integer id) {
        initComponents();
        setTitle("Incluir Caso");
        URL url = this.getClass().getResource("a.png");  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconeTitulo);
        campoTitulo.setText(titulo);
        campoDescricao.setText(descricao);
        idChamado = id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoSolucao = new javax.swing.JTextArea();
        botaoIncluirCaso = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Título:");

        jLabel2.setText("Descrição do Problema:");

        campoDescricao.setColumns(20);
        campoDescricao.setLineWrap(true);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        jLabel3.setText("Solução do Problema:");

        campoSolucao.setColumns(20);
        campoSolucao.setLineWrap(true);
        campoSolucao.setRows(5);
        jScrollPane2.setViewportView(campoSolucao);

        botaoIncluirCaso.setText("Incluir Caso");
        botaoIncluirCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirCasoActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(campoTitulo)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoIncluirCaso)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIncluirCaso)
                    .addComponent(botaoSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.setVisible(false);
        JanelaMenu janela = new JanelaMenu();
        janela.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoIncluirCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirCasoActionPerformed
        try {
            ArrayList<CBRCase> lista = new ArrayList<CBRCase>();
            Caso caso = new Caso();
            Descricaocaso descricaoCaso = new Descricaocaso();
            Solucaocaso solucaoCaso = new Solucaocaso();
            descricaoCaso.setTitulo(campoTitulo.getText());
            descricaoCaso.setDescricao(campoDescricao.getText());
            solucaoCaso.setSolucao(campoSolucao.getText());
            caso.setDescricaocaso(descricaoCaso);
            caso.setSolucaocaso(solucaoCaso);

            if(campoTitulo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor Preencher Campo Título!");                
            }else if(campoDescricao.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor Preencher Campo Descrição!");
            }else if(campoSolucao.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor Preencher Campo Solução!");
            }else{
                ConnectorHelpDesk conect = new ConnectorHelpDesk();
                conect.deleteRequest(idChamado);
                lista.add(caso);
                conect.storeCaseDescription(descricaoCaso);
                conect.storeCaseSolution(solucaoCaso);
                conect.storeCases(lista);                
                JOptionPane.showMessageDialog(null, "Caso Incluído com Sucesso!");
            }
                      
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Caso Não Incluído na Base de Casos\n"+e.getMessage());
        
        }


    }//GEN-LAST:event_botaoIncluirCasoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaIncluirCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaIncluirCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaIncluirCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaIncluirCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaIncluirCaso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoIncluirCaso;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextArea campoSolucao;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
