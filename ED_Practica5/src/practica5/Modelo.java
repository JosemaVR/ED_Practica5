package practica5;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Modelo {
	SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
	ResultSet rs = null;

	public Connection conectar()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empresa?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "Studium2019;";
		Connection con = null;
		try {
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD empresa
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Conectado a la base de datos");
			}
		} catch (SQLException ex) {
			System.out.println("ERROR:La dirección no es válida o el usuario y clave");
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		}
		return con;
	}

	public int insertar(String departamento, String extension, 
			String fechaNacimiento, String fechaIngreso, String salario, 
			String comision, String hijos, String nombre) 
	{
		Connection con = conectar();
		int respuesta = 0;
		try 
		{
			try {
				String fechaNac = outputFormat.format(inputFormat.parse(fechaNacimiento)).toString();
				String fechaIng = outputFormat.format(inputFormat.parse(fechaNacimiento)).toString();

				Statement sta = con.createStatement();

				String sqlSelect = "SELECT idEmpleado FROM empleados ORDER BY idEmpleado DESC LIMIT 1";
				System.out.println(sqlSelect);
				rs = sta.executeQuery(sqlSelect);
				rs.last();
				String idEmpleado = Integer.toString(rs.getInt("idEmpleado")+10);
				sta.close();

				Statement sta2 = con.createStatement();

				String cadenaSQL = "INSERT INTO empleados VALUES ('" + idEmpleado +"' , '"+ departamento 
						+ "', '" + extension + "', '" + fechaNac + "', '" + fechaIng + "', '" 
						+ salario + "', '" + comision + "', '" + hijos + "', '" + nombre + "')";
				System.out.println(cadenaSQL);
				sta2.executeUpdate(cadenaSQL);
				sta2.close();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Insert");
			ex.printStackTrace();
			respuesta = 1;
		}
		return respuesta;
	}

	public void consultaDepartamento(Choice departamento) {
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM departamentos";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				departamento.add(rs.getInt("idDepartamento")+
						"-"+rs.getString("nombreDepartamento"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR: al consultar");
			ex.printStackTrace();
		}
	}

	public void desconectar(Connection con)
	{
		try
		{
			con.close();
		}
		catch(Exception e) {}
	}

	public void consultaEmpleados(TextArea consulta) {
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM empleados JOIN departamentos WHERE "
				+ "empleados.idDepartamentoFK = departamentos.idDepartamento "
				+ "ORDER BY empleados.idEmpleado";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				if(consulta.getText().length()==0)
				{
					consulta.setText(rs.getInt("idEmpleado")+
							"- "+rs.getString("nombreEmpleado")+
							" - "+rs.getString("nombreDepartamento"));
				}
				else
				{
					consulta.setText(consulta.getText() + "\n" + rs.getInt("idEmpleado")+
							"- "+rs.getString("nombreEmpleado")+
							" - "+rs.getString("nombreDepartamento"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}
	}

	public void consultaEmpleado(Choice empleado) {
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM empleados";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				empleado.add(rs.getInt("idEmpleado")+
						"-"+rs.getString("nombreEmpleado"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR: al consultar");
			ex.printStackTrace();
		}
	}

	public int borrar(Choice empleado) 
	{
		Connection con = conectar();
		int respuesta = 0;
		System.out.println(empleado.getSelectedItem());
		String sql = "DELETE FROM empleados WHERE idEmpleado = '" + empleado.getSelectedItem().substring(0,3) + "'";
		System.out.println(sql);
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement sta = con.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		}
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Delete");
			ex.printStackTrace();
			respuesta = 1;
		}
		return respuesta;
	}

	public void mostrarDatos(Choice idEmpleado, TextField nombre, TextField extension, 
			TextField fechaNacimiento, TextField fechaIngreso, TextField salario,
			TextField comision, TextField hijos)
	{
		Connection con = conectar();
		String sql = "SELECT * FROM empleados WHERE idEmpleado = "+ idEmpleado.getSelectedItem().substring(0, 3);
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next())
			{
				String nombreEmpleado = rs.getString("nombreEmpleado");
				nombre.setText(nombreEmpleado);
				String extensionEmpleado = rs.getString("extensionEmpleado");
				extension.setText(extensionEmpleado);
				String fechaNacimientoEmpleado = inputFormat.format(rs.getDate("fechaNacimientoEmpleado"));
				fechaNacimiento.setText(fechaNacimientoEmpleado);
				String fechaIngresoEmpleado = inputFormat.format(rs.getDate("fechaIngresoEmpleado"));
				fechaIngreso.setText(fechaIngresoEmpleado);
				String salarioEmpleado = rs.getString("salarioEmpleado");
				salario.setText(salarioEmpleado);
				String comisionEmpleado = rs.getString("comisionEmpleado");
				comision.setText(comisionEmpleado);
				String hijosEmpleado = rs.getString("hijosEmpleado");
				hijos.setText(hijosEmpleado);
			}
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR: al hacer una modificacion");
			ex.printStackTrace();
		}
	}
}
