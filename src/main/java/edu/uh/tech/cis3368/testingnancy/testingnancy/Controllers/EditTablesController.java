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

public class EditTablesController {

    @FXML
    private Stage frostingStage, fillStage, flavstage, stateStage, custstatstage;

    private int num = 0;
    private int fillnum = 0;
    private int flavnum = 0;
    private int countrynum = 0;
    private int statenum = 0;
    private int custstatnum = 0;


    @Autowired
    @Qualifier("viewFrosting")
    private ConfigurationControllers.View frostingview;

    @Autowired
    @Qualifier("viewFilling")
    private ConfigurationControllers.View fillview;

    @Autowired
    @Qualifier("viewFlavor")
    private ConfigurationControllers.View flavview;

    @Autowired
    @Qualifier("viewCountry")
    private ConfigurationControllers.View countryview;

    @Autowired
    @Qualifier("viewState")
    private ConfigurationControllers.View stateview;

    @Autowired
    @Qualifier("viewCustStat")
    private ConfigurationControllers.View custstatview;


    @FXML
    private JFXComboBox<String> selectTblCombo;

    @FXML
    private JFXButton tableViewBtn;

    @FXML
    public void initialize( ) {

    }

    @PostConstruct
    public void init() {

       String[] elements = {"Country", "State/Province", "Customer Status", "Filling", "Flavor",
               "Frosting", "Product Type"


       };
        List<String> tableList = new ArrayList<String>(Arrays.asList(elements));
        selectTblCombo.getItems().addAll(tableList);


    }

    public void buttonEvent(javafx.event.ActionEvent event)
    {
        if(selectTblCombo.getValue() == "Country")
        {
            while (countrynum < 1)
            {
                fillStage = new Stage();
                fillStage.setTitle("View Countries");
                fillStage.setScene(new Scene(countryview.getView()));
                fillStage.setResizable(true);
                fillStage.centerOnScreen();
                fillStage.initModality(Modality.APPLICATION_MODAL);

                countrynum++;

            }


            fillStage.show();

        }
        else if(selectTblCombo.getValue() == "State/Province")
        {
            while (statenum < 1)
            {
                stateStage = new Stage();
                stateStage.setTitle("View State/Province");
                stateStage.setScene(new Scene(stateview.getView()));
                stateStage.setResizable(true);
                stateStage.centerOnScreen();
                stateStage.initModality(Modality.APPLICATION_MODAL);

                statenum++;

            }


            stateStage.show();

        }

        else if(selectTblCombo.getValue() == "Customer Status")
        {
            while (custstatnum < 1)
            {
                custstatstage = new Stage();
                custstatstage.setTitle("View Customer Status");
                custstatstage.setScene(new Scene(custstatview.getView()));
                custstatstage.setResizable(true);
                custstatstage.centerOnScreen();
                custstatstage.initModality(Modality.APPLICATION_MODAL);

                custstatnum++;

            }


            custstatstage.show();

        }

        else if(selectTblCombo.getValue() == "Customer Type")
        {


        }

        else if(selectTblCombo.getValue() == "Order Status")
        {


        }

        else if(selectTblCombo.getValue() == "Order Placement Method")
        {


        }

        else if(selectTblCombo.getValue() == "Order Fulfillment Method")
        {


        }

        else if(selectTblCombo.getValue() == "Occasion")
        {


        }

        else if(selectTblCombo.getValue() == "Order Line Status")
        {


        }

        else if(selectTblCombo.getValue() == "Assignment Status")
        {


        }

        else if(selectTblCombo.getValue() == "Assignment")
        {


        }

        else if(selectTblCombo.getValue() == "Employee Status")
        {


        }

        else if(selectTblCombo.getValue() == "Employee Type")
        {


        }

        else if(selectTblCombo.getValue() == "Employee")
        {


        }

        else if(selectTblCombo.getValue() == "Filling Status")
        {


        }

        else if(selectTblCombo.getValue() == "Filling")
        {

            while (fillnum < 1)
            {
                fillStage = new Stage();
                fillStage.setTitle("View Fillings");
                fillStage.setScene(new Scene(fillview.getView()));
                fillStage.setResizable(true);
                fillStage.centerOnScreen();
                fillStage.initModality(Modality.APPLICATION_MODAL);

                fillnum++;

            }


            fillStage.show();


        }

        else if(selectTblCombo.getValue() == "Flavor Status")
        {


        }

        else if(selectTblCombo.getValue() == "Flavor")
        {
            while (flavnum < 1)
            {
                flavstage = new Stage();
                flavstage.setTitle("View Flavors");
                flavstage.setScene(new Scene(flavview.getView()));
                flavstage.setResizable(true);
                flavstage.centerOnScreen();
                flavstage.initModality(Modality.APPLICATION_MODAL);

                flavnum++;

            }


            flavstage.show();


        }

        else if(selectTblCombo.getValue() == "Frosting Status")
        {


        }

        else if(selectTblCombo.getValue() == "Frosting")
        {
            while (num < 1)
            {
                frostingStage = new Stage();
                frostingStage.setTitle("View Frostings");
                frostingStage.setScene(new Scene(frostingview.getView()));
                frostingStage.setResizable(true);
                frostingStage.centerOnScreen();
                frostingStage.initModality(Modality.APPLICATION_MODAL);

                num++;

            }


            frostingStage.show();


        }

        else if(selectTblCombo.getValue() == "Shape Status")
        {


        }

        else if(selectTblCombo.getValue() == "Shape")
        {


        }

        else if(selectTblCombo.getValue() == "Size Status")
        {


        }

        else if(selectTblCombo.getValue() == "Size")
        {


        }

        else if(selectTblCombo.getValue() == "Product Type")
        {


        }

        else if(selectTblCombo.getValue() == "Ornament Type")
        {


        }
        else if(selectTblCombo.getValue() == "Ornament Color")
        {


        }

        else if(selectTblCombo.getValue() == "Ornament Size")
        {


        }

        else if(selectTblCombo.getValue() == "Ornament Status")
        {


        }

        else if(selectTblCombo.getValue() == "Ornament")
        {


        }

        else if(selectTblCombo.getValue() == "Order Line Status")
        {


        }
    }


}
