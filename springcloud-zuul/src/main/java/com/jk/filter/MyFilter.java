package com.jk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/5 16:34
 * @Created by ${jmh}
 */
@Component
public class MyFilter extends ZuulFilter {


    /*
       filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
           pre：路由之前 ,先执行过滤器再执行后台方法
           routing：路由之时, 执行完后台方法在执行过滤器
           post： 路由之后, 执行完后台方法在执行过滤器
           error：发送错误调用，如果请求正常没有错误，则不需要执行业务逻辑判断
    */
    @Override
    public String filterType() {
        System.out.println("第一个过滤请求的类型。。" + System.currentTimeMillis());
        return "pre";
    }


    //过滤的顺序
    @Override
    public int filterOrder() {
        System.out.println("过滤的顺序");
        return 0;
    }

    //这里可以写逻辑判断，是否要过滤，true,永远过滤。
    @Override
    public boolean shouldFilter() {
        System.out.println("是否要过滤");
        return true;
    }


    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {
        System.out.println("业务逻辑处理");

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String flag = request.getParameter("flag");
        System.out.println(url);
        System.out.println(method);
        System.out.println(flag);
        //Object obj = request.getSession().getAttribute("sessionUser");
        if(StringUtils.isEmpty(flag) /*|| obj == null*/){
            try {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);
                HttpServletResponse response = requestContext.getResponse();
                //让浏览器用utf8来解析返回的数据
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                //servlet用UTF-8转码，而不是用默认的ISO8859
                response.setCharacterEncoding("utf-8");
                response.getWriter().write("请求需要传入flag标识符 或者 用户没有登录");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
