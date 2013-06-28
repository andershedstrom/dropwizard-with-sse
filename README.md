This is a example project using [Dropwizard](github.com/codahale/dropwizard) with [Server-sent Events support](https://github.com/jetty-project/jetty-eventsource-servlet)

__Usage__

* Clone this repo. 
* Open a terminal and move into project directory, then execute:
  
```
$ mvn clean package
$ java -jar target/dropwizard-with-sse-0.0.1-SNAPSHOT.jar server \
  src/test/resources/config.yaml
```

* Open a new terminal and execute:

```
$ curl localhost:8080/sse -H"Accept: text/event-stream"
```

* Open yet another terminal and execute:

```
$ curl localhost:8080/publish?msg=HelloWorld
```

* You should see the following i terminal 2:

```
~ $ curl localhost:8080/sse -H"Accept: text/event-stream"

data: HelloWorld
```




