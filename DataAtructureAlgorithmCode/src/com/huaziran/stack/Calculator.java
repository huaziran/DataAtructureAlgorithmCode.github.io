package com.huaziran.stack;

public class Calculator {

    public static void main(String[] args) {
        //根据思路，完成实现
        String expression = "3+2*6-20+5";
        ArrayStack2 numStack2 = new ArrayStack2(10);
        ArrayStack2 operStack2 = new ArrayStack2(10);
        //定义相关 变量
        int index = 0; //用于扫描
        int numb1 = 0;
        int numb2 = 0;
        int oper = 0;
        int result = 0;
        char ch  = ' '; //将每个扫描的值存放
        String keepNum  = "";
        //开始 while循环 的扫描 expression
        while(true){
            //依次得到expression  的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是否为空，然后处理
            if (operStack2.isOper(ch)){//如果是运算符
//                判断当前的符号 栈是否为空
                if (!operStack2.isEmpty()){
                    //当前操作符小于或等于栈中的操作符，pop两个数
                    if (operStack2.priority(ch) <= operStack2.priority(operStack2.peek())){
                        numb1 = numStack2.pop();
                        numb2 = numStack2.pop();
                        oper = operStack2.pop();
                        result = numStack2.cal(numb1, numb2, oper);
                        //把运算的结果进数栈
                        numStack2.push(result);
                        //然后将当前的操作符入符号栈
                        operStack2.push(ch);
                    } else{
                        //当前操作符大于或等于栈中的操作符，直接入栈
                        operStack2.push(ch);
                        //处理多维位数

                    }
                }else{
                    //如果是空栈
                    operStack2.push(ch);
                }
            }else { //如果是数栈
//                numStack2.push(ch - 48); //
                //处理多位数
                keepNum += ch;
                //判断是否我最后一个
                if (index == expression.length() - 1){
                    numStack2.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个是否是字符
                    if (operStack2.isOper(expression.substring(index+1, index+2).charAt(0))){
                        //如果是则入栈
                        numStack2.push(Integer.parseInt(keepNum));
                        //将KeepNum清空、
                        keepNum = "";
                    }
                }
            }
            //让index + 1，是否到最后  .
            index ++;
            if (index >= expression.length()){
                break;
            }
        }
        //如果 符号栈 空
        while (true){
            if (operStack2.isEmpty()){
                break;
            }
            numb1 = numStack2.pop();
            numb2 = numStack2.pop();
            oper = operStack2.pop();
            result = numStack2.cal(numb1, numb2, oper);
            numStack2.push(result);
        }
        int res = numStack2.pop();
        System.out.printf("计算：%s = %d",expression,res);
    }

}

//定义一个ArrayStack 表示栈
class ArrayStack2 {
    private int maxSize; //栈的大小
    private int[] stack;
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //是否栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top += 1;
        stack[top] = value;
        System.out.println(top);

    }

    //出栈-pop，将 栈顶的数据返回
    public int pop() {
        //判断是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top -= 1;
        return value;
    }

    //遍历栈：需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        System.out.println(top);
        for (int i = top; i >= 0; i--) {
//            int value = stack[i];
//            System.out.println(value);
            System.out.println(top);
            System.out.printf("stack[%d]:%d\n", i, stack[i]);
        }
    }
    //返回运算符的优先级，由程序原来定，优先级使用数字表示
    //数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1; //假设只有加减乘除
        }
    }
    //判断是不会死一个运算符
    public boolean isOper(char oper){
        return oper == '+' ||  oper == '-' || oper == '*' || oper == '/';
    }

    //返回当前栈的栈顶,不是pop
    public int peek(){
        return stack[top];
    }
//计算
    public int cal(int numb1,int numb2,int oper){
        int result = 0; //用于存放计算的结果
        switch (oper){
            case '+':
                result = numb2 + numb1;
                break;
            case '-':
                result = numb2 - numb1;  //注意顺序，出栈换位
                break;
            case '*':
                result = numb2 * numb1;
                break;
            case '/':
                result = numb2 / numb1;
                break;
            default:
                break;
        }
        return result;
    }

}