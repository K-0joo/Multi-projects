package MultiLibrary;

import java.util.ArrayList;
import MultiLibrary.Register;

/**
 * @author 김영주
 * [ 강의 ] 인터페이스로 다중 상속을 시켜준다.
 * [ 찾아보고 배운 점 ] 비어있는 구조 자체로 만들기 때문에 상속만 받으면 다중 상속하여 원하는대로 쉽게 만들 수 있다.
 * 그리고 인터페이스를 보았을 때 간단하게 확인할 수 있으므로 어떤 코드가 쓰이는지 요약하여 확인할 수 있다.
 * 단, 인터페이스 내에 적혀진 소스는 상속받는 소스에도 무조건 포함이 되어야 오류가 나지 않는다.
 * */

public interface MultiMgr {
	
	Register memSearch(int membnum);
	Register memDelete(int membnum);
	Register libSearch(int libenum);
	Register libDelete(int libenum);
	ArrayList<Book> bookSearch(String boname);
} 
