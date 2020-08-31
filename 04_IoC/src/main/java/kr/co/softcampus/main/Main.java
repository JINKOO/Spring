package kr.co.softcampus.main;


/*
 *  #. IoC(Inversion of Control)
 *     - 프로그램의 실행 흐름이 개발자에 의한 것이 아닌, Framework가 제어의 결정권을 가지는 것을 의미한다.
 *     - 개발자가 직접 객체 생성 등의 코드 작성이 아니고, Framework가 사용하는 파일(beans.xml)에 작성하면
 *       이를 토대로 Framework가 객체를 생성하여 반환하는 코드가 동작하는 순서를 결정하게 된다는 의미이다.
 *     
 *     - 대표적인 IoC 컨테이너 
 *       1. BeanFactroy(deprecated)
 *       2. ApplicationContext;
 * 
 */

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import kr.co.softcampus.beans.TestBean1;

public class Main {

	public static void main(String[] args) {
//		test1(); 
//		test2(); 
//		test3();
		test4();
	}
	
	
	//IoC컨테이너 : BeanFactory - beans.xml파일이 내부 package에 있을 때
	public static void test1() {
		//beans.xml파일을 로딩한다. 이 때, 객체 생성은 X.
		ClassPathResource res = new ClassPathResource("kr/co/softcampus/config/beans.xml");
		
		//IoC컨테이너 선언.
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		//getBean()을 해야 객체가 생성되고, 해당 객체의 주솟값 반환한다.
		TestBean1 t1 = factory.getBean("t1", TestBean1.class);
		System.out.println("t1 : " + t1);
		
		//새로운 객체가 생성되는 것이 아니라, 기존에 생성하였던 객체의 주솟값을 반환한다.
		TestBean1 t2 = factory.getBean("t1", TestBean1.class);
		System.out.println("t2 : " + t2);
	}
	
	
	//BeanFactroy - beans.xml파일이 package외부에 있을 때.
	public static void test2() {
		
		FileSystemResource res = new FileSystemResource("beans.xml");
		
		XmlBeanFactory factroy = new XmlBeanFactory(res);
		TestBean1 t1 = factroy.getBean("t2", TestBean1.class);
		System.out.println("t1 : " + t1);
		
		TestBean1 t2 = factroy.getBean("t2", TestBean1.class);
		System.out.println("t2 : " + t2);
	}
	
	
	//IoC 컨테이너 : ApplicationContext - beans.xml파일이 package내부에 있을 때.
	public static void test3() {
		//ApplicationContext는 beans.xml에 정의한 bean의 class 객체들이 자동으로 생성된다. 
		//lazy-init, scope 등의 속성 값을 통하여 객체 생성 조절 가능하다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		//getBean()을 하면 새로운 객체 생성아니라, 기존 객체의 주솟값을 반환한다.
		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		System.out.println("t1 : " + t1);
		
		TestBean1 t2 = ctx.getBean("t1", TestBean1.class);
		System.out.println("t2 : " + t2);
		
		ctx.close();
	}
	
	//ApplicationContext - beans.xml파일이 package외부에 있을 때.
	public static void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		TestBean1 t1 = ctx.getBean("t2", TestBean1.class);
		System.out.println("t1 : " + t1);
		
		TestBean1 t2 = ctx.getBean("t2", TestBean1.class);
		System.out.println("t1 : " + t2);
		
		ctx.close();
		
	}
}
