package br.com.fiap.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.model.Usuario;

@ManagedBean
@SessionScoped
public class SessionMB {

	private Usuario usuarioLogado;

	public boolean isAluno() {
		return usuarioLogado.isAluno();
	}

	public boolean isProfessor() {
		return usuarioLogado.isProfessor();
	}

	public boolean isAdmin() {
		return usuarioLogado.isAdmin();
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
}
