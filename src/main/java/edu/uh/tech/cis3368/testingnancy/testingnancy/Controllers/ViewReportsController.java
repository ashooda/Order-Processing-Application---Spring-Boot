package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewReportsController {
    @FXML
    private Stage avgPOstage, fillByQtrStage, flavYearlystage, occaByyearStage, custstatstage;

    private int repnum1 = 0;
    private int repnum2 = 0;
    private int repnum3 = 0;
    private int repnum4 = 0;
    private int statenum = 0;
    private int custstatnum = 0;


    @Autowired
    @Qualifier("avgpoView")
    private ConfigurationControllers.View avgpriceview;

    @Autowired
    @Qualifier("fillByQuartDAView")
    private ConfigurationControllers.View fillbyquartview;

    @Autowired
    @Qualifier("flavByYearDAView")
    private ConfigurationControllers.View flavbyYearview;

    @Autowired
    @Qualifier("occasionByYearDAView")
    private ConfigurationControllers.View occaByYearview;

    @Autowired
    @Qualifier("viewState")
    private ConfigurationControllers.View stateview;

    @Autowired
    @Qualifier("viewCustStat")
    private ConfigurationControllers.View custstatview;


    @FXML
    private JFXComboBox<String> selectRprtCombo;

    @FXML
    private JFXButton tableViewBtn;

    @FXML
    public void initialize() {

    }

    @PostConstruct
    public void init() {

        String[] elements = {"Avg Product Price By Occasion", "Fillings By Quarter", "Flavors Ordered Yearly", "Occasion Orders Were Placed For (Yearly)",


        };
        List<String> tableList = new ArrayList<String>(Arrays.asList(elements));
        selectRprtCombo.getItems().addAll(tableList);
    }

    public void buttonEvent(javafx.event.ActionEvent event) {
        if (selectRprtCombo.getValue() == "Avg Product Price By Occasion") {
            while (repnum1 < 1) {
                avgPOstage = new Stage();
                avgPOstage.setTitle("Average Product Price By Occasion");
                avgPOstage.setScene(new Scene(avgpriceview.getView()));
                avgPOstage.setResizable(true);
                avgPOstage.centerOnScreen();
                avgPOstage.initModality(Modality.APPLICATION_MODAL);

                repnum1++;

            }


            avgPOstage.show();

        }
        else if (selectRprtCombo.getValue() == "Fillings By Quarter")
        {
            while (repnum2 < 1) {
                fillByQtrStage = new Stage();
                fillByQtrStage.setTitle("Fillings By Quarter Report");
                fillByQtrStage.setScene(new Scene(fillbyquartview.getView()));
                fillByQtrStage.setResizable(true);
                fillByQtrStage.centerOnScreen();
                fillByQtrStage.initModality(Modality.APPLICATION_MODAL);

                repnum2++;

            }


            fillByQtrStage.show();
        }

        else if (selectRprtCombo.getValue() == "Flavors Ordered Yearly")
        {
            while (repnum3 < 1) {
                flavYearlystage = new Stage();
                flavYearlystage.setTitle("Flavors Ordered Yearly");
                flavYearlystage.setScene(new Scene(flavbyYearview.getView()));
                flavYearlystage.setResizable(true);
                flavYearlystage.centerOnScreen();
                flavYearlystage.initModality(Modality.APPLICATION_MODAL);

                repnum3++;

            }


            flavYearlystage.show();
        }

        else if (selectRprtCombo.getValue() == "Occasion Orders Were Placed For (Yearly)")
        {
            while (repnum4 < 1) {
                occaByyearStage = new Stage();
                occaByyearStage.setTitle("Occasion Orders Were Placed For (Yearly)");
                occaByyearStage.setScene(new Scene(occaByYearview.getView()));
                occaByyearStage.setResizable(true);
                occaByyearStage.centerOnScreen();
                occaByyearStage.initModality(Modality.APPLICATION_MODAL);

                repnum4++;

            }


            occaByyearStage.show();
        }



    }
}