package kr.co.softcampus.main;

/*
 *   #. Collection주입
 *      - Bean을 정의할 때 주입해야 하는 멤버가 Collection인 경우, Collection이 관리할 객체를 초기에 설정할 수 있다.
 * 
 * 
 */
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.TestBean;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		//List<String> 주입
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		List<String> list1 = t1.getList1();
		for(String name : list1)
			System.out.println("list1 : " + name);
		
		//List<Integer>주입
		List<Integer> list2 = t1.getList2();
		for(Integer i : list2)
			System.out.println("list2: " + i);
		
		//List<DataBean> 주입
		List<DataBean> list3 = t1.getList3();
		for(DataBean obj : list3)
			System.out.println("list3: " + obj);
		
		System.out.println("========================================");
		
		Set<String> set1 = t1.getSet1();
		for(String name : set1)
			System.out.println("set1: " + name);
		
		Set<Integer> set2 = t1.getSet2();
		for(Integer i : set2)
			System.out.println("set2: " + i);
		
		Set<DataBean> set3 = t1.getSet3();
		for(DataBean obj : set3)
			System.out.println("set3: " + obj);
		
		System.out.println("========================================");
		
		Map<String, Object> map1 = t1.getMap1();
		String name = (String)map1.get("a1");
		Integer num = (Integer)map1.get("a2");
		DataBean dataBean = (DataBean)map1.get("a3");
		DataBean dataBean2 = (DataBean)map1.get("a4");
		List<String> list = (List<String>)map1.get("a5");
		
		System.out.println(name);
		System.out.println(num);
		System.out.println(dataBean);
		System.out.println(dataBean2);
		for(String str : list)
			System.out.println(str);
		
		System.out.println("========================================");
		
		Properties prop = t1.getProp1();
		String s1 = prop.getProperty("p1");
		String s2 = prop.getProperty("p2");
		String s3 = prop.getProperty("p3");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		ctx.close();
	}
}
