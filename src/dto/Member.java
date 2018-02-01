package dto;

public class Member {
	
	private int mem_no;
	private String id;
	private String pw;
	private String birth;
	private String gender;
	private String nick;
	private String pic_url;
	
	@Override
	public String toString() {
		return "Member [mem_no=" + mem_no + ", id=" + id + ", pw=" + pw + ", birth=" + birth + ", gender=" + gender
				+ ", nick=" + nick + ", pic_url=" + pic_url + "]";
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	
	
}