package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.StateProvince;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.StateProvinceRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class EditStateController {
    @FXML
    Stage stage;

    @Autowired
    StateViewController stateViewController;


    @FXML
    AnchorPane rootPane;


    StateProvince stateProvince;

    @Autowired
    StateProvinceRepository stateProvinceRepository;



    @FXML
    protected JFXTextField addStateTxt;

    @FXML
    private JFXButton saveBtn, cancelBtn;


    @FXML
    public void initialize( ) {

    }



    @PostConstruct
    public void init() {

    }



    public void buttonEvent(ActionEvent event) {

        if (event.getSource() == cancelBtn)
        {
            stage.close();}
        else if (event.getSource() == saveBtn)
        {
            if(addStateTxt.getText() != null )
            {
                StateProvince stateProvince1 = stateProvinceRepository.findByIdentity(stateProvince.getStateProvinceId());

                stateProvince1.setStateName(String.valueOf(addStateTxt.getText()));



                stateProvinceRepository.save(stateProvince1);
                stateViewController.loadState();

                addStateTxt.setText(null);


                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully edited a State");
                    alert.showAndWait();}
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setContentText("Please Enter a Value in the text field");
                alert.showAndWait();}

        }
    }
}





