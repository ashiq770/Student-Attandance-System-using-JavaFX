package com.Attandance_system.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class UIFactory {

    // ── Palette ──────────────────────────────────────────────────────────────
    public static final Color BG_DARK      = Color.web("#0D1117");
    public static final Color BG_CARD      = Color.web("#161B22");
    public static final Color BG_SURFACE   = Color.web("#21262D");
    public static final Color ACCENT_BLUE  = Color.web("#2F81F7");
    public static final Color ACCENT_GREEN = Color.web("#3FB950");
    public static final Color ACCENT_RED   = Color.web("#F85149");
    public static final Color TEXT_PRIMARY  = Color.web("#E6EDF3");
    public static final Color TEXT_MUTED    = Color.web("#8B949E");
    public static final Color BORDER_COLOR  = Color.web("#30363D");

    // ── Background ───────────────────────────────────────────────────────────
    public static Background darkBg() {
        return new Background(new BackgroundFill(BG_DARK, CornerRadii.EMPTY, Insets.EMPTY));
    }

    public static Background cardBg() {
        return new Background(new BackgroundFill(BG_CARD, new CornerRadii(12), Insets.EMPTY));
    }

    public static Background surfaceBg() {
        return new Background(new BackgroundFill(BG_SURFACE, new CornerRadii(8), Insets.EMPTY));
    }

    // ── Labels ───────────────────────────────────────────────────────────────
    public static Label title(String text) {
        Label l = new Label(text);
        l.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26));
        l.setTextFill(TEXT_PRIMARY);
        return l;
    }

    public static Label subtitle(String text) {
        Label l = new Label(text);
        l.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 13));
        l.setTextFill(TEXT_MUTED);
        return l;
    }

    public static Label sectionHeader(String text) {
        Label l = new Label(text);
        l.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
        l.setTextFill(TEXT_PRIMARY);
        return l;
    }

    // ── Buttons ──────────────────────────────────────────────────────────────
    public static Button primaryButton(String text, Color accent) {
        Button b = new Button(text);
        b.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 13));
        b.setTextFill(Color.WHITE);
        b.setPrefHeight(38);
        b.setPadding(new Insets(0, 20, 0, 20));
        String hex = toHex(accent);
        String darker = toHex(accent.darker());
        b.setStyle(
            "-fx-background-color: " + hex + ";" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        );
        b.setOnMouseEntered(e -> b.setStyle(
            "-fx-background-color: " + darker + ";" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        ));
        b.setOnMouseExited(e -> b.setStyle(
            "-fx-background-color: " + hex + ";" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        ));
        return b;
    }

    public static Button ghostButton(String text) {
        Button b = new Button(text);
        b.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 12));
        b.setTextFill(TEXT_MUTED);
        b.setPrefHeight(32);
        b.setPadding(new Insets(0, 14, 0, 14));
        b.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-border-color: #30363D;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        );
        b.setOnMouseEntered(e -> b.setStyle(
            "-fx-background-color: #21262D;" +
            "-fx-border-color: #8B949E;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        ));
        b.setOnMouseExited(e -> b.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-border-color: #30363D;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-cursor: hand;"
        ));
        return b;
    }

    // ── TextField ────────────────────────────────────────────────────────────
    public static TextField styledField(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setFont(Font.font("Segoe UI", 13));
        tf.setPrefHeight(38);
        tf.setStyle(
            "-fx-background-color: #21262D;" +
            "-fx-text-fill: #E6EDF3;" +
            "-fx-prompt-text-fill: #484F58;" +
            "-fx-border-color: #30363D;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-padding: 0 10 0 10;"
        );
        tf.focusedProperty().addListener((obs, o, n) -> {
            if (n) tf.setStyle(
                "-fx-background-color: #21262D;" +
                "-fx-text-fill: #E6EDF3;" +
                "-fx-prompt-text-fill: #484F58;" +
                "-fx-border-color: #2F81F7;" +
                "-fx-border-radius: 6;" +
                "-fx-background-radius: 6;" +
                "-fx-padding: 0 10 0 10;"
            );
            else tf.setStyle(
                "-fx-background-color: #21262D;" +
                "-fx-text-fill: #E6EDF3;" +
                "-fx-prompt-text-fill: #484F58;" +
                "-fx-border-color: #30363D;" +
                "-fx-border-radius: 6;" +
                "-fx-background-radius: 6;" +
                "-fx-padding: 0 10 0 10;"
            );
        });
        return tf;
    }

    // ── Card pane ─────────────────────────────────────────────────────────────
    public static VBox card(double width) {
        VBox box = new VBox(12);
        box.setPrefWidth(width);
        box.setPadding(new Insets(20));
        box.setBackground(cardBg());
        DropShadow shadow = new DropShadow(15, Color.web("#000000", 0.4));
        box.setEffect(shadow);
        box.setStyle("-fx-border-color: #30363D; -fx-border-radius: 12; -fx-background-radius: 12;");
        return box;
    }

    // ── Separator ─────────────────────────────────────────────────────────────
    public static Separator separator() {
        Separator sep = new Separator();
        sep.setStyle("-fx-background-color: #30363D;");
        return sep;
    }

    // ── Alert ─────────────────────────────────────────────────────────────────
    public static void showAlert(Alert.AlertType type, String title, String msg) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        DialogPane dp = a.getDialogPane();
        dp.setStyle(
            "-fx-background-color: #161B22;" +
            "-fx-border-color: #30363D;"
        );
        dp.lookup(".content.label").setStyle("-fx-text-fill: #E6EDF3; -fx-font-family: 'Segoe UI';");
        a.showAndWait();
    }

    // ── Helper ────────────────────────────────────────────────────────────────
    private static String toHex(Color c) {
        return String.format("#%02X%02X%02X",
            (int)(c.getRed()*255),
            (int)(c.getGreen()*255),
            (int)(c.getBlue()*255));
    }
}
