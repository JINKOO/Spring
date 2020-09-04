package kr.co.softcampus.main;

/*
 *   #. Dependency Injection(DI, 의존성 주입)
 *      - Spring에서 아주 중요한 개녕이며 큰 장점이다.
 *      - Bean객체를 생성 할 때, Bean객체가 관리할 값 혹은 객체를 주입하는 것을 의미한다.
 *      - Bean객체 생성 후 Bean객체가 가지는 기본 값들을 Java코드로 설정하는 것이 아니라
 *        Bean을 정의하는 xml코드에서 정의하는 개념이다.
 *      
 *        
 *      1. 생성자(Constructor)를 통한 주입.
 *         xml에 Bean객체를 정의 하고, 해당 Bean객체가 생성 될 때 각 생성자 매개변수에 어떠한 값을 넣을지 정하는 것이다.
 * 
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.TestBean1;
import kr.co.softcampus.beans.TestBean2;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		//1. Java코드에서 직접 객체 생성하는 방식
		TestBean1 t1 = new TestBean1();
		t1.printData();
		
		System.out.println("===================================");
		
		TestBean1 t2 = new TestBean1(100);
		t2.printData();
		
		System.out.println("===================================");
		
		TestBean1 t3 = new TestBean1(11.11);
		t3.printData();
		
		System.out.println("===================================");
		System.out.println("===================================");
		
		
		//2. xml코드에서 객체 생성하는 방식
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		obj1.printData();
		
		System.out.println("===================================");
		
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		obj2.printData();
		
		System.out.println("===================================");
		
		TestBean1 obj3 = ctx.getBean("obj3", TestBean1.class);
		obj3.printData();
		
		System.out.println("===================================");
		
		TestBean1 obj4 = ctx.getBean("obj4", TestBean1.class);
		obj4.printData();
		

		System.out.println("===================================");
		//생성자 매개변수 3개 모두 주입.
		TestBean1 obj5 = ctx.getBean("obj5", TestBean1.class);
		obj5.printData();
		
		System.out.println("===================================");
		//생성자 매개변수 순서와 상관없이 주입하였을 때도 가능하다..
		TestBean1 obj6 = ctx.getBean("obj6", TestBean1.class);
		obj6.printData();
		
		System.out.println("===================================");
		//index태그를 사용하여 주입할 때의 순서를 지정한다.
		TestBean1 obj7 = ctx.getBean("obj7", TestBean1.class);
		obj7.printData();
		
		
		System.out.println("===================================");
		//객체 주입1(bean객체를 생성하여 주입)
		TestBean2 obj8 = ctx.getBean("obj8", TestBean2.class);
		obj8.printData();
		
		System.out.println("===================================");
		//객체 주입2(이미 정의된 bean객체를 주입)
		TestBean2 obj9 = ctx.getBean("obj9", TestBean2.class);
		obj9.printData();
		
		
		ctx.close();
	}
}
