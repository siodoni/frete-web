package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Transportadora;
import br.com.snbsolucoes.modelo.geral.EmpresaProp;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "frete_calculo", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculo.findAll", query = "SELECT f FROM Calculo f"),
    @NamedQuery(name = "Calculo.findByIdCalculo", query = "SELECT f FROM Calculo f WHERE f.idCalculo = :idCalculo"),
    @NamedQuery(name = "Calculo.findByData", query = "SELECT f FROM Calculo f WHERE f.data = :data"),
    @NamedQuery(name = "Calculo.findByVlrNota", query = "SELECT f FROM Calculo f WHERE f.vlrNota = :vlrNota"),
    @NamedQuery(name = "Calculo.findByDistancia", query = "SELECT f FROM Calculo f WHERE f.distancia = :distancia"),
    @NamedQuery(name = "Calculo.findByPeso", query = "SELECT f FROM Calculo f WHERE f.peso = :peso"),
    @NamedQuery(name = "Calculo.findByPercIcms", query = "SELECT f FROM Calculo f WHERE f.percIcms = :percIcms"),
    @NamedQuery(name = "Calculo.findByDtInst", query = "SELECT f FROM Calculo f WHERE f.dtInst = :dtInst")})
public class Calculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calculo", nullable = false)
    private Integer idCalculo;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vlr_nota", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrNota;
    @Basic(optional = false)
    @Column(nullable = false, precision = 16, scale = 4)
    private BigDecimal distancia;
    @Basic(optional = false)
    @Column(nullable = false, precision = 16, scale = 4)
    private BigDecimal peso;
    @Basic(optional = false)
    @Column(name = "perc_icms", nullable = false, precision = 16, scale = 4)
    private BigDecimal percIcms;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calculo")
    private List<CalculoDetalhe> freteCalculoDetList;
    @JoinColumn(name = "empresa_prop", referencedColumnName = "id_empresa_prop", nullable = false)
    @ManyToOne(optional = false)
    private EmpresaProp empresaProp;
    @JoinColumn(name = "orig_dest", referencedColumnName = "id_orig_dest", nullable = false)
    @ManyToOne(optional = false)
    private OrigemDestino origDest;
    @JoinColumn(name = "transportadora", referencedColumnName = "id_filial", nullable = false)
    @ManyToOne(optional = false)
    private Transportadora transportadora;
    @JoinColumn(name = "familia_produto", referencedColumnName = "id_familia_produto", nullable = false)
    @ManyToOne(optional = false)
    private FamiliaProduto familiaProduto;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;

    public Calculo() {
    }

    public Calculo(Integer idCalculo) {
        this.idCalculo = idCalculo;
    }

    public Calculo(Integer idCalculo, Date data, BigDecimal vlrNota, BigDecimal distancia, BigDecimal peso, BigDecimal percIcms, Date dtInst) {
        this.idCalculo = idCalculo;
        this.data = data;
        this.vlrNota = vlrNota;
        this.distancia = distancia;
        this.peso = peso;
        this.percIcms = percIcms;
        this.dtInst = dtInst;
    }

    public Integer getIdCalculo() {
        return idCalculo;
    }

    public void setIdCalculo(Integer idCalculo) {
        this.idCalculo = idCalculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getVlrNota() {
        return vlrNota;
    }

    public void setVlrNota(BigDecimal vlrNota) {
        this.vlrNota = vlrNota;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getPercIcms() {
        return percIcms;
    }

    public void setPercIcms(BigDecimal percIcms) {
        this.percIcms = percIcms;
    }

    public Date getDtInst() {
        return dtInst;
    }

    public void setDtInst(Date dtInst) {
        this.dtInst = dtInst;
    }

    @XmlTransient
    public List<CalculoDetalhe> getFreteCalculoDetList() {
        return freteCalculoDetList;
    }

    public void setFreteCalculoDetList(List<CalculoDetalhe> freteCalculoDetList) {
        this.freteCalculoDetList = freteCalculoDetList;
    }

    public EmpresaProp getEmpresaProp() {
        return empresaProp;
    }

    public void setEmpresaProp(EmpresaProp empresaProp) {
        this.empresaProp = empresaProp;
    }

    public OrigemDestino getOrigDest() {
        return origDest;
    }

    public void setOrigDest(OrigemDestino origDest) {
        this.origDest = origDest;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public FamiliaProduto getFamiliaProduto() {
        return familiaProduto;
    }

    public void setFamiliaProduto(FamiliaProduto familiaProduto) {
        this.familiaProduto = familiaProduto;
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
        hash += (idCalculo != null ? idCalculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculo)) {
            return false;
        }
        Calculo other = (Calculo) object;
        if ((this.idCalculo == null && other.idCalculo != null) || (this.idCalculo != null && !this.idCalculo.equals(other.idCalculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteCalculo[ idCalculo=" + idCalculo + " ]";
    }
    
}
