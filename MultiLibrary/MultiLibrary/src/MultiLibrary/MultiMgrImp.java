package MultiLibrary;

import java.util.ArrayList;
import java.util.Scanner;
import MultiLibrary.Register;

/**
 * @author 김영주
 * [ 간단 설명 ] 인터페이스 다중 상속을 받는 MultiMgrImp이다.
 * 상속받아 사용한 소스들은 memSearch, memDelete, libSearch, libDelete, bookSearch가 있다.
 * 
 * [ 찾고 배운 점 ] 다중 상속을 받아와 원하는대로 바꿔서 사용하였다.
 * 
 * [ 기능 설명 ]
 * 여기 소스로 행해지는 기능은 
 * <회원> 회원 추가, 전체 회원 조회, 회원 검색, 회원 삭제
 * <사서> 사서 추가, 전체 사서 조회, 사서 검색, 사서 삭제
 * <도서> 도서 추가, 전체 도서 조회, 도서 검색, 도서 삭제
 * 이다.
 * */

public class MultiMgrImp implements MultiMgr {
	Register rg = new Register();
	Book book = new Book();
	
	private ArrayList<Register> rList; // 저장할 ArrayList 선언
	private ArrayList<Register> lList;
	private ArrayList<Book> bList;
	
	private static MultiMgrImp mmi = new MultiMgrImp();
	
	Home h = new Home();
	
	/**
	 * ArrayList들을 선언하고 새로 배치해주는 메서드
	 * */
	private MultiMgrImp() {
		rList = new ArrayList<>(); // 배치해주기
		bList = new ArrayList<>();
		lList = new ArrayList<>();
	}
	
	public static MultiMgrImp getInstance() {
		return mmi;
	}
	
	// 회원 --------------------------------------------------
	// 회원 추가 기능
	public void regMem(Register rg) {
		rList.add(rg);	
	}
	
	// 전체 회원 조회 기능
	public ArrayList<Register> getAllMem(){
		return rList;
	}
	
	// 회원 검색 기능
	public Register memSearch(int membnum) {
		for(Register r : rList) {
			if(r.getMnum() == membnum)
				rg = r;
		}	
		return rg;
	}
	
	// 회원 삭제 기능
	public Register memDelete(int membnum) {
		for(Register r : rList) {
			if(r.getMnum() == membnum) {
				rList.remove(r);
				break; // break를 해주지 않으면 오류가 발생한다.
			}
		}
		
		System.out.println("삭제가 완료되었습니다! 메인으로 돌아갑니다.");
		return rg;
		
	}
	
	// 사서 --------------------------------------------------------------
	// 사서 추가 기능
	public void regLib(Register rg) {
		lList.add(rg);	
	}
	
	// 전체 사서 조회 기능
	public ArrayList<Register> getAllLib(){
		return lList;
	}
	
	// 사서 검색 기능
	public Register libSearch(int libenum) {
		for(Register r : lList) {
			if(r.getMnum() == libenum) {
				rg = r;
			} 
		}
		return rg;
	}
	
	// 사서 삭제 기능
	public Register libDelete(int libenum) {
		for(Register r : lList) {
			if(r.getMnum() == libenum) {
				lList.remove(r);
				break;
			}
		}
		
		System.out.println("삭제가 완료되었습니다! 메인으로 돌아갑니다.");
		return rg;
		
	}
	
	// 책 추가 ------------------------------------------------- 
	// 책 추가 기능
	public void addBook(Book b) {
		bList.add(b);
	}
	
	// 전체 책 조회 기능
	public ArrayList<Book> getAllBook(){
		return bList;
	}
	
	// 책 이름으로 검색 기능
	public ArrayList<Book> bookSearch(String boname) {
		ArrayList<Book> books = new ArrayList<>();
		for(Book b : bList) {
			if(b.getBname().contains(boname)) {
				books.add(b);
			}
		}
		return books;
	}
	
	// 책 삭제 기능
	public Book bookDelete(int bookN) { 
		
		for(Book b : bList) {
			if(b.getBnum() == bookN) {
				bList.remove(b);
				break;
			}
		}
		
		System.out.println("삭제가 완료되었습니다! 메인으로 돌아갑니다.");
		return book;
	}
}
