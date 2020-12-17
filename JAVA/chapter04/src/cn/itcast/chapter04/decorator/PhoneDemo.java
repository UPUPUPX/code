package cn.itcast.chapter04.decorator;
/**
 * �ֻ� 
 */
interface Phone{
	// �ֻ��Ĺ���
	void action();
}
/**
 * �������ֻ� 
 */
class Non_SmartPhone implements Phone{
	// �����ܻ����д�绰�Ĺ���
	public void action() {
		System.out.println("���Դ�绰");
	}
}
/**
 * �����ֻ� 
 */
class SmartPhone implements Phone{
	private Phone nonSmartPhone;
	public SmartPhone(Phone nonSmartPhone){
		this.nonSmartPhone = nonSmartPhone;
	}
	//���ܻ�ӵ�д�绰�����ŭ��С��Ĺ���
	public void action() {
		nonSmartPhone.action();
		System.out.println("�������ŭ��С��"); // �ڷ����ܻ������ϣ�������ǿ
	}
}
public class PhoneDemo {
	public static void main(String[] args) {
		Phone nPhone = new Non_SmartPhone(); 
		System.out.println("--------------�ֻ�װ��ǰ--------------");
		nPhone.action();
		Phone smartPhone = new SmartPhone(nPhone);
		System.out.println("--------------�ֻ�װ�κ�--------------");
		smartPhone.action();
	}
}
