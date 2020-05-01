package practica5;

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
		v.btnModificar.addActionListener(this);
		v.addWindowListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object objetoPulsado = e.getSource();
		if (objetoPulsado.equals(v.menuAlta)) {
			v.panelElegirModificacion.setVisible(false);
			v.panelBaja.setVisible(false);			
			v.panelConsulta.setVisible(false);
			v.panelAltaLabel.setVisible(true);
			v.panelAltaText.setVisible(true);
			v.panelAltaBoton.setVisible(true);
			m.consultaDepartamento(v.departamento);
		} 
		else if (objetoPulsado.equals(v.menuBaja)) {
			v.panelElegirModificacion.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelBaja.setVisible(true);
			m.consultaEmpleado(v.choEmpleadoBaja);
		}
		else if(objetoPulsado.equals(v.menuConsulta)) {
			v.panelElegirModificacion.setVisible(false);
			v.panelBaja.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(true);
			m.consultaEmpleados(v.consulta);
		}
		else if(objetoPulsado.equals(v.menuModificacion)) {
			v.panelBaja.setVisible(false);
			v.panelAltaLabel.setVisible(false);
			v.panelAltaText.setVisible(false);
			v.panelAltaBoton.setVisible(false);
			v.panelConsulta.setVisible(false);
			v.panelElegirModificacion.setVisible(true);
			m.consultaEmpleado(v.choEmpleado);
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
			v.panelElegirModificacion.setVisible(false);
			v.panelAltaLabel.setVisible(true);
			v.panelModificacion.setVisible(true);
			m.mostrarDatos(v.choEmpleado, v.nombreModificar, v.extensionModificar, v.fechaNacimientoModificar, 
					v.fechaIngresoModificar, v.salarioModificar, v.comisionModificar, v.hijosModificar);
		}
		else if (objetoPulsado.equals(v.btnModificar)) 
		{
			System.out.println("Empleado elegido");
			m.borrar(v.choEmpleado);
			v.panelModificacion.setVisible(false);
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
		System.exit(0);
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