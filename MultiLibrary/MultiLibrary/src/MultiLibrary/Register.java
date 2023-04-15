package MultiLibrary;

import java.util.Scanner;
import MultiLibrary.Register;

/**
 * @author 김영주
 * 
 * [ 회원가입 기능 ]
 * - 외부 배열에 저장해야 하기 때문에 변수를 미리 선언해준다
 * - 메뉴는 중복이 되니 따로 showMenu()로 생성해서 보여준다.
 * - 일반 회원과 사서의 정보는 똑같이 받기 때문에 서로 다른 번호들만 따로 다른 배열에 각각 저장해준다.
 * - 중복되는 변수는 하나씩만 선언해주었으며 회원은 Register, toString을 사서는 ReRegister, toString2를 사용한다.
 * - 두 개 다 저장되기 전에 저장할 건지 물어보고 저장하지 않으면 메인으로 돌려보낸다. 저장할거라고 하면은 배열에 넣어준다.
 */

public class Register {
	private String name, phoneNum, addr, birth;
	private int mnum = 0, lnum = 0;
	
	
	public static void showMenu() {
		String str = "------------ [ 멀 티 도 서 관 ] ------------\n";
		  str += "|		1. 일 반 회 원 		|\n";
		  str += "|		2. 도 서 관 사 서		|\n";
		  str += "|		0. 상 위 메 뉴 로		|\n";
		  str += "------------------------------------------\n";
		  str += "	  ▼ 메뉴 번호를 입력해주세요 ▼ 			\n";
		  str += "------------------------------------------\n";
		  System.out.println(str);
	}
	
	public Register() { // 기본 생성자
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// 회원번호, 이름, 전화번호, 주소, 생일
	public Register(int mnum, String name, String phoneNum, String addr, String birth) {
		super();
		this.mnum = mnum;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.birth = birth;
	}

	public void ReRegister(int lnum, String name, String phoneNum, String addr, String birth) {
		this.lnum = lnum;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.birth = birth;
		
	}
	
	// 회원번호
	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	// 사서번호
	public int getLnum() {
		return lnum;
	}

	public void setLnum(int lnum) {
		this.lnum = lnum;
	}
	
	public String toString() {
		return "----" + name + "님의 정보----\n"
		+ "회원 번호 : " + mnum + "\n"
		+ "이름 : " +name + "\n"
		+"전화번호 : " + phoneNum + "\n"
		+ "주소 : " + addr + "\n"
		+ "생년월일 : " + birth + "\n\n";
	}
	
	public String toString2() {
		return "----" + name + "님의 정보----\n"
		+ "사서번호 : " + lnum + "\n"
		+ "이름 : " +name + "\n"
		+"전화번호 : " + phoneNum + "\n"
		+ "주소 : " + addr + "\n"
		+ "생년월일 : " + birth + "\n\n";
	}
	
	public void reg() {
		Scanner sc = new Scanner(System.in);
		Home h = new Home();
		Member m = new Member();
		Librarian l = new Librarian();
	
		MultiMgrImp regser = MultiMgrImp.getInstance();
		
		showMenu();
		
		while(true) {
			int menu = sc.nextInt();
			
			if(menu < 0 || menu > 2) {
				System.out.println("메뉴에 없는 번호에요. 다시 입력하세요.");
				continue;
			}
			
			switch(menu) {
				case 1 :
					m.register(null);
					
					System.out.println(">> 위 정보를 등록할까요? [1. yes] [2. no]");
					
					int no = sc.nextInt();
					
					if(no == 1) {
						m.regCheck();
						System.out.println("저장 완료 :) 메인으로 돌아갑니다.");
						h.main(null);
						
					} else {
						System.out.println("등록을 취소하셨습니다.");
						h.main(null);
					}	
					
				case 2 :
					l.register(null);

					System.out.println(">> 위 정보를 등록할까요? [1. yes] [2. no]");

					int lno = sc.nextInt();
					
					if(lno == 1) {
						l.regCheck();
						System.out.println("저장 완료 :) 메인으로 돌아갑니다.");
						h.main(null);
					} else {
						System.out.println("등록을 취소하셨습니다.");
						h.main(null);
					}	
				case 0:
					h.main(null);
			}
		}
	}
		

}
