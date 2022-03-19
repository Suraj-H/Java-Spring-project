package com.mikadosolutions.training.spring.di;

public class TrainingWorkshop implements Workshop {
	TrainingCompany trainingCompany;

	public TrainingWorkshop() {
	}

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	@Override
	public void conductWorkshop() {
		System.out.println(trainingCompany);
		trainingCompany.conductTraining();
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}
}