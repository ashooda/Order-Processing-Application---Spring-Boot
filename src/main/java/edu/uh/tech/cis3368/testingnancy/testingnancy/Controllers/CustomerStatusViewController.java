package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.CustomerStatus;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.CustomerStatusRepository;
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

public class CustomerStatusViewController {
    @Autowired
    @Qualifier("addCustStat")
    ConfigurationControllers.View addCustStatView;

    @Autowired
    @Qualifier("editCustStat")
    ConfigurationControllers.View editCustStatView;

    @Autowired
    AddCustomerStatusController addCustomerStatusController;

    @Autowired
    EditCustomerStatusController editCustomerStatusController;


    private ObservableList<CustomerStatus> data;

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @FXML
    private TableView<CustomerStatus> CustomerStatusTable;

    @FXML
    private TableColumn<CustomerStatus, Integer> CustStatIdCol;

    @FXML
    private TableColumn<CustomerStatus, String> CustStatTypeCol;



    @FXML
    private JFXButton custStatAddBtn, custStatEditBtn, custStatDeleteBtn;

    @FXML
    private Stage addCustStatStage, editCustStatStage;

    private int num = 0;
    private int num1 = 0;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {
        custStatEditBtn.setDisable(true);
        custStatDeleteBtn.setDisable(true);
        CustomerStatusTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            custStatEditBtn.setDisable(false);
            custStatDeleteBtn.setDisable(false);
        });

        loadCustStat();

    }

    public void loadCustStat()
    {
        Set<CustomerStatus> fillings = customerStatusRepository.findEverything();
        data = FXCollections.observableArrayList(fillings);
        CustStatIdCol.setCellValueFactory(new PropertyValueFactory<CustomerStatus, Integer>("customerStatusId"));


        CustStatTypeCol.setCellValueFactory(new PropertyValueFactory<CustomerStatus, String>("customerStatus"));

        CustomerStatusTable.setItems(data);


    }

    public void addCustStatEvent(javafx.event.ActionEvent event){

        while (num < 1)
        {
            addCustStatStage = new Stage();
            addCustStatStage.setTitle("Add Customer Status");
            addCustStatStage.setScene(new Scene(addCustStatView.getView()));
            addCustStatStage.setResizable(true);
            addCustStatStage.centerOnScreen();
            addCustStatStage.initModality(Modality.APPLICATION_MODAL);

            num++;

        }


        addCustStatStage.show();
        addCustomerStatusController.stage = addCustStatStage;
        custStatEditBtn.setDisable(true);
        custStatDeleteBtn.setDisable(true);



    }

    public void editCustStatEvent(javafx.event.ActionEvent event){
        while (num1 < 1)
        {
            editCustStatStage = new Stage();
            editCustStatStage.setTitle("Edit a Customer Status");
            editCustStatStage.setScene(new Scene(editCustStatView.getView()));
            editCustStatStage.setResizable(true);
            editCustStatStage.centerOnScreen();
            editCustStatStage.initModality(Modality.APPLICATION_MODAL);

            num1++;

        }


        editCustStatStage.show();
        editCustomerStatusController.stage = editCustStatStage;


        CustomerStatus customerStatus = CustomerStatusTable.getSelectionModel().getSelectedItem();
        editCustomerStatusController.customerStatus = customerStatus;


        editCustomerStatusController.addCustomerStatusTxt.setText(customerStatus.getCustomerStatus());

        custStatEditBtn.setDisable(true);
        custStatDeleteBtn.setDisable(true);





    }


    public void deleteCustStatEvent(javafx.event.ActionEvent event) {

        CustomerStatus customerStatus = CustomerStatusTable.getSelectionModel().getSelectedItem();
        customerStatusRepository.deleteById(customerStatus.getCustomerStatusId());
        custStatDeleteBtn.setDisable(true);
        custStatEditBtn.setDisable(true);
        loadCustStat();

    }


}


