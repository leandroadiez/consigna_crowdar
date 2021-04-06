package Package;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String defaultPassword = "secret_sauce";
		
		User standard_user = new User("standard_user", defaultPassword);
		User locked_out_user = new User("locked_out_user", defaultPassword);
		User problem_user = new User("problem_user", defaultPassword);
		
		//Log in as standard_user - positive
		LogIn_001 logIn_001 = new LogIn_001(standard_user);
		logIn_001.execute();
		
		//Log in as standard_user - negative
		LogIn_002 logIn_002 = new LogIn_002(standard_user);
		logIn_002.execute();
		
		//Log in as locked_out_user - positive
		LogIn_003 logIn_003 = new LogIn_003(locked_out_user);
		logIn_003.execute();
		
		//Log in with empty username and valid password
		LogIn_004 logIn_004 = new LogIn_004(standard_user);
		logIn_004.execute();
		
		//Log in with valid standard user and empty password
		LogIn_005 logIn_005 = new LogIn_005(standard_user);
		logIn_005.execute();

	}

}
