package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfig.class);//this class defines the config for my annotations
        ShoppingCart cart = appContext.getBean(ShoppingCart.class);
        cart.checkout("CANCELLED");
        cart.quantity();
    }
}
