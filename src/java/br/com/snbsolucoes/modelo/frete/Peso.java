
package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Cidade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "amfrete_peso", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"frete_tab_transp", "cidade", "km_inicio", "peso_inicio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peso.findAll", query = "SELECT f FROM Peso f"),
    @NamedQuery(name = "Peso.findByIdPeso", query = "SELECT f FROM Peso f WHERE f.idFretePeso = :idFretePeso"),
    @NamedQuery(name = "Peso.findByKmInicio", query = "SELECT f FROM Peso f WHERE f.kmInicio = :kmInicio"),
    @NamedQuery(name = "Peso.findByKmFim", query = "SELECT f FROM Peso f WHERE f.kmFim = :kmFim"),
    @NamedQuery(name = "Peso.findByPesoInicio", query = "SELECT f FROM Peso f WHERE f.pesoInicio = :pesoInicio"),
    @NamedQuery(name = "Peso.findByPesoFim", query = "SELECT f FROM Peso f WHERE f.pesoFim = :pesoFim"),
    @NamedQuery(name = "Peso.findByVlrFrete", query = "SELECT f FROM Peso f WHERE f.vlrFrete = :vlrFrete"),
    @NamedQuery(name = "Peso.findByVlrKgExced", query = "SELECT f FROM Peso f WHERE f.vlrKgExced = :vlrKgExced"),
    @NamedQuery(name = "Peso.findByDtInst", query = "SELECT f FROM Peso f WHERE f.dtInst = :dtInst")})
public class Peso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frete_peso", nullable = false)
    private Integer idFretePeso;
    @Basic(optional = false)
    @Column(name = "km_inicio", nullable = false)
    private int kmInicio;
    @Basic(optional = false)
    @Column(name = "km_fim", nullable = false)
    private int kmFim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_inicio", precision = 16, scale = 4)
    private BigDecimal pesoInicio;
    @Column(name = "peso_fim", precision = 16, scale = 4)
    private BigDecimal pesoFim;
    @Basic(optional = false)
    @Column(name = "vlr_frete", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrFrete;
    @Basic(optional = false)
    @Column(name = "vlr_kg_exced", nullable = false, precision = 16, scale = 4)
    private BigDecimal vlrKgExced;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @JoinColumn(name = "cidade", referencedColumnName = "id_cidade")
    @ManyToOne
    private Cidade cidade;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;
    @JoinColumn(name = "frete_tab_transp", referencedColumnName = "id_frete_tab_transp", nullable = false)
    @ManyToOne(optional = false)
    private TabelaTransportadora freteTabTransp;
    @OneToMany(mappedBy = "fretePeso")
    private List<CalculoDetalhe> freteCalculoDetList;

    public Peso() {
    }

    public Peso(Integer idFretePeso) {
        this.idFretePeso = idFretePeso;
    }

    public Peso(Integer idFretePeso, int kmInicio, int kmFim, BigDecimal vlrFrete, BigDecimal vlrKgExced, Date dtInst) {
        this.idFretePeso = idFretePeso;
        this.kmInicio = kmInicio;
        this.kmFim = kmFim;
        this.vlrFrete = vlrFrete;
        this.vlrKgExced = vlrKgExced;
        this.dtInst = dtInst;
    }

    public Integer getIdFretePeso() {
        return idFretePeso;
    }

    public void setIdFretePeso(Integer idFretePeso) {
        this.idFretePeso = idFretePeso;
    }

    public int getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(int kmInicio) {
        this.kmInicio = kmInicio;
    }

    public int getKmFim() {
        return kmFim;
    }

    public void setKmFim(int kmFim) {
        this.kmFim = kmFim;
    }

    public BigDecimal getPesoInicio() {
        return pesoInicio;
    }

    public void setPesoInicio(BigDecimal pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    public BigDecimal getPesoFim() {
        return pesoFim;
    }

    public void setPesoFim(BigDecimal pesoFim) {
        this.pesoFim = pesoFim;
    }

    public BigDecimal getVlrFrete() {
        return vlrFrete;
    }

    public void setVlrFrete(BigDecimal vlrFrete) {
        this.vlrFrete = vlrFrete;
    }

    public BigDecimal getVlrKgExced() {
        return vlrKgExced;
    }

    public void setVlrKgExced(BigDecimal vlrKgExced) {
        this.vlrKgExced = vlrKgExced;
    }

    public Date getDtInst() {
        return dtInst;
    }

    public void setDtInst(Date dtInst) {
        this.dtInst = dtInst;
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

    public TabelaTransportadora getFreteTabTransp() {
        return freteTabTransp;
    }

    public void setFreteTabTransp(TabelaTransportadora freteTabTransp) {
        this.freteTabTransp = freteTabTransp;
    }

    @XmlTransient
    public List<CalculoDetalhe> getFreteCalculoDetList() {
        return freteCalculoDetList;
    }

    public void setFreteCalculoDetList(List<CalculoDetalhe> freteCalculoDetList) {
        this.freteCalculoDetList = freteCalculoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFretePeso != null ? idFretePeso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peso)) {
            return false;
        }
        Peso other = (Peso) object;
        if ((this.idFretePeso == null && other.idFretePeso != null) || (this.idFretePeso != null && !this.idFretePeso.equals(other.idFretePeso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.Peso[ idPeso=" + idFretePeso + " ]";
    }
    
}
