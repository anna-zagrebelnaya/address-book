---
layout: post
title:  "Address-book prototype created!"
date:   2015-06-03 23:48:01
categories: blog
alias: [/blog/blogging-on-redirects]
excerpt_separator: <!--more-->

---

Now we have some skeleton of Spring+Hibernate web-application, that consists of `domain`, `dao`,
`service` layers. There are very nice lections in russian about what are the main layers of nontrivial web-application
and what each of them for [here] [TPPS].

As for Spring, `mvc-dispatcher-servlet.xml` and `SpringBeans.xml` were created.

As for Hibernate, `persistence-mysql.properties` was created and sessionFactory and datasource were registered in
`SpringBeans.xml`:

{% highlight xml %}
<bean id="dataSource"
     class="org.springframework.jdbc.datasource.DriverManagerDataSource">
      <property name="driverClassName" value="${jdbc.driverClassName}" />
      <property name="url" value="${jdbc.url}" />
      <property name="username" value="${jdbc.username}" />
      <property name="password" value="${jdbc.password}" />
</bean>

<bean id="sessionFactory"
     class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
      <property name="dataSource" ref="dataSource"/>
      <property name="hibernateProperties">
             <props>
                    <prop key="hibernate.dialect">
                           org.hibernate.dialect.MySQLDialect
                    </prop>
                    <prop key="hibernate.show_sql">
                           true
                    </prop>
             </props>
      </property>
      <property name="packagesToScan" value="com.anka.domain"/>
</bean>
{% endhighlight %}

The contents and appointment of these files will be discussed in further posts.

[TPPS]:         https://www.youtube.com/playlist?list=PLCA5CB42F5A816A17