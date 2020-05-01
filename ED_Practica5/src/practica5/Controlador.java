package practica5;

import java.awt.Label;
import java.awt.event.*;

public class Controlador implements WindowListener, ActionListener {
	private Modelo m;
	private Vista v;

	public Controlador(Modelo m, Vista v) {
		this.m = m;
		this.v = v;

		v.menuAlta.addActionListener(this);
		v.menuBaja.addActionListener(this);
		v.menuConsulta.addActionListener(this);
		v.menuModificacion.addActionListener(this);
		v.btnLimpiar.addActionListener(this);
		v.btnAceptarAlta.addActionListener(this);
		v.btnAceptarBaja.addActionListener(this);
		v.btnAceptarModificacion.addActionListener(this);
		v.btnEliminar.addActionListener(this);
		v.btnElegir.addActionListener(this);
		v.btnAceptarModificacion.addActionListener(this);
		v.dialogAlta.addWindowListener(this);
		v.dialogBaja.addWindowListener(this);
		v.dialogConsulta.addWindowListener(this);
		v.dialogModificacion.addWindowListener(this);
		v.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object objetoPulsado = e.getSource();
		if (objetoPulsado.equals(v.menuAlta)) {
			v.dialogAlta.setVisible(true);
			v.panelElegirModificacion.setVisible(false);
			v.panelBaja.setVisible(false);			
			v.panelConsulta.setVisible(false);
			v.panelAltaLabel.setVisible(true);
			v.panelAltaText.setVisible(true);
			v.panelAltaBoton.setVisible(true);
			v.panelBotonModificacion.setVisible(false);
			m.consultaDepartamento(v.departamento);
			System.out.println("Abriendo el apartado de alta de empleados");
		} 
		else if (objetoPulsado.equals(v.menuBaja)) 
		{
			v.dialogBaja.setVisible(true);
			v.panelElegirModificacion.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelBaja.setVisible(true);
			v.panelBotonModificacion.setVisible(false);
			m.consultaEmpleado(v.choEmpleadoBaja);
			System.out.println("Abriendo el apartado de baja de empleados");
		}
		else if(objetoPulsado.equals(v.menuConsulta)) 
		{
			v.dialogConsulta.setVisible(true);
			v.panelElegirModificacion.setVisible(false);
			v.panelBaja.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(true);
			v.panelBotonModificacion.setVisible(false);
			m.consultaEmpleados(v.consulta);
			System.out.println("Abriendo el apartado de consulta de empleados");
		}
		else if(objetoPulsado.equals(v.menuModificacion)) 
		{
			v.dialogModificacion.setVisible(true);
			v.panelBaja.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelElegirModificacion.setVisible(true);
			v.panelBotonModificacion.setVisible(false);
			m.consultaEmpleado(v.choEmpleado);			
			System.out.println("Abriendo el apartado de selección de empleados a modificar");
		}
		else if (objetoPulsado.equals(v.btnEliminar)) 
		{
			System.out.println("Borrando empleado");
			m.borrar(v.choEmpleadoBaja);
			v.panelBaja.setVisible(false);
		}
		else if (objetoPulsado.equals(v.btnElegir)) 
		{
			System.out.println("Empleado elegido");
			v.panelBaja.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelElegirModificacion.setVisible(false);
			v.panelAltaLabel.setVisible(true);
			v.panelModificacion.setVisible(true);
			v.panelBotonModificacion.setVisible(true);
			v.lblIdEmpleado = new Label(m.idEmpleado(v.choEmpleado));
			v.panelBotonModificacion.add(v.lblIdEmpleado);
			m.mostrarDatos(v.choEmpleado, v.nombreModificar, v.extensionModificar, v.fechaNacimientoModificar, 
					v.fechaIngresoModificar, v.salarioModificar, v.comisionModificar, v.hijosModificar);
			m.consultaDepartamento(v.departamentoModificacion);
			System.out.println("Abriendo el apartado de modificación de empleados");
		}
		else if (objetoPulsado.equals(v.btnAceptarModificacion)) 
		{
			m.modificar(v.departamentoModificacion.getSelectedItem().substring(0, 3), v.extensionModificar.getText(), 
					v.fechaNacimientoModificar.getText(), v.fechaIngresoModificar.getText(), v.salarioModificar.getText(), 
					v.comisionModificar.getText(), v.hijosModificar.getText(), v.nombreModificar.getText(), v.lblIdEmpleado.getText());
			v.panelModificacion.setVisible(false);
			v.panelBaja.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelElegirModificacion.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelBotonModificacion.setVisible(false);

		}
		else if(objetoPulsado.equals(v.btnLimpiar))
		{
			v.nombre.selectAll();
			v.nombre.setText("");
			v.departamento.select(0);
			v.extension.setText("");
			v.fechaNacimiento.setText("");
			v.fechaIngreso.setText("");
			v.salario.setText("");
			v.comision.setText("");
			v.hijos.setText("");
			v.nombre.requestFocus();
			System.out.println("Limpieza de campos");
		}
		else if(objetoPulsado.equals(v.btnAceptarAlta))
		{
			m.insertar(v.departamento.getSelectedItem().substring(0, 3), v.extension.getText(), 
					v.fechaNacimiento.getText(), v.fechaIngreso.getText(), v.salario.getText(), v.comision.getText(), 
					v.hijos.getText(), v.nombre.getText());
			v.panelAltaBoton.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.nombre.selectAll();
			v.nombre.setText("");
			v.departamento.select(0);
			v.extension.setText("");
			v.fechaNacimiento.setText("");
			v.fechaIngreso.setText("");
			v.salario.setText("");
			v.comision.setText("");
			v.hijos.setText("");
			v.nombre.requestFocus();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(v.dialogAlta.hasFocus())
		{
			v.dialogAlta.setVisible(false);
		}
		else if(v.dialogBaja.hasFocus())
		{
			v.dialogBaja.setVisible(false);
		}
		else if(v.dialogConsulta.hasFocus())
		{
			v.dialogConsulta.setVisible(false);
		}
		else if(v.dialogModificacion.hasFocus())
		{
			v.dialogModificacion.setVisible(false);
		}
		else
		{
			System.out.println("Cerrando el programa");
			System.exit(0);		
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}	
}