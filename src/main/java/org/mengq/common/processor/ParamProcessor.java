package org.mengq.common.processor;

import org.mengq.common.annotation.Form;
import org.mengq.common.annotation.QueryParam;
import org.mengq.common.binder.DefaultParamBinder;
import org.mengq.common.binder.FormParamBinder;
import org.mengq.common.binder.QueryParamBinder;
import org.mengq.common.holder.HttpServletRequestHolder;
import org.springframework.core.MethodParameter;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 17:14
 * @Description TODO
 */
public class ParamProcessor {

    public Object resolveParam(HttpServletRequest request, MethodParameter methodParameter){
        DefaultParamBinder binder;
        HttpServletRequestHolder holder = new HttpServletRequestHolder(request);
        Class<?> clazz = methodParameter.getParameterType();
        String v = null;
        if(methodParameter.getParameter().isAnnotationPresent(QueryParam.class)) {
            binder = new QueryParamBinder(holder);
            QueryParam annotation = methodParameter.getParameter().getAnnotation(QueryParam.class);
            v = binder.get(annotation.key());
            if(annotation.required() && (v == null || v.isEmpty())) {
                throw new RuntimeException("parameter " + annotation.key() + " is empty.");
            } else if((v == null || v.isEmpty()) && annotation.defaultVal() != null && !annotation.defaultVal().isEmpty()){
                v = annotation.defaultVal();
            }
        } else if(methodParameter.getParameter().isAnnotationPresent(Form.class)) {
            binder = new FormParamBinder(holder);
            Form annotation = methodParameter.getParameter().getAnnotation(Form.class);
            v = binder.get(annotation.key());
            if(annotation.required() && (v == null || v.isEmpty())) {
                throw new RuntimeException("parameter " + annotation.key() + " is empty.");
            } else if((v == null || v.isEmpty()) && annotation.defaultVal() != null && !annotation.defaultVal().isEmpty()){
                v = annotation.defaultVal();
            }
        }
        return cast(v,clazz);
    }

    private Object cast(String val,Class clazz) {
        if(Integer.class == clazz || int.class == clazz) {
            return Integer.parseInt(val);
        }
        if(Double.class == clazz || double.class == clazz) {
            return Double.parseDouble(val);
        }
        if(Float.class == clazz || float.class == clazz) {
            return Float.valueOf(val);
        }
        if(Long.class == clazz || long.class == clazz) {
            return Long.valueOf(val);
        }
        if(Short.class == clazz || short.class == clazz) {
            return Short.valueOf(val);
        }
        if(Boolean.class == clazz || boolean.class == clazz) {
            return Boolean.valueOf(val);
        }
        return val;

    }
}
