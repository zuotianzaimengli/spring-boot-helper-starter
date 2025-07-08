package org.mengq.common.binder;


import org.mengq.common.holder.HttpServletRequestHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 16:51
 * @Description TODO
 */
public class QueryParamBinder extends DefaultParamBinder{

    public QueryParamBinder(HttpServletRequestHolder holder) {
        super(holder);
    }

    @Override
    protected String get(HttpServletRequest request, String key) {
        return getByParameter(request,key);
    }
}
