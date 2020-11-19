package br.com.fiap.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class LoginFilter implements Filter {


    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		
		
		if (session.getAttribute("user") == null && !url.endsWith("login") && !url.contains("resources") && !url.contains("register")) {
			request.setAttribute("erro", "Entre com o usuário e senha!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
//			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}else {
			chain.doFilter(request, response);
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
