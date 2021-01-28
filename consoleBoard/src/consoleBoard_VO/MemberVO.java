package consoleBoard_VO;

public class MemberVO {
	private int board_no;
	private String title;
	private String date;
	private String content;
	private String writer;
	private int cnt;	//조회수
	
	public MemberVO(int board_no, String title, String writer, int cnt) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.writer = writer;
		this.cnt = cnt;
	}
	
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
