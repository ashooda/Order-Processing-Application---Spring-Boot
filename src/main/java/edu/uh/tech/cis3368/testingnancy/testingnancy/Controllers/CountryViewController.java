package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Country;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.CountryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.Set;

public class CountryViewController {
    @Autowired
    @Qualifier("addCountry")
    ConfigurationControllers.View addCountryView;

    @Autowired
    @Qualifier("editCountry")
    ConfigurationControllers.View editCountryView;

    @Autowired
    AddCountryController addCountryController;

    @Autowired
    EditCountryController editCountryController;


    private ObservableList<Country> data;

    @Autowired
    CountryRepository countryRepository;

    @FXML
    private TableView<Country> CountryTable;

    @FXML
    private TableColumn<Country, Integer> CountryIdCol;

    @FXML
    private TableColumn<Country, String> CountryNameCol;



    @FXML
    private JFXButton countryAddBtn, countryEditBtn, countryDeleteBtn;

    @FXML
    private Stage addCountryStage, editCountryStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        countryEditBtn.setDisable(true);
        countryDeleteBtn.setDisable(true);
        CountryTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            countryEditBtn.setDisable(false);
            countryDeleteBtn.setDisable(false);
        });

        loadCountry();

    }

    public void loadCountry()
    {
        Set<Country> fillings = countryRepository.findEverything();
        data = FXCollections.observableArrayList(fillings);
        CountryIdCol.setCellValueFactory(new PropertyValueFactory<Country, Integer>("countryId"));


        CountryNameCol.setCellValueFactory(new PropertyValueFactory<Country, String>("countryName"));

        CountryTable.setItems(data);


    }

    public void addCountryEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addCountryStage = new Stage();
            addCountryStage.setTitle("Add Country");
            addCountryStage.setScene(new Scene(addCountryView.getView()));
            addCountryStage.setResizable(true);
            addCountryStage.centerOnScreen();
            addCountryStage.initModality(Modality.APPLICATION_MODAL);

            num++;

        }


        addCountryStage.show();
        addCountryController.stage = addCountryStage;
        countryEditBtn.setDisable(true);
        countryDeleteBtn.setDisable(true);



    }

    public void editCountryEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editCountryStage = new Stage();
            editCountryStage.setTitle("Edit a Country");
            editCountryStage.setScene(new Scene(editCountryView.getView()));
            editCountryStage.setResizable(true);
            editCountryStage.centerOnScreen();
            editCountryStage.initModality(Modality.APPLICATION_MODAL);

            num1++;

        }


        editCountryStage.show();
        editCountryController.stage = editCountryStage;


        Country country = CountryTable.getSelectionModel().getSelectedItem();
        editCountryController.country = country;


        editCountryController.addCountryTxt.setText(country.getCountryName());

        countryEditBtn.setDisable(true);
        countryDeleteBtn.setDisable(true);





    }


    public void deleteCountryEvent(javafx.event.ActionEvent event) {

        Country country = CountryTable.getSelectionModel().getSelectedItem();
        countryRepository.deleteById(country.getCountryId());
        countryDeleteBtn.setDisable(true);
        countryEditBtn.setDisable(true);
        loadCountry();

    }


}

