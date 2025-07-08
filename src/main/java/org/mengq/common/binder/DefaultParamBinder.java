package org.mengq.common.binder;

import org.mengq.common.holder.HttpServletRequestHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 16:42
 * @Description TODO
 */
public abstract class DefaultParamBinder {

    private final HttpServletRequestHolder holder;

    public DefaultParamBinder(HttpServletRequestHolder holder){
        this.holder = holder;
    }

    public String get(String key){
        if(holder == null) {
            throw new RuntimeException("can not find any request holder.");
        }
        return get(holder.getRequest(),key);
    }

    protected abstract String get(HttpServletRequest request,String key);

    protected final String getByParameter(HttpServletRequest request,String key){
        return request.getParameter(key);
    }
}
