package edu.uh.tech.cis3368.testingnancy.testingnancy;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OccasionRepository;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.ProductLayerRepository;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppLancher extends AbstractJavaFxAppSupport {

    @Value("${ui.title:JavaFX App}")
    private String windowTitle;

    @Autowired
    @Qualifier("mainview")
    public ConfigurationControllers.View view;

    @Autowired
    public ProductLayerRepository productLayerRepository;








    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();

    }

    public static void main(String[] args) {
        launchApp(AppLancher.class, args);

    }

}
