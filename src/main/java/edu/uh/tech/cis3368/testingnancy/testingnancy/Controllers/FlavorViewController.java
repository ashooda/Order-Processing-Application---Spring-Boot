package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Flavor;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FlavorRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.Set;

public class FlavorViewController {
    @Autowired
    @Qualifier("addFlavor")
    ConfigurationControllers.View addFlavView;

    @Autowired
    @Qualifier("editFlavor")
    ConfigurationControllers.View editFlavView;

    @Autowired
    AddFlavorController addFlavorController;

    @Autowired
    EditFlavorController editFlavorController;


    private ObservableList<Flavor> data;

    @Autowired
    FlavorRepository flavorRepository;

    @FXML
    private TableView<Flavor> FlavorTable ;

    @FXML
    private TableColumn<Flavor, Integer> FlavIdCol;

    @FXML
    private TableColumn<Flavor, String> FlavStatCol;

    @FXML
    private TableColumn<Flavor, String> FlavTypeCol;

    @FXML
    private JFXButton flavAddBtn, flavEditBtn, flavDeleteBtn;

    @FXML
    private Stage addFlavStage, editFlavStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        flavEditBtn.setDisable(true);
        flavDeleteBtn.setDisable(true);
        FlavorTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            flavEditBtn.setDisable(false);
            flavDeleteBtn.setDisable(false);
        });

        loadFlavors();

    }

    public void loadFlavors()
    {
        Set<Flavor> frostings = flavorRepository.findEverything();
        data = FXCollections.observableArrayList(frostings);
        FlavIdCol.setCellValueFactory(new PropertyValueFactory<Flavor, Integer>("flavorId"));

        FlavStatCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Flavor,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Flavor, String> param) {
                return new SimpleStringProperty(param.getValue().getFlavorStatus().getFlavorStatus());
            }
        });

        FlavTypeCol.setCellValueFactory(new PropertyValueFactory<Flavor, String>("flavorType"));

        FlavorTable.setItems(data);


    }

    public void addFlavEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addFlavStage = new Stage();
            addFlavStage.setTitle("Add Flavor");
            addFlavStage.setScene(new Scene(addFlavView.getView()));
            addFlavStage.setResizable(true);
            addFlavStage.centerOnScreen();
            addFlavStage.initModality(Modality.APPLICATION_MODAL);

            num++;

        }


        addFlavStage.show();
        addFlavorController.stage = addFlavStage;



    }

    public void editFlavEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editFlavStage = new Stage();
            editFlavStage.setTitle("Edit a Flavor");
            editFlavStage.setScene(new Scene(editFlavView.getView()));
            editFlavStage.setResizable(true);
            editFlavStage.centerOnScreen();
            editFlavStage.initModality(Modality.APPLICATION_MODAL);
            flavEditBtn.setDisable(true);
            flavDeleteBtn.setDisable(true);

            num1++;

        }


        editFlavStage.show();
        editFlavorController.stage = editFlavStage;


        Flavor flavor = FlavorTable.getSelectionModel().getSelectedItem();
        editFlavorController.flavor = flavor;

        editFlavorController.flavStatusCombo.setValue(flavor.getFlavorStatus().getFlavorStatus());
        editFlavorController.addFlavorTxt.setText(flavor.getFlavorType());

        flavEditBtn.setDisable(true);
        flavDeleteBtn.setDisable(true);





    }


    public void deleteFlavEvent(javafx.event.ActionEvent event) {

        Flavor flavor = FlavorTable.getSelectionModel().getSelectedItem();
        flavorRepository.deleteById(flavor.getFlavorId());
        flavDeleteBtn.setDisable(true);
        flavEditBtn.setDisable(true);
        loadFlavors();

    }
}

