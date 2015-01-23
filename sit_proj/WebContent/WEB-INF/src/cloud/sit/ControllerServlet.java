package cloud.sit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cloud.sit.Constants;
import cloud.sit.LoginBean;

import cloud.sit.Model;
import java.util.*;

public class ControllerServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Default constructor.
	 */
	public ControllerServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
			{
				process(request, response);
			}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
			{
				process(request, response);
			}

	protected void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
			{
		
				RequestDispatcher rd=null;
				try {
						String uri = request.getRequestURI();
						Model m = new Model();
						
						
						/*REDIRECTING REQUEST TO LOGIN PAGE*/
						
						if (uri.contains("openLoginView"))
						{
							rd = request.getRequestDispatcher("Login.jsp");
							rd.forward(request, response);
						}
						
						/*----------------------------------*/
						
						
						/*AUTHENTICATING USER AND ALLOWING INSIDE THE APPLICATION*/
						
						if (uri.contains("/login"))
						{
							LoginBean lb = (LoginBean) request.getAttribute("log");
							String result = m.authenticate(lb);

							if (result.equals(Constants.SUCCESS))
							{
								List res = m.getName(lb.getEmail());
								request.setAttribute("dataList",res);
								
								HttpSession session = request.getSession(true);
								session.setAttribute("s", lb);
								session.setAttribute("user", lb);
								request.setAttribute("hesaru",  res);
								System.out.println("Name of the Logged in user is : "+request.getAttribute("hesaru"));
								rd = request.getRequestDispatcher("StudentView.jsp");
								rd.forward(request, response);
							}
													
							else
							{
								request.setAttribute("errorMsg", result);
								rd = request.getRequestDispatcher("Login.jsp");
								rd.forward(request, response);
							}
						}
						
						/*----------------------------------------------------------*/
						
						
						
						
					}
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}

}
