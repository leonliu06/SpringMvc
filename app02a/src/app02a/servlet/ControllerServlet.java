package app02a.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import app02a.domain.Product;
import app02a.form.ProductForm;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input", "/product_save" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1579L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		/*
		 * uri is in this form: /contextName/resourceName, for example: /app10a/product_input.
		 * However, in the event of a default context, the context name is empty, and uri has this form 
		 * /resourceName, e.g.: /product_input
		 * */
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		// execute an action
		if(action.equals("product_input")){
			// no action class, there is nothing to be done
		}else if(action.equals("product_save")){
			// create form
			ProductForm productForm = new ProductForm();
			// populate action properties
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));
			// create model
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			try{
				product.setPrice(Float.parseFloat(productForm.getPrice()));
			}catch(NumberFormatException e){
				
			}
			// Code to save product
			
			// store model in a scope variable for the view
			request.setAttribute("product", product);
		}
		
		// forward to view
		String dispatchUrl = null;
		if(action.equals("product_input")){
			dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
		}else if(action.equals("product_save")){
			dispatchUrl = "WEB-INF/jsp/ProductDetails.jsp";
		}
		if(dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
