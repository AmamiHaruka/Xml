package bean;

public class Users {
 private String account;
 private String pw;
 private String email;
 private String sex;
 private String roleID;
 private String registerTime;
 private String userLevel;
 public String getUserLevel() {
	return userLevel;
}
public void setUserLevel(String userLevel) {
	this.userLevel = userLevel;
}
public Users(String account,String pw,String email,String sex,String userlevel,String role_id,String reg_tm){
	 this.account=account;
	 this.pw=pw;
	 this.email=email;
	 this.sex=sex;
	 this.userLevel=userlevel;
	 this.roleID=role_id;
	 this.registerTime=reg_tm;
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
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
}
