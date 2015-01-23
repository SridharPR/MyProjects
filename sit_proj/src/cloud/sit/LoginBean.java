package cloud.sit;

public class LoginBean {
	private String uname, email, pass, rpass;

	public String validate() {
		String msg = "";

		if (email == null || email.trim().equals("")) {
			msg = msg + " <h5> Please Enter your Username. </h5> ";
		}

		if (pass == null || pass.trim().equals("")) {
			msg = msg + " <h5> Please Enter your password. </h5> ";
		}

		if (msg.equals("")) {
			return Constants.SUCCESS;
		} else {
			return msg;
		}
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
}
