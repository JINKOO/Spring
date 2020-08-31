package kr.co.softcampus.main;

/*
 *   #. Bean객체의 LifeCyle
 *      - 기본적으로 IoC컨테이너의 close()가 호출 되면 Bean객체는 모두 소멸된다.
 *      - init-method, default-init-method : 생성자 호출 후 수행
 *        destroy-method, default-destroy-method : close()후 수행된다.
 * 
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.TestBean1;
import kr.co.softcampus.beans.TestBean2;
import kr.co.softcampus.beans.TestBean3;
import kr.co.softcampus.beans.TestBean4;

public class Main {

	public static void main(String[] args) {
		
		//beans.xml로드 할 때, lazy-init != true 이고 scope != prototype이면 객체 생성
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		//1. init-method, destroy-method를 정의하였다.
		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		System.out.println("t1 : " + t1);
	
		System.out.println("--------------------------------------------");
		
		//2. default-init-method, default-destroy-method 정의
		TestBean2 t2 = ctx.getBean("t2", TestBean2.class);
		System.out.println("t2 : " + t2);
		
		System.out.println("--------------------------------------------");
		
		//3. 모두 정의하였을 때에는, init-method, destroy-method가 호출된다.
		TestBean3 t3 = ctx.getBean("t3", TestBean3.class);
		System.out.println("t3 : " + t3);
		
		System.out.println("--------------------------------------------");
		
		//4. 아무것도 정의하지 않았을 경우 에러안난다.
		TestBean4 t4 = ctx.getBean("t4", TestBean4.class);
		System.out.println("t4 : " + t4);
		
		System.out.println("--------------------------------------------");
		
		//에러 코드임. init-method, destroy-method를 TestBean4에 정의하지 않았는데 bean.xml에서는 속성을 지정해놨기 때문.
		TestBean4 t4_2 = ctx.getBean("t4_2", TestBean4.class);
		System.out.println("t4_2 : " + t4_2);
		
		System.out.println("--------------------------------------------");
		
		
		//IoC 컨테이너가 close()될 때, bean.xml에 정의한 class 객체들이 모두 소멸 된다.
		ctx.close();
	}
}
