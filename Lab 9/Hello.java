package lab9;

import java.util.Calendar;
//import java.util.Date;
//import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class Hello {

	private String firstName;
	private String surname;
	private String address;
	private String country;
	private String course;
	private String phone;
	private int age;
	private String sex = "Male";
	private int born;
	Calendar cal = Calendar.getInstance();//Create a calander obj of the current date D/M/Y
	private int year = cal.get(Calendar.YEAR);

	public Hello() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the age
	 */
	public int getAge() {

		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the date
	 */

	public int getYear() {
		if (course.contains("BSCHONS")) {
			year+=4;
		} else{
			year+=3;
		}
		
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
			this.year = year;
		}

	/**
	 * @return the born
	 */
	public int getBorn() {
		
		born = cal.get(Calendar.YEAR) - age;
		return born;
	}

	/**
	 * @param born the born to set
	 */
	public void setBorn(int born) {
		this.born = born;
	}

	

}
