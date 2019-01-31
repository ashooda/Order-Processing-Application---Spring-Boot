package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Frosting;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FrostingRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class FrostingViewController {

    @Autowired
    @Qualifier("addFrosting")
    ConfigurationControllers.View addFrostView;

    @Autowired
    @Qualifier("editFrosting")
    ConfigurationControllers.View editFrostView;

    @Autowired
    AddFrostingController addFrostingController;

    @Autowired
    EditFrostingController editFrostingController;


    private ObservableList<Frosting> data;

    @Autowired
    FrostingRepository frostingRepository;

    @FXML
    private TableView<Frosting> FrostingTable ;

    @FXML
    private TableColumn<Frosting, Integer> FrostIdCol;

    @FXML
    private TableColumn<Frosting, String> FrostStatCol;

    @FXML
    private TableColumn<Frosting, String> FrostTypeCol;

    @FXML
    private JFXButton  frostingAddBtn, frostingEditBtn, frostingDeleteBtn;

    @FXML
    private  Stage addFrostStage, editFrostStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        frostingEditBtn.setDisable(true);
        frostingDeleteBtn.setDisable(true);
        FrostingTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            frostingEditBtn.setDisable(false);
            frostingDeleteBtn.setDisable(false);
        });

        loadFrostings();

    }

    public void loadFrostings()
    {
        Set<Frosting> frostings = frostingRepository.findEverything();
        data = FXCollections.observableArrayList(frostings);
        FrostIdCol.setCellValueFactory(new PropertyValueFactory<Frosting, Integer>("frostingId"));

        FrostStatCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Frosting,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Frosting, String> param) {
                return new SimpleStringProperty(param.getValue().getFrostingStatus().getFrostingStatus());
            }
        });

        FrostTypeCol.setCellValueFactory(new PropertyValueFactory<Frosting, String>("frostingType"));

        FrostingTable.setItems(data);


    }

    public void addFrostingEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addFrostStage = new Stage();
            addFrostStage.setTitle("Add Frosting");
            addFrostStage.setScene(new Scene(addFrostView.getView()));
            addFrostStage.setResizable(true);
            addFrostStage.centerOnScreen();
            addFrostStage.initModality(Modality.APPLICATION_MODAL);


            num++;

        }


        addFrostStage.show();
        addFrostingController.stage = addFrostStage;
        frostingEditBtn.setDisable(true);
        frostingDeleteBtn.setDisable(true);



    }

    public void editFrostingEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editFrostStage = new Stage();
            editFrostStage.setTitle("Edit a Frosting");
            editFrostStage.setScene(new Scene(editFrostView.getView()));
            editFrostStage.setResizable(true);
            editFrostStage.centerOnScreen();
            editFrostStage.initModality(Modality.APPLICATION_MODAL);

            num1++;

        }


        editFrostStage.show();
       editFrostingController.stage = editFrostStage;


        Frosting frosting = FrostingTable.getSelectionModel().getSelectedItem();
       editFrostingController.frosting = frosting;

       editFrostingController.frostStatusCombo.setValue(frosting.getFrostingStatus().getFrostingStatus());
       editFrostingController.addFrostingTxt.setText(frosting.getFrostingType());

        frostingEditBtn.setDisable(true);
        frostingDeleteBtn.setDisable(true);





    }


    public void deleteFrostingEvent(javafx.event.ActionEvent event) {

        Frosting frosting = FrostingTable.getSelectionModel().getSelectedItem();
        frostingRepository.deleteById(frosting.getFrostingId());
        frostingDeleteBtn.setDisable(true);
        frostingEditBtn.setDisable(true);
        loadFrostings();

    }
}
