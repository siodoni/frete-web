package br.com.snbsolucoes.mb;

import br.com.snbsolucoes.dao.DAOGenerico;
import br.com.snbsolucoes.modelo.frete.FamiliaProduto;
import br.com.snbsolucoes.modelo.geral.Usuario;
import br.com.snbsolucoes.util.Mensagem;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "login")
@ViewScoped
public class loginMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private DAOGenerico dao = new DAOGenerico();
    private Map<String, Long> parametros;
    private List<FamiliaProduto> lstFamiliaProduto;
    
    private String usuario ="", senha="";

    @SuppressWarnings("unchecked")
	public loginMB() {
        lstFamiliaProduto = dao.listarNamedQuery("FamiliaProduto.findAll", null);
    }

    public void logar() throws IOException{
        Usuario user;
        
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("aliasUsuario", usuario);
        param.put("senha", senha);

        user = (Usuario)dao.buscarNamedQuery("Usuario.findByUsuarioSenha",param);
        
        if(user != null && user.getIdUsuario() != null){
        	Mensagem.info("Logado!");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/frete/faces/welcomePrimefaces.xhtml");
        }
        
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
