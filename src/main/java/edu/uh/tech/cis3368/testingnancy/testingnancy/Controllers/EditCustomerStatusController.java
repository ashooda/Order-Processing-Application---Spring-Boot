package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.CustomerStatus;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.CustomerStatusRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class EditCustomerStatusController {
    @FXML
    Stage stage;

    @Autowired
    CustomerStatusViewController customerStatusViewController;


    @FXML
    AnchorPane rootPane;


    CustomerStatus customerStatus;

    @Autowired
    CustomerStatusRepository customerStatusRepository;



    @FXML
    protected JFXTextField addCustomerStatusTxt;

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
            if(addCustomerStatusTxt.getText() != null )
            {
                customerStatus = new CustomerStatus();
                customerStatus.setCustomerStatus(String.valueOf(addCustomerStatusTxt.getText()));



                customerStatusRepository.save(customerStatus);
                customerStatusViewController.loadCustStat();

                addCustomerStatusTxt.setText(null);


                stage.close();

                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully edited a Customer Status");
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





