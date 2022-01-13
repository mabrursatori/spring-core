package com.mabrur.intellej;

import com.mabrur.intellej.configuration.MultiBarComponent;
import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.data.FooBar;
import com.mabrur.intellej.repository.CategoryRepository;
import com.mabrur.intellej.repository.CustomerRepository;
import com.mabrur.intellej.repository.ProductRepository;
import com.mabrur.intellej.service.CategoryService;
import com.mabrur.intellej.service.CustomerService;
import com.mabrur.intellej.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ComponentScanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
    }

    @Test
    void testScan() {

        Bar bar = applicationContext.getBean(Bar.class);

        Assertions.assertNotNull(bar);

    }

    @Test
    void testComponent() {

        Service service1 = applicationContext.getBean(Service.class);
        Service service2 = applicationContext.getBean("service", Service.class);

        Assertions.assertSame(service1, service2);
    }

    @Test
    void testDI() {

        Service service = applicationContext.getBean(Service.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, service.getProductRepository());

    }

    @Test
    void testSetDI() {

        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);

        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    @Test
    void testFieldDI() {

        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Bar bar = applicationContext.getBean("bar", Bar.class);
        Bar bar1 = applicationContext.getBean("bar1", Bar.class);
        Assertions.assertSame(customerRepository, customerService.getCustomerRepository());
        Assertions.assertSame(bar, customerService.getBar());
        Assertions.assertSame(bar1, customerService.getBar1());
    }

    @Test
    void testOptional() {
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getFoo());
        Assertions.assertNotNull(fooBar.getBar());

    }

    @Test
    void testObject() {

        MultiBarComponent multiBarComponent = applicationContext.getBean(MultiBarComponent.class);

        Assertions.assertEquals(2, multiBarComponent.getBars().size());
    }

    @Test
    void testBeanFactory() {

        Map<String, Bar> bars = applicationContext.getBeansOfType(Bar.class);
        System.out.println(bars);
    }
}
