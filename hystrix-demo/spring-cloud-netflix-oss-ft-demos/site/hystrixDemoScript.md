# Hystrix Demo

## Nominal Load 1/second

### Prereq

1. Fortune Service @ 10ms
1. Fortune Service feature enabled
1. Client socket timeout disabled
1. Greeting Say Hello circuit breaker enabled closed

### Start Up Stuff

1.  Terminal window @ ~/workspace/config
1.  Terminal window @ ~/workspace/hystrix-demo/applications/greeting/src/main/scripts
1.  Start in following order:
    -   Rabbitmq Server
    -   Nginx
    -   Zipkin Server
    -   Config Server, Service Registry, Circuit Breaker Dashboard
    -   Turbine
    -   Greeting and Fortune Service
    -   Jmeter @ 1 hps:
        `jmeter -n -t GreetingHystrixTest.jmx -Jhits=60`

### Demo Steps

1.  Show Call Graph
1.  Show Eureka Dashboard
1.  Show Hystrix Dashboard
1.  Show Protected Service Code (key and thread pool)
1.  Show configuration
    -   App Config (common security disablement)
    -   Greeting Service
        - Feature toggle
        - Hystrix config
    -   Fortune Service
        - Latency

## Load Shedding

1.  Bump up load to 10/second:
    `jmeter -n -t GreetingHystrixTest.jmx -Jhits=600`
1.  Bump up fortune service latency to 750 ms
1.  Scale up to clear load shedding.

## Circuit breaker

1. Bump up fortune service latency to 2.5 seconds
1. Watch timeout failures and circuit breaker trip
1. Watch re-attempts
1. Recover by lowering fortune service latecy to 10 ms

## Demonstrate Stuck Threads

1.  Bump up fortune latency to 1000 seconds
1.  Watch timeout failures and circuit breaker trip
1.  Wait until thread pools deplete, failure to load shedding
1.  Reduce fortune latency to 10 ms
1.  Do thread pools recover?
1.  How might we automate recovery?
    Hint:
    Actuator health check

## Demonstrate Stuck Threads with "Trusted" client

1.  Stop test
1.  Change primary path to SEMAPHORE strategy
1.  Refresh greeting application
1.  Refresh Hystrix dashboard, verify thread pool
    stats goto zero
1.  Bump up fortune latency to 1000 seconds and watch the fun!

## Demonstrate Circuit Breaker with Socket Timeouts

1. Enable socket timeout, refresh and restart greeting servers
1. Increase latency to 2 seconds
1. Show errors (vs Timeouts)
1. Reduce fortune latency to 10 ms to recover
