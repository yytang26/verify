package com.tyy.aop.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:tyy
 * @date:2021/5/16
 */
public class LogUtil {



    /**
     * 获取客户端ip地址
     * */
    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if(!"".equals(ip) && !"unknown".equalsIgnoreCase(ip)){
            return ip;
        }
        ip = request.getHeader("X-Forwarder-For");
        if(!"".equals(ip) && !"unknown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个为真实ip
            int index = ip.indexOf(",");
            if(index!=-1){
                return ip.substring(0,index);
            }
            return ip;
        }
        return request.getRemoteAddr();
    }

    /***
     *
     * 获取登录用户远程主机ip地址
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("x-forwarder-for");
        if(ip==null || ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        return ip;

    }

    /**
     * 请求参数拼装
     * */
    public static String argsArrayToString(Object[] paramsArray){
        String params = null;
        if(!ArrayUtils.isEmpty(paramsArray)){
            List<Object> logArgs = Arrays.asList(paramsArray).stream()
                    .filter(arg->(!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
            .collect(Collectors.toList());

            //过滤后序列化无异常
            params = JSON.toJSONString(logArgs);
        }
        return params;
    }
}
