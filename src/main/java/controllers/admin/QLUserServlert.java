package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.RegisterData;
import dao.UserDAO;
import entities.User;

@WebServlet({
	"/users/index",    // GET
	"/users/create",   // GET
	"/users/store",    // POST
	"/users/edit",     // GET
	"/users/update",   // POST
	"/users/delete",   // GET
})
public class QLUserServlert extends HttpServlet {
	private UserDAO userDAO;

    public QLUserServlert() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		}  else if (uri.contains("edit")) {
			this.edit(request, response);
		}  else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
//			this.update(request, response);
		}
	}
	
	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		
		request.setAttribute("ds", ds);
		request.setAttribute("view",
			"/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view",
			"/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		//
	}
	
	private void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		User entity = this.userDAO.findById(id);
		this.userDAO.delete(entity);

		response.sendRedirect("/SP22B2_SOF3011_IT16308/users/index");
	}

	private void store(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		try {
			User entity = new User();
			BeanUtils.populate(entity,
				request.getParameterMap());
			
			this.userDAO.create(entity);
			
			response.sendRedirect("/SP22B2_SOF3011_IT16308"
				+ "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
