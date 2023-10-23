package limitedBook.model.prod;

public class ProdDTO {
	
		private int p_id;
		private String p_code;
		private String p_name;
		private String p_img;
		private String p_etc;
		private String p_date;
		
	public ProdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdDTO(int p_id, String p_code, String p_name, String p_img, String p_etc, String p_date) {
		super();
		this.p_id = p_id;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_img = p_img;
		this.p_etc = p_etc;
		this.p_date = p_date;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_etc() {
		return p_etc;
	}

	public void setP_etc(String p_etc) {
		this.p_etc = p_etc;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
	
		
		

}
