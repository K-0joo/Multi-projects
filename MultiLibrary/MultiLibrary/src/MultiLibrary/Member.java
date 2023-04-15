package MultiLibrary;

import java.util.ArrayList;
import java.util.Scanner;
import MultiLibrary.Register;

/**
 * @author 김영주
 * 
 * [ 기능 설명 ] 회원 관련 기능들이다. 회원가입 화면, 검색 화면, 삭제 화면 등의 화면이 있고, 회원가입 전에 할건지 물어보는 기능과 전체 화면을 띄우는 기능이 있다.
 * 모든 기능들은 자기의 일이 끝나면 다 메인으로 사용자를 보낸다. 
 * 
 * */

public class Member {
		
	Scanner sc = new Scanner(System.in);
	
	Register rg = new Register();
	Home h = new Home();
	MultiMgrImp regser = MultiMgrImp.getInstance();
	
	String name, phoneNum, addr, birth;
	static int mnum = 1000;
	
	// 회원 가입 화면 및 값 받기
	public void register(ArrayList<Register> rg) {
		try {
			System.out.println("------------------------------------------");
		
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
		regser.regMem(new Register(mnum, name, phoneNum,addr, birth));
		mnum++;		
	}
	
	// 검색 하기 위한 화면
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("	▽ 검색할 회원 번호를 입력해 주세요. ▽");
		System.out.println("------------------------------------------");

		int menum = sc.nextInt();
		sc.nextLine();
		
		System.out.println(regser.memSearch(menum));
		
		h.main(null);
	
	}
	
	// 삭제 하기 위한 화면
	public void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("	▽ 삭제할 회원 번호를 입력해 주세요. ▽");
		System.out.println("------------------------------------------");

		int memnum = sc.nextInt();
		sc.nextLine();
		
		System.out.println(regser.memDelete(memnum));
		
		h.main(null);

	}
		
	// 회원 전체 출력
	public void printAllMembers() {
	    System.out.println("	  모든 회원 정보 출력");
	    System.out.println(regser.getAllMem());
	    h.main(null);
	    
	}
	
}
