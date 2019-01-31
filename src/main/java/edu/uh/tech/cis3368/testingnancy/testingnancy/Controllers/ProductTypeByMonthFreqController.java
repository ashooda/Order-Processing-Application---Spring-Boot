package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductbyMonth;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.ProductTypeFrequencyRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Set;

public class ProductTypeByMonthFreqController {
    private ObservableList<ProductbyMonth> data;


    @Autowired
    ProductTypeFrequencyRepo productTypeFrequencyRepo;


    @FXML
    private TableView<ProductbyMonth> PBMTable;

    @FXML
    private TableColumn<ProductbyMonth, String> ProductType;

    @FXML
    private TableColumn<ProductbyMonth, Integer> Quantity;




    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<ProductbyMonth> views = productTypeFrequencyRepo.productByMonthReport();
        data = FXCollections.observableArrayList(views);
        ProductType.setCellValueFactory(new PropertyValueFactory<ProductbyMonth, String>("productType"));

        Quantity.setCellValueFactory(new PropertyValueFactory<ProductbyMonth, Integer>("quantity"));



        PBMTable.setItems(data);


    }}


