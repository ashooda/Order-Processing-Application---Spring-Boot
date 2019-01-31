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

public class EditCountryController {
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
    protected JFXTextField addCountryTxt;

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
                Country country1 = countryRepository.findByIdentity(country.getCountryId());
                country1.setCountryName(String.valueOf(addCountryTxt.getText()));



                countryRepository.save(country1);
                countryViewController.loadCountry();

                addCountryTxt.setText(null);


                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully edited a Country");
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
