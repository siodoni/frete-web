package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Transportadora;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "frete_tab_transp", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"transportadora", "familia_produto", "dt_inicio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaTransportadora.findAll", query = "SELECT f FROM TabelaTransportadora f"),
    @NamedQuery(name = "TabelaTransportadora.findByIdFreteTabTransp", query = "SELECT f FROM TabelaTransportadora f WHERE f.idFreteTabTransp = :idFreteTabTransp"),
    @NamedQuery(name = "TabelaTransportadora.findByDtInicio", query = "SELECT f FROM TabelaTransportadora f WHERE f.dtInicio = :dtInicio"),
    @NamedQuery(name = "TabelaTransportadora.findByDtFim", query = "SELECT f FROM TabelaTransportadora f WHERE f.dtFim = :dtFim"),
    @NamedQuery(name = "TabelaTransportadora.findByDtInst", query = "SELECT f FROM TabelaTransportadora f WHERE f.dtInst = :dtInst")})
public class TabelaTransportadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frete_tab_transp", nullable = false)
    private Integer idFreteTabTransp;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteTabTransp1")
    private List<TabelaTransportadoraVariavel> freteTabTranspVarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteTabTransp")
    private List<Peso> fretePesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteTabTransp")
    private List<TabelaEmpresa> freteTabEmpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteTabTransp")
    private List<TabelaFilial> freteTabFilialList;
    @JoinColumn(name = "transportadora", referencedColumnName = "id_filial", nullable = false)
    @ManyToOne(optional = false)
    private Transportadora transportadora;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "tp_calc_vlr_frete", referencedColumnName = "id_tp_calc_valor", nullable = false)
    @ManyToOne(optional = false)
    private TipoCalculoValor tpCalcVlrFrete;
    @JoinColumn(name = "tp_calc_vlr_kg_exced", referencedColumnName = "id_tp_calc_valor")
    @ManyToOne
    private TipoCalculoValor tpCalcVlrKgExced;
    @JoinColumn(name = "familia_produto", referencedColumnName = "id_familia_produto", nullable = false)
    @ManyToOne(optional = false)
    private FamiliaProduto familiaProduto;

    public TabelaTransportadora() {
    }

    public TabelaTransportadora(Integer idFreteTabTransp) {
        this.idFreteTabTransp = idFreteTabTransp;
    }

    public TabelaTransportadora(Integer idFreteTabTransp, Date dtInicio, Date dtFim, Date dtInst) {
        this.idFreteTabTransp = idFreteTabTransp;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.dtInst = dtInst;
    }

    public Integer getIdFreteTabTransp() {
        return idFreteTabTransp;
    }

    public void setIdFreteTabTransp(Integer idFreteTabTransp) {
        this.idFreteTabTransp = idFreteTabTransp;
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

    @XmlTransient
    public List<TabelaTransportadoraVariavel> getFreteTabTranspVarList() {
        return freteTabTranspVarList;
    }

    public void setFreteTabTranspVarList(List<TabelaTransportadoraVariavel> freteTabTranspVarList) {
        this.freteTabTranspVarList = freteTabTranspVarList;
    }

    @XmlTransient
    public List<Peso> getFretePesoList() {
        return fretePesoList;
    }

    public void setFretePesoList(List<Peso> fretePesoList) {
        this.fretePesoList = fretePesoList;
    }

    @XmlTransient
    public List<TabelaEmpresa> getFreteTabEmpList() {
        return freteTabEmpList;
    }

    public void setFreteTabEmpList(List<TabelaEmpresa> freteTabEmpList) {
        this.freteTabEmpList = freteTabEmpList;
    }

    @XmlTransient
    public List<TabelaFilial> getFreteTabFilialList() {
        return freteTabFilialList;
    }

    public void setFreteTabFilialList(List<TabelaFilial> freteTabFilialList) {
        this.freteTabFilialList = freteTabFilialList;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Usuario getUsuarioInst() {
        return usuarioInst;
    }

    public void setUsuarioInst(Usuario usuarioInst) {
        this.usuarioInst = usuarioInst;
    }

    public TipoCalculoValor getTpCalcVlrFrete() {
        return tpCalcVlrFrete;
    }

    public void setTpCalcVlrFrete(TipoCalculoValor tpCalcVlrFrete) {
        this.tpCalcVlrFrete = tpCalcVlrFrete;
    }

    public TipoCalculoValor getTpCalcVlrKgExced() {
        return tpCalcVlrKgExced;
    }

    public void setTpCalcVlrKgExced(TipoCalculoValor tpCalcVlrKgExced) {
        this.tpCalcVlrKgExced = tpCalcVlrKgExced;
    }

    public FamiliaProduto getFamiliaProduto() {
        return familiaProduto;
    }

    public void setFamiliaProduto(FamiliaProduto familiaProduto) {
        this.familiaProduto = familiaProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFreteTabTransp != null ? idFreteTabTransp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaTransportadora)) {
            return false;
        }
        TabelaTransportadora other = (TabelaTransportadora) object;
        if ((this.idFreteTabTransp == null && other.idFreteTabTransp != null) || (this.idFreteTabTransp != null && !this.idFreteTabTransp.equals(other.idFreteTabTransp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.TabelaTransportadora[ idFreteTabTransp=" + idFreteTabTransp + " ]";
    }
    
}
