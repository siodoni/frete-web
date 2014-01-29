package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Cidade;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "amfrete_tab_transp_valor_var", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"frete_tab_transp", "frete_variavel", "cidade", "fg_tp_cobranca", "vlr_faixa_inicio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findAll", query = "SELECT f FROM TabelaTransportadoraValorVariavel f"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavelr.findByIdTabTranspValorVar", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.idTabTranspValorVar = :idTabTranspValorVar"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findByFgTpCobranca", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.fgTpCobranca = :fgTpCobranca"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findByVlrFaixaInicio", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.vlrFaixaInicio = :vlrFaixaInicio"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findByVlrFaixaFim", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.vlrFaixaFim = :vlrFaixaFim"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findByVlrVariavel", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.vlrVariavel = :vlrVariavel"),
    @NamedQuery(name = "TabelaTransportadoraValorVariavel.findByDtInst", query = "SELECT f FROM TabelaTransportadoraValorVariavel f WHERE f.dtInst = :dtInst")})
public class TabelaTransportadoraValorVariavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tab_transp_valor_var", nullable = false)
    private Integer idTabTranspValorVar;
    @Basic(optional = false)
    @Column(name = "fg_tp_cobranca", nullable = false, length = 1)
    private String fgTpCobranca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vlr_faixa_inicio", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrFaixaInicio;
    @Basic(optional = false)
    @Column(name = "vlr_faixa_fim", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrFaixaFim;
    @Basic(optional = false)
    @Column(name = "vlr_variavel", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrVariavel;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumns({
        @JoinColumn(name = "frete_tab_transp", referencedColumnName = "frete_tab_transp", nullable = false),
        @JoinColumn(name = "frete_variavel", referencedColumnName = "frete_variavel", nullable = false)})
    @ManyToOne(optional = false)
    private TabelaTransportadoraVariavel freteTabTranspVar;
    @JoinColumn(name = "cidade", referencedColumnName = "id_cidade")
    @ManyToOne
    private Cidade cidade;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "tp_calc_valor", referencedColumnName = "id_tp_calc_valor", nullable = false)
    @ManyToOne(optional = false)
    private TipoCalculoValor tpCalcValor;

    public TabelaTransportadoraValorVariavel() {
    }

    public TabelaTransportadoraValorVariavel(Integer idTabTranspValorVar) {
        this.idTabTranspValorVar = idTabTranspValorVar;
    }

    public TabelaTransportadoraValorVariavel(Integer idTabTranspValorVar, String fgTpCobranca, BigDecimal vlrFaixaInicio, BigDecimal vlrFaixaFim, BigDecimal vlrVariavel, Date dtInst) {
        this.idTabTranspValorVar = idTabTranspValorVar;
        this.fgTpCobranca = fgTpCobranca;
        this.vlrFaixaInicio = vlrFaixaInicio;
        this.vlrFaixaFim = vlrFaixaFim;
        this.vlrVariavel = vlrVariavel;
        this.dtInst = dtInst;
    }

    public Integer getIdTabTranspValorVar() {
        return idTabTranspValorVar;
    }

    public void setIdTabTranspValorVar(Integer idTabTranspValorVar) {
        this.idTabTranspValorVar = idTabTranspValorVar;
    }

    public String getFgTpCobranca() {
        return fgTpCobranca;
    }

    public void setFgTpCobranca(String fgTpCobranca) {
        this.fgTpCobranca = fgTpCobranca;
    }

    public BigDecimal getVlrFaixaInicio() {
        return vlrFaixaInicio;
    }

    public void setVlrFaixaInicio(BigDecimal vlrFaixaInicio) {
        this.vlrFaixaInicio = vlrFaixaInicio;
    }

    public BigDecimal getVlrFaixaFim() {
        return vlrFaixaFim;
    }

    public void setVlrFaixaFim(BigDecimal vlrFaixaFim) {
        this.vlrFaixaFim = vlrFaixaFim;
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

    public TabelaTransportadoraVariavel getFreteTabTranspVar() {
        return freteTabTranspVar;
    }

    public void setFreteTabTranspVar(TabelaTransportadoraVariavel freteTabTranspVar) {
        this.freteTabTranspVar = freteTabTranspVar;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTabTranspValorVar != null ? idTabTranspValorVar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaTransportadoraValorVariavel)) {
            return false;
        }
        TabelaTransportadoraValorVariavel other = (TabelaTransportadoraValorVariavel) object;
        if ((this.idTabTranspValorVar == null && other.idTabTranspValorVar != null) || (this.idTabTranspValorVar != null && !this.idTabTranspValorVar.equals(other.idTabTranspValorVar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTabTranspValorVar[ idTabTranspValorVar=" + idTabTranspValorVar + " ]";
    }
    
}
