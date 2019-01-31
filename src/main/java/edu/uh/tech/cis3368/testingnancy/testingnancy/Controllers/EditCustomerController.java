package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Customer;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.ArrayList;


public class EditCustomerController {


    @Autowired
    MainTabController mainTabController;


    @FXML
     AnchorPane rootPane1;


    Stage stage;


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

    Customer customer;


    ArrayList<String> countryData, statData, customerStatData, customerTypeData;
    ObservableList<String> countryComboData, statComboData, custStatComboData, customerTypeComboData;


    @FXML
    protected JFXComboBox<String> countryCombo;

    @FXML
    protected JFXComboBox<String> stateCombo;

    @FXML
    protected JFXComboBox<String> custTypeCombo;

    @FXML
    protected JFXComboBox<String> custStatCombo;

    @FXML
    protected JFXButton custSavebtn, custClearbtn;

    //@FXML
    //AnchorPane rootPane1;

    @FXML
    protected JFXTextField firstNametxt, lastNametxt, streetTxt, cityTxt, zipcodeTxt, phoneTxt, emailTxt;

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


        if (firstNametxt.getText() != null && lastNametxt.getText() != null && phoneTxt.getText() != null && countryCombo.getValue() != null && stateCombo.getValue() != null && custTypeCombo.getValue() != null && custStatCombo.getValue() != null) {

            Customer customer2 = customerRepository.findByIdentity(customer.getCustomerId());
            customer2.setCustomerFirstName(firstNametxt.getText());
            customer2.setCustomerLastName(lastNametxt.getText());
            customer2.setCustomerPhoneNumber(phoneTxt.getText());
            customer2.setCountryId(countryRepository.findByCountryName(countryCombo.getValue()));
            customer2.setStateProvinceId(stateProvinceRepository.findByStateProve(stateCombo.getValue()));
            customer2.setCustomerTypeId(customerTypeRepository.findByCustomerTyp(custTypeCombo.getValue()));
            customer2.setCustomerStatusId(customerStatusRepository.findByCustomerStat(custStatCombo.getValue()));
            customer2.setCustomerCity(cityTxt.getText());
            customer2.setCustomerStreetAddress(streetTxt.getText());
            customer2.setCustomerZipcode(zipcodeTxt.getText());
            customer2.setCustomerEmail(emailTxt.getText());
            customerRepository.save(customer2);
            mainTabController.loadCustomerData();


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText("Please Enter Values in all of the Required Fields");
            alert.showAndWait();
            alert.initModality(Modality.APPLICATION_MODAL);
        }


    }




    public void clearButtonEvent(ActionEvent event){


            stage.close();



        }


    }




