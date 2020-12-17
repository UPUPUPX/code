package cn.itcast.chapter10;
import java.text.MessageFormat;
import java.util.Date;
public class MessageFormatExam1 {
	public static void main(String[] args) {
		String pattern = "At {0,time} on {0,date}, {1} destroyed "
				+ "{2,number,integer} houses and caused {3} of damage.";
		Object[] msgArgs = { new Date(System.currentTimeMillis()),
				"a hurricance", new Integer(7), new Double(2000000) };
		MessageFormat mf = new MessageFormat(pattern);
		String result = mf.format(msgArgs);
		System.out.println(result);
	}
}
