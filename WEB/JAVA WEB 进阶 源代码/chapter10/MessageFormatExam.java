package cn.itcast.chapter10;
import java.text.*;
public class MessageFormatExam {
	public static void main(String[] args) {
		String pattern = "On {0},{1} destroyed {2} houses "
				+ "and caused {3} of damage.";
		Object[] msgArgs = {"2010.11.03", "a hurricance", "100", "2000000"};
		MessageFormat mf = new MessageFormat(pattern);
		String result = mf.format(msgArgs);
		System.out.println(result);
	}
}
