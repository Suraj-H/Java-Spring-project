package com.mikadosolutions.training.spring.di;

import java.util.List;

public interface Course {
	public List<String> getCourseContents();
	public int getCourseDuration();
	public double getCourseFees();
}