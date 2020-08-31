package kr.co.softcampus.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {
	
	public TestBeanPostProcessor() {
		// TODO Auto-generated constructor stub
		System.out.println("TestBeanPostProcessor의 생성자");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BEFORE");
		switch(beanName) {
		case "t1":
			System.out.println("id가 t1인 bean객체 생성");
			break;
		case "t2":
			System.out.println("id가 t2인 bean객체 생성");
			break;
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("AFTER");
		return bean;
	}

}
