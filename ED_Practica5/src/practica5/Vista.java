package practica5;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Vista extends Frame{
	private static final long serialVersionUID = 1L;

	MenuBar barraMenu = new MenuBar();

	Menu menu = new Menu("Opciones");

	MenuItem menuAlta = new MenuItem("Alta");
	MenuItem menuBaja = new MenuItem("Baja");
	MenuItem menuConsulta = new MenuItem("Consulta");
	MenuItem menuModificacion = new MenuItem("Modificación");

	Label lblNombre = new Label("Nombre:");
	Label lblDepartamento = new Label("Departamento:");
	Label lblExtension = new Label("Extensión:");
	Label lblFechaNacimiento = new Label("Fecha Nacimiento:");
	Label lblFechaIngreso = new Label("Fecha Ingreso:");
	Label lblSalario = new Label("Salario:");
	Label lblComision= new Label("Comisión:");
	Label lblHijos = new Label("Hijos:");
	Label saltoDeLinea = new Label("\n");
	TextField nombre = new TextField(20);
	Choice departamento = new Choice();
	TextField extension = new TextField(20);
	TextField fechaNacimiento = new TextField(20);
	TextField fechaIngreso = new TextField(20);
	TextField salario = new TextField(20);
	TextField comision = new TextField(20);
	TextField hijos = new TextField(20);
	
	TextField nombreModificar = new TextField(20);
	TextField extensionModificar = new TextField(20);
	TextField fechaNacimientoModificar = new TextField(20);
	TextField fechaIngresoModificar = new TextField(20);
	TextField salarioModificar = new TextField(20);
	TextField comisionModificar = new TextField(20);
	TextField hijosModificar = new TextField(20);
	
	Button btnAceptarAlta = new Button("Aceptar");
	Button btnAceptarBaja = new Button("Aceptar");
	Button btnAceptarModificacion = new Button("Aceptar");
	Button btnLimpiar = new Button("Limpiar");
	Panel panelAltaLabel = new Panel(new FlowLayout());
	Panel panelAltaText = new Panel(new FlowLayout());
	Panel panelAltaBoton = new Panel(new FlowLayout());
	Panel panelBaja = new Panel(new FlowLayout());
	Panel panelConsulta = new Panel();
	Panel panelModificacion = new Panel(new FlowLayout());
	TextArea consulta = new TextArea(20,42);
	Choice choEmpleado = new Choice();
	Choice choEmpleadoBaja = new Choice();
	Button btnEliminar = new Button("Borrar empleado");
	Button btnElegir = new Button("Seleccionar empleado");
 	Button btnModificar = new Button("Modificar empleado");
	Panel panelElegirModificacion = new Panel(new FlowLayout());
	Choice departamentoModificacion = new Choice();
	Panel panelBotonModificacion = new Panel(new FlowLayout());
	Button btnLimpiarModificacion = new Button();
	
	public Vista() {
		setTitle("Gestión de empleados");
		setLayout(new FlowLayout());
		menu.add(menuAlta);
		menu.add(menuBaja);
		menu.add(menuConsulta);
		menu.add(menuModificacion);
		
		barraMenu.add(menu);
		
		add(panelAltaLabel);		
		panelAltaLabel.setVisible(false);
		panelAltaLabel.add(lblNombre);
		panelAltaLabel.add(lblDepartamento);
		panelAltaLabel.add(lblExtension);
		panelAltaLabel.add(lblFechaNacimiento);
		panelAltaLabel.add(lblFechaIngreso);
		panelAltaLabel.add(lblSalario);
		panelAltaLabel.add(lblComision);
		panelAltaLabel.add(lblHijos);
		panelAltaLabel.setSize(120, 240);
		panelAltaLabel.setLocation(25,50);
		
		add(panelAltaText);
		panelAltaText.setVisible(false);
		panelAltaText.add(nombre);
		panelAltaText.add(departamento);
		departamento.add("Seleccionar uno...                     ");
		departamento.select(0);
		panelAltaText.add(extension);
		panelAltaText.add(fechaNacimiento);
		panelAltaText.add(fechaIngreso);
		panelAltaText.add(salario);
		panelAltaText.add(comision);
		panelAltaText.add(hijos);
		panelAltaText.setSize(200, 240);
		panelAltaText.setLocation(150,50);
		
		add(panelAltaBoton);
		panelAltaBoton.setVisible(false);
		panelAltaBoton.add(btnAceptarAlta);
		panelAltaBoton.add(btnLimpiar);
		panelAltaBoton.setLocation(70,300);
		panelAltaBoton.setSize(200,100);
		
		add(panelConsulta);
		panelConsulta.setVisible(false);
		panelConsulta.add(consulta);
		panelConsulta.setLocation(25,50);
		panelConsulta.setSize(325,350);
		
		add(panelBaja);
		panelBaja.setVisible(false);
		panelBaja.add(choEmpleadoBaja);
		choEmpleadoBaja.add("Seleccionar uno...                     ");
		choEmpleadoBaja.select(0);
		panelBaja.add(btnEliminar);
		panelBaja.setLocation(25,50);
		panelBaja.setSize(325,350);
		
		add(panelElegirModificacion);
		panelElegirModificacion.setVisible(false);
		panelElegirModificacion.add(choEmpleado);
		choEmpleado.add("Seleccionar uno...                     ");
		choEmpleado.select(0);
		panelElegirModificacion.add(btnElegir);
		panelElegirModificacion.setLocation(25,50);
		panelElegirModificacion.setSize(325,350);
		
		add(panelModificacion);
		panelModificacion.setVisible(false);
		panelModificacion.add(nombreModificar);
		panelModificacion.add(departamentoModificacion);
		departamentoModificacion.add("Seleccionar uno...                     ");
		departamentoModificacion.select(0);
		panelModificacion.add(extensionModificar);
		panelModificacion.add(fechaNacimientoModificar);
		panelModificacion.add(fechaIngresoModificar);
		panelModificacion.add(salarioModificar);
		panelModificacion.add(comisionModificar);
		panelModificacion.add(hijosModificar);
		panelModificacion.setLocation(150,50);
		panelModificacion.setSize(200,240);
		
		add(panelBotonModificacion);
		panelBotonModificacion.setVisible(false);
		panelBotonModificacion.add(btnModificar);
		panelBotonModificacion.add(btnLimpiarModificacion);
		panelBotonModificacion.setLocation(70,300);
		panelBotonModificacion.setSize(200,100);
		
		setMenuBar(barraMenu);
		setSize(375,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
