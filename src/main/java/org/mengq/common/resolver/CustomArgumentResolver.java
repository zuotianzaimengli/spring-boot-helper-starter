package org.mengq.common.resolver;

import org.mengq.common.annotation.Form;
import org.mengq.common.annotation.QueryParam;
import org.mengq.common.processor.ParamProcessor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 17:04
 * @Description TODO
 */
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameter().isAnnotationPresent(QueryParam.class) || methodParameter.getParameter().isAnnotationPresent(Form.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return resolve((HttpServletRequest) nativeWebRequest.getNativeRequest(),methodParameter);
    }

    private Object resolve(HttpServletRequest request,MethodParameter methodParameter){
        ParamProcessor paramProcessor = new ParamProcessor();
        return paramProcessor.resolveParam(request,methodParameter);
    }
}
