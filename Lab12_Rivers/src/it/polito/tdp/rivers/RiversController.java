package it.polito.tdp.rivers;


import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtK;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;
    
    @FXML
    void getFiume(ActionEvent event) {

    	
    	River river = model.getRiver(boxRiver.getValue());
    	System.out.println(river);
    	 txtStartDate.setText(river.getFirstData().toString());
    	 txtEndDate.setText(river.getLastData().toString());
    	 txtNumMeasurements.setText(String.valueOf(river.getTotMisurazioni()));
    	 txtFMed.setText(String.valueOf(river.getFlowMed()));

    }
    @FXML
    void simula(ActionEvent event) {
    	
    	River river = model.getRiver(boxRiver.getValue());
    	Statistiche stat = model.simula(Integer.parseInt(txtK.getText()), river);
    	txtResult.appendText("Numero giorni fMin non soddisfatto \n");
    	txtResult.appendText(stat.getGiorniKO()+"\n");
    	txtResult.appendText("Capacità Media \n");
    	txtResult.appendText(stat.getCapacitaMed()+"\n");
    	
    	
    
    	
    }

    @FXML
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }

	public void setModel(Model model) {
		
		this.model = model;
		
		boxRiver.getItems().addAll(model.getAllRiver());		
	}
    
    
}


