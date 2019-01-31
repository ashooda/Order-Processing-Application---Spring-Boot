package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Filling;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FillingRepository;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FillingStatusRepository;
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

public class EditFillingsController {
    ArrayList<String> data;
    ObservableList<String> comboData;

    @FXML
    Stage stage;

    @Autowired
    FillingViewController fillingViewController;

    @Autowired
    FillingStatusRepository fillingStatusRepository;

    @FXML
    AnchorPane rootPane;


    Filling filling;

    @Autowired
    FillingRepository fillingRepository;

    @FXML
    protected JFXComboBox<String> fillStatusCombo;

    @FXML
    protected JFXTextField addFillingTxt;

    @FXML
    private JFXButton saveBtn, cancelBtn;


    @FXML
    public void initialize( ) {

    }



    @PostConstruct
    public void init() {
        data = fillingStatusRepository.findEverything();


        comboData = FXCollections.observableArrayList(data);
        fillStatusCombo.getItems().addAll(comboData);




    }



    public void buttonEvent(ActionEvent event) {

        if (event.getSource() == cancelBtn)
        {
            stage.close();}
        else if (event.getSource() == saveBtn)
        {
            if(addFillingTxt.getText() != null && fillStatusCombo.getValue() != null)
            {
                Filling filling1 = fillingRepository.findByIdentity(filling.getFillingId());

                filling1.setFillingType(String.valueOf(addFillingTxt.getText()));


                filling1.setFillingStatusId(fillingStatusRepository.findByStatus(fillStatusCombo.getValue()));
                fillingRepository.save(filling1);
                fillingViewController.loadFillings();
                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully edited a filling");
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



