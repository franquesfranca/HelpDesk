/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Assunção
 */
@Entity
@Table(name = "chamado", catalog = "glpi", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chamado.findAll", query = "SELECT c FROM Chamado c"),
    @NamedQuery(name = "Chamado.findByIdChamado", query = "SELECT c FROM Chamado c WHERE c.idChamado = :idChamado"),
    @NamedQuery(name = "Chamado.findByTituloChamado", query = "SELECT c FROM Chamado c WHERE c.tituloChamado = :tituloChamado"),
    @NamedQuery(name = "Chamado.findByDescricaoChamado", query = "SELECT c FROM Chamado c WHERE c.descricaoChamado = :descricaoChamado"),
    @NamedQuery(name = "Chamado.findByDataChamado", query = "SELECT c FROM Chamado c WHERE c.dataChamado = :dataChamado"),
    @NamedQuery(name = "Chamado.findByChamadoAtendido", query = "SELECT c FROM Chamado c WHERE c.chamadoAtendido = :chamadoAtendido"),
    @NamedQuery(name = "Chamado.findByIdUsuario", query = "SELECT c FROM Chamado c WHERE c.idUsuario = :idUsuario")})
public class Chamado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChamado")
    private Integer idChamado;
    @Basic(optional = false)
    @Column(name = "tituloChamado")
    private String tituloChamado;
    @Basic(optional = false)
    @Column(name = "descricaoChamado")
    private String descricaoChamado;
    @Basic(optional = false)
    @Column(name = "dataChamado")
    private String dataChamado;
    @Basic(optional = false)
    @Column(name = "chamadoAtendido")
    private boolean chamadoAtendido;
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private int idUsuario;

    public Chamado() {
    }

    public Chamado(Integer idChamado) {
        this.idChamado = idChamado;
    }

    public Chamado(Integer idChamado, String tituloChamado, String descricaoChamado, String dataChamado, boolean chamadoAtendido, int idUsuario) {
        this.idChamado = idChamado;
        this.tituloChamado = tituloChamado;
        this.descricaoChamado = descricaoChamado;
        this.dataChamado = dataChamado;
        this.chamadoAtendido = chamadoAtendido;
        this.idUsuario = idUsuario;
    }

    public Integer getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Integer idChamado) {
        Integer oldIdChamado = this.idChamado;
        this.idChamado = idChamado;
        changeSupport.firePropertyChange("idChamado", oldIdChamado, idChamado);
    }

    public String getTituloChamado() {
        return tituloChamado;
    }

    public void setTituloChamado(String tituloChamado) {
        String oldTituloChamado = this.tituloChamado;
        this.tituloChamado = tituloChamado;
        changeSupport.firePropertyChange("tituloChamado", oldTituloChamado, tituloChamado);
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String descricaoChamado) {
        String oldDescricaoChamado = this.descricaoChamado;
        this.descricaoChamado = descricaoChamado;
        changeSupport.firePropertyChange("descricaoChamado", oldDescricaoChamado, descricaoChamado);
    }

    public String getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(String dataChamado) {
        String oldDataChamado = this.dataChamado;
        this.dataChamado = dataChamado;
        changeSupport.firePropertyChange("dataChamado", oldDataChamado, dataChamado);
    }

    public boolean getChamadoAtendido() {
        return chamadoAtendido;
    }

    public void setChamadoAtendido(boolean chamadoAtendido) {
        boolean oldChamadoAtendido = this.chamadoAtendido;
        this.chamadoAtendido = chamadoAtendido;
        changeSupport.firePropertyChange("chamadoAtendido", oldChamadoAtendido, chamadoAtendido);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        int oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChamado != null ? idChamado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.idChamado == null && other.idChamado != null) || (this.idChamado != null && !this.idChamado.equals(other.idChamado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.Chamado[ idChamado=" + idChamado + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
