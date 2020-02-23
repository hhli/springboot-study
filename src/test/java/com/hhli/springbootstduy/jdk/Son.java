package com.hhli.springbootstduy.jdk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 李辉辉
 * @date 2019-11-13 20:52
 * @description
 */
@Setter
@Getter
@ToString(callSuper=true)
public class Son extends Father{

    private static final long serialVersionUID = 1321963342771256723L;

    private long processId;

    public long getProcessId() {
        return processId;
    }

    public void setProcessId(long processId) {
        this.processId = processId;
    }

    public Son(){
        super(0);
    }

    public Son(long processId, long id){
        super(id);
        this.processId = processId;
    }

}
