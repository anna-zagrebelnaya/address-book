---
layout: post
title:  "Description of Spring MVC configuration"
date:   2015-06-04 14:48:35
categories: blog
alias: [/blog/blogging-on-redirects]
excerpt_separator: <!--more-->

---

## Application context

Now let's configure Spring MVC.

Spring MVC is designed around a `DispatcherServlet`, which is responsible to send the request on to a Spring MVC
controller. Like any servlet, `DispatcherServlet` must be configured in the web application’s `web.xml` file:

{% highlight xml %}

<servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>

{% endhighlight %}

`DispatcherServlet` will try to load the application context from a file named
`<servlet-name>-servlet.xml`, i.e. in this case, because the servlet is named `mvc-dispatcher`, 
`mvc-dispatcher-servlet.xml` will be loaded. 
If you want to explicitly define it, you may use `<init-param>` tag:

{% highlight xml %}

<servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/some-servlet.xml</param-value>
    </init-param>
</servlet>

{% endhighlight %}

## Url pattern

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

## Static content

All requests must be handled someway, commonly via controllers, but for static content you don't need to write a
special controller since `<mvc:resources>` element is on the job. We'll add it to the `mvc-dispatcher-servlet.xml`:

{% highlight xml %}

<mvc:resources mapping="/resources/**" location="resources"/>

{% endhighlight %}

As configured here, any requests whose paths begin with `/resources` will be automatically served from the `/resources`
folder at the root of the application.

Therefore, all of our images, stylesheets, JavaScript, and other static content needs to be kept in the application’s
`/resources` folder.

## View resolver

Next we have to define the view resolver in `mvc-dispatcher-servlet.xml`:

{% highlight xml %}

<bean
    class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix">
        <value>/WEB-INF/pages/</value>
    </property>
    <property name="suffix">
        <value>.jsp</value>
    </property>
</bean>

{% endhighlight %}

When `DispatcherServlet` asks `InternalResourceViewResolver` to resolve a view, it
takes the logical view name, prefixes it with `/WEB-INF/pages/` and suffixes it with `.jsp`.
The result is the path of a JSP that will render the output.