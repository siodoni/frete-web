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
@Table(name = "amfrete_familia_produto", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"descricao"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliaProduto.findAll", query = "SELECT f FROM FamiliaProduto f ORDER BY f.idFamiliaProduto"),
    @NamedQuery(name = "FamiliaProduto.findByIdFamiliaProduto", query = "SELECT f FROM FamiliaProduto f WHERE f.idFamiliaProduto = :idFamiliaProduto"),
    @NamedQuery(name = "FamiliaProduto.findByDescricao", query = "SELECT f FROM FamiliaProduto f WHERE f.descricao = :descricao")})
public class FamiliaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_familia_produto", nullable = false)
    private Integer idFamiliaProduto;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaProduto")
    private List<Calculo> freteCalculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaProduto")
    private List<TabelaTransportadora> freteTabTranspList;

    public FamiliaProduto() {
    }

    public FamiliaProduto(Integer idFamiliaProduto) {
        this.idFamiliaProduto = idFamiliaProduto;
    }

    public FamiliaProduto(Integer idFamiliaProduto, String descricao) {
        this.idFamiliaProduto = idFamiliaProduto;
        this.descricao = descricao;
    }

    public Integer getIdFamiliaProduto() {
        return idFamiliaProduto;
    }

    public void setIdFamiliaProduto(Integer idFamiliaProduto) {
        this.idFamiliaProduto = idFamiliaProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Calculo> getFreteCalculoList() {
        return freteCalculoList;
    }

    public void setFreteCalculoList(List<Calculo> freteCalculoList) {
        this.freteCalculoList = freteCalculoList;
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
        hash += (idFamiliaProduto != null ? idFamiliaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliaProduto)) {
            return false;
        }
        FamiliaProduto other = (FamiliaProduto) object;
        if ((this.idFamiliaProduto == null && other.idFamiliaProduto != null) || (this.idFamiliaProduto != null && !this.idFamiliaProduto.equals(other.idFamiliaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FamiliaProduto[ idFamiliaProduto=" + idFamiliaProduto + " ]";
    }
    
}
