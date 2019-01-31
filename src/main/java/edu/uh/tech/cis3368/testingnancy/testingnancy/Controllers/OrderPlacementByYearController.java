package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrderPlacementByYear;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OrderPlacementYearRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.Set;

public class OrderPlacementByYearController {
    private ObservableList<OrderPlacementByYear> data;

    @Autowired
    OrderPlacementYearRepo orderPlacementYearRepo;


    @FXML
    private TableView<OrderPlacementByYear> OPYTable;

    @FXML
    private TableColumn<OrderPlacementByYear, String> FirstName;

    @FXML
    private TableColumn<OrderPlacementByYear, String> LastName;

    @FXML
    private TableColumn<OrderPlacementByYear, Integer> CustomerID;

    @FXML
    private TableColumn<OrderPlacementByYear, String> CustomerStatus;

    @FXML
    private TableColumn<OrderPlacementByYear, String> CustomerType;

    @FXML
    private TableColumn<OrderPlacementByYear,String> OrderPlacementMethod;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<OrderPlacementByYear> views = orderPlacementYearRepo.opmByYearReport(2018);
        data = FXCollections.observableArrayList(views);

        FirstName.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, String>("customerFirstName"));

        LastName.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, String>("customerLastName"));


        CustomerID.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, Integer>("customerId"));

        CustomerStatus.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, String>("customerStatus"));

        CustomerType.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, String>("customerType"));

        OrderPlacementMethod.setCellValueFactory(new PropertyValueFactory<OrderPlacementByYear, String>("orderPlacementMethod"));

        OPYTable.setItems(data);


    }


}
