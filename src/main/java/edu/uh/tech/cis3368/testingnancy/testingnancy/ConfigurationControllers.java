package edu.uh.tech.cis3368.testingnancy.testingnancy;


import edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {


    @Bean
    @Qualifier("mainview")
    public  View getMainView() throws IOException {
        return loadView("main.fxml");
    }

    @Bean
    @Qualifier("Controller")
    public MainTabController getMainController() throws IOException {
        return (MainTabController) getMainView().getController();
    }

    @Bean
    @Qualifier("addCust")
    public View getAddCustView() throws IOException {
        return loadView("AddCustomer.fxml");
    }

    @Bean
    @Qualifier("addCustController")
    public addCustomerController getAddCustController() throws IOException {
        return (addCustomerController) getAddCustView().getController();
    }


    @Bean
    @Qualifier("editCust")
    public View getEditCustView() throws IOException {
        return loadView("EditCustomer.fxml");
    }


    @Bean
    @Qualifier("editCustController")
    public EditCustomerController getEditCustController() throws IOException {
        return (EditCustomerController) getEditCustView().getController();
    }

    @Bean
    @Qualifier("editTables")
    public View getEditTablesView() throws IOException {
        return loadView("EditTables.fxml");
    }


    @Bean
    @Qualifier("editTablesController")
    public EditTablesController getEditTablesController() throws IOException {
        return (EditTablesController) getEditTablesView().getController();
    }

    @Bean
    @Qualifier("viewFrosting")
    public View getViewFrostingView() throws IOException {
        return loadView("FrostingView.fxml");
    }


    @Bean
    @Qualifier("frostingViewController")
    public FrostingViewController getViewFrostingController() throws IOException {
        return (FrostingViewController) getViewFrostingView().getController();
    }

    @Bean
    @Qualifier("addFrosting")
    public View getAddFrostingView() throws IOException {
        return loadView("AddFrosting.fxml");
    }


    @Bean
    @Qualifier("addFrostingController")
    public AddFrostingController getAddFrostingController() throws IOException {
        return (AddFrostingController) getAddFrostingView().getController();
    }

    @Bean
    @Qualifier("editFrosting")
    public View getEditFrostingView() throws IOException {
        return loadView("EditFrosting.fxml");
    }


    @Bean
    @Qualifier("editFrostingController")
    public EditFrostingController getEditFrostingController() throws IOException {
        return (EditFrostingController) getEditFrostingView().getController();
    }

    @Bean
    @Qualifier("viewFilling")
    public View getViewFillingView() throws IOException {
        return loadView("FillingView.fxml");
    }


    @Bean
    @Qualifier("fillingViewController")
    public FillingViewController getViewFillingController() throws IOException {
        return (FillingViewController) getViewFillingView().getController();
    }

    @Bean
    @Qualifier("addFilling")
    public View getAddFillingView() throws IOException {
        return loadView("AddFillings.fxml");
    }


    @Bean
    @Qualifier("addFillingController")
    public AddFillingController getAddFillingController() throws IOException {
        return (AddFillingController) getAddFillingView().getController();
    }

    @Bean
    @Qualifier("editFilling")
    public View getEditFillingView() throws IOException {
        return loadView("EditFillings.fxml");
    }


    @Bean
    @Qualifier("editFillingController")
    public EditFillingsController getEditFillingController() throws IOException {
        return (EditFillingsController) getEditFillingView().getController();
    }

    @Bean
    @Qualifier("viewFlavor")
    public View getViewFlavorView() throws IOException {
        return loadView("FlavorView.fxml");
    }


    @Bean
    @Qualifier("flavorViewController")
    public FlavorViewController getViewFlavorController() throws IOException {
        return (FlavorViewController) getViewFlavorView().getController();
    }

    @Bean
    @Qualifier("addFlavor")
    public View getAddFlavorView() throws IOException {
        return loadView("AddFlavor.fxml");
    }


    @Bean
    @Qualifier("addFlavorController")
    public AddFlavorController getAddFlavorController() throws IOException {
        return (AddFlavorController) getAddFlavorView().getController();
    }

    @Bean
    @Qualifier("editFlavor")
    public View getEditFlavorView() throws IOException {
        return loadView("EditFlavor.fxml");
    }


    @Bean
    @Qualifier("editFlavorController")
    public EditFlavorController getEditFlavorController() throws IOException {
        return (EditFlavorController) getEditFlavorView().getController();
    }

    @Bean
    @Qualifier("viewCountry")
    public View getViewCountryView() throws IOException {
        return loadView("CountryView.fxml");
    }


    @Bean
    @Qualifier("countryViewController")
    public CountryViewController getViewCountryController() throws IOException {
        return (CountryViewController) getViewCountryView().getController();
    }

    @Bean
    @Qualifier("addCountry")
    public View getAddCountryView() throws IOException {
        return loadView("AddCountry.fxml");
    }


    @Bean
    @Qualifier("addCountryController")
    public AddCountryController getAddCountryController() throws IOException {
        return (AddCountryController) getAddCountryView().getController();
    }

    @Bean
    @Qualifier("editCountry")
    public View getEditCountryView() throws IOException {
        return loadView("EditCountry.fxml");
    }


    @Bean
    @Qualifier("editCountryController")
    public EditCountryController getEditCountryController() throws IOException {
        return (EditCountryController) getEditCountryView().getController();
    }

    @Bean
    @Qualifier("viewState")
    public View getViewStateView() throws IOException {
        return loadView("StateView.fxml");
    }


    @Bean
    @Qualifier("stateViewController")
    public StateViewController getViewStateController() throws IOException {
        return (StateViewController) getViewStateView().getController();
    }

    @Bean
    @Qualifier("addState")
    public View getAddStateView() throws IOException {
        return loadView("AddState.fxml");
    }


    @Bean
    @Qualifier("addStateController")
    public AddStateController getAddStateController() throws IOException {
        return (AddStateController) getAddStateView().getController();
    }

    @Bean
    @Qualifier("editState")
    public View getEditStateView() throws IOException {
        return loadView("EditState.fxml");
    }


    @Bean
    @Qualifier("editStateController")
    public EditStateController getEditStateController() throws IOException {
        return (EditStateController) getEditStateView().getController();
    }

    @Bean
    @Qualifier("viewCustStat")
    public View getViewCustStatView() throws IOException {
        return loadView("CustomerStatusView.fxml");
    }


    @Bean
    @Qualifier("custStatViewController")
    public CustomerStatusViewController getViewCustStatController() throws IOException {
        return (CustomerStatusViewController) getViewCustStatView().getController();
    }


    @Bean
    @Qualifier("addCustStat")
    public View getAddCustStatView() throws IOException {
        return loadView("AddCustomerStatus.fxml");
    }


    @Bean
    @Qualifier("addCustStatController")
    public AddCustomerStatusController getAddCustStaController() throws IOException {
        return (AddCustomerStatusController) getAddCustStatView().getController();
    }


    @Bean
    @Qualifier("editCustStat")
    public View getEditCustStatView() throws IOException {
        return loadView("EditCustomerStatus.fxml");
    }


    @Bean
    @Qualifier("editCustStatController")
    public EditCustomerStatusController getEditCustStatController() throws IOException {
        return (EditCustomerStatusController) getEditCustStatView().getController();
    }

    @Bean
    @Qualifier("orderForm")
    public View getOrderView() throws IOException {
        return loadView("orders.fxml");
    }


    @Bean
    @Qualifier("editCustStatController")
    public Controller getOrdersController() throws IOException {
        return (Controller) getOrderView().getController();
    }


    @Bean
    @Qualifier("addLayer")
    public View getAddLayerView() throws IOException {
        return loadView("AddLayer.fxml");
    }


    @Bean
    @Qualifier("addLayerConntroller")
    public AddLayerController getAddLayerController() throws IOException {
        return (AddLayerController) getAddLayerView().getController();
    }

    @Bean
    @Qualifier("avgpoView")
    public View getAvgPOView() throws IOException {
        return loadView("AvgPriceOccasion.fxml");
    }


    @Bean
    @Qualifier("avgPOController")
    public AvgPriceOccasionController getAvgPOController() throws IOException {
        return (AvgPriceOccasionController) getAvgPOView().getController();
    }

    @Bean
    @Qualifier("fillByQuartView")
    public View getFillByQuartView() throws IOException {
        return loadView("FillingByQuarter.fxml");
    }


    @Bean
    @Qualifier("fillByQuartViewController")
    public FillingByQuartController getFillByQuartController() throws IOException {
        return (FillingByQuartController) getFillByQuartView().getController();
    }

    @Bean
    @Qualifier("flavByyear")
    public View getFlavByYearView() throws IOException {
        return loadView("FlavorByYear.fxml");
    }


    @Bean
    @Qualifier("fillByQuartViewController")
    public FlavorByYearController getFlavByYearController() throws IOException {
        return (FlavorByYearController) getFlavByYearView().getController();
    }

    @Bean
    @Qualifier("occasionByyear")
    public View getOccaByYearView() throws IOException {
        return loadView("OcasionByYear.fxml");
    }


    @Bean
    @Qualifier("occasByYearViewController")
    public OccasionByYearController getOccByYearController() throws IOException {
        return (OccasionByYearController) getOccaByYearView().getController();
    }

    @Bean
    @Qualifier("opmByyear")
    public View getOpmByYearView() throws IOException {
        return loadView("OrderPlacementYear.fxml");
    }


    @Bean
    @Qualifier("opmByYearController")
    public OrderPlacementByYearController getOpmByYearController() throws IOException {
        return (OrderPlacementByYearController) getOpmByYearView().getController();
    }

    @Bean
    @Qualifier("ornByyear")
    public View getOrnByYearView() throws IOException {
        return loadView("OrnamentByYear.fxml");
    }


    @Bean
    @Qualifier("ornByYearController")
    public OrnamentsByYearController getOrnByYearController() throws IOException {
        return (OrnamentsByYearController) getOrnByYearView().getController();
    }

    @Bean
    @Qualifier("ornRentOccasion")
    public View getOrnRentOccasionView() throws IOException {
        return loadView("OrnamentRentalOccasion.fxml");
    }


    @Bean
    @Qualifier("ornRentOccasionController")
    public OrnamentRentalOccasionController getOrnRentOccasionController() throws IOException {
        return (OrnamentRentalOccasionController) getOrnRentOccasionView().getController();
    }

    @Bean
    @Qualifier("prodTypeFreq")
    public View getProdTypeFreqView() throws IOException {
        return loadView("ProductbyMonth.fxml");
    }


    @Bean
    @Qualifier("prodTypeFreqController")
    public ProductTypeByMonthFreqController getprodTypeFreqController() throws IOException {
        return (ProductTypeByMonthFreqController) getProdTypeFreqView().getController();
    }

    @Bean
    @Qualifier("prodSizebyMonth")
    public View getProdSizebyMonthView() throws IOException {
        return loadView("ProductSizeMonth.fxml");
    }


    @Bean
    @Qualifier("ProdSizebyMonthController")
    public ProdSizeMonthController getprodSizeMonthController() throws IOException {
        return (ProdSizeMonthController) getProdSizebyMonthView().getController();
    }

    @Bean
    @Qualifier("revbyQuart")
    public View getRevByQuarterView() throws IOException {
        return loadView("RevByQuarter.fxml");
    }


    @Bean
    @Qualifier("RevByQuartController")
    public RevByQuartController getRevByQuartController() throws IOException {
        return (RevByQuartController) getRevByQuarterView().getController();
    }

    @Bean
    @Qualifier("viewReports")
    public View getviewRportsView() throws IOException {
        return loadView("ViewReports.fxml");
    }


    @Bean
    @Qualifier("viewReportsController")
    public ViewReportsController getViewReportsController() throws IOException {
        return (ViewReportsController) getviewRportsView().getController();
    }

    @Bean
    @Qualifier("fillByQuartDAView")
    public View getFillByQuartDAView() throws IOException {
        return loadView("FillingByQuarterView.fxml");
    }


    @Bean
    @Qualifier("fillByQuartDAViewController")
    public FillingByQuarterViewController getFillByQuartDAViewController() throws IOException {
        return (FillingByQuarterViewController) getFillByQuartDAView().getController();
    }

    @Bean
    @Qualifier("flavByYearDAView")
    public View getFlavByYearDAView() throws IOException {
        return loadView("FlavorByYearView.fxml");
    }


    @Bean
    @Qualifier("flavByYearDAViewController")
    public FlavorByYearViewController getFlavByYearDAViewController() throws IOException {
        return (FlavorByYearViewController) getFlavByYearDAView().getController();
    }

    @Bean
    @Qualifier("occasionByYearDAView")
    public View getOccByYearDAView() throws IOException {
        return loadView("OccasionByYearView.fxml");
    }


    @Bean
    @Qualifier("occasionByYearDAViewController")
    public OccasionByYearViewController getOccByYearDAViewController() throws IOException {
        return (OccasionByYearViewController) getOccByYearDAView().getController();
    }
    protected View loadView(String url) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }


    public class View {
        private Parent view;
        private Object controller;

        public View(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }

}

