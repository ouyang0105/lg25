package com.cssl.filter;

import com.cssl.Tools.Get_Ip;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class IpFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String ip= Get_Ip.getIpAddr(request);

        System.out.println("IpFilter ip="+ip);
        List<String> ilist=new ArrayList<String>();
        ilist.add("127.0.0.1");
       ilist.add("192.168.100.1");
        if(ilist.contains(ip)){
            System.out.println("IP地址校验通过！");
            ctx.setSendZuulResponse(true);
        }else {
            System.out.println("IP地址校验不通过！");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("text/html;charset=utf-8");
            ctx.setResponseBody("{\"msg\":\"IP地址校验不通过！\"}");
        }

       // ctx.setSendZuulResponse(true);

        return null;
    }



}
