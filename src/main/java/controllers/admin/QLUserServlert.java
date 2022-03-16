package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.form_data.RegisterData;

@WebServlet({
	"/users/index",    // GET
	"/users/create",   // GET
	"/users/store",    // POST
	"/users/edit",     // GET
	"/users/update",   // POST
	"/users/delete",   // GET
})
public class QLUserServlert extends HttpServlet {
    public QLUserServlert() {
        super();
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
//			this.store(request, response);
		} else if (uri.contains("update")) {
//			this.update(request, response);
		}
	}
	
	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<RegisterData> ds = new ArrayList<RegisterData>();
		
		RegisterData o1 = new RegisterData("Ng Van A", 
			"HN", "a@gmail.com", "123456", "0123", 1, 0),
			o2 = new RegisterData("Ng Van B", "HN",
				"a@gmail.com", "123456", "0123", 1, 0),
			o3 = new RegisterData("Ng Thi C", "HN",
					"a@gmail.com", "123456", "0123", 0, 0);
		
		ds.add(o1);
		ds.add(o2);
		ds.add(o3);
		
		request.setAttribute("ds", ds);
		request.setAttribute("view",
			"/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		//
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
	) {
		//
	}
}
