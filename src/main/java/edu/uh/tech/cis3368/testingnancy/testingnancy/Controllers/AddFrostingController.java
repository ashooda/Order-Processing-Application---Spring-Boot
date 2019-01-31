package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Frosting;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FrostingStatus;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FrostingRepository;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FrostingStatusRepository;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AddFrostingController {

    ArrayList<String> data;
    ObservableList<String> comboData;

    @FXML
    Stage stage;

    @Autowired
    FrostingViewController frostingViewController;

    @Autowired
    FrostingStatusRepository frostingStatusRepository;

    @FXML
    AnchorPane rootPane;


   Frosting frosting;

    @Autowired
    FrostingRepository frostingRepository;

    @FXML
    private JFXComboBox<String> frostStatusCombo;

    @FXML
    private JFXTextField addFrostingTxt;

    @FXML
    private JFXButton saveBtn, cancelBtn;


    @FXML
    public void initialize( ) {

    }



    @PostConstruct
    public void init() {
        data = frostingStatusRepository.findEverything();


        comboData = FXCollections.observableArrayList(data);
        frostStatusCombo.getItems().addAll(comboData);




    }



    public void buttonEvent(ActionEvent event) {

        if (event.getSource() == cancelBtn)
        {
            stage.close();}
        else if (event.getSource() == saveBtn)
        {
            if(addFrostingTxt.getText() != null && frostStatusCombo.getValue() != null)
            {frosting = new Frosting();
                frosting.setFrostingType(String.valueOf(addFrostingTxt.getText()));


                frosting.setFrostingStatusId(frostingStatusRepository.findByStatus(frostStatusCombo.getValue()));

                frostingViewController.loadFrostings();
                frostingRepository.save(frosting);

                addFrostingTxt.setText(null);
                frostStatusCombo.setValue(null);
                stage.close();

                {Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully added a frosting");
                    alert.showAndWait();}
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setContentText("Please Enter Values in all of the required fields");
                alert.showAndWait();}



            }
    }
}
