
package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.EmpresaProp;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "frete_tab_emp", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"frete_tab_transp", "empresa_prop", "dt_inicio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaEmpresa.findAll", query = "SELECT f FROM TabelaEmpresa f"),
    @NamedQuery(name = "TabelaEmpresa.findByIdFreteTabEmp", query = "SELECT f FROM TabelaEmpresa f WHERE f.idFreteTabEmp = :idFreteTabEmp"),
    @NamedQuery(name = "TabelaEmpresa.findByDtInicio", query = "SELECT f FROM TabelaEmpresa f WHERE f.dtInicio = :dtInicio"),
    @NamedQuery(name = "TabelaEmpresa.findByDtFim", query = "SELECT f FROM TabelaEmpresa f WHERE f.dtFim = :dtFim"),
    @NamedQuery(name = "TabelaEmpresa.findByDtInst", query = "SELECT f FROM TabelaEmpresa f WHERE f.dtInst = :dtInst")})
public class TabelaEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frete_tab_emp", nullable = false)
    private Integer idFreteTabEmp;
    @Basic(optional = false)
    @Column(name = "dt_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtInicio;
    @Basic(optional = false)
    @Column(name = "dt_fim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtFim;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumn(name = "empresa_prop", referencedColumnName = "id_empresa_prop", nullable = false)
    @ManyToOne(optional = false)
    private EmpresaProp empresaProp;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "frete_tab_transp", referencedColumnName = "id_frete_tab_transp", nullable = false)
    @ManyToOne(optional = false)
    private TabelaTransportadora freteTabTransp;

    public TabelaEmpresa() {
    }

    public TabelaEmpresa(Integer idFreteTabEmp) {
        this.idFreteTabEmp = idFreteTabEmp;
    }

    public TabelaEmpresa(Integer idFreteTabEmp, Date dtInicio, Date dtFim, Date dtInst) {
        this.idFreteTabEmp = idFreteTabEmp;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.dtInst = dtInst;
    }

    public Integer getIdFreteTabEmp() {
        return idFreteTabEmp;
    }

    public void setIdFreteTabEmp(Integer idFreteTabEmp) {
        this.idFreteTabEmp = idFreteTabEmp;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Date getDtInst() {
        return dtInst;
    }

    public void setDtInst(Date dtInst) {
        this.dtInst = dtInst;
    }

    public EmpresaProp getEmpresaProp() {
        return empresaProp;
    }

    public void setEmpresaProp(EmpresaProp empresaProp) {
        this.empresaProp = empresaProp;
    }

    public Usuario getUsuarioInst() {
        return usuarioInst;
    }

    public void setUsuarioInst(Usuario usuarioInst) {
        this.usuarioInst = usuarioInst;
    }

    public TabelaTransportadora getFreteTabTransp() {
        return freteTabTransp;
    }

    public void setFreteTabTransp(TabelaTransportadora freteTabTransp) {
        this.freteTabTransp = freteTabTransp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFreteTabEmp != null ? idFreteTabEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaEmpresa)) {
            return false;
        }
        TabelaEmpresa other = (TabelaEmpresa) object;
        if ((this.idFreteTabEmp == null && other.idFreteTabEmp != null) || (this.idFreteTabEmp != null && !this.idFreteTabEmp.equals(other.idFreteTabEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTabEmp[ idFreteTabEmp=" + idFreteTabEmp + " ]";
    }
    
}
