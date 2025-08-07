package com.gonzalez.vista;

import java.util.Collection;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gonzalez.controlador.*;
import com.gonzalez.modelo.Paciente;

public class PanelVerPacientes extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelVerPacientes(GestorPacientes gestor) {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[] { "Nombre", "DNI", "Edad" }, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        Collection<Paciente> pacientes = gestor.getPacientes();
        for (Paciente p : pacientes) {
            modelo.addRow(new Object[] { p.getNombre(), p.getDni(), p.getEdad() });
        }

    }
}
