package com.cssl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();
        System.out.println("AuthorityFilter"+ctx.sendZuulResponse());
        return ctx.sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String token=request.getHeader("token");
        System.out.println("token="+token);
        if(token==null||token.isEmpty()){
            System.out.println("令牌为空，不能继续传递请求！");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("text/html;charset=utf-8");
            ctx.setResponseBody("{\"msg\":\"令牌为空，不能继续传递请求！\"}");
        }else {
            System.out.println("继续传递请求！");
            ctx.setSendZuulResponse(true);

        }
        return null;
    }
}
