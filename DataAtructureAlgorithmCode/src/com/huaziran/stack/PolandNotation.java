package com.huaziran.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        //创建一个中缀表达式
        String expression = "1+((2+3)*4)/2-5";  //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> inseSufferfixExpression = toInfixExpression(expression);
        System.out.println("中缀表达式：" + inseSufferfixExpression);
        List<String> prseSufferfixExpression = parseSufferfixExpression(inseSufferfixExpression);
        System.out.println("后缀表达式：" + prseSufferfixExpression); //后缀表达式：[1, 2, 3, +, 4, *, +, 5, -]
        int re = calculate(prseSufferfixExpression);
        System.out.println("再将其计算的结果：" + re);

        /*
        //定义一个逆波兰表达式
        //(30+4)*5-6
//        String sufferxExpression = "30 4 + 5 * 6 -";
        //4*5-8+60+8/2  = 76
        String sufferxExpression = "4 5 * 8 - 60 + 8 2 / +";
        //    思路：
//    1、从左至右扫描，将3和4压入堆栈；
//    2、遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
//    3、将5入栈；
//    4、接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
//    5、将6入栈；
//    6、最后是-运算符，计算出35-6的值，即29，由此得出最终结果
        List<String> list =  getListStrings(sufferxExpression); //将表达式放入到数组中   //将数组中的数传给栈进行计算
        System.out.println("数组遍历结果：" + list);
        int result = calculate(list);
        System.out.println("计算的结果：" + result);
*/
    }
    //将中缀表达式转化成对应的list
    public static List<String > toInfixExpression(String s){
        //定义一个list，存放中缀表达式字符串
        List<String> ls = new ArrayList<String>();  //建立数组
        int i = 0;  //指针
        String str;  //对应的拼接
        char c; //每遍历到一个字符，就放到c中
        do {
            //如果c是一个非数字，我们需要加入到ls
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else { //如果是数字
                str = ""; //将str置空
                while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){
                    str += c;  //拼接多位数数字
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;  //返回数组
    }

    //定义一个方法：中缀表达式=>后缀表达式
    public static List<String> parseSufferfixExpression(List<String> list){
        //定义一个栈作为符号栈
        Stack<String> s1 = new Stack<String>();
        //定义一个数组存放中间结果=>后缀表达式
        List<String> s2 = new ArrayList<String>();
        //遍历list（中缀表达式）
        for (String item: list) {
            //如果是数，则直接加入s2数组
            if (item.matches("\\d+")){ //正则表达式
                s2.add(item);
            }else if (item.equals("(")){  //左小括号加入s1栈中
                s1.add(item);
            }else if (item.equals(")")){ //右边小括号，则一次弹出s1中的运算符，压入s2中，知道遇到左括号为止，消除一对括号
               while (!s1.peek().equals("(")){
                   s2.add(s1.pop());
               }
               s1.pop(); //弹出遇到的左括号，达到消除的问题
            }else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中,再次转到(4. 1)与s1中新的栈顶运算符相比较
                //问题:我们缺少一个比较优先级高低的方法，所以创建一个方法判断:Operation
                while (s1.size() !=0 && Operation.getValue(item) <= Operation.getValue(s1.peek())){
                    s2.add(s1.pop()); //将s1栈顶的运算符弹出并加入到s2中
                }
                //还需要将item压入s1栈中
                s1.add(item);
            }
        }
        //将s1中剩余的元素依次弹出加入s2中
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;  //将数组返回;
    }

    //将表达式转换相应的值放入数组中
    public static List<String> getListStrings(String sufferxExpression){
        String[] split = sufferxExpression.split(" "); //将sufferxExpression分割（空格为标准）
        List<String> list = new ArrayList<String>(); //建立数组
        for (String ele: split){   //遍历分割得到的值
            list.add(ele); //添加到数组中
        }
        return list;  //返回一个数组
    }

//    利用栈来计算（后缀表达式）
    public static int calculate(List<String> ls){
        //穿点一个栈
        Stack<String> stack = new Stack<String>();
//        遍历list
            for(String item : ls){
                //使用正则表达式
                if (item.matches("\\d+")){   //匹配多位数
                    //入栈
                    stack.push(item);
                }else{
                    //如果不是数则取出两个数
                    int num2 =  Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    int result = 0;
                    if (item.equals("+")){
                        result = num1 + num2;
                    }else if(item.equals("-")){
                        result = num1 - num2;
                    }else if (item.equals("*")){
                        result = num2 * num1;
                    }else if (item.equals("/")){
                        result = num1 / num2;
                    }else{
//                        System.out.println("运算符有问题！！");
                        throw new RuntimeException("运算符错误！！");
                    }
                    //将算算的的结果入栈
                    stack.push("" + result);
                }
            }
            //最后输出在stack中的结果（栈中最后一个数）
        return Integer.parseInt(stack.pop());
    }
}
class Operation{
    private static int ADD = 1;
    private static int SUM = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String opertion){
        int rs = 0;
        switch (opertion){
            case "+":
                rs = ADD;
                break;
            case "-":
                rs = SUM;
                break;
            case "*":
                rs = MUL;
                break;
            case "/":
                rs = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return rs;
    }
 }


