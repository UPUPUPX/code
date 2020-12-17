package cn.itcast.chapter04.decorator;
/**
 * 手机 
 */
interface Phone{
	// 手机的功能
	void action();
}
/**
 * 非智能手机 
 */
class Non_SmartPhone implements Phone{
	// 非智能机具有打电话的功能
	public void action() {
		System.out.println("可以打电话");
	}
}
/**
 * 智能手机 
 */
class SmartPhone implements Phone{
	private Phone nonSmartPhone;
	public SmartPhone(Phone nonSmartPhone){
		this.nonSmartPhone = nonSmartPhone;
	}
	//智能机拥有打电话和玩愤怒的小鸟的功能
	public void action() {
		nonSmartPhone.action();
		System.out.println("可以玩愤怒的小鸟"); // 在非智能机基础上，功能增强
	}
}
public class PhoneDemo {
	public static void main(String[] args) {
		Phone nPhone = new Non_SmartPhone(); 
		System.out.println("--------------手机装饰前--------------");
		nPhone.action();
		Phone smartPhone = new SmartPhone(nPhone);
		System.out.println("--------------手机装饰后--------------");
		smartPhone.action();
	}
}
