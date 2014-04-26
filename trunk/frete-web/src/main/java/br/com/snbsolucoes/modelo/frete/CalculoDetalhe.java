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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "frete_calculo_det", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"calculo", "frete_peso", "frete_variavel", "tp_faixa", "tp_calc_valor", "vlr_variavel"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalculoDetalhe.findAll", query = "SELECT f FROM CalculoDetalhe f"),
    @NamedQuery(name = "CalculoDetalhe.findByIdCalculoDet", query = "SELECT f FROM CalculoDetalhe f WHERE f.idCalculoDet = :idCalculoDet"),
    @NamedQuery(name = "CalculoDetalhe.findByVlrVariavel", query = "SELECT f FROM CalculoDetalhe f WHERE f.vlrVariavel = :vlrVariavel"),
    @NamedQuery(name = "CalculoDetalhe.findByVlrResultado", query = "SELECT f FROM CalculoDetalhe f WHERE f.vlrResultado = :vlrResultado"),
    @NamedQuery(name = "CalculoDetalhe.findByFgIncideIcms", query = "SELECT f FROM CalculoDetalhe f WHERE f.fgIncideIcms = :fgIncideIcms"),
    @NamedQuery(name = "CalculoDetalhe.findByFgAutomatico", query = "SELECT f FROM CalculoDetalhe f WHERE f.fgAutomatico = :fgAutomatico"),
    @NamedQuery(name = "CalculoDetalhe.findByDtInst", query = "SELECT f FROM CalculoDetalhe f WHERE f.dtInst = :dtInst")})
public class CalculoDetalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calculo_det", nullable = false)
    private Integer idCalculoDet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vlr_variavel", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrVariavel;
    @Basic(optional = false)
    @Column(name = "vlr_resultado", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrResultado;
    @Basic(optional = false)
    @Column(name = "fg_incide_icms", nullable = false, length = 1)
    private String fgIncideIcms;
    @Basic(optional = false)
    @Column(name = "fg_automatico", nullable = false, length = 1)
    private String fgAutomatico;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "frete_variavel", referencedColumnName = "id_frete_variavel")
    @ManyToOne
    private Variavel freteVariavel;
    @JoinColumn(name = "tp_faixa", referencedColumnName = "id_tp_faixa")
    @ManyToOne
    private TipoFaixa tpFaixa;
    @JoinColumn(name = "tp_calc_valor", referencedColumnName = "id_tp_calc_valor", nullable = false)
    @ManyToOne(optional = false)
    private TipoCalculoValor tpCalcValor;
    @JoinColumn(name = "frete_peso", referencedColumnName = "id_frete_peso")
    @ManyToOne
    private Peso fretePeso;
    @JoinColumn(name = "calculo", referencedColumnName = "id_calculo", nullable = false)
    @ManyToOne(optional = false)
    private Calculo calculo;

    public CalculoDetalhe() {
    }

    public CalculoDetalhe(Integer idCalculoDet) {
        this.idCalculoDet = idCalculoDet;
    }

    public CalculoDetalhe(Integer idCalculoDet, BigDecimal vlrVariavel, BigDecimal vlrResultado, String fgIncideIcms, String fgAutomatico, Date dtInst) {
        this.idCalculoDet = idCalculoDet;
        this.vlrVariavel = vlrVariavel;
        this.vlrResultado = vlrResultado;
        this.fgIncideIcms = fgIncideIcms;
        this.fgAutomatico = fgAutomatico;
        this.dtInst = dtInst;
    }

    public Integer getIdCalculoDet() {
        return idCalculoDet;
    }

    public void setIdCalculoDet(Integer idCalculoDet) {
        this.idCalculoDet = idCalculoDet;
    }

    public BigDecimal getVlrVariavel() {
        return vlrVariavel;
    }

    public void setVlrVariavel(BigDecimal vlrVariavel) {
        this.vlrVariavel = vlrVariavel;
    }

    public BigDecimal getVlrResultado() {
        return vlrResultado;
    }

    public void setVlrResultado(BigDecimal vlrResultado) {
        this.vlrResultado = vlrResultado;
    }

    public String getFgIncideIcms() {
        return fgIncideIcms;
    }

    public void setFgIncideIcms(String fgIncideIcms) {
        this.fgIncideIcms = fgIncideIcms;
    }

    public String getFgAutomatico() {
        return fgAutomatico;
    }

    public void setFgAutomatico(String fgAutomatico) {
        this.fgAutomatico = fgAutomatico;
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

    public Variavel getFreteVariavel() {
        return freteVariavel;
    }

    public void setFreteVariavel(Variavel freteVariavel) {
        this.freteVariavel = freteVariavel;
    }

    public TipoFaixa getTpFaixa() {
        return tpFaixa;
    }

    public void setTpFaixa(TipoFaixa tpFaixa) {
        this.tpFaixa = tpFaixa;
    }

    public TipoCalculoValor getTpCalcValor() {
        return tpCalcValor;
    }

    public void setTpCalcValor(TipoCalculoValor tpCalcValor) {
        this.tpCalcValor = tpCalcValor;
    }

    public Peso getFretePeso() {
        return fretePeso;
    }

    public void setFretePeso(Peso fretePeso) {
        this.fretePeso = fretePeso;
    }

    public Calculo getCalculo() {
        return calculo;
    }

    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalculoDet != null ? idCalculoDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalculoDetalhe)) {
            return false;
        }
        CalculoDetalhe other = (CalculoDetalhe) object;
        if ((this.idCalculoDet == null && other.idCalculoDet != null) || (this.idCalculoDet != null && !this.idCalculoDet.equals(other.idCalculoDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.CalculoDet[ idCalculoDet=" + idCalculoDet + " ]";
    }
    
}
