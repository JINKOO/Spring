package kr.co.softcampus.beans;

public class TestBean3 {

	public TestBean3() {
		// TODO Auto-generated constructor stub
		System.out.println("TestBean3의 생성자");
	}
	
	public void bean3_init() {
		System.out.println("TestBean3의 init()");
	}
	
	public void bean3_destroy() {
		System.out.println("TestBean3의 destroy()");
	}
	
	public void default_init() {
		System.out.println("TestBean3의 default_init()");
	}
	
	public void default_destroy() {
		System.out.println("TestBean3의 default_destroy()");
	}
}
