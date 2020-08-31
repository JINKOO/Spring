package kr.co.softcampus.main;

/*
 *   #. Spring Bean객체 생성
 *      - Spring에서는 사용할 Bean객체를 beans.xml파일에 정의하고 필요할 때, 객체를 가져와 사용하는 방법을 이용한다.
 *      
 *      -bean태그 (사용할 Bean을 정의하는 태그)
 *      1. class  :: 객체를 사용하기 위해 사용할 Class 지정. 얘는 반드시 해야한다.
 *      2. id     :: 객체를 반환하기 위해 사용하는 이름을 지정.
 *      3. lazy-init(default = false) :: Singleton인 경우, xml로딩 할 때 객체의 생성 여부 설정. getBean()할 때 생성 할 것이냐, xml로딩할 때 생성할 것이냐
 *      4. scope(default = Singleton) :: Singleton인 경우, 객체를 하나만 생성한다.
 *                                       Prototype인 경우, getBean()을 할 때마다 객체 생성.
 * 
 * 
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.softcampus.beans.TestBean;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		//1. class속성 만 있을 때, id속성이 없으므로 객체의 주솟값을 사용할 수 없다.
		
		System.out.println("--------------------------------------------");
		
		//2. id속성이 있을 때, 객체의 주솟값을 사용할 수 있다.
		TestBean t1 = ctx.getBean("test1", TestBean.class);
		System.out.println("t1 : " + t1);
		//객체의 주솟값은 이전에 생성한 객체이다.
		TestBean t2 = ctx.getBean("test1", TestBean.class);
		System.out.println("t2 : " + t2);
		
		System.out.println("--------------------------------------------");
		
		//3. lazy-init인 경우, getBean()을 통하여 객체가 생성된다.
		TestBean t3 = ctx.getBean("test2", TestBean.class);
		System.out.println("t3 : " + t3);
		//이전에 생성한 객체의 주솟값 반환
		TestBean t4 = ctx.getBean("test2", TestBean.class);
		System.out.println("t4 : " + t4);
		
		System.out.println("--------------------------------------------");
		
		//4. scope=prototype인 경우, getBean()을 할 때마다 새로운 객체가 생성된다.
		TestBean t5 = ctx.getBean("test3", TestBean.class);
		System.out.println("t5 : " + t5);
		//새로운 객체가 생성된다.
		TestBean t6 = ctx.getBean("test3", TestBean.class);
		System.out.println("t6 : " + t6);
		
		
		ctx.close();
	}
}
