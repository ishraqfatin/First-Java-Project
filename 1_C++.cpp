#include <iostream>
using namespace std;

class Address {
// MUST have houseNo, roadNo, street, thana, district, zipCode, etc. as private fields
Public: // add necessary methods including setters and getters,
// AND/OR declare friends, so that the given main() works
};
class Employee{
// MUST have employeeID, name, department and the following as private fields
Address empAddress;
Public: // add necessary methods including setters and getters,
// AND/OR declare friends, so that the given main() works
};
int main(){
Employee e1, e2(4161, “S K Dey”, “CSE”);
//parameterized constructor also ask for address details
cout << ”Give input for employee 1: “ << endl;
cin >> e1;
//Should ask employeeID, name, department.
//Then ask address related information.
cout << ”Complete information of the employees are: “ << endl;
cout<< e1 << e2 << endl;
cout<<”The employee e1 “;
if(e1 == 1229) cout << ”lives in Bashundhara R/A.” << endl;
else cout << ”does NOT lives in Bashundhara R/A.” << endl;
//comparing zipCode field
return 0;
}
