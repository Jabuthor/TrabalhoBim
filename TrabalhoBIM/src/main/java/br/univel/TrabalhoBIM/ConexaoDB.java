package br.univel.TrabalhoBIM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexaoDB {

	private static ConexaoDB self;
	
	private Connection con;
	
	private ConexaoDB() {
		try {
			this.con = DriverManager
					.getConnection(
					"jdbc:postgresql://localhost:5432/TrabBIM",
					"postgres", "univel");
			
			Runtime.getRuntime()
				.addShutdownHook(new Thread(new Runnable() {
					public void run() {
						try {
							ConexaoDB.this.con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}));
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	public final static synchronized ConexaoDB getInstance() {
		if (self == null) {
			self = new ConexaoDB();
		}
		return self;
	}
	
	public Connection getConnection() {
		return this.con;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Erro, só pode haver um!");
	}
	
}
