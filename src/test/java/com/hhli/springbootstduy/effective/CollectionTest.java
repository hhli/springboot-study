package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019-10-08 11:07
 * @description 集合测试
 */
public class CollectionTest {

    public static void main(String[] args) {
        //ArrayList strList = new ArrayList();
        //strList.add("11");
        //strList.add(new Date());

        //Object[] temp =  new Date[6];
        //System.out.println(new ArrayList<String>() instanceof ArrayList);
        //System.out.println(new ArrayList<Date>() instanceof ArrayList);
        //ArrayList<?> strList = new ArrayList<>();
        //strList.add(null);
        //
        //List<String> strList = new ArrayList<>();
        //List<Date> dateList = new ArrayList<>();
        //List<?> collectionTest = strList;
        //collectionTest = dateList;

        //String[] temp = pickTwo("1", "44444", "3");
        //System.out.println(Arrays.toString(temp));
        //List.of("1", "2");

        Integer i1 = 1111;
        int i2 = 1111;
        System.out.println(i1 == i2);
    }


    //static <T> T[] toArray(T... args){
    //    return args;
    //}
    //
    //static <T> T[] pickTwo(T a, T b, T c){
    //    T[] temp = null;
    //    switch (ThreadLocalRandom.current().nextInt(3)){
    //        case 0: temp = toArray(a, b);break;
    //        case 1: temp = toArray(b, c);break;
    //        case 2: temp = toArray(a, c);break;
    //
    //    }
    //
    //    return  temp;
    //}

}
