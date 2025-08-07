package com.gonzalez.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.gonzalez.controlador.*;
import com.gonzalez.modelo.*;

public class PanelCrearCitas extends JPanel {
    private JComboBox<String> comboPacientes;
    private JComboBox<String> comboMedicos;
    private JTextField txtFechaHora;
    private GestorPacientes gestorPacientes;
    private GestorMedicos gestorMedicos;
    private GestorCitas gestorCitas;

    public PanelCrearCitas(GestorPacientes gp, GestorMedicos gm, GestorCitas gc) {
        this.gestorPacientes = gp;
        this.gestorMedicos = gm;
        this.gestorCitas = gc;

        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Seleccionar paciente:"));
        comboPacientes = new JComboBox<>();
        for (Paciente p : gestorPacientes.getPacientes()) {
            comboPacientes.addItem(p.getDni() + " - " + p.getNombre() + " " + p.getApellido());
        }
        add(comboPacientes);

        add(new JLabel("Seleccionar médico:"));
        comboMedicos = new JComboBox<>();
        for (Medico m : gestorMedicos.getMedicos()) {
            comboMedicos.addItem(m.getNombre() + " " + m.getApellido() + " - " + m.getEspecialidad());

        }
        add(comboMedicos);

        add(new JLabel("Fecha y hora (yyyy-MM-dd HH:mm):"));
        txtFechaHora = new JTextField();
        add(txtFechaHora);

        JButton btnCrear = new JButton("Crear cita");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String fechaTexto = txtFechaHora.getText();
                    LocalDateTime fechaHora = LocalDateTime.parse(fechaTexto,
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    int pacienteIndex = comboPacientes.getSelectedIndex();
                    int medicoIndex = comboMedicos.getSelectedIndex();

                    if (pacienteIndex >= 0 && medicoIndex >= 0) {
                        Paciente paciente = gestorPacientes.getPacientes().stream().toList().get(pacienteIndex);
                        Medico medico = gestorMedicos.getMedicos().get(medicoIndex);

                        if (!medico.isDisponible()) {
                            JOptionPane.showMessageDialog(null, "El médico no está disponible.");
                            return;
                        }

                        Cita nuevaCita = new Cita(fechaHora, paciente, medico, "Activa");
                        gestorCitas.agregarCita(nuevaCita);

                        JOptionPane.showMessageDialog(null, "Cita registrada correctamente.");
                        txtFechaHora.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente y un médico.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use: yyyy-MM-dd HH:mm");
                }
            }
        });
        add(btnCrear);
    }
}
