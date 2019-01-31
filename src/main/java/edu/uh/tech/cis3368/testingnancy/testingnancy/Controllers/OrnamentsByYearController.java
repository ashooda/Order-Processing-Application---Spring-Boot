package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentsByYear;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OrnamentByYearRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Set;

public class OrnamentsByYearController {
    private ObservableList<OrnamentsByYear> data;

    @Autowired
    OrnamentByYearRepo ornamentByYearRepo;


    @FXML
    private TableView<OrnamentsByYear> OBYTable;

    @FXML
    private TableColumn<OrnamentsByYear, Integer> OrderID;

    @FXML
    private TableColumn<OrnamentsByYear, String> FirstName;

    @FXML
    private TableColumn<OrnamentsByYear, String> LastName;

    @FXML
    private TableColumn<OrnamentsByYear, Integer> OrnamentID;

    @FXML
    private TableColumn<OrnamentsByYear, String> OrnamentType;

    @FXML
    private TableColumn<OrnamentsByYear, String> OrnamentColor;

    @FXML
    private TableColumn<OrnamentsByYear, String> OrnamentSize;


    @FXML
    public void initialize() {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView() {
        Set<OrnamentsByYear> views = ornamentByYearRepo.ornamentByYearReport();
        data = FXCollections.observableArrayList(views);

        OrderID.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, Integer>("orderId"));

        FirstName.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, String>("customerFirstName"));


        LastName.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear,String>("customerLastName"));

        OrnamentID.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, Integer>("ornamentId"));

        OrnamentType.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, String>("ornamentType"));

        OrnamentColor.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, String>("ornamentColor"));


        OrnamentSize.setCellValueFactory(new PropertyValueFactory<OrnamentsByYear, String>("ornamentSize"));

        OBYTable.setItems(data);


    }
}


