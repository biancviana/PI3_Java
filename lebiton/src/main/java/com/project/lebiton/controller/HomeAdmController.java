package com.project.lebiton.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.project.lebiton.Main;

public class HomeAdmController implements Initializable{

	@FXML
	private Button btCadastrar, btDeslogar;
	@FXML
	private Button btCadastroDias;
	
	FXMLLoader root = null;
	
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
	}
	
	@FXML
    public void cadastrarMedico(final ActionEvent actionEvent) {

        final Stage stage = (Stage) btCadastrar.getScene().getWindow();

        try {
            root = new FXMLLoader(HomeAdmController.class.getResource("/com/project/lebiton/view/CadastroMedico.fxml"));
            final Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.setTitle("Cadastro Médico");
            stage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
	
	@FXML
    public void cadastrarDiasAgenda(final ActionEvent actionEvent) {

        final Stage stage = (Stage) btCadastroDias.getScene().getWindow();

        try {
            root = new FXMLLoader(HomeAdmController.class.getResource("/com/project/lebiton/view/CadastroDiasAgenda.fxml"));
            final Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.setTitle("Cadastro Dias");
            stage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
	
	 @FXML
	    public void deslogarOnClicked() {
	        final Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setTitle("MENSAGEM");
	        alert.setContentText("Deseja realmente sair?");

	        final Optional<ButtonType> result = alert.showAndWait();

	        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
	        	
	        	final Stage stage = (Stage) btDeslogar.getScene().getWindow();
	        	
	        	try {
	                root = new FXMLLoader(PacienteController.class.getResource("/com/project/lebiton/view/Login.fxml"));
	                final Scene scene = new Scene(root.load());
	                stage.setScene(scene);
	                stage.setTitle("Login");
	                stage.show();
	            } catch (final IOException e) {
	                e.printStackTrace();
	            }
	        }
	 }

}
