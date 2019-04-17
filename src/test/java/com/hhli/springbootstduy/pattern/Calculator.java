package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 9:38
 * @description
 */
public enum  Calculator {
    Add("+"){
        @Override
        public int exec(int a, int b) {
            return a +b;
        }
    },
    Sub("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };
    String value="";
    private  Calculator(String value){
        this.value = value;
    }

    //获取枚举成员
    public String getValue() {
        return value;
    }

    //声明一个抽象函数
    public  abstract  int exec(int a, int b);
}
