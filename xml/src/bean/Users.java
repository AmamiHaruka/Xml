package bean;

public class Users {
 private String account;
 private String pw;
 private String email;
 private String sex;
 private String role_id;
 private String reg_tm;
 public Users(String account,String pw,String email,String sex,String role_id,String reg_tm){
	 this.account=account;
	 this.pw=pw;
	 this.email=email;
	 this.sex=sex;
	 this.role_id=role_id;
	 this.reg_tm=reg_tm;
 }
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getRole_id() {
	return role_id;
}
public void setRole_id(String role_id) {
	this.role_id = role_id;
}
public String getReg_tm() {
	return reg_tm;
}
public void setReg_tm(String reg_tm) {
	this.reg_tm = reg_tm;
}
}
