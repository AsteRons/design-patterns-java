package com.singleton;

import com.singleton.config.singleton.ConfigurationManagerDCL;
import com.singleton.config.singleton.ConfigurationManagerHolder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    private static final int THREAD_COUNT = 10000;

    @Test
    public void testHolderSingletonIsThreadSafe() throws InterruptedException, ExecutionException {
        assertSingletonThreadSafety(ConfigurationManagerHolder::getInstance);
    }

    @Test
    public void testDCLSingletonIsThreadSafe() throws InterruptedException, ExecutionException {
        assertSingletonThreadSafety(ConfigurationManagerDCL::getInstance);
    }

    private <T> void assertSingletonThreadSafety(Callable<T> singletonSupplier)
            throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<T>> results = new ArrayList<>();

        IntStream.range(0, THREAD_COUNT)
                .forEach(i -> results.add(executor.submit(singletonSupplier)));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        T firstInstance = results.get(0).get();

        for (Future<T> future : results) {
            assertSame(firstInstance, future.get(), "Different singleton instances detected!");
        }
    }
}