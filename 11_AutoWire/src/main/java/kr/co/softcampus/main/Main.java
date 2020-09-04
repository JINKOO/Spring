package kr.co.softcampus.main;

/*
 *   #. AutoWire 자동 주입
 *      - Bean을 정의 할때, 주입할 객체는 생성자를 통한 주입 , Setter()를 통한 주입을 사용하였다.
 *      - Spring에서는 '객체'를 주입 할 때, 자동으로 주입 할 수 있다.
 *        byName
 *        byType
 *        constructor
 *      - 단 기본 자료형은 불가하다. 일일히 주입해줘야 한다.
 * 
 * 
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.TestBean1;
import kr.co.softcampus.beans.TestBean2;
import kr.co.softcampus.beans.TestBean3;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");

		// 1. 기존 Setter()를 사용한 객체 주입
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		System.out.println("obj1.getData1(): " + obj1.getData1());
		System.out.println("obj1.getData2(): " + obj1.getData2());

		System.out.println("============================================");

		// 2. ByName을 사용한 객체 자동 주입
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		System.out.println("obj2.getData1(): " + obj2.getData1());
		System.out.println("obj2.getData2(): " + obj2.getData2());

		System.out.println("============================================");

		// 3. ByType을 사용한 객체 자동 주입
		TestBean2 obj3 = ctx.getBean("obj3", TestBean2.class);
		System.out.println("obj3.getData1(): " + obj3.getData1());
		System.out.println("obj3.getData2(): " + obj3.getData2());

		System.out.println("============================================");

		// 4. 생성자를 사용한 객체 주입
		TestBean3 obj4 = ctx.getBean("obj4", TestBean3.class);
		System.out.println("obj4.getData1(): " + obj4.getData1());
		System.out.println("obj4.getData2(): " + obj4.getData2());
		System.out.println("obj4.getData1(): " + obj4.getData3());
		System.out.println("obj4.getData2(): " + obj4.getData4());

		System.out.println("============================================");

		// 5. 생성자를 사용한 객체 자동 주입
		TestBean3 obj5 = ctx.getBean("obj5", TestBean3.class);
		System.out.println("obj5.getData1(): " + obj5.getData1());
		System.out.println("obj5.getData2(): " + obj5.getData2());
		System.out.println("obj5.getData1(): " + obj5.getData3());
		System.out.println("obj5.getData2(): " + obj5.getData4());

		System.out.println("============================================");

		// 6. 생성자를 사용하여 일일이 주입
		TestBean3 obj6 = ctx.getBean("obj6", TestBean3.class);
		System.out.println("obj6.getData1(): " + obj6.getData1());
		System.out.println("obj6.getData2(): " + obj6.getData2());
		System.out.println("obj6.getData1(): " + obj6.getData3());
		System.out.println("obj6.getData2(): " + obj6.getData4());

		System.out.println("============================================");

		// 7. 기본 자료형은 생성자를 통한 주입, 참조 변수형은 생성자를 통한 autowire사용
		TestBean3 obj7 = ctx.getBean("obj7", TestBean3.class);
		System.out.println("obj7.getData1(): " + obj7.getData1());
		System.out.println("obj7.getData2(): " + obj7.getData2());
		System.out.println("obj7.getData1(): " + obj7.getData3());
		System.out.println("obj7.getData2(): " + obj7.getData4());

		System.out.println("============================================");
		
		// 8. default-autowire
		TestBean1 obj8 = ctx.getBean("obj8", TestBean1.class);
		System.out.println("obj8.getData1(): " + obj8.getData1());
		System.out.println("obj8.getData2(): " + obj8.getData2());
		
		System.out.println("============================================");
		
		// 9. default-autowire안 할 때.
		TestBean1 obj9 = ctx.getBean("obj9", TestBean1.class);
		System.out.println("obj9.getData1(): " + obj9.getData1());
		System.out.println("obj9.getData2(): " + obj9.getData2());

		ctx.close();
	}
}
