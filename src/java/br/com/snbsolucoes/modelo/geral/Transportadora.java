package br.com.snbsolucoes.modelo.geral;

import br.com.snbsolucoes.modelo.frete.Calculo;
import br.com.snbsolucoes.modelo.frete.OrigemDestino;
import br.com.snbsolucoes.modelo.frete.TabelaFilial;
import br.com.snbsolucoes.modelo.frete.TabelaTransportadora;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "fttransportadora", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportadora.findAll", query = "SELECT t FROM Transportadora t"),
    @NamedQuery(name = "Transportadora.findByIdFilial", query = "SELECT t FROM Transportadora t WHERE t.idFilial = :idFilial")})
public class Transportadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_filial", nullable = false)
    private Integer idFilial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filial")
    private List<TabelaFilial> freteTabFilialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadora")
    private List<Calculo> freteCalculoList;
    @OneToMany(mappedBy = "transportadora")
    private List<OrigemDestino> freteOrigDestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadora")
    private List<TabelaTransportadora> freteTabTranspList;

    public Transportadora() {
    }

    public Transportadora(Integer idFilial) {
        this.idFilial = idFilial;
    }

    public Integer getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(Integer idFilial) {
        this.idFilial = idFilial;
    }

    @XmlTransient
    public List<TabelaFilial> getFreteTabFilialList() {
        return freteTabFilialList;
    }

    public void setFreteTabFilialList(List<TabelaFilial> freteTabFilialList) {
        this.freteTabFilialList = freteTabFilialList;
    }

    @XmlTransient
    public List<Calculo> getFreteCalculoList() {
        return freteCalculoList;
    }

    public void setFreteCalculoList(List<Calculo> freteCalculoList) {
        this.freteCalculoList = freteCalculoList;
    }

    @XmlTransient
    public List<OrigemDestino> getFreteOrigDestList() {
        return freteOrigDestList;
    }

    public void setFreteOrigDestList(List<OrigemDestino> freteOrigDestList) {
        this.freteOrigDestList = freteOrigDestList;
    }

    @XmlTransient
    public List<TabelaTransportadora> getFreteTabTranspList() {
        return freteTabTranspList;
    }

    public void setFreteTabTranspList(List<TabelaTransportadora> freteTabTranspList) {
        this.freteTabTranspList = freteTabTranspList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFilial != null ? idFilial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) object;
        if ((this.idFilial == null && other.idFilial != null) || (this.idFilial != null && !this.idFilial.equals(other.idFilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.Transportadora[ idFilial=" + idFilial + " ]";
    }
    
}
