package MultiLibrary;

import java.util.*;
import MultiLibrary.Register;
import MultiLibrary.MultiMgrImp;

/**
 * @author 김영주
 * 
 * [ 화 면 ] 전체 화면과 회원, 사서, 도서를 선택하는 공통적으로 사용되는 화면들 소스가 있다.
 * [ 메서드 ] 전체출력, 검색, 삭제 기능과 메인 기능들로 이루어져 있다.
 * 
 * */

public class Home {

	// 기본 화면
	public static void showMenu() {
		String str = "------------ [ 멀 티 도 서 관 ] ------------\n";
			  str += "|		1. 회 원 가 입 		|\n";
			  str += "|		2. 도 서 등 록 		|\n";
			  str += "| 		3. 정 보 출 력		|\n";
			  str += "|		4. 정 보 검 색		|\n";
			  str += "|		5. 정 보 삭 제		|\n";
			  str += "|		0. 종 료 하 기		|\n";
			  str += "------------------------------------------\n";
			  str += "	  ▼ 메뉴 번호를 입력해주세요 ▼ 			\n";
			  str += "------------------------------------------";
					 
		System.out.println(str);
	}
	
	// 회원, 사서, 도서를 선택하는 화면
	public static void showSelectMenu() {
		String str = "------------ [ 멀 티 도 서 관 ] ------------\n";
		  str += "|		1. 일 반 회 원 		|\n";
		  str += "|		2. 도 서 관 사 서		|\n";
		  str += "|		3. 도 서 정 보	     	|\n";
		  str += "|		0. 상 위 메 뉴 로		|\n";
		  str += "------------------------------------------\n";
		  str += "	  ▼ 메뉴 번호를 입력해주세요 ▼ 			\n";
		  str += "------------------------------------------\n";
		  System.out.println(str);
	}
	
	// 모든 것들을 출력하면서 어느 기능을 사용할지 받는 메서드
	public void AllPrint() {
		BookFunc b = new BookFunc();
		Member m = new Member();
		Librarian l = new Librarian();
		
		Scanner sc = new Scanner(System.in);
		showSelectMenu();
		
		int pm = sc.nextInt();
		switch(pm){
		case 1:
			m.printAllMembers();
			break;
		case 2:
			l.printAllLib();
			break;
		case 3:
			b.printAllBook();
			break;
		case 0 :
			main(null);
		}
		
	}
	
	// 검색 기능들을 모아놓은 메서드
	public void AllSearch() {
		BookFunc b = new BookFunc();
		Member m = new Member();
		Librarian l = new Librarian();
		 
		Scanner sc = new Scanner(System.in);
		showSelectMenu();
		
		int sm = sc.nextInt();
		switch(sm){
		case 1:
			m.search();
			break;
		case 2:
			l.search();
			break;
		case 3:
			b.search();
			break;
		case 0 :
			main(null);
		}
	}
	
	// 삭제 기능들을 모아놓은 메서드
	public void Delete() {
		BookFunc b = new BookFunc();
		Member m = new Member();
		Librarian l = new Librarian();
		
		Scanner sc = new Scanner(System.in);
		showSelectMenu();
		
		int dm = sc.nextInt();
		switch(dm){
		case 1:
			m.delete();
			break;
		case 2:
			l.delete();
			break;
		case 3:
			b.delete();
			break;
		case 0 :
			main(null);
		}
	}
	
	public static void main(String[] args) {
		Register rg = new Register();
		BookFunc b = new BookFunc();
		Home h = new Home();
		
		Scanner sc = new Scanner(System.in);

		showMenu();
		
		while(true) {

			int menu = sc.nextInt();
			
			if(menu < 0 || menu > 5) {
				System.out.println("메뉴에 없는 번호에요. 다시 입력학세요.");
				continue;
			}
			
			
			switch(menu) {
				case 1 :
					rg.reg();
					break;
				case 2 :
					b.plusBook(null);
					break;
				case 3 :
					h.AllPrint();
					break;
				case 4 :
					h.AllSearch();
					break;
				case 5 :
					h.Delete();
					break;
				case 0 :
					System.out.println("종료합니다.");
					System.exit(0);
					break;
			}
		}
		
		
	}

}
