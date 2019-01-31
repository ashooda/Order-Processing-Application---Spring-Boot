package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.AvgPriceOccasion;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.AvgPriceOccasionRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Set;

public class AvgPriceOccasionController {
    private ObservableList<AvgPriceOccasion> data;

    @Autowired
    AvgPriceOccasionRepository avgPriceOccasionRepository;


    @FXML
    private TableView<AvgPriceOccasion> APOTable;

    @FXML
    private TableColumn<AvgPriceOccasion, String> OccasionType;

    @FXML
    private TableColumn<AvgPriceOccasion, Integer> ProductTypeID;

    @FXML
    private TableColumn<AvgPriceOccasion, String> ProductType;

    @FXML
    private TableColumn<AvgPriceOccasion, Integer> ProductFrequency;

    @FXML
    private TableColumn<AvgPriceOccasion, Double> AveragePrice;

    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<AvgPriceOccasion> views = avgPriceOccasionRepository.avgPriceOccasionReport();
        data = FXCollections.observableArrayList(views);
        OccasionType.setCellValueFactory(new PropertyValueFactory<AvgPriceOccasion, String>("occasionType"));

        ProductTypeID.setCellValueFactory(new PropertyValueFactory<AvgPriceOccasion, Integer>("productTypeId"));

        ProductType.setCellValueFactory(new PropertyValueFactory<AvgPriceOccasion, String>("productType"));
        ProductFrequency.setCellValueFactory(new PropertyValueFactory<AvgPriceOccasion, Integer>("productFrequency"));
        AveragePrice.setCellValueFactory(new PropertyValueFactory<AvgPriceOccasion, Double>("averagePrice"));


        APOTable.setItems(data);


    }





}
