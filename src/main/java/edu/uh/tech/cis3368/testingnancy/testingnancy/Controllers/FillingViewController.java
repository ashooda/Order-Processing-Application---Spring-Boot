package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.Filling;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FillingRepository;
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

public class FillingViewController {
    @Autowired
    @Qualifier("addFilling")
    ConfigurationControllers.View addFillView;

    @Autowired
    @Qualifier("editFilling")
    ConfigurationControllers.View editFillView;

    @Autowired
    AddFillingController addFillingController;

    @Autowired
    EditFillingsController editFillingsController;


    private ObservableList<Filling> data;

    @Autowired
    FillingRepository fillingRepository;

    @FXML
    private TableView<Filling> FillingTable;

    @FXML
    private TableColumn<Filling, Integer> FillIdCol;

    @FXML
    private TableColumn<Filling, String> FillStatCol;

    @FXML
    private TableColumn<Filling, String> FillTypeCol;

    @FXML
    private JFXButton fillingAddBtn, fillingEditBtn, fillingDeleteBtn;

    @FXML
    private Stage addFillStage, editFillStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        fillingEditBtn.setDisable(true);
        fillingDeleteBtn.setDisable(true);
        FillingTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            fillingEditBtn.setDisable(false);
            fillingDeleteBtn.setDisable(false);
        });

        loadFillings();

    }

    public void loadFillings()
    {
        Set<Filling> fillings = fillingRepository.findEverything();
        data = FXCollections.observableArrayList(fillings);
        FillIdCol.setCellValueFactory(new PropertyValueFactory<Filling, Integer>("fillingId"));

        FillStatCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Filling,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Filling, String> param) {
                return new SimpleStringProperty(param.getValue().getFillingStatus().getFillingStatus());
            }
        });

        FillTypeCol.setCellValueFactory(new PropertyValueFactory<Filling, String>("fillingType"));

        FillingTable.setItems(data);


    }

    public void addFillingEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addFillStage = new Stage();
            addFillStage.setTitle("Add Filling");
            addFillStage.setScene(new Scene(addFillView.getView()));
            addFillStage.setResizable(true);
            addFillStage.centerOnScreen();
            addFillStage.initModality(Modality.APPLICATION_MODAL);

            num++;

        }


        addFillStage.show();
        addFillingController.stage = addFillStage;
        fillingEditBtn.setDisable(true);
        fillingDeleteBtn.setDisable(true);



    }

    public void editFillingEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editFillStage = new Stage();
            editFillStage.setTitle("Edit a Filling");
            editFillStage.setScene(new Scene(editFillView.getView()));
            editFillStage.setResizable(true);
            editFillStage.centerOnScreen();
            editFillStage.initModality(Modality.APPLICATION_MODAL);

            num1++;

        }


        editFillStage.show();
        editFillingsController.stage = editFillStage;


        Filling filling = FillingTable.getSelectionModel().getSelectedItem();
        editFillingsController.filling = filling;

        editFillingsController.fillStatusCombo.setValue(filling.getFillingStatus().getFillingStatus());
        editFillingsController.addFillingTxt.setText(filling.getFillingType());

        fillingEditBtn.setDisable(true);
        fillingDeleteBtn.setDisable(true);





    }


    public void deleteFillingEvent(javafx.event.ActionEvent event) {

        Filling filling = FillingTable.getSelectionModel().getSelectedItem();
        fillingRepository.deleteById(filling.getFillingId());
        fillingDeleteBtn.setDisable(true);
        fillingEditBtn.setDisable(true);
        loadFillings();

    }


}
