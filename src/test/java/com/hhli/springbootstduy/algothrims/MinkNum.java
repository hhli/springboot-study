package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/5/1 16:36
 * @description  字典序最小k数
 */
public class MinkNum {

    public static void main(String[] args) {
        //System.out.println(findKthNumber(1000, 1000));
        //System.out.println(findKthNumber(13, 5));
        //System.out.println(findKthNumber(13, 6));
        //System.out.println(findKthNumber(20, 15));
        //System.out.println(findKthNumber(10, 3));
        long start = System.currentTimeMillis();
        System.out.println(findKthNumber(4289384 ,1922239));
        long end = System.currentTimeMillis();
        System.out.println("time waste:" + (end -start) + "mills");
    }

    public static int findKthNumber(int n, int k) {
        //最终需要返回的数据
        int ret = 1;
        //当前计算的基准数据
        int base = 1;
        // 循环的次数
        int loop = 1;
        while(loop != k){
            if(base * 10 <= n){
                base = base * 10;
                ret = base;
                //System.out.printf("%d,", ret);
            }else{
                if(ret+1 > n){
                    ret = ret/10 + 1;
                    base = ret;
                    //System.out.printf("%d,", ret);
                }else{
                    if(loop + 9 < n){
                        ret = ret +9;
                        loop = loop + 9;
                    }else{
                        ret  = ret + (n -loop);
                        break;
                    }

                    ret = ret+1;
                    if(ret%10 == 0){
                        while (ret%10 == 0){
                            //9、99、999的情况
                            if(Math.log10(ret) == 0){
                                ret = ret * 10;
                                base = ret;
                            }else{
                                base = ret/10;
                                ret = base;
                            }
                        }
                    }
                    //System.out.printf("%d,", ret);
                }
            }

            loop ++;
        }

        return  ret;
    }
}
