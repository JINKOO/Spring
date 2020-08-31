package kr.co.softcampus.main;


/*
 *   #. BeanPostProcessor
 *      - init-method수행 전 BeanPostProcessor를 implement하는 class를 만들고,
 *        postProcessBeforeInitialization, postProcessAfterInitialization을 Override하면,
 *        객체가 생성 될 때,생성자 호출하고 나서 
 *        init-method호출 전과 후의 다른 메소드를 호출 할 수 있다.
 *        
 *        즉, 생성자 -> before -> init-method -> after
 * 
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.softcampus.beans.TestBean1;
import kr.co.softcampus.beans.TestBean2;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		System.out.println("t1 : " + t1);
		
		System.out.println("=======================================");
		
		TestBean2 t2 = ctx.getBean("t2", TestBean2.class);
		System.out.println("t2 : " + t2);
		
		ctx.close();
	}
}
