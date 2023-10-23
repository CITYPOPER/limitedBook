package limitedBook.model.sign;

public class SignDTO {
	
	private int signup_num;
	private String signup_name;
	private String signup_email;
	private String signup_password;
	
	public SignDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignDTO(int signup_num, String signup_name, String signup_email, String signup_password) {
		super();
		this.signup_num = signup_num;
		this.signup_name = signup_name;
		this.signup_email = signup_email;
		this.signup_password = signup_password;
	}

	public int getSignup_num() {
		return signup_num;
	}

	public void setSignup_num(int signup_num) {
		this.signup_num = signup_num;
	}

	public String getSignup_name() {
		return signup_name;
	}

	public void setSignup_name(String signup_name) {
		this.signup_name = signup_name;
	}

	public String getSignup_email() {
		return signup_email;
	}

	public void setSignup_email(String signup_email) {
		this.signup_email = signup_email;
	}

	public String getSignup_password() {
		return signup_password;
	}

	public void setSignup_password(String signup_password) {
		this.signup_password = signup_password;
	}
	
	

}
