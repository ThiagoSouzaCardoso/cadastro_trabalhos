package br.com.fiap.mb;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@RequestScoped
@ManagedBean
public class LoginMB {
	
		private String login;
		private String senha;
		private Map<String, Object> sessionMap;
		
		public LoginMB() {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			sessionMap = externalContext.getSessionMap();
		}
		
		public String autenticar(){
			UsuarioDao dao = new UsuarioDao();
			Usuario usr = dao.autenticacao(login, senha);
			
			if (usr != null) {
				sessionMap.put("usuario_logado", usr);
				return "pages/template.jsf?faces-redirect=true";
			} else {
				return "login.jsf?faces-redirect=true";
			}
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

}
