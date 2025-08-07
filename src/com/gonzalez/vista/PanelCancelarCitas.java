package com.gonzalez.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import com.gonzalez.controlador.GestorCitas;
import com.gonzalez.modelo.Cita;

public class PanelCancelarCitas extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;
    private GestorCitas gestor;

    public PanelCancelarCitas(GestorCitas gestor) {
        this.gestor = gestor;
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[] { "Paciente", "Médico", "Fecha" }, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        JButton btnCancelar = new JButton("Cancelar cita seleccionada");
        add(btnCancelar, BorderLayout.SOUTH);

        cargarCitas();

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    Cita cita = gestor.getCitas().get(fila);
                    gestor.cancelarCita(cita);
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "Cita cancelada correctamente.");

                    SwingUtilities.getWindowAncestor(PanelCancelarCitas.this).repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una cita para cancelar.");
                }
            }
        });

    }

    private void cargarCitas() {
        modelo.setRowCount(0);
        for (Cita c : gestor.getCitas()) {
            if ("Activa".equalsIgnoreCase(c.getEstado())) {
                modelo.addRow(new Object[] {
                        c.getPaciente().getNombre() + " " + c.getPaciente().getApellido(),
                        c.getMedico().getNombre() + " " + c.getMedico().getApellido(),
                        c.getFechaHora()
                });
            }
        }
    }

}
