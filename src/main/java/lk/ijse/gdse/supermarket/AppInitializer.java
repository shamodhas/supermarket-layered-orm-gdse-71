package lk.ijse.gdse.supermarket;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator; // Not used but can be useful for loading indication
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.bo.custom.BoFactory;
import lk.ijse.gdse.supermarket.bo.custom.BoTypes;
import lk.ijse.gdse.supermarket.bo.custom.PlaceOrderBO;
import lk.ijse.gdse.supermarket.bo.exeception.DuplicateException;
import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.DaoFactory;
import lk.ijse.gdse.supermarket.dao.DaoTypes;
import lk.ijse.gdse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.gdse.supermarket.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.entity.Item;
import lk.ijse.gdse.supermarket.entity.SuperEntity;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppInitializer extends Application {


    public static void main(String[] args) {
//        SuperEntity customer = new Customer();
//        SuperEntity item = new Item();
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//
//        Optional<Customer> optionalCustomer = customerDAO.findByPK("");
//
//        if (!optionalCustomer.isEmpty()){
//            Customer customer = optionalCustomer.get();
//        }
//
//        // optionalCustomer.isEmpty() - no data
//        // optionalCustomer.isPresent() - have data
//
//        if (optionalCustomer.isPresent()){
//            // have data
//            Customer customer = optionalCustomer.get();
//        }
//
//        Session session = FactoryConfiguration.getInstance().getSession();
//        session.close();

//        CustomerDAO customerDAO = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER);
//        System.out.println(customerDAO.getAll());

        // PLace order

//        PlaceOrderBO placeOrderBO = BoFactory.getInstance().getBO(BoTypes.PLACE_ORDER);
//
//        String orderId = "O001";
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setOrderId(orderId);
//        orderDTO.setCustomerId("C001");
//        orderDTO.setOrderDate(Date.valueOf(LocalDate.now()));
//
//        OrderDetailsDTO orderDetailsDTO1 = new OrderDetailsDTO();
//        orderDetailsDTO1.setOrderId(orderId);
//        orderDetailsDTO1.setItemId("I001");
//        orderDetailsDTO1.setQuantity(50);
//        orderDetailsDTO1.setPrice(20.00);
//
//        OrderDetailsDTO orderDetailsDTO2 = new OrderDetailsDTO();
//        orderDetailsDTO2.setOrderId(orderId);
//        orderDetailsDTO2.setItemId("I002");
//        orderDetailsDTO2.setQuantity(5);
//        orderDetailsDTO2.setPrice(100.00);
//
//        ArrayList<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();
//        orderDetailsDTOS.add(orderDetailsDTO1);
//        orderDetailsDTOS.add(orderDetailsDTO2);
//
//        orderDTO.setOrderDetailsDTOS(orderDetailsDTOS);
//
//        boolean isSaved = placeOrderBO.placeOrder(orderDTO);
//        System.out.println("Order placed : " + isSaved);

//        throw new DuplicateException("hello");

        launch(); // Launch the JavaFX application
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Load and display the loading view
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoadingView.fxml"))));
        stage.show();

        // Create a background task to load the main scene
        Task<Scene> loadMainSceneTask = new Task<>() {
            @Override
            protected Scene call() throws Exception {
                // Load the main layout from FXML
                FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/MainLayout.fxml"));
                return new Scene(fxmlLoader.load()); // Return the loaded scene
            }
        };

        // What to do when loading is successful
        loadMainSceneTask.setOnSucceeded(event -> {
            Scene value = loadMainSceneTask.getValue();

            stage.setTitle("Supermarket FX");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/app_logo.png")));
            stage.setMaximized(true);

            // Switch to the main scene
            stage.setScene(value);
        });

        // What to do in case of loading failure (optional)
        loadMainSceneTask.setOnFailed(event -> {
            System.err.println("Failed to load the main layout."); // Print error message
        });

        // Start the task in a separate thread
        new Thread(loadMainSceneTask).start();
    }
}
