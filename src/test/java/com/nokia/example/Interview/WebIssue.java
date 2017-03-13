package com.nokia.example.Interview;

/**
 * Created by YLongYao on 2016/11/2.
 */
public class WebIssue {

    /**
     * Servlet：
     *      用来处理客户端提交的请求并产生动态网页内容的Java类。
     *      Servlet是非线程安全的
     *
     * Servlet的生命周期：
     *      Servlet引擎载入Servlet
     *      调用init()初始化
     *      调用service()方法处理客户端请求
     *      最后调用destory()方法销毁Servlet
     *
     * Cookie与Session的区别：
     *      cookie的数据存储在客户的浏览器上，session的数据存放在服务器上
     *      cookie不安全，session较安全
     *      session会在一定时间内保存在服务器上，访问量大的时候比较占用服务器性能
     *      单个cookie的保存的数据不能超过4K
     *
     * JSP的内置对象：
     *      request、response、pageContext、application、out、exception、session、config、page；
     *
     * Web程序中当前用户的上下文信息保存在session中
     *
     * forward和redirect的区别:
     *      1.从地址栏显示来说
     *          forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内
     *              容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.
     *          redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.
     *      2.从数据共享来说
     *          forward:转发页面和转发到的页面可以共享request里面的数据.
     *          redirect:不能共享数据.
     *      3.从运用地方来说
     *          forward:一般用于用户登陆的时候,根据角色转发到相应的模块.
     *          redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.
     *      4.从效率来说
     *          forward:高.
     *          redirect:低.
     *
     *      转发是服务器行为，重定向是客户端行为
     *
     * JSP与Servlet的区别：
     *
     */

}
