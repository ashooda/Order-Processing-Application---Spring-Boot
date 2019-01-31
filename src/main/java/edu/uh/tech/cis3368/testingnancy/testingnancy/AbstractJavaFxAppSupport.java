package edu.uh.tech.cis3368.testingnancy.testingnancy;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public abstract class AbstractJavaFxAppSupport extends Application {
    private static String[] savedArgs;


    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxAppSupport> appClass, String[] args) {
        AbstractJavaFxAppSupport.savedArgs = args;
        Application.launch(appClass, args);
    }
}
