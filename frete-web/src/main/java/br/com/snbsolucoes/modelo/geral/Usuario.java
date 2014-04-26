package br.com.snbsolucoes.modelo.geral;

import br.com.snbsolucoes.modelo.frete.Calculo;
import br.com.snbsolucoes.modelo.frete.CalculoDetalhe;
import br.com.snbsolucoes.modelo.frete.Controle;
import br.com.snbsolucoes.modelo.frete.OrigemDestino;
import br.com.snbsolucoes.modelo.frete.Peso;
import br.com.snbsolucoes.modelo.frete.TabelaEmpresa;
import br.com.snbsolucoes.modelo.frete.TabelaFilial;
import br.com.snbsolucoes.modelo.frete.TabelaTransportadora;
import br.com.snbsolucoes.modelo.frete.TabelaTransportadoraValorVariavel;
import br.com.snbsolucoes.modelo.frete.TabelaTransportadoraVariavel;
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
@Table(name = "usuario", catalog = "frete", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsuarioSenha", query = "SELECT u FROM Usuario u WHERE u.aliasUsuario = :aliasUsuario and u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByAliasUsuario", query = "SELECT u FROM Usuario u WHERE u.aliasUsuario = :aliasUsuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "alias_usuario", nullable = false, length = 20)
    private String aliasUsuario;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<TabelaTransportadoraVariavel> freteTabTranspVarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<Peso> fretePesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<CalculoDetalhe> freteCalculoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<TabelaEmpresa> freteTabEmpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<TabelaFilial> freteTabFilialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<Calculo> freteCalculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<Controle> freteControleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<OrigemDestino> freteOrigDestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<TabelaTransportadoraValorVariavel> freteTabTranspValorVarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInst")
    private List<TabelaTransportadora> freteTabTranspList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String aliasUsuario, String nome, String senha) {
        this.idUsuario = idUsuario;
        this.aliasUsuario = aliasUsuario;
        this.nome = nome;
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<TabelaTransportadoraVariavel> getFreteTabTranspVarList() {
        return freteTabTranspVarList;
    }

    public void setFreteTabTranspVarList(List<TabelaTransportadoraVariavel> freteTabTranspVarList) {
        this.freteTabTranspVarList = freteTabTranspVarList;
    }

    @XmlTransient
    public List<Peso> getFretePesoList() {
        return fretePesoList;
    }

    public void setFretePesoList(List<Peso> fretePesoList) {
        this.fretePesoList = fretePesoList;
    }

    @XmlTransient
    public List<CalculoDetalhe> getFreteCalculoDetList() {
        return freteCalculoDetList;
    }

    public void setFreteCalculoDetList(List<CalculoDetalhe> freteCalculoDetList) {
        this.freteCalculoDetList = freteCalculoDetList;
    }

    @XmlTransient
    public List<TabelaEmpresa> getFreteTabEmpList() {
        return freteTabEmpList;
    }

    public void setFreteTabEmpList(List<TabelaEmpresa> freteTabEmpList) {
        this.freteTabEmpList = freteTabEmpList;
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
    public List<Controle> getFreteControleList() {
        return freteControleList;
    }

    public void setFreteControleList(List<Controle> freteControleList) {
        this.freteControleList = freteControleList;
    }

    @XmlTransient
    public List<OrigemDestino> getFreteOrigDestList() {
        return freteOrigDestList;
    }

    public void setFreteOrigDestList(List<OrigemDestino> freteOrigDestList) {
        this.freteOrigDestList = freteOrigDestList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
