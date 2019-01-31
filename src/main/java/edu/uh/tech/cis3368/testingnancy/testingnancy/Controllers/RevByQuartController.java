package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.RevByQuarter;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.RevByQuarterRepository;
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

public class RevByQuartController {
    private ObservableList<RevByQuarter> data;

    @Autowired
    RevByQuarterRepository revByQuarterRepository;


    @FXML
    private TableView<RevByQuarter> RBQTable;

    @FXML
    private TableColumn<RevByQuarter, String> Occasion;

    @FXML
    private TableColumn<RevByQuarter, String> OrderStatus;

    @FXML
    private TableColumn<RevByQuarter, Date> CompletedDate;

    @FXML
    private TableColumn<RevByQuarter, Double> TotalPrice;

    @FXML
    private TableColumn<RevByQuarter, Double> Revenue;



    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<RevByQuarter> views = revByQuarterRepository.revByQuarterReport(3, 2018);
        data = FXCollections.observableArrayList(views);
        Occasion.setCellValueFactory(new PropertyValueFactory<RevByQuarter, String>("occasionType"));

        OrderStatus.setCellValueFactory(new PropertyValueFactory<RevByQuarter, String>("orderStatus"));

        CompletedDate.setCellValueFactory(new PropertyValueFactory<RevByQuarter, Date>("orderCompletedDate"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<RevByQuarter, Double>("orderTotalPrice"));
        Revenue.setCellValueFactory(new PropertyValueFactory<RevByQuarter, Double>("revenue"));


        RBQTable.setItems(data);


    }


}



