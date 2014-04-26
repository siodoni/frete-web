package br.com.snbsolucoes.modelo.geral;

import br.com.snbsolucoes.modelo.frete.Calculo;
import br.com.snbsolucoes.modelo.frete.OrigemDestino;
import br.com.snbsolucoes.modelo.frete.TabelaEmpresa;
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
@Table(name = "empresa_prop", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaProp.findAll", query = "SELECT e FROM EmpresaProp e"),
    @NamedQuery(name = "EmpresaProp.findByIdEmpresaProp", query = "SELECT e FROM EmpresaProp e WHERE e.idEmpresaProp = :idEmpresaProp")})
public class EmpresaProp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empresa_prop", nullable = false)
    private Integer idEmpresaProp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaProp")
    private List<TabelaEmpresa> freteTabEmpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaProp")
    private List<Calculo> freteCalculoList;
    @OneToMany(mappedBy = "empresaProp")
    private List<OrigemDestino> freteOrigDestList;

    public EmpresaProp() {
    }

    public EmpresaProp(Integer idEmpresaProp) {
        this.idEmpresaProp = idEmpresaProp;
    }

    public Integer getIdEmpresaProp() {
        return idEmpresaProp;
    }

    public void setIdEmpresaProp(Integer idEmpresaProp) {
        this.idEmpresaProp = idEmpresaProp;
    }

    @XmlTransient
    public List<TabelaEmpresa> getFreteTabEmpList() {
        return freteTabEmpList;
    }

    public void setFreteTabEmpList(List<TabelaEmpresa> freteTabEmpList) {
        this.freteTabEmpList = freteTabEmpList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaProp != null ? idEmpresaProp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaProp)) {
            return false;
        }
        EmpresaProp other = (EmpresaProp) object;
        if ((this.idEmpresaProp == null && other.idEmpresaProp != null) || (this.idEmpresaProp != null && !this.idEmpresaProp.equals(other.idEmpresaProp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.EmpresaProp[ idEmpresaProp=" + idEmpresaProp + " ]";
    }
    
}
