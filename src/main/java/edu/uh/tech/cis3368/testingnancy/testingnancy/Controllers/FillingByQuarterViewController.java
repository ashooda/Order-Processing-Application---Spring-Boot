package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class FillingByQuarterViewController {



    Stage stage;



    @Autowired
    FillingByQuartController fillingByQuartController;

    @Autowired
    @Qualifier("fillByQuartView")
    ConfigurationControllers.View view;

    private int num = 0;





    @FXML
    private JFXTextField quarterTXT, yearTXT;

    @FXML
    private JFXButton tableViewBtn;


    @FXML
    public void initialize( ) {

    }



    @PostConstruct
    public void init() {

    }



    public void buttonEvent(ActionEvent event) {
        if(quarterTXT.getText() != null && yearTXT != null)
        {fillingByQuartController.quarter = Integer.valueOf(quarterTXT.getText());
        fillingByQuartController.year = Integer.valueOf(yearTXT.getText());

            while (num < 1)
            {
                stage = new Stage();
                stage.setTitle("View Fillings By Quarter Report");
                stage.setScene(new Scene(view.getView()));
                stage.setResizable(true);
                stage.centerOnScreen();
                stage.initModality(Modality.APPLICATION_MODAL);

                num++;

            }
            stage.show();
            fillingByQuartController.loadView();

        }



        else
        {Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText("Please be sure to enter a value in both fields");
            alert.showAndWait();}



    }
}

