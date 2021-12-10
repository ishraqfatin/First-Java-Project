<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.DatePicker?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TableColumn?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane id="AnchorPane" prefHeight="500.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/10.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="fxmlapplicationpkg.FXMLMainSceneController">
    <children>
        <TextField fx:id="idTxt" layoutX="106.0" layoutY="28.0" onMouseClicked="#idTxtOnMouseClick" prefHeight="25.0" prefWidth="141.0" />
        <Label layoutX="29.0" layoutY="32.0" prefHeight="17.0" prefWidth="79.0" text="Enter ID:" />
        <TextField fx:id="nameTxt" layoutX="108.0" layoutY="62.0" onMouseClicked="#nameTxtOnMouseClick" prefHeight="25.0" prefWidth="141.0" />
        <Label layoutX="29.0" layoutY="66.0" prefHeight="17.0" prefWidth="79.0" text="Enter Name:" />
        <TextField fx:id="cgpaTxt" layoutX="382.0" layoutY="29.0" onMouseClicked="#cgpaTxtOnMouseClick" prefHeight="25.0" prefWidth="174.0" />
        <Label layoutX="307.0" layoutY="32.0" prefHeight="17.0" prefWidth="68.0" text="Enter Cgpa:" />
        <Button layoutX="173.0" layoutY="258.0" mnemonicParsing="false" onAction="#loadTableFromFileButtonOnClick" prefHeight="37.0" prefWidth="273.0" text="Load Table from Stud.bin" />
        <TableView fx:id="tableView" layoutX="29.0" layoutY="334.0" prefHeight="128.0" prefWidth="537.0">
            <columns>
                <TableColumn fx:id="idColumn" prefWidth="87.0" text="ID" />
                <TableColumn fx:id="nameColumn" prefWidth="193.0" text="Name" />
                <TableColumn fx:id="birthdayColumn" prefWidth="84.0" text="Birthday" />
            <TableColumn fx:id="deptColumn" minWidth="0.0" prefWidth="91.0" text="Dept" />
            <TableColumn fx:id="cgpaColumn" text="Cgpa" />
            </columns>
        </TableView>
      <DatePicker fx:id="birthdayDatePicker" layoutX="234.0" layoutY="119.0" promptText="Select Birthday" />
      <Button layoutX="173.0" layoutY="187.0" mnemonicParsing="false" onAction="#saveToFileButtonOnClick" prefHeight="37.0" prefWidth="273.0" text="Write Student instance to Stud.bin file" />
      <Label layoutX="136.0" layoutY="123.0" prefHeight="17.0" prefWidth="89.0" text="Enter Biirthday:" />
      <TextField fx:id="deptTxt" layoutX="383.0" layoutY="61.0" onMouseClicked="#deptTxtOnMouseClick" prefHeight="25.0" prefWidth="174.0" />
      <Label layoutX="308.0" layoutY="64.0" prefHeight="17.0" prefWidth="68.0" text="Enter Dept:" />
    </children>
</AnchorPane>
