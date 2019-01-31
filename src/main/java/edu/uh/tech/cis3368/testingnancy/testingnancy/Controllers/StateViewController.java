package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.StateProvince;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.StateProvinceRepository;
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

public class StateViewController {
    @Autowired
    @Qualifier("addState")
    ConfigurationControllers.View addStateView;

    @Autowired
    @Qualifier("editState")
    ConfigurationControllers.View editStateView;

    @Autowired
    AddStateController addStateController;

    @Autowired
    EditStateController editStateController;


    private ObservableList<StateProvince> data;

    @Autowired
    StateProvinceRepository stateProvinceRepository;

    @FXML
    private TableView<StateProvince> StateTable;

    @FXML
    private TableColumn<StateProvince, Integer> StateIdCol;

    @FXML
    private TableColumn<StateProvince, String> StateNameCol;



    @FXML
    private JFXButton stateAddBtn, stateEditBtn, stateDeleteBtn;

    @FXML
    private Stage addStateStage, editStateStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        stateEditBtn.setDisable(true);
        stateDeleteBtn.setDisable(true);
        StateTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            stateEditBtn.setDisable(false);
            stateDeleteBtn.setDisable(false);
        });

        loadState();

    }

    public void loadState()
    {
        Set<StateProvince> fillings = stateProvinceRepository.findEverything();
        data = FXCollections.observableArrayList(fillings);
        StateIdCol.setCellValueFactory(new PropertyValueFactory<StateProvince, Integer>("stateProvinceId"));


        StateNameCol.setCellValueFactory(new PropertyValueFactory<StateProvince, String>("stateName"));

        StateTable.setItems(data);


    }

    public void addStateEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addStateStage = new Stage();
            addStateStage.setTitle("Add State/Province");
            addStateStage.setScene(new Scene(addStateView.getView()));
            addStateStage.setResizable(true);
            addStateStage.centerOnScreen();
            addStateStage.initModality(Modality.APPLICATION_MODAL);

            num++;

        }


        addStateStage.show();
        addStateController.stage = addStateStage;
        stateEditBtn.setDisable(true);
        stateDeleteBtn.setDisable(true);



    }

    public void editStateEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editStateStage = new Stage();
            editStateStage.setTitle("Edit a State/Province");
            editStateStage.setScene(new Scene(editStateView.getView()));
            editStateStage.setResizable(true);
            editStateStage.centerOnScreen();
            editStateStage.initModality(Modality.APPLICATION_MODAL);

            num1++;

        }


        editStateStage.show();
        editStateController.stage = editStateStage;


        StateProvince stateProvince = StateTable.getSelectionModel().getSelectedItem();
        editStateController.stateProvince = stateProvince;


        editStateController.addStateTxt.setText(stateProvince.getStateName());

        stateEditBtn.setDisable(true);
        stateDeleteBtn.setDisable(true);





    }


    public void deleteStateEvent(javafx.event.ActionEvent event) {

        StateProvince stateProvince = StateTable.getSelectionModel().getSelectedItem();
        stateProvinceRepository.deleteById(stateProvince.getStateProvinceId());
        stateDeleteBtn.setDisable(true);
        stateEditBtn.setDisable(true);
        loadState();

    }


}

