package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Transportadora;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "frete_tab_filial", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaFilial.findAll", query = "SELECT f FROM TabelaFilial f"),
    @NamedQuery(name = "TabelaFilial.findByIdFreteTabFilial", query = "SELECT f FROM TabelaFilial f WHERE f.idFreteTabFilial = :idFreteTabFilial"),
    @NamedQuery(name = "TabelaFilial.findByDtInicio", query = "SELECT f FROM TabelaFilial f WHERE f.dtInicio = :dtInicio"),
    @NamedQuery(name = "TabelaFilial.findByDtFim", query = "SELECT f FROM TabelaFilial f WHERE f.dtFim = :dtFim"),
    @NamedQuery(name = "TabelaFilial.findByDtInst", query = "SELECT f FROM TabelaFilial f WHERE f.dtInst = :dtInst")})
public class TabelaFilial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frete_tab_filial", nullable = false)
    private Integer idFreteTabFilial;
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
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "frete_tab_transp", referencedColumnName = "id_frete_tab_transp", nullable = false)
    @ManyToOne(optional = false)
    private TabelaTransportadora freteTabTransp;
    @JoinColumn(name = "filial", referencedColumnName = "id_filial", nullable = false)
    @ManyToOne(optional = false)
    private Transportadora filial;

    public TabelaFilial() {
    }

    public TabelaFilial(Integer idFreteTabFilial) {
        this.idFreteTabFilial = idFreteTabFilial;
    }

    public TabelaFilial(Integer idFreteTabFilial, Date dtInicio, Date dtFim, Date dtInst) {
        this.idFreteTabFilial = idFreteTabFilial;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.dtInst = dtInst;
    }

    public Integer getIdFreteTabFilial() {
        return idFreteTabFilial;
    }

    public void setIdFreteTabFilial(Integer idFreteTabFilial) {
        this.idFreteTabFilial = idFreteTabFilial;
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

    public Transportadora getFilial() {
        return filial;
    }

    public void setFilial(Transportadora filial) {
        this.filial = filial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFreteTabFilial != null ? idFreteTabFilial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaFilial)) {
            return false;
        }
        TabelaFilial other = (TabelaFilial) object;
        if ((this.idFreteTabFilial == null && other.idFreteTabFilial != null) || (this.idFreteTabFilial != null && !this.idFreteTabFilial.equals(other.idFreteTabFilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTabFilial[ idFreteTabFilial=" + idFreteTabFilial + " ]";
    }
    
}
