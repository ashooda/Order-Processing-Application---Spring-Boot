package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.OrnamentRentalOccasion;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OrnamentRentalOccasionRepository;
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

public class OrnamentRentalOccasionController {
    private ObservableList<OrnamentRentalOccasion> data;


    @Autowired
    OrnamentRentalOccasionRepository ornamentRentalOccasionRepository;


    @FXML
    private TableView<OrnamentRentalOccasion> OROTable;

    @FXML
    private TableColumn<OrnamentRentalOccasion, String> OccasionType;

    @FXML
    private TableColumn<OrnamentRentalOccasion, String> OrnamentType;


    @FXML
    private TableColumn<OrnamentRentalOccasion, Integer> Frequency;


    @FXML
    public void initialize( ) {


    }

    @PostConstruct
    public void init() {


        loadView();

    }

    public void loadView()
    {
        Set<OrnamentRentalOccasion> views = ornamentRentalOccasionRepository.ornamentRentalOccasionReport();
        data = FXCollections.observableArrayList(views);
        OccasionType.setCellValueFactory(new PropertyValueFactory<OrnamentRentalOccasion, String>("occasionType"));

        OrnamentType.setCellValueFactory(new PropertyValueFactory<OrnamentRentalOccasion, String>("ornamentType"));

        Frequency.setCellValueFactory(new PropertyValueFactory<OrnamentRentalOccasion, Integer>("frequency"));


        OROTable.setItems(data);


    }


}

