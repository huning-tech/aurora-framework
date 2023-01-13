package tech.huning.aurora.util;

import tech.huning.aurora.specs.exception.SystemException;
import tech.huning.aurora.specs.model.ResultCode;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * HttpServlet工具类
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class HttpServletUtil {

    /**
     *  获取URI
     * @param servletRequest 请求
     * @return uri
     * @throws SystemException 系统异常
     */
    public static String getUri(ServletRequest servletRequest) throws SystemException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest req = (HttpServletRequest)servletRequest;
            return req.getRequestURI();
        }
        else{
            throw new SystemException(ResultCode.FAILURE);
        }
    }

    /**
     * 获取HttpServletRequest
     * @param servletRequest 请求
     * @return 请求
     * @throws SystemException 系统异常
     */
    public static HttpServletRequest getHttp(ServletRequest servletRequest) throws SystemException {
        if(servletRequest instanceof HttpServletRequest){
            return (HttpServletRequest)servletRequest;
        }
        else{
            throw new SystemException(ResultCode.FAILURE);
        }
    }

}
