
package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "frete_tab_transp_var", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaTransportadoraVariavel.findAll", query = "SELECT f FROM TabelaTransportadoraVariavel f"),
    @NamedQuery(name = "TabelaTransportadoraVariavel.findByFreteTabTransp", query = "SELECT f FROM TabelaTransportadoraVariavel f WHERE f.freteTabTranspVarPK.freteTabTransp = :freteTabTransp"),
    @NamedQuery(name = "TabelaTransportadoraVariavel.findByFreteVariavel", query = "SELECT f FROM TabelaTransportadoraVariavel f WHERE f.freteTabTranspVarPK.freteVariavel = :freteVariavel"),
    @NamedQuery(name = "TabelaTransportadoraVariavel.findByVlrVariavel", query = "SELECT f FROM TabelaTransportadoraVariavel f WHERE f.vlrVariavel = :vlrVariavel"),
    @NamedQuery(name = "TabelaTransportadoraVariavel.findByDtInst", query = "SELECT f FROM TabelaTransportadoraVariavel f WHERE f.dtInst = :dtInst")})
public class TabelaTransportadoraVariavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabelaTransportadoraVariavelPK freteTabTranspVarPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_variavel", precision = 16, scale = 4)
    private BigDecimal vlrVariavel;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "tp_calc_valor", referencedColumnName = "id_tp_calc_valor")
    @ManyToOne
    private TipoCalculoValor tpCalcValor;
    @JoinColumn(name = "tp_faixa", referencedColumnName = "id_tp_faixa")
    @ManyToOne
    private TipoFaixa tpFaixa;
    @JoinColumn(name = "frete_variavel", referencedColumnName = "id_frete_variavel", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Variavel freteVariavel1;
    @JoinColumn(name = "frete_tab_transp", referencedColumnName = "id_frete_tab_transp", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TabelaTransportadora freteTabTransp1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteTabTranspVar")
    private List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList;

    public TabelaTransportadoraVariavel() {
    }

    public TabelaTransportadoraVariavel(TabelaTransportadoraVariavelPK freteTabTranspVarPK) {
        this.freteTabTranspVarPK = freteTabTranspVarPK;
    }

    public TabelaTransportadoraVariavel(TabelaTransportadoraVariavelPK freteTabTranspVarPK, Date dtInst) {
        this.freteTabTranspVarPK = freteTabTranspVarPK;
        this.dtInst = dtInst;
    }

    public TabelaTransportadoraVariavel(int freteTabTransp, int freteVariavel) {
        this.freteTabTranspVarPK = new TabelaTransportadoraVariavelPK(freteTabTransp, freteVariavel);
    }

    public TabelaTransportadoraVariavelPK getFreteTabTranspVarPK() {
        return freteTabTranspVarPK;
    }

    public void setFreteTabTranspVarPK(TabelaTransportadoraVariavelPK freteTabTranspVarPK) {
        this.freteTabTranspVarPK = freteTabTranspVarPK;
    }

    public BigDecimal getVlrVariavel() {
        return vlrVariavel;
    }

    public void setVlrVariavel(BigDecimal vlrVariavel) {
        this.vlrVariavel = vlrVariavel;
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

    public TipoCalculoValor getTpCalcValor() {
        return tpCalcValor;
    }

    public void setTpCalcValor(TipoCalculoValor tpCalcValor) {
        this.tpCalcValor = tpCalcValor;
    }

    public TipoFaixa getTpFaixa() {
        return tpFaixa;
    }

    public void setTpFaixa(TipoFaixa tpFaixa) {
        this.tpFaixa = tpFaixa;
    }

    public Variavel getFreteVariavel1() {
        return freteVariavel1;
    }

    public void setFreteVariavel1(Variavel freteVariavel1) {
        this.freteVariavel1 = freteVariavel1;
    }

    public TabelaTransportadora getFreteTabTransp1() {
        return freteTabTransp1;
    }

    public void setFreteTabTransp1(TabelaTransportadora freteTabTransp1) {
        this.freteTabTransp1 = freteTabTransp1;
    }

    @XmlTransient
    public List<TabelaTransportadoraValorVariavel> getFreteTabTranspValorVarList() {
        return freteTabTranspValorVarList;
    }

    public void setFreteTabTranspValorVarList(List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList) {
        this.freteTabTranspValorVarList = freteTabTranspValorVarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (freteTabTranspVarPK != null ? freteTabTranspVarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaTransportadoraVariavel)) {
            return false;
        }
        TabelaTransportadoraVariavel other = (TabelaTransportadoraVariavel) object;
        if ((this.freteTabTranspVarPK == null && other.freteTabTranspVarPK != null) || (this.freteTabTranspVarPK != null && !this.freteTabTranspVarPK.equals(other.freteTabTranspVarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTabTranspVar[ freteTabTranspVarPK=" + freteTabTranspVarPK + " ]";
    }
    
}
