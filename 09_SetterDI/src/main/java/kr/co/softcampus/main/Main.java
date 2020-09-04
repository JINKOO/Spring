package kr.co.softcampus.main;

/*
 *   #. Setter 메소드를 통한 주입.
 *      - Bean Class를 정의할 때 Bean객체가 가지고 있을 기본 값을 생성자가 아닌
 *        Setter메소드를 통하여 주입할 수 있다. 
 * 
 * 
 * 
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.TestBean;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		int data1 = t1.getData1();
		double data2 = t1.getData2();
		boolean data3 = t1.isData3();
		String data4 = t1.getData4();
		DataBean data5 = t1.getData5();
		DataBean data6 = t1.getData6();
		
		System.out.println("data1: " + data1);
		System.out.println("data2: " + data2);
		System.out.println("data3: " + data3);
		System.out.println("data4: " + data4);
		System.out.println("data5: " + data5);
		System.out.println("data6: " + data6);
		
		ctx.close();
	}
}
