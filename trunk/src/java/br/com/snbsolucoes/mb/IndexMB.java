package br.com.snbsolucoes.mb;

import br.com.snbsolucoes.dao.DAOGenerico;
import br.com.snbsolucoes.modelo.frete.FamiliaProduto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "index")
@ViewScoped
public class IndexMB implements Serializable {
    
    private DAOGenerico dao = new DAOGenerico();
    private Map<String, Long> parametros;
    private List<FamiliaProduto> lstFamiliaProduto;
    
    private String usuario ="", senha="";

    public IndexMB() {
        lstFamiliaProduto = dao.buscarNamedQuery("FamiliaProduto.findAll", null);
    }

    public void logar(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("aliasUsuario", usuario);
        param.put("senha", senha);

        dao.buscarNamedQuery("Usuario.findByUsuarioSenha", param);
        
        System.out.println("AQUI !!!");
    }

    public String getUsuario() {
        return usuario;
    }    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }    

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Map<String, Long> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, Long> parametros) {
        this.parametros = parametros;
    }

    public DAOGenerico getDao() {
        return dao;
    }

    public void setLstFamiliaProduto(List<FamiliaProduto> lstFamiliaProduto) {
        this.lstFamiliaProduto = lstFamiliaProduto;
    }   

    public List<FamiliaProduto> getLstFamiliaProduto() {
        return lstFamiliaProduto;
    }
}
