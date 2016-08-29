package br.com.fiap.mb;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginMB {

	private String login;
	private String senha;
	private Map<String, Object> sessionMap;
	private Usuario usuarioLogado;

	public LoginMB() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		sessionMap = externalContext.getSessionMap();
	}

	public String autenticar() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		sessionMap = externalContext.getSessionMap();
		UsuarioDao dao = new UsuarioDao();
		Usuario usr = dao.autenticacao(login, senha);

		if (usr != null) {
			sessionMap.put("usuario_logado", usr);
			usuarioLogado = usr;
			return "pages/template.jsf?faces-redirect=true";
		} else {
			return "login.jsf?faces-redirect=true";
		}
	}

	public String cadastrar() {
		return "cadastroUsuario.jsf?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void logout() {
		try{
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    ec.invalidateSession();
		    ec.redirect("../login.jsf");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isAluno() {
		return usuarioLogado.isAluno();
	}

	public boolean isProfessor() {
		return usuarioLogado.isProfessor();
	}

	public boolean isAdmin() {
		return usuarioLogado.isAdmin();
	}

}
