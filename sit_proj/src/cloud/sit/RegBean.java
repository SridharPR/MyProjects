package cloud.sit;

public class RegBean {
	private String reguname, regemail, regpass, regbranch, regdateofbirth;

	public String validate() {
		String msg = "";

		if (reguname == null || reguname.trim().equals("")) {
			msg = msg + " <h5> Please Enter Student Name. </h5> ";
		}
		if (regemail == null || regemail.trim().equals("")) {
			msg = msg + " <h5> Please Enter Student Email ID. </h5> ";
		}
		if (regpass == null || regpass.trim().equals("")) {
			msg = msg + " <h5> Password can not be empty. </h5> ";
		}
		if (regbranch == null || regbranch.trim().equals("")) {
			msg = msg + " <h5> Please Enter Student Branch. </h5> ";
		}
		if (msg.equals("")) {
			return Constants.SUCCESS;
		} else {
			return msg;
		}
	}

	public String getReguname() {
		return reguname;
	}

	public void setReguname(String reguname) {
		this.reguname = reguname;
	}

	public String getRegemail() {
		return regemail;
	}

	public void setRegemail(String regemail) {
		this.regemail = regemail;
	}

	public String getRegpass() {
		return regpass;
	}

	public void setRegpass(String regpass) {
		this.regpass = regpass;
	}

	public String getRegbranch() {
		return regbranch;
	}

	public void setRegbranch(String regbranch) {
		this.regbranch = regbranch;
	}

	public String getRegdateofbirth() {
		return regdateofbirth;
	}

	public void setRegdateofbirth(String regdateofbirth) {
		this.regdateofbirth = regdateofbirth;
	}
}
