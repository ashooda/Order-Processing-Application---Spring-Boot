package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.ProductLayer;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class AddLayerController {

    Stage stage;

    @Autowired
    FlavorRepository flavorRepository;
    @Autowired
    FillingRepository fillingRepository;
    @Autowired
    FrostingRepository frostingRepository;
    @Autowired
    ShapeRepository shapeRepository;
    @Autowired
    SizeRepository sizeRepository;

    @Autowired
     Controller controller;
    ProductLayer productLayer;

    @FXML
    private JFXTextField layerNumCombooTxt;

    @FXML
    private JFXButton saveBtn, cancelBtn;

    @FXML
    private JFXComboBox<String> flavor, frosting, filling, size, shape;


    @FXML
    public void initialize( ) {

    }


    ArrayList<String>  flavorData, fillingData, frostingData, sizeData, shapeData;
    ObservableList<String> flavorComboData, fillingComboData, frostingComboData, sizeComboData, shapeComboData;

    @PostConstruct
    public void init() {

        flavorData = flavorRepository.findEverythingArray();
        flavorComboData = FXCollections.observableArrayList(flavorData);
        flavor.getItems().addAll(flavorComboData);

        fillingData = fillingRepository.findEverythingArray();
        fillingComboData = FXCollections.observableArrayList(fillingData);
        filling.getItems().addAll(fillingComboData);

        frostingData = frostingRepository.findEverythingArray();
        frostingComboData = FXCollections.observableArrayList(frostingData);
        frosting.getItems().addAll(frostingComboData);

        shapeData = shapeRepository.findEverythingArray();
        shapeComboData = FXCollections.observableArrayList(shapeData);
        shape.getItems().addAll(shapeComboData);


        sizeData = sizeRepository.findEverythingArray();
        sizeComboData = FXCollections.observableArrayList(sizeData);
        size.getItems().addAll(sizeComboData);

    }

    public void submitEvent(ActionEvent event) {


        productLayer.setOrderlineId(controller.orderline.getOrderLineId());
        productLayer.setFlavorId(flavorRepository.findByFlavType(flavor.getValue()));
        productLayer.setFillingId(fillingRepository.findByFillingType(filling.getValue()));
        productLayer.setFrostingId(frostingRepository.findByFrostingType(frosting.getValue()));
        productLayer.setShapeId(shapeRepository.findByShapeType(shape.getValue()));
        productLayer.setSizeId(sizeRepository.findBySizeDimensions(size.getValue()));
        productLayer.setLayerNumber(Integer.valueOf(layerNumCombooTxt.getText()) );


    }

    public void cancelEvent(ActionEvent event) {
        stage.close();

    }
}
