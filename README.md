# SpringBoot下Bean注册的几种方式
- **@Bean**
- **FactoryBean**: 根据beanName获取bean时需要采用`&beanName`作为实例名
- **ImportBeanDefinitionRegistrar**：借助beanDefinitionRegistry完成bean注册，并`@Import`载入
- **ImportSelector**：通过借助`@Import`载入
- **BeanDefinitionRegistryPostProcessor**：借助BeanDefinitionRegistry完成bean注册

# IOC执行过程
- **BeanDefinitionRegistryPostProcessor**:
  - **postProcessBeanDefinitionRegistry**: 可以通过BeanDefinitionRegistry注册更多的bean实例，也可以获取当前已经注册bean并进行属性的修改
  - **postProcessBeanFactory**: 此时仅完成了所有bean的**注册**工作，并没有实例化，我们可以对注册的bean重写或者添加一些属性
<br>↓
- **BeanFactoryPostProcessor**:
  - **postProcessBeanFactory**: 作用基本同于接口BeanDefinitionRegistryPostProcessor中定义的postProcessBeanFactory方法，此时仅完成了所有bean的注册工作，并没有实例化，我们可以对注册的bean重写或者添加一些属性
<br>↓
- 实例化bean，执行对应的**constructor**
<br>↓
- **BeanPostProcessor**：Bean后置处理器，初始化前后进行处理工作
  - **postProcessBeforeInitialization**：优先于bean实例被@PostConstruct修饰的方法
<br>↓
- 执行bean实例被<strong>@PostConstruct</strong>修改的方法
<br>↓
- **BeanPostProcessor**：Bean后置处理器，初始化前后进行处理工作
  - **postProcessAfterInitialization**：执行于bean实例被@PostConstruct修饰的方法之后
<br>↓ 
- **SmartInitializingSingleton**： 对初始化完成后的bean进行回调
<br>↓ 
- **SmartLifecycle**：在所有的bean完成注册、实例化、初始化后方会执行start方法
  - **isAutoStartup** : true表明在ApplicationContext更新后将自动执行，否则需要显示调用start方法
  - getPhase：控制多个lifecycle的执行顺序，start方法由低到高，stop由高到低
  - isRunning: 
  - isAutoStartup
  - **start**
<br>↓ 
- **ContextRefreshedEvent**
<br>↓ 
- **ApplicationContextEvent**
<br>↓
- **ApplicationStartedEvent**
<br>↓
- **ApplicationRunner|CommandLineRunner**:执行顺序由order决定，有低到高
<br>↓
- **ApplicationReadyEvent**
<br>↓
- **ContextClosedEvent**
<br>↓
- **ApplicationContextEvent**
<br>↓
- **SmartLifecycle**： 在所有的bean完成注册、实例化、初始化后方会执行start方法
  - getPhase
  - isRunning
<br>↓
- 执行bean实例被<strong>@PreDestroy</strong>修改的方法
<br>↓
- exit(0)
