package com.gonzalez.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gonzalez.controlador.GestorMedicos;
import com.gonzalez.modelo.Medico;

public class PanelRegistrarMedicos extends JPanel {
    private JTextField txtNombre, txtApellido, txtEspecialidad;
    private JCheckBox chkDisponible;
    private GestorMedicos gestor;

    public PanelRegistrarMedicos(GestorMedicos gestor) {
        this.gestor = gestor;
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        add(txtEspecialidad);

        add(new JLabel("¿Está disponible?"));
        chkDisponible = new JCheckBox("Disponible");
        add(chkDisponible);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String especialidad = txtEspecialidad.getText();
                boolean disponible = chkDisponible.isSelected();

                Medico medico = new Medico(nombre, apellido, especialidad, disponible);
                gestor.agregarMedico(medico);

                JOptionPane.showMessageDialog(null, "Médico registrado correctamente");

                txtNombre.setText("");
                txtApellido.setText("");
                txtEspecialidad.setText("");
                chkDisponible.setSelected(false);
            }
        });
        add(btnRegistrar);
    }
}