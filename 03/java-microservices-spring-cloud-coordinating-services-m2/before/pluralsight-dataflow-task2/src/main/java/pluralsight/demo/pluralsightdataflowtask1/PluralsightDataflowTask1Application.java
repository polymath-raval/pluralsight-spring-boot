package pluralsight.demo.pluralsightdataflowtask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(Task1Properties.class)
@EnableTask
@SpringBootApplication
public class PluralsightDataflowTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightDataflowTask1Application.class, args);
	}

	/*@Bean
	public Task1 task1(){
		return new Task1();
	}
	public class Task1 implements CommandLineRunner{
		@Autowired
		Task1Properties properties;

		@Override
		public void run(String... strings) throws Exception {
			System.out.println(properties);
			if(properties.getControlMessage().equals("fail")){
				System.out.println("Control message is asking it to be failed");
				throw new RuntimeException("I'm angry !@#$");
			}

			System.out.println("Done with your task");
		}
	}*/

	/*public Task2 task2(){
		return new Task2();
	}
	public class Task2 implements CommandLineRunner{
		@Autowired
		Task1Properties properties;

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Done with your task 2");
		}
	}*/

	public Task3 task3(){
		return new Task3();
	}
	public class Task3 implements CommandLineRunner{
		@Autowired
		Task1Properties properties;

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Done with your task 3");
		}
	}

}
