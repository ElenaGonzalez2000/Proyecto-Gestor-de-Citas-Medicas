package com.gonzalez.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.gonzalez.controlador.*;
import com.gonzalez.modelo.Cita;

public class PanelVerCitas extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelVerCitas(GestorCitas gestor) {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"Paciente", "Médico", "Fecha"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        for (Cita c : gestor.getCitas()) {
            modelo.addRow(new Object[]{
                c.getPaciente().getNombre() + " " + c.getPaciente().getApellido(),
                c.getMedico().getNombre() + " " + c.getMedico().getApellido(),
                c.getFechaHora().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
            });
        }
    }
}