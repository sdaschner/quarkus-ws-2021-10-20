package com.sebastian_daschner.workshops.concurrency.boundary;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.context.ManagedExecutor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.locks.LockSupport;

@Path("concurrent")
@ApplicationScoped
@Startup
public class ConcurrentResource {

    @Inject
    ManagedExecutor executor;

    @Inject
    MeterRegistry meterRegistry;

    @GET
    @Counted
    public String execute() {
        meterRegistry.counter("execute.total").increment();
        executor.execute(() -> {
            System.out.println("processing ...");
            LockSupport.parkNanos(2_000_000_000L);
            System.out.println("done");
        });
        return "Hello";
    }

    @Scheduled(every = "3s")
    public void executeScheduler() {
        System.out.println("run in scheduler");
    }

}
