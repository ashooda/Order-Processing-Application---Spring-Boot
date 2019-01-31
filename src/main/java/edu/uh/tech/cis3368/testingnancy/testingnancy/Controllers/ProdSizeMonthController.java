package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductSizeMonth;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.ProductSizeMonthRepo;
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

public class ProdSizeMonthController {
    private ObservableList<ProductSizeMonth> data;

    @Autowired
    ProductSizeMonthRepo productSizeMonthRepo;


    @FXML
    private TableView<ProductSizeMonth> PSMTable;

    @FXML
    private TableColumn<ProductSizeMonth, Integer> OrderID;

    @FXML
    private TableColumn<ProductSizeMonth, String> Product;

    @FXML
    private TableColumn<ProductSizeMonth, String> Size;

    @FXML
    private TableColumn<ProductSizeMonth, Date> OrderCompletedDate;


    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<ProductSizeMonth> views = productSizeMonthRepo.productSizeByMonthReport(7,2018);
        data = FXCollections.observableArrayList(views);
        OrderID.setCellValueFactory(new PropertyValueFactory<ProductSizeMonth, Integer>("orderId"));

        Product.setCellValueFactory(new PropertyValueFactory<ProductSizeMonth, String>("productType"));

        Size.setCellValueFactory(new PropertyValueFactory<ProductSizeMonth, String>("sizeDimension"));
        OrderCompletedDate.setCellValueFactory(new PropertyValueFactory<ProductSizeMonth, Date>("orderCompletedDate"));


        PSMTable.setItems(data);


    }


}

