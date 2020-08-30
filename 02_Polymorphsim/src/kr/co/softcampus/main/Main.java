package kr.co.softcampus.main;

import kr.co.softcampus.beans.HelloWorld;
import kr.co.softcampus.beans.HelloWorldEn;
import kr.co.softcampus.beans.HelloWorldKo;

/*
 *  #. 다형성(Polymorphism)
 *     다형성을 사용하면, 앞의 문제점에서 변경할 Class가 작성된 부분을 모두 수정해야하는 불편함이 어느정도 해소된다.
 *     다형성을 통하여, 부모 Class = 자식 Class 즉, 업 캐스팅을 통하여 해결 할 수 있다.
 *     하지만, 레퍼런스의 선언 부분은 수정하지 않아도 되지만, 객체 생성 부분은 여전히 수정해줘야 한다.
 *     
 *     이를 해결하는 것이 Spring Framework를 사용하는 것이다.
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		//HelloWorldEn에서 HelloWorldKo로 변경할 때, 
		//Up casting을 통하여 레퍼런스변수 선언 부분은 수정하지 않아도 된다.
		HelloWorld hello1 = new HelloWorldKo(); //new HelloWorldEn();
		Main.callMethod(hello1);
		
		HelloWorld hello2 = new HelloWorldKo(); //new HelloWorldEn();
		Main.callMethod(hello2);
	}
	
	//파라미터로 업 캐스팅으로 자식 객체들을 받는다.
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
