package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OccasionByYear;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OccasionByYearRepo;
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

public class OccasionByYearController {
    private ObservableList<OccasionByYear> data;

    @Autowired
    OccasionByYearRepo occasionByYearRepo;

    protected int year = 0;


    @FXML
    private TableView<OccasionByYear> OBYTable;

    @FXML
    private TableColumn<OccasionByYear, String> Occasion;

    @FXML
    private TableColumn<OccasionByYear, String> FirstName;

    @FXML
    private TableColumn<OccasionByYear, String> LastName;

    @FXML
    private TableColumn<OccasionByYear, String> Product;

    @FXML
    private TableColumn<OccasionByYear, Date> OrderCompleteDate;

    @FXML
    private TableColumn<OccasionByYear,Double> OrderTotal;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<OccasionByYear> views = occasionByYearRepo.occasionByYearReport(year);
        data = FXCollections.observableArrayList(views);
        Occasion.setCellValueFactory(new PropertyValueFactory<OccasionByYear, String>("occasion"));

        FirstName.setCellValueFactory(new PropertyValueFactory<OccasionByYear, String>("customerFirstName"));

        LastName.setCellValueFactory(new PropertyValueFactory<OccasionByYear, String>("customerLastName"));

        Product.setCellValueFactory(new PropertyValueFactory<OccasionByYear, String>("productType"));

        OrderCompleteDate.setCellValueFactory(new PropertyValueFactory<OccasionByYear, Date>("orderCompletedDate"));

        OrderTotal.setCellValueFactory(new PropertyValueFactory<OccasionByYear, Double>("orderTotalPrice"));

        OBYTable.setItems(data);


    }


}
