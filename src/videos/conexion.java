package videos;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;

import javax.swing.*;

import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;

public class conexion {
	public static String now(){
		Calendar date = new GregorianCalendar();
		int day= date.get(Calendar.DAY_OF_MONTH);
		int month= date.get(Calendar.MONTH)+1;	// Por alguna razon el gregorian calendar me da la fecha un mes menor a lo que es
		int year=date.get(Calendar.YEAR);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		String y =(year+"-"+month+"-"+day);
		return (y);
		}
	public static Integer CxRe(String id_vid){
		int r=0;
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				Statement myStat = conn.createStatement();
				ResultSet myRs= myStat.executeQuery("Select precio from videos where id_video = "+id_vid+";");
				System.out.println("proceso...");
				while(myRs.next())	
				{
					r= myRs.getInt("precio");
				}
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}
		return r;
	}
	public void TxRe(String id_cl, String id_video){
		int x= CxRe(id_video);
		String f= now().toString();
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				System.out.println("Se obtuvo el precio "+ x+", Con la fecha: "+f);
				Statement myStat = conn.createStatement();
				myStat.executeUpdate("insert into rentas(id_cliente,id_video,costxrent,fecha) values("+id_cl+","+id_video+","+x+",\""+f+"\")");
				
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}	
	}
	public static String TxCl(String ID,String today){
		String tcl=null;
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				System.out.println("En proceso...");
				Statement myStat = conn.createStatement();
				System.out.println(today);
				ResultSet myRs= myStat.executeQuery("Select c.id_cliente AS ID,c.nombre_cl AS Nombre,r.fecha AS Fecha,sum(r.costxrent) AS Total "
													+ "from rentas r inner join clientes c on r.id_cliente=c.id_cliente "
													+ "inner join videos v on r.id_video=v.id_video "
													+ "where c.id_cliente = "+ID+" AND r.fecha = \""+today+"\";");	
				//int y=0;
				while(myRs.next())	
				{
					System.out.println(myRs.getString("ID")+"\t"+myRs.getString("Nombre")+"\t\t"+myRs.getString("Fecha")+
							"\t"+myRs.getString("Total"));
					tcl=(myRs.getString("ID")+"\t"+myRs.getString("Nombre")+"\t\t"+myRs.getString("Fecha")+
							"\t"+myRs.getString("Total"));
					//y++;
				}
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}
		return tcl;
	}
	public static String[] TxD(){
	String [] cl= new String[3];
	Connection conn= null;
	try
	{
		conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
		if(conn!=null)
		{
			System.out.println("En proceso...");
			Statement myStat = conn.createStatement();
			ResultSet myRs= myStat.executeQuery("Select c.id_cliente AS ID,c.nombre_cl AS Nombre,r.fecha AS Fecha,sum(r.costxrent) AS Total "
												+ "from rentas r inner join clientes c on r.id_cliente=c.id_cliente "
												+ "inner join videos v on r.id_video=v.id_video group by c.id_cliente;");
			int y=0;
			while(myRs.next())	
			{
				System.out.println(myRs.getString("ID")+"\t"+myRs.getString("Nombre")+"\t"
									+myRs.getString("Fecha")+"\t"+myRs.getString("Total"));
				cl[y]= (myRs.getString("ID")+"\t"+myRs.getString("Nombre")+"\t"
						+myRs.getString("Fecha")+"\t"+myRs.getString("Total")+"\n");
				y++;
			}
		}	
	}
	catch(Exception e)
		{
			System.out.println("Fallo en la conexion con la base de datos"+ e);
		}
	return cl;
	}
	public static void TxCl2(){  //Bug : Modificar base de datos para dividir el apellido y el nombre de la persona. 
		String client = "Stanford Pines";
		String tcl=null;
		System.out.println(client);
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				System.out.println("En proceso...");
				Statement myStat = conn.createStatement();
				ResultSet myRs= myStat.executeQuery("Select c.id_cliente AS ID,c.nombre_cl AS Nombre,r.fecha AS Fecha,sum(r.costxrent) AS Total "
													+ "from rentas r inner join clientes c on r.id_cliente=c.id_cliente "
													+ "inner join videos v on r.id_video=v.id_video "
													+ "where c.nombre_cl= \""+client+"\""
													+ "group by c.id_cliente;");	
				
				while(myRs.next())	
				{
					System.out.println(myRs.getString("ID")+"\t"+myRs.getString("Nombre")+"\t\t"+myRs.getString("Fecha")+
										"\t"+myRs.getString("Total"));	
					
				}
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}
		//return tcl;
	}
	public static String[] TxMem(String day){   
		String [] memb = new String [3];
		System.out.println("Por Membresia... Procesando...");
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				System.out.println("En proceso...");
				Statement myStat = conn.createStatement();
				ResultSet myRs= myStat.executeQuery("Select c.tipo_membresia AS Membresia,r.fecha AS Fecha,sum(r.costxrent) AS Total "
													+ "from rentas r inner join clientes c on r.id_cliente=c.id_cliente "
													+ "inner join videos v on r.id_video=v.id_video where r.fecha= \""+day+"\""
													+ " group by c.tipo_membresia;");	
				
				int y=0;
				while(myRs.next())	
				{
					System.out.println(myRs.getString("Membresia")+"\t"+myRs.getString("Fecha")+"\t"+myRs.getString("Total"));	
					memb[y]=(myRs.getString("Membresia")+"\t"+myRs.getString("Fecha")+"\t"+myRs.getString("Total")+"\n");
					y++;
				}
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}
		return memb;
	}
	public static String[] TxType(String day){
		String [] peerday= new String[3];
		Connection conn= null;
		try
		{
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/video","root","lillium");	
			if(conn!=null)
			{
				System.out.println("En proceso...");
				Statement myStat = conn.createStatement();
				ResultSet myRs= myStat.executeQuery("Select v.tipo AS Tipo,r.fecha AS Fecha,sum(r.costxrent) AS Total "
													+ "from rentas r  inner join clientes c on r.id_cliente=c.id_cliente "
													+ "inner join videos v on r.id_video=v.id_video "
													+ "where r.fecha = \""+day+"\" group by v.tipo;");
				int y=0;
				while(myRs.next())	
				{	
					System.out.println(myRs.getString("Tipo")+"\t"+myRs.getString("Fecha")+"\t"
										+myRs.getString("Total"));
					peerday[y]=(myRs.getString("Tipo")+"\t"+myRs.getString("Fecha")+"\t"
							+myRs.getString("Total")+"\n");
					y++;
				}
			}	
		}
		catch(Exception e)
			{
				System.out.println("Fallo en la conexion con la base de datos"+ e);
			}
		return peerday;
	}
	
	//Autor: Luis Fernando Sapiéns Ochoa
	//Sección de Puebas...
	public static void main(String [] args){
		String x, y;
		Scanner lee = new Scanner(System.in);
		//System.out.println("Fecha que desea conocer precios: (yyy-mm-dd");
		System.out.println("teclee el Dia:");
		x=lee.next();
		TxType(x);
	}
}
