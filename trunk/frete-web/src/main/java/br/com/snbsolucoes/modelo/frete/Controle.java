package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "frete_controle", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controle.findAll", query = "SELECT f FROM Controle f"),
    @NamedQuery(name = "Controle.findByIdControle", query = "SELECT f FROM Controle f WHERE f.idControle = :idControle"),
    @NamedQuery(name = "Controle.findByDtInicio", query = "SELECT f FROM Controle f WHERE f.dtInicio = :dtInicio"),
    @NamedQuery(name = "Controle.findByDtFim", query = "SELECT f FROM Controle f WHERE f.dtFim = :dtFim"),
    @NamedQuery(name = "Controle.findByPercentualIcms", query = "SELECT f FROM Controle f WHERE f.percentualIcms = :percentualIcms"),
    @NamedQuery(name = "Controle.findByDtInst", query = "SELECT f FROM Controle f WHERE f.dtInst = :dtInst")})
public class Controle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle", nullable = false)
    private Integer idControle;
    @Basic(optional = false)
    @Column(name = "dt_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtInicio;
    @Basic(optional = false)
    @Column(name = "dt_fim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtFim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "percentual_icms", nullable = false, precision = 5, scale = 2)
    private BigDecimal percentualIcms;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;

    public Controle() {
    }

    public Controle(Integer idControle) {
        this.idControle = idControle;
    }

    public Controle(Integer idControle, Date dtInicio, Date dtFim, BigDecimal percentualIcms, Date dtInst) {
        this.idControle = idControle;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.percentualIcms = percentualIcms;
        this.dtInst = dtInst;
    }

    public Integer getIdControle() {
        return idControle;
    }

    public void setIdControle(Integer idControle) {
        this.idControle = idControle;
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

    public BigDecimal getPercentualIcms() {
        return percentualIcms;
    }

    public void setPercentualIcms(BigDecimal percentualIcms) {
        this.percentualIcms = percentualIcms;
    }

    public Date getDtInst() {
        return dtInst;
    }

    public void setDtInst(Date dtInst) {
        this.dtInst = dtInst;
    }

    public Usuario getUsuarioInst() {
        return usuarioInst;
    }

    public void setUsuarioInst(Usuario usuarioInst) {
        this.usuarioInst = usuarioInst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControle != null ? idControle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controle)) {
            return false;
        }
        Controle other = (Controle) object;
        if ((this.idControle == null && other.idControle != null) || (this.idControle != null && !this.idControle.equals(other.idControle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.Controle[ idControle=" + idControle + " ]";
    }
    
}
