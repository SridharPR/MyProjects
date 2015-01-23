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

public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;
		RequestDispatcher rd1, rd2;
		try {
			String uri = request.getRequestURI();
			Model m = new Model();

			/*REDIRECTING REQUEST TO LOGIN PAGE*/

			if (uri.contains("openLoginView")) {
				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

			/*----------------------------------*/
			/*AUTHENTICATING USER AND ALLOWING INSIDE THE APPLICATION*/

			if (uri.contains("/login")) {
				LoginBean lb = (LoginBean) request.getAttribute("log");
				String result = m.authenticate(lb);
				System.out.println("SSN is :" + lb.getEmail());

				if (result.equals(Constants.SUCCESS)) {
					String nh = m.getUserName(lb.getEmail());
					request.setAttribute("nannahesaru", nh);

					List res = m.getName(lb.getEmail());
					request.setAttribute("dataList", res);

					HttpSession session = request.getSession(true);
					session.setAttribute("s", lb);
					session.setAttribute("user", lb);
					request.setAttribute("hesaru", res);
					System.out.println("Name of the Logged in user is : "
							+ request.getAttribute("hesaru"));
					rd = request.getRequestDispatcher("StudentView.jsp");
					rd.forward(request, response);
				} else {
					if ((lb.getEmail().toString().equalsIgnoreCase("hod"))
							&& (lb.getPass().toString().equalsIgnoreCase("hod"))) {
						System.out.println("Inside of Hod Login....");
						rd1 = request.getRequestDispatcher("HodView.jsp");
						rd1.forward(request, response);
					} else {
						//String sb="Neenu Authenticated User alla....";
						request.setAttribute("errorMsg", result);
						rd = request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}
				}
			}
			/*----------------------------------------------------------*/
			/*------------REDIRECTING TO STUDENT ADD VIEW PAGE------------*/
			if (uri.contains("openStudentAddView")) {
				rd1 = request.getRequestDispatcher("StudentAdd.jsp");
				rd1.forward(request, response);
			}
			/*----------------------------------------------------------*/
			/*------------ADDING NEW STUDENT BY ADMIN------------------*/
			if (uri.contains("/register")) {
				RegBean rb = (RegBean) request.getAttribute("reg");
				String result = m.insert(rb);

				if (result.equals(Constants.SUCCESS)) {
					rd1 = request.getRequestDispatcher("HodView.jsp");
					rd1.forward(request, response);
				} else {
					request.setAttribute("job1", result);
					rd1 = request.getRequestDispatcher("HodView.jsp");
					rd1.forward(request, response);
				}
			}
			/*----------------------------------------------------------*/
			/*------------REDIRECTING TO STUDENT DELETE VIEW PAGE------------*/
			if (uri.contains("openStudentDeleteView")) {
				ArrayList<String> snbl = (ArrayList<String>) m
						.loadstudentname();
				System.out.println("Array list inside controller is : " + snbl);
				if ((snbl.size()) > 0) {
					request.setAttribute("stud_names_list", snbl);
					System.out
							.println("inside request transfer to delete view ( before )...");
					rd1 = request.getRequestDispatcher("StudentDelete.jsp");
					rd1.forward(request, response);
					System.out
							.println("inside request transfer to deelte view ( after )...");
				} else {
					String ms = "No Student Details Found...!!";
					request.setAttribute("error", ms);
					rd = request.getRequestDispatcher("HodView.jsp");
					rd.forward(request, response);
				}
			}
			/*----------------------------------------------------------*/
			/*-------------------DELETE STUDENT DETAILS-----------------*/
			if (uri.contains("/Load")) {
				System.out
						.println("Inside of Loading Student Details to be deleted..");
				String str = request.getParameter("studname");
				request.setAttribute("bbname", str);
				System.out.println("Student name to be passed to Model is : "
						+ str);
				String result = m.delete(str);
				if (result.equals(Constants.SUCCESS)) {
					String s1 = "Successfully deleted....";
					request.setAttribute("sucessdelete", s1);
					rd1 = request.getRequestDispatcher("HodView.jsp");
					rd1.forward(request, response);
				} else {
					String s2 = "Error while deleting Student Details";
					request.setAttribute("failuredelete", s2);

					rd1 = request.getRequestDispatcher("HodView.jsp");
					rd1.forward(request, response);
				}
			}
			/*----------------------------------------------------------*/
			/*------------REDIRECTING TO MARKSUPLOAD PAGE---------------*/
			if (uri.contains("openStudentUploadView")) {
				String str = request.getParameter("studname");

				ArrayList<String> snbl = (ArrayList<String>) m
						.loadstudentname();
				System.out.println("Array list inside controller is : " + snbl);
				if ((snbl.size()) > 0) {
					request.setAttribute("stud_names_list", snbl);
					System.out
							.println("inside request transfer to delete view ( before )...");
					rd1 = request.getRequestDispatcher("MarksUpload.jsp");
					rd1.forward(request, response);
					System.out
							.println("inside request transfer to deelte view ( after )...");
				} else {
					String ms = "No Student Details Found...!!";
					request.setAttribute("error", ms);
					rd = request.getRequestDispatcher("HodView.jsp");
					rd.forward(request, response);
				}
			}
			/*----------------------------------------------------------*/
			/*-----------------UPLOADING MARKS INTO DB----------------*/
			if (uri.contains("/UpLoad")) {
				String m1;
				MarksBean mb = (MarksBean) request.getAttribute("up");

				String s = request.getParameter("sname");

				String correctname = m.getUserName(s);
				String errorname = mb.getInputname();

				System.out.println("/*--------------------------*/");
				System.out.println("The Errorname is :" + errorname);
				System.out.println("The Errorname is :" + correctname);
				System.out.println("/*--------------------------*/");
				if (errorname.equals(correctname)) {
					System.out
							.println("Inside the upload of marks of Controller Servlet and Student name is : "
									+ s);
					System.out.println("--------------------" + mb.getMarks1());
					String result = m.automataupload(s, mb);
					if (result.equals(Constants.SUCCESS)) {
						String b1 = "Uploaded Successfully.....";
						request.setAttribute("uploadsuccess", b1);
						rd1 = request.getRequestDispatcher("HodView.jsp");
						rd1.forward(request, response);
					} else {
						String b2 = "Error While Uploading.....";
						request.setAttribute("uploadfailure", b2);
						rd1 = request.getRequestDispatcher("HodView.jsp");
						rd1.forward(request, response);
					}
				} else {
					/*----------CREATING ERROR LOG FILE----------*/
					String ms = m.errorLog(errorname, correctname);
					/*------------------------------------------*/
					String correctQuery = "update registration set marks=?,marks=?,marks3=?,marks4=?,marks5=? where name=correctname";
					String str1 = correctQuery;

					if (ms.equals(Constants.SUCCESS)) {
						ArrayList<String> snbl = (ArrayList<String>) m
								.loadstudentname();

						String sb = "The Name " + errorname + " is Wrong ";
						String bs = "The Correct Name is :-----> "
								+ correctname;

						request.setAttribute("en", sb);
						request.setAttribute("cn", bs);
						request.setAttribute("stud_names_list", snbl);

						rd2 = request.getRequestDispatcher("MarksUpload.jsp");
						rd2.forward(request, response);
					}
				}
			}
			/*----------------------------------------------------------*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
