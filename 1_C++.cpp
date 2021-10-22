#include <iostream>
#include <string>
using namespace std;

class Address
{
	// MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
private:
	int houseNo, roadNo,  zipCode;
	string thana, street, district;

	friend int getZipCode(Address);

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
		cout << "House no. : " << houseNo;
		cout << ", Road no. : " << roadNo;
		cout << ", Street no. : ";
		street;
		cout << ", ZipCode: " << zipCode;
		cout << ", Thana: " << thana;
		cout << ", District: " << district;
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
	Employee(int id, string name, string dep){
		empId=id;
		empName=name;
		department=dep;
		cout<<"Enter Address of Employee: \n";
		empAddress.setAddress();
	}
	Employee(){
	}
	void setEmpInfo()
	{
		cout << "Enter employee ID: ";
		cin >> empId;
		cin.ignore();
		cout << "Enter employee Name: ";
		getline(cin, empName);
		cout << "Enter employee Department: ";
		getline(cin, department);

		empAddress.setAddress();
	}
	void showEmpInfo()
	{
		cout << "Id=" << empId << ", Name=" << empName << ", Department=" << department << endl;
		empAddress.showAddress();
	}

	int zip(){	//passes the empAddress object to the friend function
		return getZipCode(empAddress);
	}
};

int getZipCode(Address d){	//friend function
	return d.zipCode;
}


int main()
{
	Employee e1, e2(4161, "S K Dey", "CSE");	// parameterized constructor also ask for address details
	cout << "Give input for employee 1: " << endl;
	// Should ask employeeID, name, department.
	// Then ask address related information.
	e1.setEmpInfo();	
	cout << "Complete information of the employees are: " << endl;
	e1.showEmpInfo();
	cout<<endl;
	e2.showEmpInfo();
	
	cout << "The employee e1 ";
	if ( e1.zip() == 1229)
		cout << "lives in Bashundhara R/A." << endl;
	else
		cout << "does NOT lives in Bashundhara R/A." << endl; // comparing zipCode field
	return 0;
}
