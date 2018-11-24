package beancopy;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2018/11/24 10:57
 * @description
 */
@Data
public class Home implements Serializable, Cloneable{

    private static final long serialVersionUID = 6665989869782355932L;

    /**
     * 成家日期
     */
    private Date beginDate;

    @Override
    public Home clone(){
        try {
            Home h =    (Home) super.clone();
            if(Objects.nonNull(beginDate)){
                h.setBeginDate((Date) beginDate.clone());
            }

            return  h;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
