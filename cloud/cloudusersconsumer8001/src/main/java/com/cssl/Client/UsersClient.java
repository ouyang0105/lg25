package com.cssl.Client;

import com.cssl.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "GATEWAT-ZUUL",fallback = UsersClinetImpl.class,
path = "/gateway/provider")
public interface UsersClient {

    @RequestMapping("/hello")
    public Users login(@SpringQueryMap Users users,@RequestHeader(name = "token") String token);

    @PostMapping("/cx")
    public String cx(@RequestParam(name = "msg") String msg);

    @PostMapping("/map")
    public Map<String,Object> map(@RequestParam Map<String,Object> map);
}
