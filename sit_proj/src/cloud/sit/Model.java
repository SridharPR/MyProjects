package cloud.sit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cloud.sit.Constants;

import cloud.sit.JDBCHelper;
import java.util.*;

import cloud.sit.LoginBean;

public class Model {

	int sl;

	/*---------AUTHENTICATION OF USER----------*/
	public String authenticate(LoginBean lb) {
		// TODO Auto-generated method stub
		String msg1 = "";
		msg1 = lb.validate();

		if (msg1.equals(Constants.SUCCESS)) {
			Connection con = null;
			PreparedStatement ps1 = null, ps2 = null, ps3 = null, ps4 = null;
			ResultSet rs1 = null, rs2 = null, rs3 = null;
			String str1 = "";
			String str2 = "";
			String str3 = "";

			try {
				con = JDBCHelper.getConnection();
				System.out.println("con=" + con);
				if (con == null) {
					msg1 = "<h5> Problem while establishing connection to Database . . ! ! Contact Admin.( Inside of authenticating username and password) </h5> ";
				} else {
					System.out
							.println(con
									+ " \n Database Connection Established Successfully... ");
					str1 = "select * from users where email=? and password=?";

					ps1 = con.prepareStatement(str1);
					ps1.setString(1, lb.getEmail());
					ps1.setString(2, lb.getPass());
					ps1.execute();

					rs1 = ps1.getResultSet();
					if (rs1.next()) {
						sl = rs1.getInt("sl_no");
						msg1 = Constants.SUCCESS;
					} else {
						System.out.println("");
						str2 = "select * from users where email=? or password=?";
						ps2 = con.prepareStatement(str2);
						ps2.setString(1, lb.getEmail());
						ps2.setString(2, lb.getPass());
						ps2.execute();

						rs2 = ps2.getResultSet();
						if (rs2.next()) {
							msg1 = " <h5> Invalid Username or Password . . . ! ! </h5> ";
						} else {
							msg1 = " <h5> You are not an Authenticated user . . . ! ! </h5> ";
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				JDBCHelper.close(ps1);
				JDBCHelper.close(ps2);
				JDBCHelper.close(rs1);
				JDBCHelper.close(rs2);
				JDBCHelper.close(con);
			}
			return msg1;
		} else
			return msg1;
	}

	/*------------------------------------------------*/
	/*--------- GETTING USER INFORMATION FROM DATABASE ----------*/
	public String getUserName(String str) {
		String msg = "";
		String str1 = "";
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		try {
			con = JDBCHelper.getConnection();
			if (con == null) {
				msg = " <h5> Pbm while establishing connection to DB . . . ! ! Contact Admin.(Inside cloud application  - 2) </h5>";
			} else {
				str1 = "select * from registration where email=?";
				ps1 = con.prepareStatement(str1);
				ps1.setString(1, str);
				ps1.execute();
				rs1 = ps1.getResultSet();
				if (rs1.next()) {
					msg = rs1.getString("name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(ps1);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}
		return msg;
	}

	/*------------------------------------------------*/
	/*---------GETTING USERNAME FROM DATABASE----------*/
	public List getName(String str) {
		String msg = "";
		String str1 = "";
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		List listOfData = new ArrayList();

		try {
			con = JDBCHelper.getConnection();
			if (con == null) {
				msg = " <h5> Pbm while establishing connection to DB . . . ! ! Contact Admin. ( Inside getting Student details )</h5>";
			} else {
				System.out.println(" email = " + str);
				System.out.println(" At registration table...");
				str1 = "select * from registration where email=?";
				ps1 = con.prepareStatement(str1);
				ps1.setString(1, str);
				ps1.execute();
				rs1 = ps1.getResultSet();
				if (rs1.next()) {
					listOfData.add(rs1.getString("name"));
					listOfData.add(rs1.getString("email"));
					listOfData.add(rs1.getString("branch"));
					listOfData.add(rs1.getString("dateofbirth"));
					listOfData.add(rs1.getString("marks1"));
					listOfData.add(rs1.getString("marks2"));
					listOfData.add(rs1.getString("marks3"));
					listOfData.add(rs1.getString("marks4"));
					listOfData.add(rs1.getString("marks5"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(ps1);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}
		return listOfData;
	}

	/*------------------------------------------------*/
	/*----------INSERTING NEW STUDENT BY ADMIN---------- */
	public String insert(RegBean rb) {
		// TODO Auto-generated method stub
		String msg1 = "";
		msg1 = rb.validate();

		if (msg1.equals(Constants.SUCCESS)) {
			int serial;
			Connection con = null;
			PreparedStatement ps1 = null, ps2 = null, ps3 = null, ps4 = null;
			ResultSet rs1 = null, rs2 = null, rs3 = null;
			String str1 = "";
			String str2 = "";
			String str3 = "";

			try {
				con = JDBCHelper.getConnection();
				System.out.println("con=" + con);
				if (con == null) {
					msg1 = "<h5> Problem while establishing connection to Database . . ! ! Contact Admin.</h5> ";
				} else {
					System.out
							.println(con
									+ " \n Database Connection Established Successfully... ");

					str1 = "insert into users(name,email,password,branch,dateofbirth) values(?,?,?,?,?)";
					str2 = "select * from users where email=?";
					str3 = "insert into registration(sl_no,name,email,branch,dateofbirth) values(?,?,?,?,?)";

					ps1 = con.prepareStatement(str1);
					ps1.setString(1, rb.getReguname());
					ps1.setString(2, rb.getRegemail());
					ps1.setString(3, rb.getRegpass());
					ps1.setString(4, rb.getRegbranch());
					ps1.setString(5, rb.getRegdateofbirth());
					ps1.execute();

					ps2 = con.prepareStatement(str2);
					ps2.setString(1, rb.getRegemail());
					ps2.execute();

					rs2 = ps2.getResultSet();
					System.out
							.println("Before inserting into registration table...");
					if (rs2.next()) {
						serial = rs2.getInt("sl_no");
						ps3 = con.prepareStatement(str3);
						ps3.setInt(1, serial);
						System.out.println("Serial no. is :" + serial);

						ps3.setString(2, rb.getReguname());
						ps3.setString(3, rb.getRegemail());
						ps3.setString(4, rb.getRegbranch());
						ps3.setString(5, rb.getRegdateofbirth());
						ps3.execute();
						msg1 = Constants.SUCCESS;
					}

					System.out.println("Inserting a New Student is Success..");
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				JDBCHelper.close(ps1);
				JDBCHelper.close(ps2);
				JDBCHelper.close(rs1);
				JDBCHelper.close(rs2);
				JDBCHelper.close(con);
			}
			return msg1;
		} else
			return msg1;
	}

	/*--------------------------------------------------*/
	/*--------- GETTING ALL THE NAMES OF STUDENTS -----------*/
	public List<String> loadstudentname() {

		ArrayList<String> as = new ArrayList<String>();
		String msg = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		String temp1 = "", temp2 = "", temp3 = "", temp4 = "";

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;

		try {
			con = JDBCHelper.getConnection();
			if (con == null) {
				msg = " <h5> Pbm while establishing connection to DB. . . ! ! Contact Admin. </h5>";
			} else {
				ArrayList<String> a = new ArrayList<String>();
				str1 = "select * from users";
				ps1 = con.prepareStatement(str1);

				ps1.execute();
				rs1 = ps1.getResultSet();
				System.out.println("Student list is :");
				while (rs1.next()) {
					String temp = rs1.getString("email");
					a.add(temp);
				}
				System.out.println("List is :" + a);
				return a;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(ps1);
			JDBCHelper.close(ps2);
			JDBCHelper.close(ps3);
			JDBCHelper.close(ps4);
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(rs3);
			JDBCHelper.close(rs4);
			JDBCHelper.close(con);
		}
		return null;
	}

	/*-------------------------------------------------------*/
	/*---------DELETING USER INFORMATION FROM DATABASE----------*/
	public String delete(String sb) {
		String msg = "";
		String str1 = "";
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;

		try {
			con = JDBCHelper.getConnection();
			if (con == null) {
				msg = " <h5> Pbm while establishing connection to DB . . . ! ! Contact Admin. </h5>";
			} else {
				System.out.println("Inside of actual query....");
				System.out.println("Name of the Student to be deleted is : "
						+ sb + sb);
				str1 = "delete from users where name=?";
				ps1 = con.prepareStatement(str1);
				ps1.setString(1, sb);
				ps1.execute();
				rs1 = ps1.getResultSet();
				if (rs1.next()) {
					System.out.println("Inside next...");
					msg = Constants.SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(ps1);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}
		return msg;
	}

	/*------------------------------------------------*/
	/*---------------UPLOADING MARKS INTO DB-------------------*/
	public String automataupload(String b, MarksBean mb) {
		String msg = "";
		String str1 = "";
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;

		try {
			con = JDBCHelper.getConnection();
			if (con == null) {
				msg = " <h5> Pbm while establishing connection to DB . . . ! ! Contact Admin. </h5>";
			} else {
				System.out.println("Inside of uploading query...");
				System.out.println("Student name inside uploading query :" + b);

				str1 = "update registration set marks1=?, marks2=?, marks3=?, marks4=?, marks5=? where email=?";
				ps1 = con.prepareStatement(str1);
				ps1.setString(1, mb.getMarks1());
				ps1.setString(2, mb.getMarks2());
				ps1.setString(3, mb.getMarks3());
				ps1.setString(4, mb.getMarks4());
				ps1.setString(5, mb.getMarks5());
				ps1.setString(6, b);

				ps1.execute();
				rs1 = ps1.getResultSet();
				if (rs1.next()) {
					System.out.println("Inside next...");
					msg = Constants.SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(ps1);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}
		return msg;
	}

	/*------------------------------------------------*/
	/*-------------- CREATING ERROR LOG FILE ------------*/
	public String errorLog(String errorname, String correctname) {
		String msg = "";
		try {

			FileOutputStream fo1 = null;
			File f1 = new File("D:/TFCS/ErrorLog" + ".txt");
			fo1 = new FileOutputStream(f1);

			String sr = "Error Name : " + errorname;
			char currentChar = 0;

			for (int i = 0; i < errorname.length(); i++) {
				currentChar = (char) errorname.charAt(i);
				fo1.write(currentChar);
			}
			msg = Constants.SUCCESS;
			fo1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	/*------------------------------------------------*/
}
