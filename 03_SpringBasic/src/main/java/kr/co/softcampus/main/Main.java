package kr.co.softcampus.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.softcampus.beans.HelloWorld;

/*
 *  #. 사용하고 있던 class가 변경이 되면, beans.xml의 해당 class가 있던 부분만 변경하면 된다.
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		//1. beans.xml파일을 로딩한다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		//2. xml에 정의한 id가 hello인 class의 객체를 가져온다.
		//   getBean()의 반환형은 Object형이므로 Down Casting을 해야한다.
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		Main.callMethod(hello1);
		
		//2.1 또 다른 방식
		//    여기서는 형변환할 타입을 파라미터로 넘겨준다. 즉, id가 Hello인 객체를 받아오는데 HelloWorld형으로 받겠다!
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		Main.callMethod(hello2);
		
		ctx.close();
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
