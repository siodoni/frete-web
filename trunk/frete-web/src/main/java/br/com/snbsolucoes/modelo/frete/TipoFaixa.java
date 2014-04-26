package br.com.snbsolucoes.modelo.frete;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "frete_tp_faixa", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dsc_tp_faixa"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFaixa.findAll", query = "SELECT f FROM TipoFaixa f"),
    @NamedQuery(name = "TipoFaixa.findByIdTpFaixa", query = "SELECT f FROM TipoFaixa f WHERE f.idTpFaixa = :idTpFaixa"),
    @NamedQuery(name = "TipoFaixa.findByDscTpFaixa", query = "SELECT f FROM TipoFaixa f WHERE f.dscTpFaixa = :dscTpFaixa")})
public class TipoFaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tp_faixa", nullable = false)
    private Integer idTpFaixa;
    @Basic(optional = false)
    @Column(name = "dsc_tp_faixa", nullable = false, length = 20)
    private String dscTpFaixa;
    @OneToMany(mappedBy = "tpFaixa")
    private List<TabelaTransportadoraVariavel> freteTabTranspVarList;
    @OneToMany(mappedBy = "tpFaixa")
    private List<CalculoDetalhe> freteCalculoDetList;

    public TipoFaixa() {
    }

    public TipoFaixa(Integer idTpFaixa) {
        this.idTpFaixa = idTpFaixa;
    }

    public TipoFaixa(Integer idTpFaixa, String dscTpFaixa) {
        this.idTpFaixa = idTpFaixa;
        this.dscTpFaixa = dscTpFaixa;
    }

    public Integer getIdTpFaixa() {
        return idTpFaixa;
    }

    public void setIdTpFaixa(Integer idTpFaixa) {
        this.idTpFaixa = idTpFaixa;
    }

    public String getDscTpFaixa() {
        return dscTpFaixa;
    }

    public void setDscTpFaixa(String dscTpFaixa) {
        this.dscTpFaixa = dscTpFaixa;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTpFaixa != null ? idTpFaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFaixa)) {
            return false;
        }
        TipoFaixa other = (TipoFaixa) object;
        if ((this.idTpFaixa == null && other.idTpFaixa != null) || (this.idTpFaixa != null && !this.idTpFaixa.equals(other.idTpFaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteTpFaixa[ idTpFaixa=" + idTpFaixa + " ]";
    }
    
}
