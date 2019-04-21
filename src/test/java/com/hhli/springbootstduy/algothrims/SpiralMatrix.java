package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/20 15:28
 * @description 螺旋矩阵练习
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        getPositionTest();
        System.out.println(getPositionValue(-2, 2));
    }

    /**
     *  获取对应位置的值
     *
     * @param x 对应位置横坐标
     * @param y 对应位置纵坐标
     * @return
     */
    public static int getPositionValue(int x, int y){
        //原点纵坐标
        int tempX = 0;
        //原点横坐标
        int tempY = 0;

        int xGap = 2;
        int yGap = -1;

        int ret = 1;
        //是否已经进行横向移动
        boolean hasMovedX = false;
        boolean isOver = true;
        while(isOver){
            if(hasMovedX){
                //进行纵向移动
                for (int i = 0; i < Math.abs(yGap); i++) {
                    if(tempX == x && tempY == y){
                        isOver = false;
                        break;
                    }
                    ret++;
                    if(Math.abs(yGap) == yGap){
                        tempY ++;
                    }else{
                        tempY --;
                    }
                }
                hasMovedX = false;
                if(yGap<0){
                    yGap = 1 -yGap;
                }else{
                    yGap = -1 - yGap;
                }
            }else{
                //进行横向移动
                for (int i = 0; i < Math.abs(xGap); i++) {
                    if(tempX == x && tempY == y){
                        isOver = false;
                        break;
                    }
                    ret++;
                    if(Math.abs(xGap) == xGap){
                        tempX ++;
                    }else{
                        tempX --;
                    }
                }

                hasMovedX = true;
                if(xGap < 0){
                    xGap = 1-xGap;
                }else{
                    xGap = -1 -xGap;
                }
            }
        }

        return ret;
    }


    public static void getPositionTest(){
        //1
        System.out.println(getPositionValue(0,0));
        //2
        System.out.println(getPositionValue(1,0));
        //3
        System.out.println(getPositionValue(2,0));

        //4
        System.out.println(getPositionValue(2,-1));
        //8
        System.out.println(getPositionValue(-1,0));
        //6
        System.out.println(getPositionValue(0,-1));
        //20
        System.out.println(getPositionValue(-1, -2));
        //26
        System.out.println(getPositionValue(-1, 2));
    }
}
