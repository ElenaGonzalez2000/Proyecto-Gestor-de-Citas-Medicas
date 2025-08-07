package com.gonzalez.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.gonzalez.controlador.GestorPacientes;
import com.gonzalez.controlador.*;

public class VentanaCitas extends JFrame {
    // Panel principal
    private JPanel panelPrincipal;
    // Gestores de pacientes, médicos y citas
    private GestorPacientes gestorPacientes;
    private GestorMedicos gestorMedicos = new GestorMedicos();
    private GestorCitas gestorCitas = new GestorCitas();

    public VentanaCitas() {
        setTitle("Mi primer ventana"); 
        setSize(600, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gestorPacientes = new GestorPacientes(); // Inicializa gestor de pacientes
        gestorMedicos = new GestorMedicos(); // Inicializa gestor de médicos
        gestorCitas = new GestorCitas(); // Inicializa gestor de citas

        JMenuBar menuBar = new JMenuBar(); // Barra de menú superior

        // Menú de pacientes y sus opciones
        JMenu menuPacientes = new JMenu("Pacientes");
        JMenuItem registrarPacienItem = new JMenuItem("Registrar nuevo paciente");
        JMenuItem verPacientesItem = new JMenuItem("Ver pacientes registrados");
        menuPacientes.add(registrarPacienItem);
        menuPacientes.add(verPacientesItem);

        // Menú de médicos y sus opciones
        JMenu menuMedicos = new JMenu("Medicos");
        JMenuItem registrarMedicoItem = new JMenuItem("Registrar nuevo médico");
        JMenuItem verMedicosItem = new JMenuItem("Ver médicos registrados");
        menuMedicos.add(registrarMedicoItem);
        menuMedicos.add(verMedicosItem);

        // Menú de citas y sus opciones
        JMenu menuCitas = new JMenu("Citas");
        JMenuItem registrarCitaItem = new JMenuItem("Registrar nueva cita");
        JMenuItem verCitasItem = new JMenuItem("Ver citas");
        JMenuItem cancelarCitaItem = new JMenuItem("Cancelar cita");
        menuCitas.add(registrarCitaItem);
        menuCitas.add(verCitasItem);
        menuCitas.add(cancelarCitaItem);

        // Agrega los menús a la barra de menú
        menuBar.add(menuPacientes);
        menuBar.add(menuMedicos);
        menuBar.add(menuCitas);
        setJMenuBar(menuBar);

        setLayout(new BorderLayout());

        // Barra de herramientas con botones rápidos
        JToolBar toolBar = new JToolBar();
        JButton btnNuevaCita = new JButton("Nueva cita");
        JButton btnMostrarCitas = new JButton("Mostrar citas");
        toolBar.add(btnNuevaCita);
        toolBar.add(btnMostrarCitas);
        add(toolBar, BorderLayout.NORTH);

        // Acción para botón "Nueva cita"
        btnNuevaCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelCrearCitas(gestorPacientes, gestorMedicos, gestorCitas),
                        BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para botón "Mostrar citas"
        btnMostrarCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelVerCitas(gestorCitas), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        panelPrincipal = new JPanel(new BorderLayout()); // Inicializa panel principal
        add(panelPrincipal, BorderLayout.CENTER); // Lo agrega al centro de la ventana

        // Acción para registrar paciente
        registrarPacienItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelRegistrarPacientes(gestorPacientes), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para ver pacientes
        verPacientesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelVerPacientes(gestorPacientes), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para registrar médico
        registrarMedicoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelRegistrarMedicos(gestorMedicos), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para ver médicos
        verMedicosItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelVerMedicos(gestorMedicos), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para registrar cita
        registrarCitaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelCrearCitas(gestorPacientes, gestorMedicos, gestorCitas),
                        BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para ver citas
        verCitasItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelVerCitas(gestorCitas), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Acción para cancelar cita
        cancelarCitaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(new PanelCancelarCitas(gestorCitas), BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });

        // Muestra el panel de crear citas por defecto al iniciar
        panelPrincipal.removeAll();
        panelPrincipal.add(new PanelCrearCitas(gestorPacientes, gestorMedicos, gestorCitas), BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();

        // Hace visible la ventana principal
        setVisible(true);
    }
}
