#include <iostream>
using namespace std;

class Date {
// MUST have day (int), month (string), year (int) as private fields.
private:
	int day, year; string month;

public: // add necessary methods including setters and getters,
	void setJoinDate(){
		cout<<"Enter join date in format (dd month yyyy): ";
		cin>>day>>month>>year;
	}
	void showJoinDate(){
		cout<<"Joining Date is : "<<day<<"."<<month<<"."<<year;
	}
// AND/OR declare friends, so that the given main() works
	friend int getYear(Date);
	friend string getMonth(Date);
};

int getYear(Date d){
	return d.year;
}
string getMonth(Date a){
	return a.month;
}

istream &operator >> (istream &in, Date &e){
	e.setJoinDate();
	return in;
}
ostream &operator << (ostream &out, Date &e){
	e.showJoinDate();
	return out;
}

class Employee{
// MUST have employeeID, name, department and the following as private fields.
private:
	int employeeID;
	string name, department;

	Date dateOfJoining;
public: // add necessary methods including setters and getters,
	Employee(int a, string b, string c){
		employeeID=a;
		name=b;
		department=c;
		cout<<"Enter joining date of "<<name<<endl;
		dateOfJoining.setJoinDate();
	}
	Employee(){};

	void setEmpInfo()
	{
		cout << "Enter employee ID: ";
		cin >> employeeID;
		cin.ignore();
		cout << "Enter employee Name: ";
		getline(cin, name);
		cout << "Enter employee Department: ";
		getline(cin, department);

		cout<<"Enter joining date of "<<name<<endl;
		dateOfJoining.setJoinDate();
	}
	string getName(){
		return name;
	}
	void showEmpInfo()
	{
		cout << "Id=" << employeeID << ", Name=" << name << ", Department=" << department << endl;
		dateOfJoining.showJoinDate();
	}
	int year(){
		return getYear(dateOfJoining);
	}
	string month(){
		return getMonth(dateOfJoining);
	}
// AND/OR declare friends, so that the given main() works
		
};


bool operator == (Employee &c, int x){
	if(c.year()== x){
		return true;
	}
	else return false;
}
bool operator == (Employee &c, string x){
	if(c.month()== x){
		return true;
	}
	else return false;
}

istream &operator >> (istream &in, Employee &e){
	e.setEmpInfo();
	return in;
}
ostream &operator << (ostream &out, Employee &e){
	e.showEmpInfo();
	return out;
}

int main()
{
Employee e1, e2(4161, "S K Dey", "CSE");
cout << "Give input for employee 1: " << endl;

cin>>e1;	//Should ask employeeID, name, department.
					//Then ask for date of joining related information.

cout << "Complete information of the employees are: " << endl;
cout<<e1<<endl<<e2<<endl;

cout<<"\nMr./Ms. " << e1.getName();
if(e1 == 2017 && e1 == "October")
cout<<" joined the company in October 2017." << endl;
else
cout<<" did NOT join the company in October 2017." << endl;
return 0;
}
