package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.RegisterData;
import dao.UserDAO;
import entities.User;
import utils.EncryptUtil;

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
			this.update(request, response);
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
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
			// TODO: Thông báo thành công
		} catch (Exception e) {
			// TODO: Thông báo lỗi
			e.printStackTrace();
		}

		response.sendRedirect("/SP22B2_SOF3011_IT16308/users/index");
	}

	private void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity,
				request.getParameterMap());
			
			String encrypted = EncryptUtil.encrypt(
				request.getParameter("password")
			);
			
			entity.setPassword(encrypted);
			this.userDAO.create(entity);
			session.setAttribute("message", 
				"Thêm mới thành công");
			response.sendRedirect("/SP22B2_SOF3011_IT16308"
				+ "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", 
					"Thêm mới thất bại");
			response.sendRedirect("/SP22B2_SOF3011_IT16308"
				+ "/users/create");
		}
	}
	
	private void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity,
				request.getParameterMap());

			User oldUser = this.userDAO.findById(entity.getId());
			entity.setPassword(oldUser.getPassword());
			this.userDAO.update(entity);
			response.sendRedirect("/SP22B2_SOF3011_IT16308/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			String id = request.getParameter("id");
			response.sendRedirect("/SP22B2_SOF3011_IT16308/users/edit?id=" + id);
		}
	}
}
