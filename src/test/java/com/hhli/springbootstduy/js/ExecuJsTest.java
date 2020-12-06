package com.hhli.springbootstduy.js;

import javax.script.*;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2020-12-04 16:18
 * @description java执行js测试
 */
public class ExecuJsTest {

    public static void main(String[] args) throws Exception {

        // 获取JS执行引擎
        ScriptEngine se = new ScriptEngineManager().getEngineByName("javascript");
        // 获取变量
        Bindings bindings = se.createBindings();
        bindings.put("number", 3);
        se.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("输入的参数【" + a + "】 + 【" + b + "】");
            Object obj = se.eval(new FileReader("test.js"));
            System.out.println("obj==" + obj);
            // 是否可调用
            if (se instanceof Invocable) {
                Invocable in = (Invocable) se;
                Double result = (Double) in.invokeFunction("add", a, b);
                System.out.println("获得的结果：" + result);

            }

        }

    }

}
