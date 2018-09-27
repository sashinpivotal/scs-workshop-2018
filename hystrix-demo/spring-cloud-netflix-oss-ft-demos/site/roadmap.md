# Roadmap

The Hytrix Demo project currently focuses on failure mode handling
characteristics using Neflix-OSS based on static latency bottlenecks.

Ideally we want to expand to additional scenarios and failure modes.

## More Dynamic Failure Handling

-   Non-deterministic (randomized) failures

-   Driving failure mode re-configuration through load controller
    (dedicated actuator controller)

-   Configuration Repo as gitsubmodule?

## Automated Tests

- Add automated Test Cases for deterministic failures

## Additional Failure Mode Handling

-   Runtime Exception Injection
-   Resource depletion (stretch)
    - Memory inflation
    - CPU spin
    - I/O
    - Network
-   Inject multiple failures in order
-   Investigate use of Netflix Chaos Engineering toolset

## Potential scenarios

-   Resource depletion
    -   CPU queuing, saturation -> impacts liveness
    -   Out-of-memory -> Process termination or indeterminate state
        - Java
        - Process
    -   I/O bottlenecks -> impacts liveness
    -   File Descriptors (Linux) -> Runtime exceptions

## Enhanced Demonstrations

-   Trusted client demo
-   Demo each hystrix failure mode
    -   Runtime Exception
    -   Timeout (Untrusted Client only)
    -   Load shedding
        - Thread Pools
        - Semaphore
-   Simulate production peak load profile with Jmeter (Ultimate Thread
    Group)

## Deployments

- Docker Compose
- Kubernetes
- Pivotal Cloud Foundry
