package com.mikadosolutions.training.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LaunchTraining {
	public static void main(String[] args) {
		/*ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\SurajH\\OneDrive\\Documents\\Visual Studio Projects\\Java\\Spring\\TrainingConfig.xml");
		Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
		trainingWorkshop.conductWorkshop();*/

		ApplicationContext context = new FileSystemXmlApplicationContext(new String[] {"C:\\Users\\SurajH\\OneDrive\\Documents\\Visual Studio Projects\\Java\\Spring\\TrainingConfig.xml", "C:\\Users\\SurajH\\OneDrive\\Documents\\Visual Studio Projects\\Java\\Spring\\MyDataSource.xml" });
		Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
		trainingWorkshop.conductWorkshop();
		MyDataSource dataSource = (MyDataSource) context.getBean("myDataSource");
		System.out.println(dataSource.getConnection());

		Trainer trainer = (Trainer) context.getBean("sanjay");
		System.out.println(trainer.getSpecialties());

		Course course1 = ((Course) context.getBean("struts2Course"));
		Course course2 = ((Course) context.getBean("struts2Course"));
		if (course1 == course2)
			System.out.println("They are same");
		else
			System.out.println("They are different");

		LodhaDevelopers developers = (LodhaDevelopers) context.getBean("lodha");
		Home home1 = developers.getHome();
		Home home2 = developers.getHome();
		System.out.println("Home1 = " + home1);
		System.out.println("Home2 = " + home2);
	}
}