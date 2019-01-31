package edu.uh.tech.cis3368.testingnancy.testingnancy.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import edu.uh.tech.cis3368.testingnancy.testingnancy.ConfigurationControllers;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Entities.*;
import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class Controller {
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
	OccasionRepository occasionRepository;
	@Autowired
	OrderPlacementMethodRepository orderPlacementMethodRepository;
	@Autowired
	OrderFulfillmentMethodRepository orderFulfillmentMethodRepository;
	@Autowired
	CustomerRepository customerRepository;
    @Autowired
    OrderStatusRepository orderStatusRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
	ProductTypeRepository productTypeRepository;
    @Autowired
    OrderlineRepository orderlineRepository;
    @Autowired
	OrderLineStatusRepository orderLineStatusRepository;
    @Autowired
    ProductLayerRepository productLayerRepository;
    @Autowired
    AddLayerController addLayerController;



    @Autowired
    @Qualifier("addLayer")
    ConfigurationControllers.View addLayerview;

    Stage addLayerstage;

	private Customer customer;
	private Occasion occasion;
	private Orders order;
	protected Orderline orderline = new Orderline();;
	private ProductLayer productLayer = new ProductLayer();
	private int layernum = 1;
	private int num = 0;



	@FXML
	private ChoiceBox<String> flavors, occasionCombo, opmCombo, orderStatusCombo;

	@FXML
	private JFXComboBox<String> flavor, filling, size, shape, frosting;

	@FXML
    private DatePicker orderRecDate, orderDueDate;

	@FXML
	private TextField hall, OrderDepositTxt, OrderTotPrice ;

    @FXML
    TextField hallAddress;
    @FXML
    TextField hallPhone;
	@FXML
	private RadioButton delivery;
	@FXML
	private RadioButton pickup;
	@FXML
	private ChoiceBox<String> product;
	@FXML
	private TextField qty, emailTxtField, lnameTxtField, phoneTxtField;
	@FXML
	private VBox box;
	@FXML
	private Button delOrnament;
	@FXML
    TextArea specReqTextArea;
	@FXML
	private CheckBox orn;
	@FXML
	private VBox layerBox;
	@FXML
	private JFXButton layerplus, lookupBtn, submit;
	@FXML
	private JFXButton layermin;
	@FXML
    private ImageView image;

	public ArrayList<ProductLayer> layers;


	ArrayList<String> orderStatData, occasionData, opmData, flavorData, fillingData, frostingData, sizeData, shapeData, prodTypeData;
	ObservableList<String> orderstatComboData,  occasionComboData, opmComboData, flavorComboData, fillingComboData, frostingComboData, sizeComboData, shapeComboData, prodTypeComboData;

	@FXML
	public void initialize(){

	}


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

		prodTypeData = productTypeRepository.findEverythingArray();
		prodTypeComboData = FXCollections.observableArrayList(prodTypeData);
		product.getItems().addAll(prodTypeComboData);

		occasionData = occasionRepository.findEverythingArray();
		occasionComboData = FXCollections.observableArrayList(occasionData);
		occasionCombo.getItems().addAll(occasionComboData);

		opmData = orderPlacementMethodRepository.findEverythingArray();
		opmComboData = FXCollections.observableArrayList(opmData);
		opmCombo.getItems().addAll(opmComboData);

		orderStatData = orderStatusRepository.findEverythingArray();
		orderstatComboData = FXCollections.observableArrayList(orderStatData);
		orderStatusCombo.getItems().addAll(orderstatComboData);

		lnameTxtField.setDisable(true);
		emailTxtField.setDisable(true);











		try {
			ToggleGroup fulfillment = new ToggleGroup();
			delivery.setToggleGroup(fulfillment);
			pickup.setToggleGroup(fulfillment);
			pickup.setSelected(true);
			//product.setValue("Product");
		} catch (Exception e) {
		}
		try {
			product.getSelectionModel().selectedItemProperty()
					.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
					{
						chooseType();
					});
		}catch (Exception e){}

	}
	public void goHome()
	{
		//return to home screen
	}

	public void submitOrder(ActionEvent event) throws IOException
	{
		//sql code to insert into database
		//pass order id to ornaments or use class variable
		/*if(product.getValue().equals("Cake"))
		{
			//insert layers
			//Quantity = 1
		}
		else
		{
			//insert Quantity
			//Layers = 1
		}
		*/

	if(phoneTxtField.getText() != null && flavor.getValue() != null && filling.getValue() != null && frosting.getValue() != null &&
		shape.getValue() != null && size.getValue() != null && product.getValue() != null && occasionCombo.getValue() != null &&
        opmCombo.getValue() != null && OrderTotPrice.getText() !=  null && OrderDepositTxt.getText() != null && (pickup.isSelected() || delivery.isSelected()))
    {
        order = new Orders();
        order.setCustomerId(customer.getCustomerId());
        order.setOccasionId(occasionRepository.findByOccaType(occasionCombo.getValue()));
        order.setOrderPlacementMethodId(orderPlacementMethodRepository.findByOrderPlaceMthd(opmCombo.getValue()));
        order.setOrderStatusId(orderStatusRepository.findByOrderStatMthd(orderStatusCombo.getValue()));
        order.setOrderReceivedDate(Date.valueOf(orderRecDate.getValue()));
        order.setOrderDueDate(Date.valueOf(orderDueDate.getValue()));
        order.setOrderDeposit(Double.valueOf(OrderDepositTxt.getText()));
        order.setOrderTotalPrice(Double.valueOf(OrderTotPrice.getText()));
        order.setOrderSpecialRequirements(specReqTextArea.getText());
        if (delivery.isSelected())
        {        order.setOrderFulfillmentMethodId(orderFulfillmentMethodRepository.findByOrderFulMthd("Delivery"));
        }else {        order.setOrderFulfillmentMethodId(orderFulfillmentMethodRepository.findByOrderFulMthd("Pickup"));
        }
        if(orn.isSelected())
        { order.setOrderRentalRequest(true);}
        else { order.setOrderRentalRequest(false);}
        ordersRepository.save(order);


        orderline.setOrderId(order.getOrderId());
        orderline.setProductTypeId(productTypeRepository.findByProdType(product.getValue()));
        orderline.setOrderlineStatusId(orderLineStatusRepository.findByOrdlineStat("In Progress"));
        orderline.setOrderLineQuantity(Integer.valueOf(qty.getText()));
        orderlineRepository.save(orderline);


        productLayer.setOrderlineId(orderline.getOrderLineId());
        productLayer.setFlavorId(flavorRepository.findByFlavType(flavor.getValue()));
        productLayer.setFillingId(fillingRepository.findByFillingType(filling.getValue()));
        productLayer.setFrostingId(frostingRepository.findByFrostingType(frosting.getValue()));
        productLayer.setShapeId(shapeRepository.findByShapeType(shape.getValue()));
        productLayer.setSizeId(sizeRepository.findBySizeDimensions(size.getValue()));
        productLayer.setLayerNumber(layernum);



	}
	}

	public void sceneSwap(ActionEvent event)throws IOException
	{
		Parent root;
		CheckBox source = (CheckBox) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		if(event.getSource()==orn)
		{
			stage = (Stage)orn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("ornaments.fxml"));
			Scene scene = new Scene(root,800,600);
			stage.setScene(scene);
			stage.show();
			stage.close();
		}

	}

	public void newOrnament()
	{
		Group group = new Group();
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.setPrefWidth(175);
		cb.getItems().addAll("Ornament 1","Ornament 2","Ornament 3");
		TextField tf = new TextField();
		tf.setPrefWidth(100);
		cb.setLayoutX(0);
		tf.setLayoutX(240);

		group.getChildren().addAll(tf, cb);
		box.getChildren().add(group);
	}

	public void minOrn()
	{
		if(box.getChildren().size()>1)
			box.getChildren().remove(box.getChildren().size() - 1);
	}

	public void layerMin()
	{
		if(layerBox.getChildren().size()>1)
			layerBox.getChildren().remove(layerBox.getChildren().size() - 1);
	}


	public void addLayer(javafx.event.ActionEvent  event)
	{
        while (num < 1)
        {
            addLayerstage = new Stage();
            addLayerstage.setTitle("Add Layers");
            addLayerstage.setScene(new Scene(addLayerview.getView()));
            addLayerstage.setResizable(true);
            addLayerstage.centerOnScreen();
            addLayerstage.initModality(Modality.APPLICATION_MODAL);

            num++;


        }
        addLayerController.stage = addLayerstage;

	}



    public void setDelivery()
    {
        order.setOrderFulfillmentMethodId(orderFulfillmentMethodRepository.findByOrderFulMthd("Delivery"));
        hall.setDisable(false);
        hallAddress.setDisable(false);
        hallPhone.setDisable(false);
    }

    public void setPickup()
    {
        order.setOrderFulfillmentMethodId(orderFulfillmentMethodRepository.findByOrderFulMthd("Pickup"));
        hall.setDisable(true);
        hallAddress.setDisable(true);
        hallPhone.setDisable(true);
    }
	private void chooseType()
	{
		if(product.getSelectionModel().getSelectedItem().equals(product.getItems().get(0)))
		{
			//layer.setDisable(false);
			for (Node a:layerBox.getChildren())
			{
				if(a.isDisabled())
					a.setDisable(false);
			}
			qty.setDisable(true);
			layerplus.setDisable(false);
			layermin.setDisable(false);
		}
		else
		{
			if(layerBox.getChildren().size()>1)
				for(int i=layerBox.getChildren().size(); i>1;i--)
				{
					layerBox.getChildren().get(i-1).setDisable(true);
				}
				qty.setDisable(false);
				layerplus.setDisable(true);
				layermin.setDisable(true);

		}
	}

	public void buttonEvent(){}


	public void lookupCust(ActionEvent event) {
		customer = customerRepository.findByPhone(phoneTxtField.getText());
		lnameTxtField.setText(customer.getCustomerLastName());
		emailTxtField.setText(customer.getCustomerEmail());


	}

    public void setOFM(ActionEvent event) {

    }
    public void getImage()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(layerBox.getScene().getWindow());
        Image img = new Image("file:"+selectedFile.getAbsolutePath(), true);
        image = new ImageView();
        image.setImage(img);
        image.setFitWidth(150);
        image.setFitHeight(150);
        image.setLayoutX(925);
        image.setLayoutY(475);
        image.setSmooth(true);
        image.setCache(true);
    }
}
