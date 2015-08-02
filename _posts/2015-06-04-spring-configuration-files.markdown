---
layout: post
title:  "Description of Spring configuration"
date:   2015-06-04 14:00:00
categories: blog
alias: [/blog/blogging-on-redirects]
excerpt_separator: <!--more-->
comments: True

---

So, let's look how Spring is set up.

Spring is a container-based framework, so we need to configure it to define what beans it should contain and how to
wire those beans so that they can work together. 

Traditionally, Spring configuration is defined in one or more XML files called context files. Here we have one named 
as `applicationContext.xml`. Further we will discuss its content.

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

Now we can add component scanning to `applicationContext.xml` to configure Spring to automatically discover beans:

{% highlight xml %}

<context:component-scan base-package="com.anka">

{% endhighlight %}

Now all classes that are annotated with `@Component` (or any custom annotation that is itself annotated with 
`@Component`), `@Controller`, `@Repository` or `@Service` will be registered as Spring beans.   