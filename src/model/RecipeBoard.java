package model;

public class RecipeBoard {
	private int recp_no;
	private String recp_name;
	private String nick;
	private String date;
	private int cnt;
	private int likes;
	private String recp_intro;
	private String url;
	private String ingre;
	private String editor;
	
	// Foreign Key
	private int mem_no;

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public int getRecp_no() {
		return recp_no;
	}

	public void setRecp_no(int recp_no) {
		this.recp_no = recp_no;
	}

	public String getRecp_name() {
		return recp_name;
	}

	public void setRecp_name(String recp_name) {
		this.recp_name = recp_name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getRecp_intro() {
		return recp_intro;
	}

	public void setRecp_intro(String recp_intro) {
		this.recp_intro = recp_intro;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIngre() {
		return ingre;
	}

	public void setIngre(String ingre) {
		this.ingre = ingre;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}