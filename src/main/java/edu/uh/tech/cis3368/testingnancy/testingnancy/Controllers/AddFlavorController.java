package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Flavor;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FlavorRepository;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FlavorStatusRepository;
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

public class AddFlavorController {
    ArrayList<String> data;
    ObservableList<String> comboData;

    @FXML
    Stage stage;

    @Autowired
    FlavorViewController flavorViewController;

    @Autowired
    FlavorStatusRepository flavorStatusRepository;

    @FXML
    AnchorPane rootPane;


    Flavor flavor;

    @Autowired
    FlavorRepository flavorRepository;

    @FXML
    private JFXComboBox<String> flavStatusCombo;

    @FXML
    private JFXTextField addFlavorTxt;

    @FXML
    private JFXButton saveBtn, cancelBtn;


    @FXML
    public void initialize( ) {

    }



    @PostConstruct
    public void init() {
        data = flavorStatusRepository.findEverything();


        comboData = FXCollections.observableArrayList(data);
        flavStatusCombo.getItems().addAll(comboData);




    }



    public void buttonEvent(ActionEvent event) {

        if (event.getSource() == cancelBtn)
        {
            stage.close();}
        else if (event.getSource() == saveBtn)
        {
            if(addFlavorTxt.getText() != null && flavStatusCombo.getValue() != null)
            {
                flavor = new Flavor();
                flavor.setFlavorType(String.valueOf(addFlavorTxt.getText()));


                flavor .setFlavorStatusId(flavorStatusRepository.findByStatus(flavStatusCombo.getValue()));
                flavorRepository.save(flavor );
                flavorViewController.loadFlavors();

                addFlavorTxt.setText(null);
                flavStatusCombo.setValue(null);

                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully added a flavor");
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


