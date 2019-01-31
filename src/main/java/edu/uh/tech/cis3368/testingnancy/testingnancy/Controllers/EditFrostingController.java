package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Frosting;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FrostingRepository;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FrostingStatusRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class EditFrostingController {

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
    protected JFXComboBox<String> frostStatusCombo;

    @FXML
    protected JFXTextField addFrostingTxt;

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
            {Frosting frosting2 = frostingRepository.findByIdentity(frosting.getFrostingId());
                frosting2.setFrostingType(String.valueOf(addFrostingTxt.getText()));


                frosting2.setFrostingStatusId(frostingStatusRepository.findByStatus(frostStatusCombo.getValue()));
                frostingRepository.save(frosting2);
                frostingViewController.loadFrostings();

                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully edited a frosting");
                    alert.showAndWait();}
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setContentText("Please ensure that there are no empty fileds");
                alert.showAndWait();}


        }
    }

}
