package cn.itcast.chapter05.entity;
import java.util.*; 
public class OnlineUser {
	private OnlineUser() {}
	private static OnlineUser instance = new OnlineUser();
	public static OnlineUser getInstance() {
		return instance;
	}
	private Map userMap=new HashMap<>();
	// ���û�������б�
	public void addUser(User user) {
		userMap.put(user.getId(), user.getUsername());
	}
	// ���û��Ƴ��б�
	public void removeUser(User user) {
		userMap.remove(user.getId());
	}
	// �����û��б�
	public Map getOnlineUsers() {
		return userMap;
	}
}
