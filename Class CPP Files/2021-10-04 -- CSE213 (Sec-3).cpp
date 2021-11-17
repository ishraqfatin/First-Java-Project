/*
#include<iostream>
using namespace std;

struct Employee{
	int empId; string empName; float salary;
};

int main(){
	Employee farid;
	cout<<"Enter employee ID: "; cin>>farid.empId; cin.ignore();
	cout<<"Enter employee Name: "; getline(cin, farid.empName);
	cout<<"Enter employee Salary: "; cin>>farid.salary;
	cout<<"Id="<<farid.empId<<", Name="<<farid.empName<<", Salary="<<farid.salary<<endl;
	return 0;
}
*/
//-------------------------------------------------------------------
/*
#include<iostream>
using namespace std;
// 
class Student{
    public:
    int studId; string studName; float cgpa;
};

int main(){
	Student asif, luna;
	cout<<"Enter student ID: "; cin>>asif.studId; cin.ignore();
	cout<<"Enter student Name: "; getline(cin, asif.studName);
	cout<<"Enter cgpa: "; cin>>asif.cgpa;
	cout<<"Id="<<asif.studId<<", Name="<<asif.studName<<", Cgpa="<<asif.cgpa<<endl;
	return 0;
}
*/
//------------------------------------------------------------------
/*
#include<iostream>
using namespace std;
struct Employee{
    private:
	int empId; string empName; float salary; //member data, a.k.a field
    public:
	void setEmpInfo(){	//member function, a.k.a method
		cout<<"Enter employee ID: "; cin>>empId; cin.ignore();
		cout<<"Enter employee Name: "; getline(cin, empName);
		cout<<"Enter employee Salary: "; cin>>salary;
	}
	void showEmpInfo(){
        cout<<"Id="<<empId<<", Name="<<empName<<", Salary="<<salary<<endl;
	}
	float getSalary(){ return salary;}
};

int main(){
	Employee farid, luna;
	farid.setEmpInfo();	//luna.setEmpInfo();
    farid.showEmpInfo();
    float sal = farid.getSalary();
    //cout<<farid.empId;
	return 0;
}
*/
//------------------------------------------------------------------
// /*
#include<iostream>
using namespace std;

class Student{
	int studId; string studName; float cgpa;

	public:
    void setStudInfo(){
		cout<<"Enter student ID: "; cin>>studId; cin.ignore();
		cout<<"Enter student Name: "; getline(cin, studName);
		cout<<"Enter cgpa: "; cin>>cgpa;
	}
	void showStudInfo(){
        	cout<<"Id="<<studId<<", Name="<<studName<<", Cgpa="<<cgpa<<endl;
	}
	void submitAssignment(){
        conductSurvey();
	}
	private:
    void conductSurvey(){
        //....
    }
};

int main(){

    int id; string name,address; float cgpa;
    cin>>id>>name>>cgpa;
    cin>>id; cin.ignore();
    getline(cin,name);
    getline(cin,address);
    cin>>cgpa;
    cout<<"id="<<id<<", name="<<name<<", cgpa="<<cgpa<<endl;

	Student asif, luna;
	cout<<"Enter student ID: "; cin>>asif.studId; cin.ignore();
	cout<<"Enter student Name: "; getline(cin, asif.studName);
	cout<<"Enter cgpa: "; cin>>asif.cgpa;
	cout<<"Id="<<asif.studId<<", Name="<<asif.studName<<", Cgpa="<<asif.cgpa<<endl;
	asif.setStudInfo();
	asif.showStudInfo();
    luna.setStudInfo();
	luna.showStudInfo();
	asif.submitAssignment();
	return 0;
}
// */
//-----------------------------------------------
/*
#include<iostream>
using namespace std;
int main(){
    int x = 35, y;
    y = x<<2;
    cout<<y;	//140
	return 0;
}
*/
//---------------------------------------------------
