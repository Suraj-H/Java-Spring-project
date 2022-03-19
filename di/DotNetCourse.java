package com.mikadosolutions.training.spring.di;

import java.util.List;

public class DotNetCourse implements Course {
	List<String> courseContents;
	int courseDuration;
	double courseFees;

	public DotNetCourse() { 
	}

	public DotNetCourse(List<String> courseContents, int courseDuration, double courseFees) {
		this.courseContents = courseContents;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
	}

	public void setCourseContents(List<String> courseContents) {
		this.courseContents = courseContents;
	}

	@Override
	public List<String> getCourseContents() {
		return courseContents;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseFees(double courseFees) {
		this.courseFees = courseFees;
	}

	@Override
	public double getCourseFees() {
		return courseFees;
	}

	@Override
	public String toString() {
		return "DotNet " + courseContents + " duration is " + courseDuration + " fees is " + courseFees; 
	}
}