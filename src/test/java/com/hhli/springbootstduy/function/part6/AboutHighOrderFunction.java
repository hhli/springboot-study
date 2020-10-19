package com.hhli.springbootstduy.function.part6;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class AboutHighOrderFunction {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        plusOffset(a::getId,a::setId);
        plusOffset(b::getId,b::setId);
        plusOffset(c::getId,c::setId);
    }
    
    public static void plusOffset(Supplier<Integer> sup,Consumer<Integer> cons) {
        cons.accept(sup.get() + 100);
    }
    
    public static class A {
        Integer id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class B {
        Integer id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class C {
        Integer id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

}
