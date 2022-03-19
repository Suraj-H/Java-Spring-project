package com.mikadosolutions.training.spring.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MikadoSolutions implements TrainingCompany, BeanNameAware,
		BeanFactoryAware, InitializingBean, DisposableBean, ApplicationContextAware {
	List<Trainer> trainers;
	Set<Course> courses;
	Map<Course, Trainer> courseTrainers;
	Map<String, Trainer> nameTrainers;
	static MikadoSolutions mikado;

	private MikadoSolutions() {
	}

	public static MikadoSolutions getMikadoSolutions() {
		if (mikado == null)
			mikado = new MikadoSolutions();
		return mikado;
	}

	@Override
	public void conductTraining() {
		Iterator<Trainer> it = trainers.iterator();
		while (it.hasNext()) {
			Trainer trainer = it.next();
			System.out.println(trainer);
			trainer.train();
		}
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourseTrainers(Map<Course, Trainer> courseTrainers) {
		this.courseTrainers = courseTrainers;
		courses = courseTrainers.keySet();
		Collection<Trainer> values = courseTrainers.values();
		trainers = new ArrayList<Trainer> (values);
	}

	public Map<Course, Trainer> getCourseTrainers() {
		return courseTrainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setNameTrainers(Map<String, Trainer> nameTrainers) {
		this.nameTrainers = nameTrainers;
		System.out.println("Inside setNameTrainers() " + nameTrainers);
	}

	@Override
	public String toString() {
		return "Mikado Solutions is a Training Company";
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Inside setBeanName() " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Inside setBeanFactory() " + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Inside setApplicationContext() " + applicationContext);
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("Inside afterPropertiesSet()");
	}

	@Override
	public void destroy() {
		System.out.println("Inside destroy()");
	}
}