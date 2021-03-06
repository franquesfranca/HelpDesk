/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bd.ConnectorHelpDesk;
import entidades.Chamado;
import entidades.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Assunção
 */
public class JanelaAbrirChamado extends javax.swing.JFrame {

    /**
     * Creates new form JanelaAbrirChamado
     */
    public JanelaAbrirChamado() {
        initComponents();
        setTitle("Abrir Chamado");
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

        jComboBox1 = new javax.swing.JComboBox();
        rotuloTitulo = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        rotuloDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoAbrirChamado = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rotuloTitulo.setText("Título:");

        rotuloDescricao.setText("Descrição do Problema:");

        campoDescricao.setColumns(20);
        campoDescricao.setLineWrap(true);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        botaoAbrirChamado.setText("Abrir Chamado");
        botaoAbrirChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAbrirChamadoActionPerformed(evt);
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
                            .addComponent(rotuloTitulo)
                            .addComponent(campoTitulo)
                            .addComponent(rotuloDescricao)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAbrirChamado)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotuloTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotuloDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAbrirChamado)
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

    private void botaoAbrirChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAbrirChamadoActionPerformed
        Usuario user = new Usuario();        
        user.setAdmin(true);
        user.setMatricula("10111905");
        user.setNome("Weverson");
        user.setSenha("123456");
        
        Chamado chamado = new Chamado();
        chamado.setTituloChamado(campoTitulo.getText());
        chamado.setDescricaoChamado(campoDescricao.getText());
        chamado.setChamadoAtendido(false);
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyy");
        
        chamado.setDataChamado(formato.format(data));
        chamado.setUsuario(user);
        
        

        if (campoTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor Preencher Campo Título!");
        } else if (campoDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor Preencher Campo Descrição!");
        } else {
            ConnectorHelpDesk conect = new ConnectorHelpDesk();
            conect.storeUser(user);
            conect.storeRequest(chamado);
            JOptionPane.showMessageDialog(null, "Chamado Incluído com Sucesso!\n Aguarde o Atendimento...");
        }

    }//GEN-LAST:event_botaoAbrirChamadoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaAbrirChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaAbrirChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaAbrirChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaAbrirChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAbrirChamado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAbrirChamado;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotuloDescricao;
    private javax.swing.JLabel rotuloTitulo;
    // End of variables declaration//GEN-END:variables
}
