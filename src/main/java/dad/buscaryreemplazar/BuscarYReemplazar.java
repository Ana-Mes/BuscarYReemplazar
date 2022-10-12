package dad.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazar extends Application {
	
	//view
	private TextField buscarText;
	private TextField reemplazarText;
	private CheckBox MayusMinusCheck, buscarCheck, regularCheck, resaltarCheck;
	private Button buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		MayusMinusCheck = new CheckBox("Mayúsculas y minúsculas");
		buscarCheck = new CheckBox("Buscar hacia atrás");
		regularCheck = new CheckBox("Expresión regular");
		resaltarCheck = new CheckBox("Resaltar resultados");
		
		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazarTodoButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");
		
		GridPane checkPanel = new GridPane();
		checkPanel.setHgap(5);
		checkPanel.setVgap(5);
		checkPanel.addRow(0, MayusMinusCheck, buscarCheck);
		checkPanel.addRow(1, regularCheck, resaltarCheck);
		
		VBox buttonPanel = new VBox(5);
		buttonPanel.setPrefWidth(106);
		buttonPanel.setAlignment(Pos.CENTER);
		
		buscarButton.setMinWidth(buttonPanel.getPrefWidth());
		reemplazarButton.setMinWidth(buttonPanel.getPrefWidth());
		reemplazarTodoButton.setMinWidth(buttonPanel.getPrefWidth());
		cerrarButton.setMinWidth(buttonPanel.getPrefWidth());
		ayudaButton.setMinWidth(buttonPanel.getPrefWidth());
		
		buttonPanel.getChildren().addAll(buscarButton,reemplazarButton,reemplazarTodoButton,cerrarButton,ayudaButton);
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(5));
		root.setHgap(5);
		root.setVgap(5);
		root.addRow(0, new Label("Buscar: "), buscarText, buttonPanel);
		root.addRow(1, new Label("Reemplazar con: "), reemplazarText);
		root.addRow(3, new Label(), checkPanel);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(new Scene(root, 505, 200));
		primaryStage.show();
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
				new ColumnConstraints(),
				new ColumnConstraints(),
			};
		root.getColumnConstraints().setAll(cols);
		
		cols[1].setHgrow(Priority.ALWAYS);
		
		RowConstraints [] rows = {
				new RowConstraints(),
				new RowConstraints(),
				new RowConstraints(),
		};
		
		for (int row = 0; row < rows.length; row++) {
			rows[row].setPrefHeight(30);
		}
		
		GridPane.setRowSpan(buttonPanel, 4);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
