package kr.co.softcampus.beans;

/*
 *   #. 생성자를 통한 기본 자료형 주입(String형 포함)
 * 
 */
public class TestBean1 {

	private int data1;
	private double data2;
	private String data3;
	
	public TestBean1() {
		System.out.println("TestBean()의 기본 생성자");
		this.data1 = 0;
		this.data2 = 0.0;
		this.data3 = null;
	}
	
	public TestBean1(int data1) {
		System.out.println("TestBean()생성자 : int형 변수 1개");
		this.data1 = data1;
		this.data2 = 0.0;
		this.data3 = null;
	}
	
	public TestBean1(double data2) {
		System.out.println("TestBean()생성자 : double형 변수 1개");
		this.data1 = 0;
		this.data2 = data2;
		this.data3 = null;
	}
	
	public TestBean1(String data3) {
		System.out.println("TestBean()생성자 : String형 변수 1개");
		this.data1 = 0;
		this.data2 = 0.0;
		this.data3 = data3;
	}
	
	public TestBean1(int data1, double data2, String data3) {
		System.out.println("TestBean()생성자 : 모든 매개변수");
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}
	
	public void printData() {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
	}
}
