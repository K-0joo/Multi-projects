package MultiLibrary;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 김영주
 * 
 * 정보를 캡슐화하기 위해 접근 제어자를 사용하였다.
 * private로 선언해버렸기 때문에 외부에서 참조하려면 getter, setter를 이용해야 한다.
 * toString은 나중에 배열로 다시 받아 볼 때 주소값이 아닌 정보값으로 가져오기 위해 선언해주었다.
 * */

public class Book {
	private String bname, writer, publish, pubDate; 
	private int bnum;
	
	Home h = new Home();
	
	Scanner sc = new Scanner(System.in);

	public Book() { // 기본 생성자
		
	} 
	
	public Book(int bnum, String bname, String writer, String publish, String pubDate) {
		super();
		this.bnum = bnum;
		this.bname = bname;
		this.writer = writer;
		this.publish = publish;
		this.pubDate = pubDate;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	
	public String toString() {
		return "----" + bname + " 책 정보----\n"
				+ "도서번호 : " + bnum + "\n"
				+ "도서명 : " + bname + "\n"
				+"저자 : " + writer + "\n"
				+ "출판사 : " + publish + "\n"
				+ "출판일 : " + pubDate + "\n\n";
	}



}
