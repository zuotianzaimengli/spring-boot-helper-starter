package org.mengq.common.binder;

import org.mengq.common.holder.HttpServletRequestHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 16:56
 * @Description TODO
 */
public class FormParamBinder extends DefaultParamBinder{

    public FormParamBinder(HttpServletRequestHolder holder) {
        super(holder);
    }

    @Override
    protected String get(HttpServletRequest request, String key) {
       return getByParameter(request,key);
    }
}
