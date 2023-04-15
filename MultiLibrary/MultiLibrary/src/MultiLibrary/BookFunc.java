package MultiLibrary;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 김영주
 * 
 * 도서 기능들을 모아놓았다. 돌아가는 주 기능은 추가, 삭제, 검색, 전체 책 조회이다.
 * */

public class BookFunc {
	Scanner sc = new Scanner(System.in);
	
	Home h = new Home();
	MultiMgrImp m = MultiMgrImp.getInstance();
	
	String bname, writer, publish, pubDate; 
	static int bnum;
	
	// 책 추가하는 메서드
	public void plusBook(ArrayList<Book> b) {
		System.out.println("------------------------------------------");
		try {
			System.out.printf("도서명 : ");
			bname = sc.nextLine();
			
			System.out.printf("저자 : ");
			writer = sc.nextLine();
			
			System.out.printf("출판사 : ");
			publish = sc.nextLine();
			
			System.out.printf("출판일 : ");
			pubDate = sc.nextLine();
			
			if(bname.isEmpty() == true || writer.isEmpty() == true || publish.isEmpty() == true || pubDate.isEmpty() == true) {
				throw new Exception();
			}
		} catch(Exception e) {
			System.out.println("도서명, 저자, 출판사, 출판일 중 빈칸이 있으면 안됩니다. 메인으로 돌아갑니다.");
			h.main(null);
		}
		
		addCheck();
	}
	
	// 책 추가할 건지 물어보는 메서드
	public void addCheck() {
		Home h = new Home();
		System.out.println(">> 위 정보를 등록할까요? [1. yes] [2. no]");
		
		while(true) {
			int menu = sc.nextInt();
			switch(menu) {
				case 1 :
					m.addBook(new Book(bnum, bname, writer, publish, pubDate));
					System.out.println("저장 완료 :D 메인으로 돌아갑니다.");
					bnum++;
					h.main(null);
				case 2 :
					System.out.println("등록을 취소하셨습니다. 메인으로 돌아갑니다.");
					h.main(null);
			}
		}
	}
	
	// 검색 하기 위한 메서드
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	▽ 검색할 도서명을 입력해 주세요. ▽");
		System.out.println("------------------------------------------");

		String title = sc.nextLine();
		
		System.out.println(m.bookSearch(title));
		
		h.main(null);

	}
	
	// 삭제 하기 위한 메서드
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	▽ 삭제할 도서 번호를 입력해 주세요. ▽");
		System.out.println("------------------------------------------");
		
		int bookN = sc.nextInt();
		sc.nextLine();
		
		System.out.println(m.bookDelete(bookN));
		
		h.main(null);

	}
	
	// 전체 도서 보여주는 메서드
	public void printAllBook() {
		System.out.println("	  모든 도서 정보 출력");
		System.out.println(m.getAllBook());
		h.main(null);
	}
}
