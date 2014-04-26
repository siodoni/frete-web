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
@Table(name = "frete_variavel", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"descricao"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variavel.findAll", query = "SELECT f FROM Variavel f"),
    @NamedQuery(name = "Variavel.findByIdFreteVariavel", query = "SELECT f FROM Variavel f WHERE f.idFreteVariavel = :idFreteVariavel"),
    @NamedQuery(name = "Variavel.findByDescricao", query = "SELECT f FROM Variavel f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "Variavel.findByOrdemApresent", query = "SELECT f FROM Variavel f WHERE f.ordemApresent = :ordemApresent"),
    @NamedQuery(name = "Variavel.findByFgIncideIcms", query = "SELECT f FROM Variavel f WHERE f.fgIncideIcms = :fgIncideIcms")})
public class Variavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frete_variavel", nullable = false)
    private Integer idFreteVariavel;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "ordem_apresent", nullable = false)
    private int ordemApresent;
    @Basic(optional = false)
    @Column(name = "fg_incide_icms", nullable = false, length = 1)
    private String fgIncideIcms;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freteVariavel1")
    private List<TabelaTransportadoraVariavel> freteTabTranspVarList;
    @OneToMany(mappedBy = "freteVariavel")
    private List<CalculoDetalhe> freteCalculoDetList;

    public Variavel() {
    }

    public Variavel(Integer idFreteVariavel) {
        this.idFreteVariavel = idFreteVariavel;
    }

    public Variavel(Integer idFreteVariavel, String descricao, int ordemApresent, String fgIncideIcms) {
        this.idFreteVariavel = idFreteVariavel;
        this.descricao = descricao;
        this.ordemApresent = ordemApresent;
        this.fgIncideIcms = fgIncideIcms;
    }

    public Integer getIdFreteVariavel() {
        return idFreteVariavel;
    }

    public void setIdFreteVariavel(Integer idFreteVariavel) {
        this.idFreteVariavel = idFreteVariavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemApresent() {
        return ordemApresent;
    }

    public void setOrdemApresent(int ordemApresent) {
        this.ordemApresent = ordemApresent;
    }

    public String getFgIncideIcms() {
        return fgIncideIcms;
    }

    public void setFgIncideIcms(String fgIncideIcms) {
        this.fgIncideIcms = fgIncideIcms;
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
        hash += (idFreteVariavel != null ? idFreteVariavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variavel)) {
            return false;
        }
        Variavel other = (Variavel) object;
        if ((this.idFreteVariavel == null && other.idFreteVariavel != null) || (this.idFreteVariavel != null && !this.idFreteVariavel.equals(other.idFreteVariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.FreteVariavel[ idFreteVariavel=" + idFreteVariavel + " ]";
    }
    
}
