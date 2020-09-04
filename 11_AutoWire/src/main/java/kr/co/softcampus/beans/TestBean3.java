package kr.co.softcampus.beans;

public class TestBean3 {

	private int data1;
	private String data2;
	private DataBean2 data3;
	private DataBean2 data4;
	
	public TestBean3() {
		System.out.println("기본 생성자");
	}
	
	public TestBean3(int data1, String data2) {
		System.out.println("매개변수가 2개(int, String)인 생성자");
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public TestBean3(DataBean2 data3, DataBean2 data4) {
		System.out.println("매개변수가 2개(모두 DataBean2형)인 생성자");
		this.data3 = data3;
		this.data4 = data4;
	}
	
	public TestBean3(int data1, String data2, DataBean2 data3, DataBean2 data4) {
		System.out.println("매개변수 모두있는 생성자");
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public DataBean2 getData3() {
		return data3;
	}

	public void setData3(DataBean2 data3) {
		this.data3 = data3;
	}

	public DataBean2 getData4() {
		return data4;
	}

	public void setData4(DataBean2 data4) {
		this.data4 = data4;
	}
	
	
}
