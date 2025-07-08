package org.mengq.common.holder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author meng
 * @Date 2025/6/18 16:41
 * @Description TODO
 */
public class HttpServletRequestHolder {

    private HttpServletRequest request;

    public HttpServletRequestHolder(HttpServletRequest request){
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }
}
