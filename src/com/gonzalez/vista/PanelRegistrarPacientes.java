package com.gonzalez.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.gonzalez.controlador.*;
import com.gonzalez.modelo.Paciente;

public class PanelRegistrarPacientes extends JPanel {
    private JTextField txtNombre, txtApellido, txtDni, txtEdad, txtTelefono;
    private GestorPacientes gestor;

    public PanelRegistrarPacientes(GestorPacientes gestor) {
        this.gestor = gestor;
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("DNI:"));
        txtDni = new JTextField();
        add(txtDni);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDni.getText();
                String telefono = txtTelefono.getText();
                int edad;

                try {
                    edad = Integer.parseInt(txtEdad.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Edad inválida");
                    return;
                }

                Paciente paciente = new Paciente(nombre, apellido, edad, dni, telefono);
                gestor.agregarPaciente(paciente);

                JOptionPane.showMessageDialog(null, "Paciente registrado correctamente");

                txtNombre.setText("");
                txtApellido.setText("");
                txtDni.setText("");
                txtEdad.setText("");
                txtTelefono.setText("");
            }
        });
        add(btnRegistrar);
    }
}
