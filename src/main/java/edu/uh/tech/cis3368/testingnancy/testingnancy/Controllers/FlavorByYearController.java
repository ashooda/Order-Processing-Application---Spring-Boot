package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FlavorByYear;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FlavorByYearRepo;
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

public class FlavorByYearController {
    private ObservableList<FlavorByYear> data;

    protected int year = 0 ;
    @Autowired
    FlavorByYearRepo flavorByYearRepo;


    @FXML
    private TableView<FlavorByYear> FBYTable;

    @FXML
    private TableColumn<FlavorByYear, Integer> OrderID;

    @FXML
    private TableColumn<FlavorByYear, String> Product;

    @FXML
    private TableColumn<FlavorByYear, Date> OrderCompletedDate;

    @FXML
    private TableColumn<FlavorByYear, String> Flavor;


    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<FlavorByYear> views = flavorByYearRepo.flavByYearReport(year);
        data = FXCollections.observableArrayList(views);
        OrderID.setCellValueFactory(new PropertyValueFactory<FlavorByYear, Integer>("orderId"));

        Product.setCellValueFactory(new PropertyValueFactory<FlavorByYear, String>("productType"));

        OrderCompletedDate.setCellValueFactory(new PropertyValueFactory<FlavorByYear, Date>("orderCompletedDate"));
        Flavor.setCellValueFactory(new PropertyValueFactory<FlavorByYear, String>("flavorType"));


        FBYTable.setItems(data);


    }



}
