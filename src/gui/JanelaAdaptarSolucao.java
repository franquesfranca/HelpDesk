/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bd.ConnectorHelpDesk;
import entidades.Descricaocaso;
import entidades.Solucaocaso;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import jcolibri.cbrcore.CBRCase;

/**
 *
 * @author Assunção
 */
public class JanelaAdaptarSolucao extends javax.swing.JFrame {

    /**
     * Creates new form JanelaAtenderChamado
     */
    int id;

    public JanelaAdaptarSolucao() {
        initComponents();
        setTitle("Adaptar Solução");
        URL url = this.getClass().getResource("a.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoSolucao = new javax.swing.JTextArea();
        botaoSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoSolucionarChamado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Descrição do Problema:");

        campoSolucao.setColumns(20);
        campoSolucao.setRows(5);
        jScrollPane1.setViewportView(campoSolucao);

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Título:");

        campoTitulo.setEditable(false);

        jLabel6.setText("Solução:");

        campoDescricao.setEditable(false);
        campoDescricao.setBackground(new java.awt.Color(240, 240, 240));
        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane2.setViewportView(campoDescricao);

        botaoSolucionarChamado.setText("Solucionar Chamado");
        botaoSolucionarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSolucionarChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSolucionarChamado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSolucionarChamado)
                    .addComponent(botaoSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSolucionarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSolucionarChamadoActionPerformed
        try {
            ArrayList<CBRCase> lista = new ArrayList<CBRCase>();
            entidades.Caso caso = new entidades.Caso();
            Descricaocaso descricaoCaso = new Descricaocaso();
            Solucaocaso solucaoCaso = new Solucaocaso();
            descricaoCaso.setTitulo(JanelaAtenderChamado.getChamado().getTituloChamado());
            descricaoCaso.setDescricao(JanelaAtenderChamado.getChamado().getDescricaoChamado());
            solucaoCaso.setSolucao(campoSolucao.getText());
            caso.setDescricaocaso(descricaoCaso);
            caso.setSolucaocaso(solucaoCaso);
            
            ConnectorHelpDesk conect = new ConnectorHelpDesk();
            conect.deleteRequest(id);
            lista.add(caso);
            conect.storeCaseDescription(descricaoCaso);
            conect.storeCaseSolution(solucaoCaso);
            conect.storeCases(lista);
            JOptionPane.showMessageDialog(null, "Chamado Solucionado com Sucesso!");
            this.dispose();
            JanelaListaChamados janela = new JanelaListaChamados();
            janela.setVisible(true);
        } catch (Exception e) {
            System.out.println("Não Foi Possível Solucionar o Chamado\n" + e.getMessage());
        }
        


    }//GEN-LAST:event_botaoSolucionarChamadoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
        JanelaListaChamados janela = new JanelaListaChamados();
        janela.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaAdaptarSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaAdaptarSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaAdaptarSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaAdaptarSolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAdaptarSolucao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoSolucionarChamado;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextArea campoSolucao;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public JTextField getCampoTitulo() {
        return campoTitulo;
    }

    public JTextArea getCampoDescricao() {
        return campoDescricao;
    }

    public JTextArea getCampoSolucao() {
        return campoSolucao;
    }

    public void setCampoSolucao(JTextArea campoSolucao) {
        this.campoSolucao = campoSolucao;
    }

    public void setCampoTitulo(JTextField campoTitulo) {
        this.campoTitulo = campoTitulo;
    }
}
