##  on application starting time call openfeign with circuitbreaker and loadbalancer stuck main thread

### main thread waiting on condition
```
"main" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.concurrent.CompletableFuture$Signaller@1fd76930
	at java.base@17.0.6/jdk.internal.misc.Unsafe.park(Native Method)
	at java.base@17.0.6/java.util.concurrent.locks.LockSupport.park(LockSupport.java:211)
	at java.base@17.0.6/java.util.concurrent.CompletableFuture$Signaller.block(CompletableFuture.java:1864)
	at java.base@17.0.6/java.util.concurrent.ForkJoinPool.unmanagedBlock(ForkJoinPool.java:3463)
	at java.base@17.0.6/java.util.concurrent.ForkJoinPool.managedBlock(ForkJoinPool.java:3434)
	at java.base@17.0.6/java.util.concurrent.CompletableFuture.waitingGet(CompletableFuture.java:1898)
	at java.base@17.0.6/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:2072)
	at app//org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadProvider.lambda$decorateCallable$2(Resilience4jBulkheadProvider.java:148)
	at app//org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadProvider$$Lambda$825/0x00000008010b3b78.call(Unknown Source)
	at app//io.github.resilience4j.circuitbreaker.CircuitBreaker.lambda$decorateCallable$4(CircuitBreaker.java:168)
	at app//io.github.resilience4j.circuitbreaker.CircuitBreaker$$Lambda$826/0x00000008010b3da0.call(Unknown Source)
	at app//org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker.getAndApplyFallback(Resilience4JCircuitBreaker.java:164)
	at app//org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker.run(Resilience4JCircuitBreaker.java:125)
	at app//org.springframework.cloud.openfeign.FeignCircuitBreakerInvocationHandler.invoke(FeignCircuitBreakerInvocationHandler.java:113)
	at app/jdk.proxy2/jdk.proxy2.$Proxy77.test(Unknown Source)
	at app//com.example.demo.BeanConfig.testBean(BeanConfig.java:15)
	at app//com.example.demo.BeanConfig$$SpringCGLIB$$0.CGLIB$testBean$0(<generated>)
	at app//com.example.demo.BeanConfig$$SpringCGLIB$$FastClass$$1.invoke(<generated>)
	at app//org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258)
	at app//org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331)
	at app//com.example.demo.BeanConfig$$SpringCGLIB$$0.testBean(<generated>)
	at java.base@17.0.6/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base@17.0.6/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base@17.0.6/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base@17.0.6/java.lang.reflect.Method.invoke(Method.java:568)
	at app//org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:140)
	at app//org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:651)
	at app//org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:489)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1336)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1166)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:563)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory$$Lambda$358/0x0000000800e18f68.getObject(Unknown Source)
	at app//org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at app//org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1441)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1348)
	at app//org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.resolveFieldValue(AutowiredAnnotationBeanPostProcessor.java:769)
	at app//org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:752)
	at app//org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:145)
	at app//org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:493)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1420)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory$$Lambda$358/0x0000000800e18f68.getObject(Unknown Source)
	at app//org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:973)
	at app//org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:946)
	at app//org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:616)
	at app//org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146)
	at app//org.springframework.boot.SpringApplication.refresh(SpringApplication.java:753)
	at app//org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:455)
	at app//org.springframework.boot.SpringApplication.run(SpringApplication.java:323)
	at app//org.springframework.boot.SpringApplication.run(SpringApplication.java:1342)
	at app//org.springframework.boot.SpringApplication.run(SpringApplication.java:1331)
	at app//com.example.demo.HelloApplication.main(HelloApplication.java:22)


```


### pool-2-thread-1 blocked
```
"pool-2-thread-1" prio=0 tid=0x0 nid=0x0 blocked
     java.lang.Thread.State: BLOCKED
 on java.util.concurrent.ConcurrentHashMap@2a631f26 owned by "main" Id=1
	at app//org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:217)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:274)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at app//org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1441)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1348)
	at app//org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911)
	at app//org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:789)
	at app//org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:241)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1356)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1193)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:563)
	at app//org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory$$Lambda$358/0x0000000800e18f68.getObject(Unknown Source)
	at app//org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323)
	at app//org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at app//org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:973)
	at app//org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:946)
	at app//org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:616)
	at app//org.springframework.cloud.context.named.NamedContextFactory.createContext(NamedContextFactory.java:138)
	at app//org.springframework.cloud.context.named.NamedContextFactory.getContext(NamedContextFactory.java:122)
	at app//org.springframework.cloud.context.named.NamedContextFactory.getInstances(NamedContextFactory.java:236)
	at app//org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient.execute(FeignBlockingLoadBalancerClient.java:115)
	at app//feign.SynchronousMethodHandler.executeAndDecode(SynchronousMethodHandler.java:100)
	at app//feign.SynchronousMethodHandler.invoke(SynchronousMethodHandler.java:70)
	at app//org.springframework.cloud.openfeign.FeignCircuitBreakerInvocationHandler.lambda$asSupplier$1(FeignCircuitBreakerInvocationHandler.java:140)
	at app//org.springframework.cloud.openfeign.FeignCircuitBreakerInvocationHandler$$Lambda$807/0x00000008010ae378.get(Unknown Source)
	at app//org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker$$Lambda$840/0x00000008010b86c8.call(Unknown Source)
	at java.base@17.0.6/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base@17.0.6/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	at java.base@17.0.6/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	at java.base@17.0.6/java.lang.Thread.run(Thread.java:833)


```
