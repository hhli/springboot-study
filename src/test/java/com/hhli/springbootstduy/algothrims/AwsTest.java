package com.hhli.springbootstduy.algothrims;

import java.util.*;

/**
 * @author 李辉辉
 * @date 9/26/22 3:57 PM
 * @description
 */
public class AwsTest {
    private static Map<Character, Boolean>  ch2Exist = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(isValid("(a)"));
    }


    public static boolean isValid(String s){
        if(s == null){
            return false;
        }

        if (s.equals("")){
            return true;
        }

        ch2Exist.put('{', true);
        ch2Exist.put('}', true);
        ch2Exist.put('[', true);
        ch2Exist.put(']', true);
        ch2Exist.put('(', true);
        ch2Exist.put(')', true);

        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if(ch2Exist.containsKey(c)){
                charList.add(c);
            }
        }

        if(charList.size() % 2 > 0){
            return false;
        }

        char c  = charList.get(0); // 当前已经遍历的字符

        while(!charList.isEmpty()){
            int size = charList.size();
            char cleft  = charList.get(0);
            char cright =  charList.get(size-1);
            if(c == '{'){
                if(cleft == '{' && cright == '}'){
                    charList.remove(0);
                    charList.remove(size-1);
                    c = '[';
                    continue;
                }else {
                    return false;
                }
            }else if(c == '['){
                if(cleft == '{' && cright == '}'){
                    charList.remove(0);
                    charList.remove(size-1);
                    c = '(';
                    continue;
                }else if(cleft == '[' && cright == ']'){
                    charList.remove(0);
                    charList.remove(size-1);
                    c = '(';
                    continue;
                }else {
                    return false;
                }

            }else if(c == '('){
                if(cleft == '[' && cright == ']'){
                    charList.remove(0);
                    charList.remove(size-1);
                    continue;
                }else if((cleft == '(' && cright == ')') ||(cleft == ')' && cright == '(')){
                    charList.remove(0);
                    charList.remove(size-1);
                    continue;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }


        return true;

    }


    List<Emp> getSuggestedMentors(Emp loggedIn) {
        List<Emp> montors = new ArrayList<>();

        Emp cur = loggedIn;
        Stack<Friend> stack = new Stack<>();
        Map<Long, Boolean> id2Exist = new HashMap<>();
        id2Exist.put(loggedIn.id, true);

        int index = 0;
        while(!cur.friends.isEmpty()){
            if(stack.size() == 4 ){
                Friend f = stack.pop();
                if(f.emp.level > loggedIn.level){
                    montors.add(stack.peek().emp);
                }

                cur = stack.peek().emp;
                index = stack.peek().index + 1;
                continue;
            }

            if(index >= cur.friends.size()){
                stack.pop();
                cur = stack.peek().emp;
                index = stack.peek().index + 1;
            }

            Emp temp = cur.getFriends().get(index);
            if(!id2Exist.containsKey(temp.id)){
                Friend f = new Friend();
                f.emp = temp;
                f.index = index;
                stack.push(f);
                id2Exist.put(temp.id, true);
                cur =  temp;
                index = 0;
            }
        }

        return montors;
    }


}

class Friend {
    Emp emp;
    int index; //当前员工在好友列表的下标
}

class Emp {
    long id;
    String name;
    String title; // This will match across employees with the same job.
    int level; // A higher number means more senior
    List<Emp> friends;


    List<Emp> getFriends() {
        return this.friends;
    }
}



