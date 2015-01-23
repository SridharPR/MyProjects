package cloud.sit;

/**
 * This class is a Marks Bean which contains student's marks details through out
 * the project.
 * 
 * @author SridharR
 * 
 */
public class MarksBean {
	private String inputname, marks1, marks2, marks3, marks4, marks5;

	public String validate() {
		String msg = "";

		if (msg.equals("")) {
			return Constants.SUCCESS;
		} else {
			return msg;
		}
	}

	public String getInputname() {
		return inputname;
	}

	public void setInputname(String inputname) {
		this.inputname = inputname;
	}

	public String getMarks1() {
		return marks1;
	}

	public void setMarks1(String marks1) {
		this.marks1 = marks1;
	}

	public String getMarks2() {
		return marks2;
	}

	public void setMarks2(String marks2) {
		this.marks2 = marks2;
	}

	public String getMarks3() {
		return marks3;
	}

	public void setMarks3(String marks3) {
		this.marks3 = marks3;
	}

	public String getMarks4() {
		return marks4;
	}

	public void setMarks4(String marks4) {
		this.marks4 = marks4;
	}

	public String getMarks5() {
		return marks5;
	}

	public void setMarks5(String marks5) {
		this.marks5 = marks5;
	}
}
