package com.gonzalez.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.gonzalez.controlador.*;
import com.gonzalez.modelo.Medico;

public class PanelVerMedicos extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelVerMedicos(GestorMedicos gestor) {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "Especialidad", "Disponible"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        for (Medico m : gestor.getMedicos()) {
            modelo.addRow(new Object[]{
                m.getNombre(),
                m.getApellido(),
                m.getEspecialidad(),
                m.isDisponible() ? "Sí" : "No"
            });
        }
    }
}
