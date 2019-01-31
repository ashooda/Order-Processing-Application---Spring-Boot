package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.FillingByQuarter;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.FillingByQuarterRepository;
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

public class FillingByQuartController {
    private ObservableList<FillingByQuarter> data;

    @Autowired
    FillingByQuarterRepository fillingByQuarterRepository;

    protected  Set<FillingByQuarter> views;

    protected int quarter = 0;
    protected int year = 0 ;


    @FXML
    private TableView<FillingByQuarter> FBQTable;

    @FXML
    private TableColumn<FillingByQuarter, Integer> OrderID;

    @FXML
    private TableColumn<FillingByQuarter, String> Product;

    @FXML
    private TableColumn<FillingByQuarter, Date> OrderCompletedDate;

    @FXML
    private TableColumn<FillingByQuarter, String> Filling;


    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {

        loadView();


    }

    public void loadView()
    {

        views = fillingByQuarterRepository.fillByQuartReport(quarter,year);
        data = FXCollections.observableArrayList(views);
        OrderID.setCellValueFactory(new PropertyValueFactory<FillingByQuarter, Integer>("orderId"));

        Product.setCellValueFactory(new PropertyValueFactory<FillingByQuarter, String>("productType"));

        OrderCompletedDate.setCellValueFactory(new PropertyValueFactory<FillingByQuarter, Date>("orderCompletedDate"));
        Filling.setCellValueFactory(new PropertyValueFactory<FillingByQuarter, String>("fillingType"));


        FBQTable.setItems(data);

    }


}
