import java.util.List;
import java.util.Random;
public class Operator {
	char operator;   //运算符
	int priority;    //优先级（1最高）

	/**
	 * 带参构造方法，用于随机生成运算符
	 * @param n   运算符个数，用于生成优先级
	 */
	public Operator(int n) {
		Random r=new Random();
		switch(r.nextInt(4)){
			case 0:
				operator='+';
				break;
			case 1:
				operator='-';
				break;
			case 2:
				operator='×';
				break;
			default:
				operator='÷';
		}
		priority=r.nextInt(n)+1;
	}


	/**
	 * 判断优先级是否重复
	 * 运算符列表的最后一项与前面所有项进行比较，如果出现优先级重复，则删掉最后一项
	 * @param list   运算符列表
	 * @return       重复返回true，否则返回false
	 */
	public static boolean isRepeated(List<Operator> list) {
		for(int i=0;i<list.size()-1;i++) 
			if(list.get(list.size()-1).priority==list.get(i).priority){
				list.remove(list.size()-1);
				return true;
			}
		return false;
	}

	@Override
	public String toString() {
		return operator+" : "+priority;
	}
}