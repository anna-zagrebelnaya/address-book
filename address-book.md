---
layout: default
title: Address-book
---

<div class="home">

  <h1 class="page-heading">Contacts</h1>

  <ul class="contact-list">
    {% for page in site.pages %}
        {% if page.contact %}
          <li>
            <span class="page-meta">{{ page.phone }}</span>

            <h2>
              <a class="page-link" href="{{ page.url | prepend: site.baseurl }}">{{ page.title }}</a>
            </h2>
          </li>
        {% endif %}
    {% endfor %}
  </ul>

</div>