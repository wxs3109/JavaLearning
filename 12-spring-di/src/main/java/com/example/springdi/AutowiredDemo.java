// AutowiredDemo.java - Java Learning File

package com.example.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan
public class AutowiredDemo {
    public static void main(String[] args) {
        // Create Spring application context
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AutowiredDemo.class);
        
        // Get the demo bean
        DemoRunner runner = context.getBean(DemoRunner.class);
        runner.runDemo();
        
        // Close the context
        context.close();
    }
}

// Repository layer
@Repository
class UserRepository {
    public String findUser(String id) {
        return "User " + id + " from database";
    }
}

// Service layer
@Service
class UserService {
    // 1. Field injection (not recommended but commonly used)
    @Autowired
    private UserRepository userRepository;

    // 2. Constructor injection (recommended)
    private final UserRepository constructorInjectedRepo;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.constructorInjectedRepo = userRepository;
    }

    // 3. Setter injection
    private UserRepository setterInjectedRepo;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.setterInjectedRepo = userRepository;
    }

    public String getUserById(String id) {
        return userRepository.findUser(id);
    }
}

// Demo runner component
@Component
class DemoRunner {
    // 4. Multiple dependencies injection
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public DemoRunner(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void runDemo() {
        // Demonstrate that all injection methods work
        System.out.println("Autowired Demo Results:");
        System.out.println("1. Field injection result: " + userService.getUserById("1"));
        System.out.println("2. Constructor injection result: " + userService.getUserById("2"));
        System.out.println("3. Setter injection result: " + userService.getUserById("3"));
        System.out.println("4. Multiple dependencies injection result: " + userRepository.findUser("4"));
    }
}
