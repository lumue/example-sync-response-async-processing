
#Low http response times and normalized backend load using asynchronous request processing

##Overview

###Why is it important

Imagine what happens in your application if suddenly a lot of requests start coming in, which demand synchronous transaction execution against a database. The webserver will start to spawn more threads. Each of these threads has to acquire a database connection. This will not only drain your http-threadpool, but also your applications connection pool. after a while, most threads will be waiting for a database connection. which in turn leads to the webserver spawning more and more threads. eventually your application becomes unresponsive. 

So http-threads are a resource you do not want to hog. this is even more important if your application is accessible on the public internet.  

it is also a good thing to decouple your backend workload from the http-request frequency. remember that every thread that executes a transaction against a database likely also occupies a db connection. 


###How does it work (the short version)

When invoking a service-method directly from a http-request-processing thread, it will be occupied until the transaction completes. To avoid this, the request is handed off to a message queue and delivered to a service-activator endpoint. 

this way, updates can be queued while your backend-threads and database eat them up at a steady load.

if guaranteed delivery is needed, the message queue can be made persistent with a message store. a http ok response is sent only if the message has been added to the queue. 



###When (not) to use this

This pattern is useful if you have to handle a large amount of non trivial create or update requests to your backend in a short amount of time. Consider it especially if you have a public facing api or a spiky usage pattern.   

Its not applicable if the clients requires a response containing processing results. In this case consider to redesign your endpoint api to allow for "fire and forget" style requests: 

Does your client really need to know if the backend transaction completed successfully, or is it enough to acknowledge the delivery? 

Is it possible to pull the backend for results later?     

Obviously, this adds another level of complexity and also some overhead to your application. So only use it, if you need it. Fortunately, if you design your service api with this pattern in mind, its easy to add the implementation later.

##An example

You have built an application which receives and processes orders from thousands of clients around the country. you even stress tested it with the expected workload of 500.000 orders a day and everything works fine.

###There is always a little detail missing from the spec!

but after it is deployed to production, complaints start coming in. apparently each order has to be sent several times until it is accepted and also the userinterface seems to become slow and unresponsive every night. So you check the logs and notice a lot of exceptions which look like this:

``
``


turns out there is a little detail about that specified load which you haven't been told: all the clients start sending their orders at the same time every night!

###The Application



####The Domainmodel

Is a really simple one (after all it is an example application!). 

![domain model](/resources/2014-08-18-srap-domain-classDiagram.PNG) 

But there is a small gotcha with serious implications on the processing of orders. As you can see, the product quantity on stock is a direct property of ``Product``. Since the processing of an order involves the update of stock, the corresponding row in the product table has to be locked, which in turn requires the transaction isolation level to be serializable.

####Object Persistence

The domain objects are persisted using JPA and hibernate. Mysql is used as a database. Nothing special here.







