package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;
import com.jfoenix.controls.JFXButton;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.*;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;


import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import javax.annotation.PostConstruct;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

public class MainTabController  {

    @Autowired CustomerRepository customerRepository;
    @Autowired CountryRepository countryRepository;
    @Autowired CustomerTypeRepository customerTypeRepository;
    @Autowired CustomerStatusRepository customerStatusRepository;
    @Autowired StateProvinceRepository stateProvinceRepository;
    @Autowired OrdersRepository ordersRepository;


    private ObservableList<Customer> data;
    private ObservableList<Orders> data1;

    @FXML
    private Stage stage, stage1, editTableStage, orderStage, reportsStage;

    private int num = 0;
    private int num1 = 0;
    private int num2 = 0;
    private  int ordnum = 0;
    private int reportsnum = 0;




    @Autowired
    @Qualifier("addCust")
    ConfigurationControllers.View view;

    @Autowired
    ConfigurationControllers configurationControllers;

    @Autowired
    @Qualifier("editCust")
    ConfigurationControllers.View editview ;

    @Autowired
    @Qualifier("editTables")
    ConfigurationControllers.View editTablesview;

    @Autowired
    @Qualifier("orderForm")
    ConfigurationControllers.View orderview;

    @Autowired
    @Qualifier("viewReports")
    ConfigurationControllers.View viewReportsView;

    @Autowired
    EditCustomerController editCustomerController;

    @Autowired
    addCustomerController addCustomerController;





    @FXML
    private TableView<Customer> CustomerTable;

    @FXML
    private TableColumn<Customer, Integer> CustIdCol;

    @FXML
    private TableColumn<Customer, String> countryCol;

    @FXML
    private TableColumn<Customer, String> cusTypeCol;

    @FXML
    private TableColumn<Customer, String> custStatusCol;

    @FXML
    private TableColumn<Customer, String> stateCol;

    @FXML
    private TableColumn<Customer, String> phoneCol;

    @FXML
    private TableColumn<Customer, String> fnameCol;

    @FXML
    private TableColumn<Customer, String> lnameCol;

    @FXML
    private TableColumn<Customer, String> emailCol;

    @FXML
    private TableColumn<Customer, String> cityCol;

    @FXML
    private TableColumn<Customer, String> streetCol;

    @FXML
    private TableColumn<Customer, String> zipCol;

    @FXML
    private AnchorPane HomeTab;

    @FXML
    private BorderPane orderTab, CustomerTab;

    @FXML
    private JFXButton homeButton, customerTblViewBtn, OrdersTblViewBtn, modificationsTblViewBtn, exitButton, custAddBtn, CustEditButton;

    public MainTabController() {
    }

    @FXML
    public void initialize( ) {

    }

    @PostConstruct
    public void init() {

        loadCustomerData();
        orderDataLoader();
    }

    public void loadCustomerData(){
        CustEditButton.setDisable(true);
        CustomerTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
                    CustEditButton.setDisable(false);
                });

        Set<Customer> customers = customerRepository.findEverything();


        data = FXCollections.observableArrayList(customers);



        CustIdCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerId"));

        countryCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Customer, String> param) {
                return new SimpleStringProperty(param.getValue().getCountry().getCountryName());
            }
        });

        cusTypeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Customer, String> param) {
                return new SimpleStringProperty(param.getValue().getCustomerType().getCustomerType());
            }
        });

        custStatusCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Customer, String> param) {
                return new SimpleStringProperty(param.getValue().getCustomerStatus().getCustomerStatus());
            }
        });

        stateCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Customer, String> param) {
                return new SimpleStringProperty(param.getValue().getStateProvince().getStateName());
            }
        });

        phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerPhoneNumber"));

        fnameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerFirstName"));

        lnameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerLastName"));

        emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEmail"));

        cityCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerCity"));

        streetCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerStreetAddress"));

        zipCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerZipcode"));

        CustomerTable.setItems(data);






    }

    @FXML
    private TableView<Orders> orderTable;

    @FXML
    private TableColumn<Orders, Integer> orderIDCol;

    @FXML
    private TableColumn<Orders, String> ordLnameCol;

    @FXML
    private TableColumn<Orders, String> ordPlacementCol;

    @FXML
    private TableColumn<Orders, String> statCol;

    @FXML
    private TableColumn<Orders, String> occasCol;

    @FXML
    private TableColumn<Orders, String> fulfillCol;

    @FXML
    private TableColumn<Orders, Boolean> renReqCol;

    @FXML
    private TableColumn<Orders, Date> recDateCol;

    @FXML
    private TableColumn<Orders, Timestamp> dueDateCol;

    @FXML
    private TableColumn<Orders, Double> depCol;

    @FXML
    private TableColumn<Orders, String> specReqCol;

    @FXML
    private TableColumn<Orders, String> delStreetCol;

    @FXML
    private TableColumn<Orders, String> delCityCol;

    @FXML
    private TableColumn<Orders, String> delZipCol;

    @FXML
    private TableColumn<Orders, Date> dateCompCol;

    @FXML
    private TableColumn<Orders, String> delByCol;

    @FXML
    private TableColumn<Orders, Double> totPriceCol;


    public void orderDataLoader() {
        Set<Orders> orders = ordersRepository.findEverything();

        data1 = FXCollections.observableArrayList(orders);

        orderIDCol.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("orderId"));

        ordLnameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                return new SimpleStringProperty(param.getValue().getCustomer().getCustomerLastName());
            }
        });

        ordPlacementCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                return new SimpleStringProperty(param.getValue().getOrderPlacementMethod().getOrderPlacementMethod());
            }
        });

        statCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                return new SimpleStringProperty(param.getValue().getOrderStatus().getOrderStatus());
            }
        });

        occasCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                return new SimpleStringProperty(param.getValue().getOrderStatus().getOrderStatus());
            }
        });

        fulfillCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders,String>, ObservableValue<String>>(){

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                return new SimpleStringProperty(param.getValue().getOrderFulfillmentMethod().getOrderFulfillementMethod());
            }
        });

        renReqCol.setCellValueFactory(new PropertyValueFactory<Orders, Boolean>("orderRentalRequest"));

        recDateCol.setCellValueFactory(new PropertyValueFactory<Orders, Date>("orderReceivedDate"));

        dueDateCol.setCellValueFactory(new PropertyValueFactory<Orders, Timestamp>("orderDueDate"));

        depCol.setCellValueFactory(new PropertyValueFactory<Orders, Double>("orderDeposit"));

        specReqCol.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderSpecialRequirements"));

        delStreetCol.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderDeliverStreet"));

        delCityCol.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderDeliveryCity"));

        delZipCol.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderDeliveryZipcode"));

        dateCompCol.setCellValueFactory(new PropertyValueFactory<Orders, Date>("orderCompletedDate"));

        delByCol.setCellValueFactory(new PropertyValueFactory<Orders, String>("orderDeliverBy"));

        totPriceCol.setCellValueFactory(new PropertyValueFactory<Orders, Double>("orderTotalPrice"));


        orderTable.setItems(data1);




    }


    public Customer getSelectedCustomer(){  Customer selected_customer = CustomerTable.getSelectionModel().getSelectedItem();
        return selected_customer;
    }

    public void buttonEvent(javafx.event.ActionEvent event)  {




        if (event.getSource() == homeButton) {
            HomeTab.toFront();
        }
        else if(event.getSource() == customerTblViewBtn)
        {
            CustomerTab.toFront();
        }
        else if(event.getSource() == OrdersTblViewBtn)
        {
            orderTab.toFront();
        }

        else if(event.getSource() == exitButton)
        {
            System.exit(0);
        }
        else if (event.getSource() == custAddBtn)
        {

            try {


                while (num < 1)
                {
                    stage = new Stage();
                    stage.setTitle("Add a new Customer");
                    stage.setScene(new Scene(view.getView()));
                    stage.setResizable(true);
                    stage.centerOnScreen();
                    stage.initModality(Modality.APPLICATION_MODAL);

                    num++;

                }


                stage.show();

            addCustomerController.stage = stage;


            }catch (Exception e)
            {
                e.printStackTrace();
            }



        }
        else if (event.getSource() == modificationsTblViewBtn)
        {
            while (num2 < 1)
            {
                editTableStage = new Stage();
                editTableStage.setTitle("Edit Tables");
                editTableStage.setScene(new Scene(editTablesview.getView()));
                editTableStage.setResizable(true);
                editTableStage.centerOnScreen();
                editTableStage.initModality(Modality.APPLICATION_MODAL);

                num2++;

            }


            editTableStage.show();

        }
    }

        public void buttonEditEvent(javafx.event.ActionEvent event)
        {
                while (num1 < 1)
                {

                    stage1 = new Stage();
                    stage1.setTitle("Edit a new Customer");
                    stage1.setScene(new Scene(editview.getView()));
                    stage1.setResizable(true);
                    stage1.centerOnScreen();
                    stage1.initModality(Modality.APPLICATION_MODAL);
                    num1++;


                }

                stage1.show();

                editCustomerController.stage = stage1;

                Customer customer1 = CustomerTable.getSelectionModel().getSelectedItem();

                editCustomerController.customer = customer1;

                editCustomerController.firstNametxt.setText(customer1.getCustomerFirstName());
                editCustomerController.lastNametxt.setText(customer1.getCustomerLastName());
                editCustomerController.streetTxt.setText(customer1.getCustomerStreetAddress());
                editCustomerController.cityTxt.setText(customer1.getCustomerCity());
                editCustomerController.zipcodeTxt.setText(customer1.getCustomerZipcode());
                editCustomerController.phoneTxt.setText(customer1.getCustomerPhoneNumber());
                editCustomerController.emailTxt.setText(customer1.getCustomerEmail());
                editCustomerController.countryCombo.setValue(customer1.getCountry().getCountryName());
                editCustomerController.stateCombo.setValue(customer1.getStateProvince().getStateName());
                editCustomerController.custTypeCombo.setValue(customer1.getCustomerType().getCustomerType());
                editCustomerController.custStatCombo.setValue(customer1.getCustomerStatus().getCustomerStatus());


            CustEditButton.setDisable(true);


        }



    public void ChangeScenes(ActionEvent event){

    }


    public void addOrder(javafx.event.ActionEvent event) {

        while (ordnum < 1)
        {
            orderStage = new Stage();
            orderStage.setTitle("Add a new Customer");
            orderStage.setScene(new Scene(orderview.getView()));
            orderStage.setResizable(true);
            orderStage.centerOnScreen();
            orderStage.initModality(Modality.APPLICATION_MODAL);

            ordnum++;

        }


        orderStage.show();

    }

    public void reportsEvent(javafx.event.ActionEvent event) {
        while (reportsnum < 1)
        {
            reportsStage = new Stage();
            reportsStage.setTitle("View Reports");
            reportsStage.setScene(new Scene(viewReportsView.getView()));
            reportsStage.setResizable(true);
            reportsStage.centerOnScreen();
            reportsStage.initModality(Modality.APPLICATION_MODAL);

            reportsnum++;

        }


        reportsStage.show();
    }
}
