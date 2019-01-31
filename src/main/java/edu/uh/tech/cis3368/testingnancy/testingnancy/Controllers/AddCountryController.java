package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Country;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.CountryRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class AddCountryController {



    @FXML
    Stage stage;

    @Autowired
    CountryViewController countryViewController;


    @FXML
    AnchorPane rootPane;


    Country country;

    @Autowired
    CountryRepository countryRepository;



    @FXML
    private JFXTextField addCountryTxt;

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
            if(addCountryTxt.getText() != null )
            {
                country = new Country();
                country.setCountryName(String.valueOf(addCountryTxt.getText()));



                countryRepository.save(country);
                countryViewController.loadCountry();

                addCountryTxt.setText(null);


                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully added a Country");
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



