package kr.rosesystems.www.dto;

public class User {

	String u_num;
	String u_name;
	String u_pw;
	String u_contents;
	
	public User(){}
	
	public User(String u_num){
		setU_num(u_num);
	}
	public User(String u_name, String u_pw, String u_contents){
		setU_name(u_name);
		setU_pw(u_pw);
		setU_contents(u_contents);
	}
	public User(String u_num, String u_name, String u_pw, String u_contents){
		this(u_name, u_pw, u_contents);
		setU_num(u_num);
	}
	
	public String getU_num() {
		return u_num;
	}
	public void setU_num(String u_num) {
		this.u_num = u_num;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String  getU_pw() {
		return u_pw;
	}
	public void setU_pw(String  u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_contents() {
		return u_contents;
	}
	public void setU_contents(String u_contents) {
		this.u_contents = u_contents;
	}

	@Override
	public String toString() {
		return "User [u_num=" + u_num + ", u_name=" + u_name + ", u_pw=" + u_pw
				+ ", u_contents=" + u_contents + "]";
	}
	
	
}
