package MultiLibrary;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *@author 김영주
 * 
 * 사서 관리 하는 메서드들이 모인 소스이다. 회원가입, 저장, 검색, 삭제, 사서 전체 출력 기능들이 있다.
 * */

public class Librarian {
	Scanner sc = new Scanner(System.in);
	
	Home h = new Home();
	MultiMgrImp mmi = MultiMgrImp.getInstance();
	
	String name, phoneNum, addr, birth;
	static int lnum = 500;
	
	// 사서 가입 화면 및 값 받기
	public void register(ArrayList<Register> rg) {
		
		System.out.println("------------------------------------------");
	
		try {
			System.out.printf("이름 : ");
			name = sc.nextLine();
			
			System.out.printf("전화번호 : ");
			phoneNum = sc.nextLine();
			
			System.out.printf("주소 : ");
			addr = sc.nextLine();
			
			System.out.printf("생년월일 :");
			birth = sc.nextLine();
			
			if(name.isEmpty() == true || phoneNum.isEmpty() == true || addr.isEmpty() == true || birth.isEmpty() == true) {
				throw new Exception();
			}
			
		} catch(Exception e) {
			System.out.println("이름, 전화번호, 주소, 생년월일 중 빈칸이 있으면 안됩니다. 메인으로 돌아갑니다.");
			h.main(null);
		}
	
	}
	
	// 저장하기 전에 물어보는 화면
	public void regCheck() {
		mmi.regLib(new Register(lnum, name, phoneNum,addr, birth));
		lnum++;		
	}
	
	// 검색 하기 위한 화면
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	▽ 검색할 사서 번호를 입력해 주세요. ▽");
		System.out.println("------------------------------------------");

		int linum = sc.nextInt();
		sc.nextLine();
		
		System.out.println(mmi.libSearch(linum));
		
		h.main(null);
	
	}
	

	// 삭제 하기 위한 화면
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("	▽ 삭제할 사서 번호를 입력해 주세요. ▽");
		System.out.println("------------------------------------------");

		int libnum = sc.nextInt();
		sc.nextLine();
		
		System.out.println(mmi.libDelete(libnum));
		
		h.main(null);

	}
		
	// 사서 전체 출력
	public void printAllLib() {
	    System.out.println("	  모든 사서 정보 출력");
	    System.out.println(mmi.getAllLib());
	    h.main(null);
	    
	}
}
