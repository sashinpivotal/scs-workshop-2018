# Spring Cloud Bus Demo

## Overview

This demo shows how to set up a custom event listener, and broadcast
a custom event to the subscribers.

It uses Actuator endpoint to publish the event, simulating a 
hypothetical management endpoint required to be more dynamic, with
a pure broadcast mechanism to propagate a management state change.

It is *not* intended to replace the need for Spring Environment external
configuration (such as config server).

## Requirements

- Java 8 or above
- Rabbitmq 3.x or above installed

## Setup

The only setup required is to a remote rabbitmq broker.

If you have a local RMQ setup, no configuration is required.
If you need to config a remote, change the 
`test/java/resources/application.yml` file for the
`spring.rabbitmq.*` properties accordingly.

The tests demonstrate publishing a management command through
Actuator, and subequently querying the endpoint state change through
the associated Actuator GET request.

 