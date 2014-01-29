package br.com.snbsolucoes.modelo.frete;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "amfrete_tp_calc_valor", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dsc_tp_calc_valor"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCalculoValor.findAll", query = "SELECT f FROM TipoCalculoValor f"),
    @NamedQuery(name = "TipoCalculoValor.findByIdTpCalcValor", query = "SELECT f FROM TipoCalculoValor f WHERE f.idTpCalcValor = :idTpCalcValor"),
    @NamedQuery(name = "TipoCalculoValor.findByDscTpCalcValor", query = "SELECT f FROM TipoCalculoValor f WHERE f.dscTpCalcValor = :dscTpCalcValor")})
public class TipoCalculoValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tp_calc_valor", nullable = false)
    private Integer idTpCalcValor;
    @Basic(optional = false)
    @Column(name = "dsc_tp_calc_valor", nullable = false, length = 100)
    private String dscTpCalcValor;
    @OneToMany(mappedBy = "tpCalcValor")
    private List<TabelaTransportadoraVariavel> freteTabTranspVarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpCalcValor")
    private List<CalculoDetalhe> freteCalculoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpCalcValor")
    private List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpCalcVlrFrete")
    private List<TabelaTransportadora> freteTabTranspList;
    @OneToMany(mappedBy = "tpCalcVlrKgExced")
    private List<TabelaTransportadora> freteTabTranspList1;

    public TipoCalculoValor() {
    }

    public TipoCalculoValor(Integer idTpCalcValor) {
        this.idTpCalcValor = idTpCalcValor;
    }

    public TipoCalculoValor(Integer idTpCalcValor, String dscTpCalcValor) {
        this.idTpCalcValor = idTpCalcValor;
        this.dscTpCalcValor = dscTpCalcValor;
    }

    public Integer getIdTpCalcValor() {
        return idTpCalcValor;
    }

    public void setIdTpCalcValor(Integer idTpCalcValor) {
        this.idTpCalcValor = idTpCalcValor;
    }

    public String getDscTpCalcValor() {
        return dscTpCalcValor;
    }

    public void setDscTpCalcValor(String dscTpCalcValor) {
        this.dscTpCalcValor = dscTpCalcValor;
    }

    @XmlTransient
    public List<TabelaTransportadoraVariavel> getFreteTabTranspVarList() {
        return freteTabTranspVarList;
    }

    public void setFreteTabTranspVarList(List<TabelaTransportadoraVariavel> freteTabTranspVarList) {
        this.freteTabTranspVarList = freteTabTranspVarList;
    }

    @XmlTransient
    public List<CalculoDetalhe> getFreteCalculoDetList() {
        return freteCalculoDetList;
    }

    public void setFreteCalculoDetList(List<CalculoDetalhe> freteCalculoDetList) {
        this.freteCalculoDetList = freteCalculoDetList;
    }

    @XmlTransient
    public List<TabelaTransportadoraValorVariavel> getFreteTabTranspValorVarList() {
        return freteTabTranspValorVarList;
    }

    public void setFreteTabTranspValorVarList(List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList) {
        this.freteTabTranspValorVarList = freteTabTranspValorVarList;
    }

    @XmlTransient
    public List<TabelaTransportadora> getFreteTabTranspList() {
        return freteTabTranspList;
    }

    public void setFreteTabTranspList(List<TabelaTransportadora> freteTabTranspList) {
        this.freteTabTranspList = freteTabTranspList;
    }

    @XmlTransient
    public List<TabelaTransportadora> getFreteTabTranspList1() {
        return freteTabTranspList1;
    }

    public void setFreteTabTranspList1(List<TabelaTransportadora> freteTabTranspList1) {
        this.freteTabTranspList1 = freteTabTranspList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTpCalcValor != null ? idTpCalcValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCalculoValor)) {
            return false;
        }
        TipoCalculoValor other = (TipoCalculoValor) object;
        if ((this.idTpCalcValor == null && other.idTpCalcValor != null) || (this.idTpCalcValor != null && !this.idTpCalcValor.equals(other.idTpCalcValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTpCalcValor[ idTpCalcValor=" + idTpCalcValor + " ]";
    }
    
}
