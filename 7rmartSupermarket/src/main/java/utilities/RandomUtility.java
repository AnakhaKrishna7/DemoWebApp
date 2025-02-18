	package utilities;
	
	import net.datafaker.Faker;
	
	public class RandomUtility {
		public String createAUserName() {
			Faker faker = new Faker();
			String userName =faker.name().fullName();
			return userName;
		}
		
		public String createAPassword() {
			Faker faker = new Faker();
			String password =faker.internet().password();
			return password;
		}
		public String createsubCategoryName()
		{
		Faker faker = new Faker();
		String subCategoryname = faker.food().spice();
		return subCategoryname;
		}
		
		public String createCategoryName()
		{
		Faker faker = new Faker();
		String Categoryname = faker.food().spice();
		return Categoryname;
		}

	}
