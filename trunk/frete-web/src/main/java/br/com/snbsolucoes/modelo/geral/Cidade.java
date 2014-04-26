
package br.com.snbsolucoes.modelo.geral;

import br.com.snbsolucoes.modelo.frete.OrigemDestino;
import br.com.snbsolucoes.modelo.frete.Peso;
import br.com.snbsolucoes.modelo.frete.TabelaTransportadoraValorVariavel;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cidade", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdCidade", query = "SELECT c FROM Cidade c WHERE c.idCidade = :idCidade"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cidade", nullable = false)
    private Integer idCidade;
    @Column(length = 120)
    private String nome;
    @OneToMany(mappedBy = "cidade")
    private List<Peso> fretePesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeOrig")
    private List<OrigemDestino> freteOrigDestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeDest")
    private List<OrigemDestino> freteOrigDestList1;
    @OneToMany(mappedBy = "cidade")
    private List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Peso> getFretePesoList() {
        return fretePesoList;
    }

    public void setFretePesoList(List<Peso> fretePesoList) {
        this.fretePesoList = fretePesoList;
    }

    @XmlTransient
    public List<OrigemDestino> getFreteOrigDestList() {
        return freteOrigDestList;
    }

    public void setFreteOrigDestList(List<OrigemDestino> freteOrigDestList) {
        this.freteOrigDestList = freteOrigDestList;
    }

    @XmlTransient
    public List<OrigemDestino> getFreteOrigDestList1() {
        return freteOrigDestList1;
    }

    public void setFreteOrigDestList1(List<OrigemDestino> freteOrigDestList1) {
        this.freteOrigDestList1 = freteOrigDestList1;
    }

    @XmlTransient
    public List<TabelaTransportadoraValorVariavel> getFreteTabTranspValorVarList() {
        return freteTabTranspValorVarList;
    }

    public void setFreteTabTranspValorVarList(List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList) {
        this.freteTabTranspValorVarList = freteTabTranspValorVarList;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.Cidade[ idCidade=" + idCidade + " ]";
    }
    
}
