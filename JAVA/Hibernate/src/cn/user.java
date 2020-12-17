package cn;

public class user {

	public String tno;
	public String teachername;
	public Integer age;
	public String sex;
	public String title;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Teacherinfo [tno=" + tno + ", teachername=" + teachername + ", age=" + age + ", sex=" + sex + ", title="
				+ title + "]";
	}	
}