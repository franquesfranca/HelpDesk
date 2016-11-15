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
@Table(name = "caso", catalog = "glpi", schema = "")
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c"),
    @NamedQuery(name = "Caso.findByIdCaso", query = "SELECT c FROM Caso c WHERE c.idCaso = :idCaso"),
    @NamedQuery(name = "Caso.findByIdDescricao", query = "SELECT c FROM Caso c WHERE c.idDescricao = :idDescricao"),
    @NamedQuery(name = "Caso.findByIdSolucao", query = "SELECT c FROM Caso c WHERE c.idSolucao = :idSolucao")})
public class Caso implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaso")
    private Integer idCaso;
    @Basic(optional = false)
    @Column(name = "idDescricao")
    private int idDescricao;
    @Basic(optional = false)
    @Column(name = "idSolucao")
    private int idSolucao;

    public Caso() {
    }

    public Caso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Caso(Integer idCaso, int idDescricao, int idSolucao) {
        this.idCaso = idCaso;
        this.idDescricao = idDescricao;
        this.idSolucao = idSolucao;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        Integer oldIdCaso = this.idCaso;
        this.idCaso = idCaso;
        changeSupport.firePropertyChange("idCaso", oldIdCaso, idCaso);
    }

    public int getIdDescricao() {
        return idDescricao;
    }

    public void setIdDescricao(int idDescricao) {
        int oldIdDescricao = this.idDescricao;
        this.idDescricao = idDescricao;
        changeSupport.firePropertyChange("idDescricao", oldIdDescricao, idDescricao);
    }

    public int getIdSolucao() {
        return idSolucao;
    }

    public void setIdSolucao(int idSolucao) {
        int oldIdSolucao = this.idSolucao;
        this.idSolucao = idSolucao;
        changeSupport.firePropertyChange("idSolucao", oldIdSolucao, idSolucao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaso != null ? idCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caso)) {
            return false;
        }
        Caso other = (Caso) object;
        if ((this.idCaso == null && other.idCaso != null) || (this.idCaso != null && !this.idCaso.equals(other.idCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.Caso[ idCaso=" + idCaso + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
