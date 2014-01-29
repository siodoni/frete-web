package br.com.snbsolucoes.modelo.frete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TabelaTransportadoraVariavelPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "frete_tab_transp", nullable = false)
    private int freteTabTransp;
    @Basic(optional = false)
    @Column(name = "frete_variavel", nullable = false)
    private int freteVariavel;

    public TabelaTransportadoraVariavelPK() {
    }

    public TabelaTransportadoraVariavelPK(int freteTabTransp, int freteVariavel) {
        this.freteTabTransp = freteTabTransp;
        this.freteVariavel = freteVariavel;
    }

    public int getFreteTabTransp() {
        return freteTabTransp;
    }

    public void setFreteTabTransp(int freteTabTransp) {
        this.freteTabTransp = freteTabTransp;
    }

    public int getFreteVariavel() {
        return freteVariavel;
    }

    public void setFreteVariavel(int freteVariavel) {
        this.freteVariavel = freteVariavel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) freteTabTransp;
        hash += (int) freteVariavel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaTransportadoraVariavelPK)) {
            return false;
        }
        TabelaTransportadoraVariavelPK other = (TabelaTransportadoraVariavelPK) object;
        if (this.freteTabTransp != other.freteTabTransp) {
            return false;
        }
        if (this.freteVariavel != other.freteVariavel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.snbsolucoes.modelo.frete.TabelaTransportadoraVariavelPK[ freteTabTransp=" + freteTabTransp + ", freteVariavel=" + freteVariavel + " ]";
    }
    
}
