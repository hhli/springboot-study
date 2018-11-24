package beancopy;

import org.apache.commons.lang.SerializationUtils;

import java.util.Date;

/**
 * @author 李辉辉
 * @date 2018/11/24 10:59
 * @description java bean copy test
 * @数据 1w serialize 786ms  clone 6ms
 * @数据 10w  serialize 2376ms clone 9ms
 * @结论 如果进行大量的bean复制（或者对bean复制有性能要求），最好采用clone方法（以上测试基于单个字段）
 *@注意 clone的话 如果字段特别多，可能也影响性能，但是clone有一个好处，可以定制，比较灵活，不想复制的就不用处理。
 *@注意 我觉得native方法只适合处理同一块内存的对象， 比如杀掉进程或者网络传输就不适合了，两者各有使用场景吧
 */
public class CopyTest {

    public static void main(String[] args) {
        Person p1 = new Person();

        Home h = new Home();
        h.setBeginDate(new Date());

        p1.setHome(h);

        //序列化复制
        Person p2 = (Person) SerializationUtils.clone(p1);
        System.out.println(p1 == p2);
        System.out.println(p1.getHome() == p2.getHome());
        System.out.println(p1.getHome().getBeginDate() == p2.getHome().getBeginDate());


        // 克隆复制
        Person p3 = p1.clone();
        System.out.println(p1 == p3);
        System.out.println(p1.getHome() == p3.getHome());
        System.out.println(p1.getHome().getBeginDate() == p3.getHome().getBeginDate());

        Long start = System.currentTimeMillis();
        for(int i =0; i<100000; i++){
            SerializationUtils.clone(p1);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("SerializationUtils.clone waste time :%d ms\n",  (end -start));

        start = System.currentTimeMillis();
        for(int i =0; i<100000; i++){
            p1.clone();
        }
        end = System.currentTimeMillis();
        System.out.printf("clone waste time :%d ms\n",  (end -start));
    }
}
