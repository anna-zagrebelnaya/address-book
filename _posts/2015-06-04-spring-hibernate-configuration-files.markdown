---
layout: post
title:  "Description of Spring and Hibernate configuration. Part 1. Spring."
date:   2015-06-04 14:48:35
categories: blog
alias: [/blog/blogging-on-redirects]
excerpt_separator: <!--more-->

---

So, let's look how Spring is set up.

Spring is a container-based framework, so we need to configure it to define what beans it should contain and how to
wire those beans so that they can work together. Traditionally, Spring configuration is defined in one or more XML
files, also called context files. Here we have one named as "applicationContext.xml". Further we will discuss its
content, but now it is enough to know, that it wires some beans, needed for Hibernate.

To integrate Spring into web-application need to declare the `ContextLoaderListener` in `web.xml` and use a
`contextConfigLocation` to set which context files to load:

{% highlight xml %}

<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
        /WEB-INF/applicationContext.xml
    </param-value>
</context-param>

...

<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

{% endhighlight %}

#? Rename SpringBeans.xml to applicationContext.xml

Now let's configure Spring MVC.

Spring MVC is designed around a `DispatcherServlet`, which is responsible to send the request on to a Spring MVC
controller. Like any servlet, `DispatcherServlet` must be configured in the web application’s `web.xml` file:

{% highlight xml %}

<servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/mvc-dispatcher-servlet.xml</param-value>
    </init-param>
</servlet>

{% endhighlight %}

In this case, because the servlet is named mvc-dispatcher, `DispatcherServlet` will try to load the application context
from a file named `mvc-dispatcher-servlet.xml`

#? Do we need init-param, if servlet-name is "mvc-dispatcher"? Check it.

Next we must indicate what URLs will be handled by the `DispatcherServlet` using `servlet-mapping` tag in `web.xml`
file:

{% highlight xml %}

<servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>

{% endhighlight %}

By mapping `DispatcherServlet` to `/`, I’m saying that it’s the default servlet and that it’ll be responsible for
handling all requests, including requests for static content.

All requests must be handled someway, commonly via controllers, but for static content you don't need to write a
special controller since `<mvc:resources>` element is on the job. We'll add it to the `mvc-dispatcher-servlet.xml`:

{% highlight xml %}

<mvc:resources mapping="/resources/**" location="resources"/>

{% endhighlight %}

As configured here, any requests whose paths begin with `/resources` will be automatically served from the `/resources`
folder at the root of the application.

Therefore, all of our images, stylesheets, JavaScript, and other static content needs to be kept in the application’s
`/resources` folder.