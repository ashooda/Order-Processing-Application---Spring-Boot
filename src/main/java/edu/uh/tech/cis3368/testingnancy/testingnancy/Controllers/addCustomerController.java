package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Customer;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


public class addCustomerController {


    Stage stage;

    @Autowired
    MainTabController mainTabController;


    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @Autowired
    StateProvinceRepository stateProvinceRepository;

    @Autowired
    CustomerRepository customerRepository;



    ArrayList<String> countryData, statData, customerStatData, customerTypeData;
    ObservableList<String> countryComboData, statComboData, custStatComboData, customerTypeComboData;


    @FXML
    private JFXComboBox<String> countryCombo;

    @FXML
    private JFXComboBox<String> stateCombo;

    @FXML
    private JFXComboBox<String> custTypeCombo;

    @FXML
    private JFXComboBox<String> custStatCombo;

    @FXML
    private JFXButton custSavebtn, custClearbtn;



    @FXML
    private JFXTextField firstNametxt, lastNametxt, streetTxt, cityTxt, zipcodeTxt, phoneTxt, emailTxt;

    @FXML
    public void initialize( ) {

    }


    @PostConstruct
    public void init() {




        countryData = countryRepository.findEverythingArray();
        countryComboData = FXCollections.observableArrayList(countryData);
        countryCombo.getItems().addAll(countryComboData);

        statData = stateProvinceRepository.findEverythingArray();
        statComboData = FXCollections.observableArrayList(statData);
        stateCombo.getItems().addAll(statComboData);

        customerStatData = customerStatusRepository.findEverythingArray();
        custStatComboData = FXCollections.observableArrayList(customerStatData);
        custStatCombo.getItems().addAll(custStatComboData);

        customerTypeData = customerTypeRepository.findEverythingArray();
        customerTypeComboData = FXCollections.observableArrayList(customerTypeData);
        custTypeCombo.getItems().addAll(customerTypeComboData);


    }


    public void buttonEvent(ActionEvent event) {
        if (event.getSource() == custSavebtn)
        {
            if(firstNametxt.getText() != null && lastNametxt.getText() != null && phoneTxt.getText() != null && countryCombo.getValue() != null && stateCombo.getValue() != null && custTypeCombo.getValue() != null && custStatCombo.getValue() != null)
            {Customer customer = new Customer();
            customer.setCustomerFirstName(firstNametxt.getText());
            customer.setCustomerLastName(lastNametxt.getText());
            customer.setCustomerPhoneNumber(phoneTxt.getText());
            customer.setCountryId(countryRepository.findByCountryName(countryCombo.getValue()));
            customer.setStateProvinceId(stateProvinceRepository.findByStateProve(stateCombo.getValue()));
            customer.setCustomerTypeId(customerTypeRepository.findByCustomerTyp(custTypeCombo.getValue()));
            customer.setCustomerStatusId(customerStatusRepository.findByCustomerStat(custStatCombo.getValue()));
            customer.setCustomerCity(cityTxt.getText());
            customer.setCustomerStreetAddress(streetTxt.getText());
            customer.setCustomerZipcode(zipcodeTxt.getText());
            customer.setCustomerEmail(emailTxt.getText());
            customerRepository.save(customer);

            firstNametxt.setText(null); lastNametxt.setText(null); phoneTxt.setText(null); countryCombo.setValue(null);
            stateCombo.setValue(null); custTypeCombo.setValue(null); custStatCombo.setValue(null);
            streetTxt.setText(null); cityTxt.setText(null); emailTxt.setText(null); zipcodeTxt.setText(null);


            stage.close();

                {Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setContentText("You have successfully added a customer");
                    alert.showAndWait();}



            }
            else
            {Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText("Please Enter Values in all of the Required Fields");
            alert.showAndWait();}
            mainTabController.loadCustomerData();
        }

        else if(event.getSource() == custClearbtn)
        {

            stage.close();



        }
    }



}
