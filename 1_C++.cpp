#include <iostream>
#include <string>
using namespace std;

class Address
{
	// MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
private:
	int houseNo, roadNo,  zipCode;
	string thana, street, district;

public: // add necessary methods including setters and getters,
	// AND/OR declare friends, so that the given main() works
	void setAddress()
	{
		cout << "Enter house no. : ";
		cin >> houseNo;
		cout << "Enter road no. : ";
		cin >> roadNo;
		cout << "Enter zipCode: ";
		cin >> zipCode;
		cin.ignore();
		cout << "Enter street no. : ";
		getline(cin, street);
		cout << "Enter thana: ";
		getline(cin, thana);
		cout << "Enter district: ";
		getline(cin, district);
	}
	void showAddress()
	{
		cout << "house no. : " << houseNo;
		cout << ", road no. : " << roadNo;
		cout << ", street no. : ";
		street;
		cout << ", zipCode: " << zipCode;
		cout << ", thana: " << thana;
		cout << ", district: " << district;
	}
};
class Employee
{
	// MUST have employeeID, name, department and the following as private fields
private:
	int empId;
	string empName, department;

	Address empAddress;

public: // add necessary methods including setters and getters,
	// AND/OR declare friends, so that the given main() works
	void setEmpInfo()
	{
		cout << "Enter employee ID: ";
		cin >> empId;
		cin.ignore();
		cout << "Enter employee Name: ";
		getline(cin, empName);
		cout << "Enter employee Department: ";
		cin >> department;
	}
	void showEmpInfo()
	{
		cout << "Id=" << empId << ", Name=" << empName << ", Salary=" << department << endl;
	}
};
int main()
{
	Employee e1, e2;
	Address empAddress;
	// parameterized constructor also ask for address details
	cout << "Give input for employee 1: " << endl;
	e1.setEmpInfo();	// Should ask employeeID, name, department.
	empAddress.setAddress();	// Then ask address related information.
	cout << "Give input for employee 2: " << endl;
	e2.setEmpInfo();	// Should ask employeeID, name, department.
	empAddress.setAddress();	// Then ask address related information.
	cout << "Complete information of the employees are: " << endl;
	e1.showEmpInfo();
	empAddress.showAddress();
	// cout << "The employee e1 ";
	// if (empAddress.zipCode == 1229)
	// 	cout << "lives in Bashundhara R/A." << endl;
	// else
	// 	cout << "does NOT lives in Bashundhara R/A." << endl; // comparing zipCode field
	return 0;
}
