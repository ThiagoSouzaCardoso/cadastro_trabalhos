package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Permissao;
import br.com.fiap.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {

	private Usuario usuario;
	
	public UsuarioMB() {
		usuario = new Usuario();
	}
	
	public String gravar() {		
		new UsuarioDao().adicionar(this.usuario);
		this.usuario = new Usuario();
		return "login.jsf";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	 public Permissao[] getPermissoes(){
	        return Permissao.values();
	 }
	
}
