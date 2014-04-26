package br.com.snbsolucoes.modelo.frete;

import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.modelo.geral.Transportadora;
import br.com.snbsolucoes.modelo.geral.EmpresaProp;
import br.com.snbsolucoes.modelo.geral.Cidade;
import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "frete_orig_dest", catalog = "frete", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"transportadora", "empresa_prop", "cidade_orig", "cidade_dest"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrigemDestino.findAll", query = "SELECT f FROM OrigemDestino f"),
    @NamedQuery(name = "OrigemDestino.findByIdOrigDest", query = "SELECT f FROM OrigemDestino f WHERE f.idOrigDest = :idOrigDest"),
    @NamedQuery(name = "OrigemDestino.findByKmTotal", query = "SELECT f FROM OrigemDestino f WHERE f.kmTotal = :kmTotal"),
    @NamedQuery(name = "OrigemDestino.findByDtInst", query = "SELECT f FROM OrigemDestino f WHERE f.dtInst = :dtInst")})
public class OrigemDestino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orig_dest", nullable = false)
    private Integer idOrigDest;
    @Basic(optional = false)
    @Column(name = "km_total", nullable = false)
    private int kmTotal;
    @Basic(optional = false)
    @Column(name = "dt_inst", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origDest")
    private List<Calculo> freteCalculoList;
    @JoinColumn(name = "empresa_prop", referencedColumnName = "id_empresa_prop")
    @ManyToOne
    private EmpresaProp empresaProp;
    @JoinColumn(name = "cidade_orig", referencedColumnName = "id_cidade", nullable = false)
    @ManyToOne(optional = false)
    private Cidade cidadeOrig;
    @JoinColumn(name = "cidade_dest", referencedColumnName = "id_cidade", nullable = false)
    @ManyToOne(optional = false)
    private Cidade cidadeDest;
    @JoinColumn(name = "transportadora", referencedColumnName = "id_filial")
    @ManyToOne
    private Transportadora transportadora;
    @JoinColumn(name = "usuario_inst", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioInst;

    public OrigemDestino() {
    }

    public OrigemDestino(Integer idOrigDest) {
        this.idOrigDest = idOrigDest;
    }

    public OrigemDestino(Integer idOrigDest, int kmTotal, Date dtInst) {
        this.idOrigDest = idOrigDest;
        this.kmTotal = kmTotal;
        this.dtInst = dtInst;
    }

    public Integer getIdOrigDest() {
        return idOrigDest;
    }

    public void setIdOrigDest(Integer idOrigDest) {
        this.idOrigDest = idOrigDest;
    }

    public int getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }

    public Date getDtInst() {
        return dtInst;
    }

    public void setDtInst(Date dtInst) {
        this.dtInst = dtInst;
    }

    @XmlTransient
    public List<Calculo> getFreteCalculoList() {
        return freteCalculoList;
    }

    public void setFreteCalculoList(List<Calculo> freteCalculoList) {
        this.freteCalculoList = freteCalculoList;
    }

    public EmpresaProp getEmpresaProp() {
        return empresaProp;
    }

    public void setEmpresaProp(EmpresaProp empresaProp) {
        this.empresaProp = empresaProp;
    }

    public Cidade getCidadeOrig() {
        return cidadeOrig;
    }

    public void setCidadeOrig(Cidade cidadeOrig) {
        this.cidadeOrig = cidadeOrig;
    }

    public Cidade getCidadeDest() {
        return cidadeDest;
    }

    public void setCidadeDest(Cidade cidadeDest) {
        this.cidadeDest = cidadeDest;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
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
        hash += (idOrigDest != null ? idOrigDest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrigemDestino)) {
            return false;
        }
        OrigemDestino other = (OrigemDestino) object;
        if ((this.idOrigDest == null && other.idOrigDest != null) || (this.idOrigDest != null && !this.idOrigDest.equals(other.idOrigDest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.OrigemDestino[ idOrigDest=" + idOrigDest + " ]";
    }
    
}
