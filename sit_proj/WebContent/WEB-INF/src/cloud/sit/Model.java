package cloud.sit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cloud.sit.Constants;

import cloud.sit.JDBCHelper;
import java.util.*;

public class Model
{
	
	int sl;
	
	public String authenticate(LoginBean lb)
	{
		// TODO Auto-generated method stub
		String msg1 = "";
		msg1=lb.validate();
		
		if(msg1.equals(Constants.SUCCESS))
		{
			Connection con = null;
			PreparedStatement ps1 = null, ps2 = null, ps3 = null, ps4 = null;
			ResultSet rs1 = null, rs2 = null, rs3 = null;
			String str1 = "";
			String str2 = "";
			
			try
			{
				con = JDBCHelper.getConnection();
                                System.out.println("con="+con);
				if (con == null)
				{
					msg1 = "<h5> Problem while establishing connection to Database . . ! ! Contact Admin.( Inside of authenticating username and password) </h5> ";
				} 
				else
				{
					System.out.println(con+ " \n Database Connection Established Successfully... ");
					str1 = "select * from users where email=? and password=?";

					ps1 = con.prepareStatement(str1);
					ps1.setString(1, lb.getEmail());
					ps1.setString(2, lb.getPass());
					ps1.execute();

					rs1 = ps1.getResultSet();
					if (rs1.next())
					{
						sl = rs1.getInt("sl_no");
						msg1 = Constants.SUCCESS;
					}
					else
					{
                        System.out.println("");
						str2 = "select * from users where email=? or password=?";
						ps2 = con.prepareStatement(str2);
						ps2.setString(1, lb.getEmail());
						ps2.setString(2, lb.getPass());
						ps2.execute();

						rs2 = ps2.getResultSet();
						if (rs2.next())
						{
							msg1 = " <h5> Invalid Username or Password . . . ! ! </h5> ";
						}
						else
						{
							msg1 = " <h5> You are not an Authenticated user . . . ! ! </h5> ";
						}
					}
				}
				
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
				// TODO: handle exception
			}
			
			finally
			{
				JDBCHelper.close(ps1);
				JDBCHelper.close(ps2);
				JDBCHelper.close(rs1);
				JDBCHelper.close(rs2);
				JDBCHelper.close(con);
			}
			return msg1;
		}
		else
			return msg1;
	}
	
	
	
	public List getName(String str)
	{
		String msg="";
		String str1="";
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		List listOfData = new ArrayList();
		
		try
		{ 
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				msg = " <h5> Pbm while establishing connection to DB . . . ! ! Contact Admin. ( Inside getting Student details )</h5>";
			}
			else
			{
				str1="select * from registration where email=?";
				ps1=con.prepareStatement(str1);
				ps1.setString(1, str);
				ps1.execute();
				rs1=ps1.getResultSet();
				if(rs1.next())
				{
					listOfData.add(rs1.getString("name"));
					listOfData.add(rs1.getString("branch"));
					listOfData.add(rs1.getString("email"));
					listOfData.add(rs1.getString("fathername"));
					listOfData.add(rs1.getString("mothername"));
					listOfData.add(rs1.getString("dateofjoining"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(ps1);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}
		return listOfData;
	}

}
